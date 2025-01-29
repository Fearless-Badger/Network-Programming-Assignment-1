/*
   Course: CS 33600
   Name: Micah Najacht
   Email: mnajacht@pnw.edu
   Assignment : 1
*/

import java.util.ArrayList;
import java.io.*;

import java.util.Scanner;
import java.util.Properties;

/**
   This program filters.

   When playing with file filters, it is useful to know that "end-of-file" is
   denoted at the command-line in Windows by Ctrl-Z and by Ctrl-D in Linux.
*/
public class Filter
{
   public static void main(String[] args) throws IOException
   {
      final Scanner in = new Scanner(System.in);

      boolean DEBUG = false;

      /*
       * 1) Get parameters
       *    - default values
       *    - properties values
       *    - environment values
       *    - command line arguments
       * 
       * 2) read in integer input
       *    - store in dynamic array
       * 
       * 3) print output
       *    - loop through stored input, printing and formatting output
       *  
       */

      /*
       * 
       * 1/28/2025 issue - Micah
       * This program doesn't currently behave well in a stream/pipe environment.
       * It reads in all the input, and stores it. This stored input is then looped over, formatted, and printed.
       * Currently I use "print" instead of "write", so buffers aren't being utilized either. Each print call flushes the buffer.
       * 
       * How to fix -
       * Trigger a function which uses write to write output to stdout whenever the input reaches a certain amount (buffer size or group size ???).
       * Use write and work with the buffers to be more efficient. This would make it behave better when taking a large amount of data throught the input stream.
       * 
       * 
       * 
       */

      // Default values
      int columns = 3;  
      int spacing = 10; 
      int groups = 0;   


      // READ in the properties data, override the default values - filter.properties
      Properties properties = new Properties();
      try ( FileInputStream prop_stream = new FileInputStream("filter.properties")) {
         properties.load(prop_stream);
         columns = Integer.parseInt(properties.getProperty("columns"));
         spacing = Integer.parseInt(properties.getProperty("spacing"));
         groups  = Integer.parseInt(properties.getProperty("groups"));
      } catch (FileNotFoundException e){
         // do nothing
      }

      // environment values override both "default" and ".properties" values
      
      String env_cols   = System.getenv("CS336_COLUMNS");
      String env_spaces = System.getenv("CS336_SPACING");
      String env_groups = System.getenv("CS336_GROUPS");

      if (env_cols != null){
         columns = Integer.parseInt(env_cols);
      }
      if (env_spaces != null ){
         spacing = Integer.parseInt(env_spaces);
      }
      if (env_groups != null){
         groups = Integer.parseInt(env_groups);
      }

      // Command line arguments override everything else
      int number_of_args = args.length;
      if (number_of_args > 0){
         columns = Integer.parseInt(args[0]);
      }

      if (number_of_args > 1){
         spacing = Integer.parseInt(args[1]);
      }

      if (number_of_args > 2){
         groups = Integer.parseInt(args[2]);
      }

      // read in input
      ArrayList<Long> dynamic_array = new ArrayList<>();

      while (in.hasNextLong()) {
         Long new_val = in.nextLong();
         dynamic_array.add(new_val);
      }

      // configure printf format string
      spacing++;
      String format = "%," + spacing + "d" ;


      // print output
      int group_count = 0;
      int count = 0;
      for( int i = 0 ; i < dynamic_array.size() ; i++ ){

         // print and increment counters
         System.out.printf(format, dynamic_array.get(i));
         count++;
         group_count++;
         

         
         // column breaking
         if (count % columns == 0){
            System.out.println();
         }
         

         // grouping
       
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

      if (DEBUG){
         System.out.println("\nindex of count : " + count + "\n" + "dyn_size : " + dynamic_array.size() + "\n" + "diff : " + (dynamic_array.size() - count)); //+ diff );
      }

      in.close();

   }
}
