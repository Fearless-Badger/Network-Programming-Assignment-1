/*


*/

import java.util.Scanner;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

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

      int columns = 3;  // Default number of columns.
      int spacing = 10; // Default number of spaces between the ones places of two adjacent integers.
      int groups = 0;   // Default size of a group. Zero means no groups.

      // READ in the properties data, override the default values - filter.properties

      // READ in the environment values, from the env
      // names = CS336_COLUMNS or CS336_SPACING or CS336_GROUPS
      // convert string value to int using "parseInt()"

      // READ the command line args, override env. Use parseInt() again

      /* Your program should read the sequence of input integers from standard input by using the Scanner class methods hasNextLong() and nextLong(). */

      while (in.hasNextInt()) {
         System.out.println(in.nextInt() + "!");
      }

      in.close();

   }
}
