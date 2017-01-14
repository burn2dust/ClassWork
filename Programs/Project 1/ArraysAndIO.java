/* Nicholas Kaide
 * 11/30/2012
 * CO 120
 * 
 * This program will take a file with a bunch of numbers that are the encoded
 * ASCII charaters. The program will take the numbers in the file and order
 * them in numerical value from lowest to highest. The program will also take 
 * those values that are sorted and find the average and median of the values.
 * The program will also take the values and see how off it is from the actual
 * values of the program.
 * 
 */

import javax.swing.*;
import java.util.*;
import java.io.*;

class ArraysAndIO {
    public static void main(String[] args) throws FileNotFoundException,
                                                    IOException { 
        // prompt for and read file name, then file size
        System.out.print("Enter file name: ");
        Scanner scanner = new Scanner(System.in);  // use this scanner to read file name
        String str = scanner.next();
        System.out.print("\nEnter size of file: ");
        
        int size = scanner.nextInt();
        
        Scanner sc = new Scanner(new File(str)); // use this scanner to read the text files
    
        // Declare the array and fill it with values from the disk file
        int[] originalNumberArray = new int[size];
        int[] ranNumSeq = new int[size];
        int[] sortedNumberArray = new int[size];
        int[] sortA = new int[size];
        
        // Show user the original array
        System.out.println("\nHere is the array of encrypted values: ");
        
        for (int i = 0; i < size; i++)
          originalNumberArray[i] = sc.nextInt();
        for (int i = 0; i < size; i++) {
          System.out.print(" " + originalNumberArray[i]);
          if (i%10==0)
            System.out.println();
        } // end of for loop
                
        // seed random number generator and find random range value
        System.out.println("\n\nEnter the integer to seed the random "
                             + "number generator: ");
        
        int setSeed = scanner.nextInt();
        
        Random rand = new Random(setSeed);
        
        System.out.println("\nEnter the range value integer: ");
        
        int randRange = scanner.nextInt();
        
        // Generate the random number sequence array into a new array
        for (int r = 0; r < size; r++)
          ranNumSeq[r] = rand.nextInt(randRange);
        for (int i=0;i<size;i++)
          originalNumberArray[i] = originalNumberArray[i] - ranNumSeq[i];
        
        // obtains the array of decrypted numbers and shows the original
        // numbers to the user
        for (int i = 0; i < size; i++)
          System.out.print(originalNumberArray[i] + " ");
        System.out.print("\n");
        
        //Prints out the original message.
        for (int i = 0; i < size; i++)
          System.out.print((char) originalNumberArray[i]);
        
        // Sorts the array of original values and shows the user the sorted array
        System.out.print("\n\nHere are the original numeric values sorted:\n ");
        for (int i = 0; i < size-1; i++)
          sortA[i] = originalNumberArray[i];
        selectionSort(sortA);
        for (int i = 0; i < size-1; i++)
          System.out.print(sortA[i] + " ");              
        // Now write back the sorted original scores to a new disk file
        for ( int i = 0; i < size-1; i++)
          sortedNumberArray[i] = sortA[i];
        // Compute the average
        double average = findAvg(sortedNumberArray);
    
        // Show the user the average
        System.out.println("\n\nThe average of the original numeric values is " + average);

        // Calculate the median
        double median = findMedian(sortedNumberArray);
        
        // Show the user the median
        System.out.println("\nThe median of the original numeric values is " + median);
        
        double div = findDeviation(sortedNumberArray , randRange, size);

        // Show the user the standard deviation
        System.out.println("\nThe standard deviation of thr original numeric values is" + div);
        
    } // end main
    
    ///////////////////////////////////////////////////////////////
    // Now come all the methods I use.  Note that they are ALL static, i.e. class, methods
    // here I declared and coded my method to print numeric values as you see them
    // in the sample output of the assignment. I print 10 numbers to a line; I'd like
    // you to do the same
    
    // here I declared and coded my method that I only use for printing out the 
    // decrypted original message
    
    public static void selectionSort(int[] number) {
        int minIndex, length, temp;
        length = number.length;
        for(int startIndex = 0; startIndex <= length-11; startIndex++) {
            minIndex = startIndex;
            for(int i = startIndex+1; i <= length-1; i++) {
                if (number[i] < number[minIndex]) {
                    minIndex = i;
                } // end of if
            } // end of for
            temp =  number[startIndex];
            number[startIndex] = number[minIndex];
            number[minIndex] = temp;
        } // end of for
    } // end of method
    
    
    // declare and code your method for finding the average (mean) here
    public static double findAvg(int[] mean) {
      int length;
      int avg = 0;
      
      length = mean.length;
      for (int i = 0; i < length; i++)
        mean[i] =+ mean[i+1];
      avg = mean[length]/length;
      return avg;
    } // end of method
    
    
    // declare and code your method for finding the median here 
    public static double findMedian(int[] mid){
      int avg = 0;
      int length;
      length = mid.length;
      
       if (length % 2 == 0) {
        findAvg(mid);
        return avg;
      } // end of if
      else {
        avg = (int) mid[length/2];
        return avg;
      } // end of else
    } // end of method
    
    
    // declare and code your method for finding the standard deviation here
    public static double findDeviation(int[] div , int randRange, int n) {
      double dev;
      dev = Math.sqrt((1/(n-1))*Math.sigma*(randRange-findAvg(div)));
      return dev;
    } // end of method
} // end of class
