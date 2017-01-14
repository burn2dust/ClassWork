/**
 * Renan Custodio and Nicholas Kaide         ON NICHOLAS'S SHARES DRIVE
 * 3/2/2012
 * CS 120
 * 
 * Lab #6
 * 
 * This program will take the users input that will consist of two parts
 * when a colon is in the input. If a colon is not in the input, then the
 * program will take it all as one line of code and print an "N." If the
 * user does input a colon then the program will check if the string on
 * the right or on the left hand side of the colon is bigger. If both the
 * left and the right are the same size, then the program will check if
 * there are differences between the left and the right hand strings, if 
 * any. If there is a difference between the two strings, then the
 * program will output a "D." If the strings are the same in every way,
 * then the program will output an "S."
 * 
 */
import java.io.*;
import java.util.*;

public class CompareSlides {
  public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in);
    String canidate = null;
    boolean same = false;
    boolean again = false;
    
    System.out.println("\nProgram reads one line of input from the keyboard where");
    System.out.println("the input is to consist of two parts separated by a");
    System.out.println("colon. it will output the result of comparison based on:");
    System.out.println("\n\tIf no colon was entered output an      N");
    System.out.println("\tLeft side is longer than right side    L");
    System.out.println("\tRight side is longer than left side    R");
    System.out.println("\tSame length but different              D");
    System.out.println("\tSame length and equal                  S");
    System.out.println("\n\n");
    
    do {
      AQueue queue = new AQueue(50);
      System.out.println("Enter the text to be evaluated : ");
      canidate = sc.nextLine();
      int length = canidate.length();
      int i = 0;
      int j = 0;
      char ch1 = canidate.charAt(i);
      char ch2 = canidate.charAt(j);
      for ( i = 0 ; ch1 != ':' && i < length ; i++ ) {
        ch1 = canidate.charAt(i);
        queue.enqueue(ch1);
      } // end of for
      // N case
      if ( i == length )
        System.out.println("The result is " + 'N');
      else {
        // L case
        for ( j = i ; j < length ; j++ ) {
          ch2 = canidate.charAt(j);
          queue.dequeue();
        } // end of for
        j--;
        i--;
        if ( i > j-i )
          System.out.println("The result is " + 'L');
      // R case
        else if ( i < j-i )
          System.out.println("The result is " + 'R');
      // D case and S case
      // Comparing the two in difference if any
        else {
          // somthing needs to happen
          j = i+1;
          i = 0;
          do {
            ch1 = canidate.charAt(i);
            ch2 = canidate.charAt(j);
            i++;
            j++;
          } while ( ch1 == ch2 && j != length );
          if ( ch1 == ch2 )
            same = true;
          else if ( ch1 != ch2 )
            same = false;
          if (same == true)
            System.out.print("The result is " + 'S');
          else if (same == false)
            System.out.print("The result is " + 'D');
        } // end of D and S else
      } // end of else
      System.out.println("\nDo you want to evaluate another string?");
      canidate = sc.nextLine();
      if ( canidate.equals("Y") || canidate.equals("y") )
        again = false;
      if ( canidate.equals("N") || canidate.equals("n") )
        again = true;
   } while (again == false); // end of do while
   System.out.println("\n\n\t\t\t\t\tThank you for using the program");
   System.out.println("\t\t\t\t\t     Have a nice day!");
  } // end of main
} // end of CompareSlides Class
