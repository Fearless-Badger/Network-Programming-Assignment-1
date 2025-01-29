/*


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
   public static void main(String[] args)
   {
      final Scanner in = new Scanner(System.in);

      boolean DEBUG = true;

      int columns = 3;  // Default number of columns.
      int spacing = 10; // Default number of spaces between the ones places of two adjacent integers.
      int groups = 0;   // Default size of a group. Zero means no groups.

      // READ in the properties data, override the default values - filter.properties

      // READ in the environment values, from the env
      // names = CS336_COLUMNS or CS336_SPACING or CS336_GROUPS
      // convert string value to int using "parseInt()"

      // READ the command line args, override env. Use parseInt() again

      /* Your program should read the sequence of input integers from standard input by using the Scanner class methods hasNextLong() and nextLong(). */

      ArrayList<Long> dynamic_array = new ArrayList<>();

      while (in.hasNextLong()) {
         Long new_val = in.nextLong();
         dynamic_array.add(new_val);
      }

      String format = "%," + spacing + "d" ;

      int count = 0;
      int i = 0;
      while (i < dynamic_array.size()){

         /*
         String cur_format = "";
         for ( int j = 0 ; j < columns ; j++ ){
            cur_format += format;
         }
         */

         System.out.printf(format, dynamic_array.get(i));
         i++;
         

         if (i % columns == 0){
            System.out.println();
         }
      }

      /*
      int diff = dynamic_array.size() - i;
      if (diff != 0){
         String cur_format = "";
         int leftover = 0;
         long[] to_be_added = new long[diff];

         for (int j = 0 ; j <= diff ; j++ ){
            cur_format += format;
            to_be_added[j] = dynamic_array.get(i+j);
         }

         while ( i < dynamic_array.size()){
            System.out.printf(cur_format, to_be_added);
         }

      }
         */

      if (DEBUG){
         System.out.println("\nindex of i : " + i + "\n" + "dyn_size : " + dynamic_array.size() + "\n" + "diff : " + (dynamic_array.size() - i)); //+ diff );

      }

      in.close();

   }
}
