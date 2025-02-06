/*
   Course: CS 33600
   Name: Micah Najacht
   Email: mnajacht@pnw.edu
   Assignment : 1
*/

import java.util.Scanner;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
   This program filters.
*/
public class Filter
{
   public static void main(String[] args) throws IOException
   {
      // input stream
      final Scanner in = new Scanner(System.in);

      // Default values
      int columns = 3;  
      int spacing = 10; 
      int groups = 0;   


      // READ in the properties data, override the default values - filter.properties
      Properties properties = new Properties();
      try ( FileInputStream prop_stream = new FileInputStream("filter.properties")) {
         properties.load(prop_stream);
         int columns_canidate = Integer.parseInt(properties.getProperty("columns"));
         int spacing_canidate = Integer.parseInt(properties.getProperty("spacing"));
         int groups_canidate  = Integer.parseInt(properties.getProperty("groups"));

         // check that values are positive
         if (columns_canidate > 0){
            columns = columns_canidate;
         }
         if (spacing_canidate > 0){
            spacing = spacing_canidate;
         }
         if (groups_canidate > 0){
            groups = groups_canidate;
         }

      } catch (FileNotFoundException e){
         // do nothing
      }

      // environment values override both "default" and ".properties" values
      
      String env_cols   = System.getenv("CS336_COLUMNS");
      String env_spaces = System.getenv("CS336_SPACING");
      String env_groups = System.getenv("CS336_GROUPS");

      if (env_cols != null && Integer.parseInt(env_cols) > 0){
         columns = Integer.parseInt(env_cols);
      }
      if (env_spaces != null && Integer.parseInt(env_spaces) > 0){
         spacing = Integer.parseInt(env_spaces);
      }
      if (env_groups != null && Integer.parseInt(env_groups) > 0){
         groups = Integer.parseInt(env_groups);
      }

      // Command line arguments override everything else
      int number_of_args = args.length;
      if (number_of_args > 0 && Integer.parseInt(args[0]) > 0 ){
         columns = Integer.parseInt(args[0]);
      }

      if (number_of_args > 1 && Integer.parseInt(args[1]) > 0 ) {
         spacing = Integer.parseInt(args[1]);
      }

      if (number_of_args > 2 && Integer.parseInt(args[2]) > 0 ) {
         groups = Integer.parseInt(args[2]);
      }

      // configure printf format string
      spacing++;
      String format = "%," + spacing + "d" ;

      // read in input
      int group_count = 0;
      int count = 0;
      while (in.hasNextLong()) {

         // print output
         Long new_val = in.nextLong();
         System.out.printf(format, new_val);

         count++;
         group_count++;
         
         // Newline logic
         
         // column breaking
         if (count % columns == 0){
            System.out.println();
         }
         

         // grouping logic
         if (groups > 0 && group_count == groups){
            if ( count % columns != 0 ){
               System.out.println();
            }
            System.out.println();
            group_count = 0;
            count = 0;
         }
      }

      // print newline, if needed
      if (count % columns != 0){
         System.out.println();
      }

      // close stream
      in.close();

   }
}
