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

      ArrayList<Integer> dynamic_array = new ArrayList<>();

      int idx = 0;
      while (in.hasNextInt()) {
         int new_val = in.nextInt();
         dynamic_array.add(new_val);
      }

      String format = "%," + spacing + "d" ;

      int i = 0;
      while (i+columns <= dynamic_array.size()){

         String cur_format = "";
         for ( int j = 0 ; j < columns ; j++ ){
            cur_format += format;
         }

         System.out.printf(cur_format, dynamic_array.get(i), dynamic_array.get(i+1), dynamic_array.get(i+2));
         System.out.println();
         i = i + 3;
      }

      if (dynamic_array.size() - i == 2){
         String cur_format = format + format;
         System.out.printf(cur_format, dynamic_array.get(i), dynamic_array.get(i+1));
         i = i + 2;
      }
      else if (dynamic_array.size() - i == 1){
         System.out.printf(format, dynamic_array.get(i));
         i++;
      }

      if (DEBUG){
         System.out.println("\nindex of i : " + i + "\n" + "dyn_size : " + dynamic_array.size());

      }

      in.close();

   }
}
