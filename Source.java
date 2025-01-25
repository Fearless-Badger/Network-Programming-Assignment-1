/*
   This program is a source of data for the filter program.
*/

import java.util.Random;

/**
   This program takes three optional command-line arguments.
<p>
   The first determines the maximum number of digits in each random integer.
<p>
   The second determines how many lines of output there are.
<p>
   The third determines how many random integers there are on each line of output.
<p>
   The default number of digits in the random integers is 6.
   This program produces long integers, so the maximum value for digits is 19.
<p>
   Without any command-line arguments, this program will produce a random number
   of output lines (up to 100) and each output line will contain a random number
   of integers (up to 10) and each random integer will have at most six digits.
*/
class Source
{
   public static void main(String[] args)
   {
      final Random random = new Random();

      final int maxDigits; // Maximum number of digits in each random integer.
      if (args.length >= 1)
      {
         maxDigits = Integer.parseInt( args[0] ); // Fixed maximum number of digits.
      }
      else
      {
         maxDigits = 6; // Default maximum number of digits.
      }

      final int lines;  // How many lines of output.
      if (args.length >= 2)
      {
         lines = Integer.parseInt( args[1] ); // Fixed number of lines of output.
      }
      else
      {
         lines = 1 + random.nextInt(100); // Random number of lines of output.
      }

      for (int i = 0; i < lines; ++i)
      {
         final int data_points; // How many random integers on this line of output.
         if (args.length >= 3)
         {
            data_points = Integer.parseInt( args[2] ); // Fixed number of integers on this line of output.
         }
         else
         {
            data_points = 1 + random.nextInt(10); // Random number of integers on this line of output.
         }

         if ( random.nextBoolean() ) // "flip a coin" to decide if there should be leading spaces.
         {
            final int spaces = 1 + random.nextInt(20); // Random leading spaces.
            for (int j = 0; j < spaces; ++j)
            {
               System.out.printf(" ");
            }
         }

         for (int j = 0; j < data_points - 1; ++j)
         {
            final long d = randomInt(maxDigits);
            System.out.printf("%d", d);
            final int spaces = 1 + random.nextInt(20); // At least one space between integers.
            for (int k = 0; k < spaces; ++k)           // Random space between integers.
            {
               System.out.printf(" ");
            }
         }
         final long d = randomInt(maxDigits); // Last number on this line.
         System.out.printf("%d", d);

         if ( random.nextBoolean() ) // "flip a coin" to decide if there should be trailing spaces.
         {
            final int spaces = 1 + random.nextInt(20); // Random trailing spaces.
            for (int k = 0; k < spaces; ++k)
            {
               System.out.printf(" ");
            }
         }

         System.out.printf("\n");  // end this line
       //System.out.printf("#\n"); // end this line in a way that we can see where it ends
      }
   }

   private static long randomInt(int maxDigits)
   {
      final Random random = new Random();

      final int digits = 1 + random.nextInt(maxDigits); // int between 1 and maxDigits

      long result = 1 + random.nextInt(8); // digit between 1 and 9
      for (int i = 1; i < digits; ++i)
      {
         result = (10 * result) + random.nextInt(10);
      }
      return result;
   }
}
