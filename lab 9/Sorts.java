
/**
 * Nicholas Kaide and Renan Custodio
 * CS 120 
 * 04/03/12
 * 
 * This program will take an array of a size and sort all the numbers in the numerical order.
 * How it does it depends on the method. The Count sort method tasks each of the numbers and 
 * counts how many are less than it. The number that are less is the numbered placement that
 * the number in the array should belong. All of count sort depends on the fact that all the
 * random numbers are not the same from one another. How it get this is by setting an 
 * arbitrary number that is not zero then in the loop sets to zero. If the program has to
 * change even one number then the 0 is added a number. It will start over again in the loop 
 * with the arbitrary number being zero again. How it gets out is when the program will not
 * have to change the numbers in the array so that the arbitrary number is 0. 
 * 
 */
import java.util.*;
import java.text.DecimalFormat;

public class Sorts
{
    static final int SIZE = 200;  // size of array to be sorted
    static int[] values = new int[SIZE]; // values to be sorted
    //static int cmpcntr = 0;
    
    static void initValues() {
    // initializes the values array with random ints in range 0 to 
        Random rand = new Random();
        for (int index =0; index < SIZE; index++)
            values[index] = Math.abs(rand.nextInt()) % SIZE;
    }
    
    static public boolean isSorted() {
    // Returns true if array values sorted; else false
        boolean sorted = true;
        for (int index =0; index < (SIZE-1); index++)
            if (values[index] > values[index+1])
                sorted = false;
        return sorted;
    }
    
    static public void swap(int index1, int index2) {
    // Swaps the integers at locations index1, index2 of values array
    // NOTE: assumes the two indices are both >= 0 and < SIZE
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }
    
    static public void printValues() {
    // prints out the values array in formatted form
        int value;
        DecimalFormat fmt = new DecimalFormat("00000");
        System.out.println("The values array is: ");
        for(int index = 0; index < SIZE; index++) {
            value = values[index];
            if ( ( (index+1) % 20) == 0)
                System.out.println(fmt.format(value) + " ");
            else
                System.out.print(fmt.format(value) + " ");
        }
        System.out.println();
    }
    
    /**
     * The various sort routines will start here 
     */

   //////////////////////////////////////////////////////////////////////
   // Bubble Sort
   static public void bubbleSort() {
        for (int i = 0; i < SIZE-1; i++) {
            for (int j = SIZE-1;j > i; --j) {
                if (values[j] < values[j-1]) {
                    swap(j,j-1);
                }
            }
        }
   }

    //////////////////////////////////////////////////////////////////////
    // Selection Sort
    static void selectionSort() {
        for (int i = 0; i < SIZE; i++) {
            int j = i;
            for (int k = i+1; k < SIZE; k++) {
                if (values[k] < values[j]) {
                    j = k;
                }
            }
            int temp = values[i]; values[i] = values[j]; values[j] = temp;
        }
    }
    
    static void selectionSort2() {
        int numCmps = 0;
        int dataMov = 0;
        for (int i = 0; i < SIZE; i++) {
            int j = i;
            for (int k = i+1; k < SIZE; k++) {
                ++numCmps;
                if (values[k] < values[j]) {
                    j = k;
                }
            }
            int temp = values[i]; values[i] = values[j]; values[j] = temp;
            dataMov+=3;
        }
        System.out.println("\nnumber of compares predicted: " + (.5*SIZE*SIZE-SIZE/2));
        System.out.println("actual number of compares: " + numCmps);
        System.out.println("number of assignments predicted: " + (3*SIZE));
        System.out.println("actual number of assignments: " + dataMov);
    }

    //////////////////////////////////////////////////////////////////////
    // Insertion Sort    
    static void insertionSort() {
        int firstunsorted,     // position of first unsorted entry
            position,          // searches sorted part of list
            current;           // holds the entry temorarily removed from the list
        for(firstunsorted = 1; firstunsorted < SIZE; firstunsorted++) {
            if (values[firstunsorted] < values[firstunsorted-1]) {
                position = firstunsorted;
                current = values[firstunsorted];
                do {           // shift all entries up until proper position found
                    values[position] = values[position-1];
                    position--;
                } while (position > 0 && values[position-1] > current);
                values[position] = current;
            } // end if
        } // end for
    } // end insertionSort
    
    //////////////////////////////////////////////////////////////////////
// Shell Sort
    static void shellSort() {
        int i, j, increment, temp;
        increment = 7;
        while (increment > 0) {
            for (i = 0; i < SIZE; i++) {
                j = i;
                temp = values[i];
                while ( (j >= increment)  &&  (values[j-increment] > temp) ) {
                    values[j] = values[j-increment];
                    j = j - increment;
                } // end while
                values[j] = temp;
            } // end for
            if (increment /2 != 0)
               increment = increment/2;
            else if (increment == 1)
               increment = 0;
            else
               increment = 1;
        }
    }
    
    static void initAllDifferentValues() {
      Random rand = new Random();
      int counter = 1; // arbitrary value
      do {
        counter = 0;
        for (int index = SIZE-1; index != 0; index-- ) {
          for (int w = index; w != 0; w-- ) {
            if (values[index] == values[index-w]) {
              values[index] = Math.abs(rand.nextInt()) % SIZE;
              counter++;
            }
          }
        }
      } while (counter != 0);
    }
    
    static void countSort() {
      int count = 0;
      int[] cs = new int[SIZE];
      int[] cs2 = new int[SIZE];
      cs = values;
      for (int index = SIZE-1; index >= 0; index--) {
        count = 0;
        for (int i = SIZE-1; i >= 0; i--) {
          if (cs[i]<cs[index])
            count++;
        }
        cs2[count] = cs[index];
      }
      values = cs2;
    }
    
    static void scanSort(int cs[]) {
      int i = 2;
      int c = SIZE;
      do {
        if (cs[i] < cs[i-1]) {
          swap(i,i-1);
          if(i>2)
            i = i-1;
        }
        else
          i = i+1;
      } while (i != c+1);
    }
    
    public static void main(String[] args) {
        initAllDifferentValues();
        //printValues();
        System.out.println("values array is sorted: " + isSorted());
        System.out.println();
        System.out.println("Calling sort routine now!");
        long startTime = System.currentTimeMillis();
        countSort();
        long stopTime = System.currentTimeMillis();
        long elapsedTimeMilliseconds = stopTime-startTime;
        double elapsedTimeSeconds = elapsedTimeMilliseconds/1000.0;
        System.out.println("\nSort routine finished!!\n");
        //printValues();
        System.out.println("values array is sorted: " + isSorted()); 
        System.out.println("\nelapsed time was " + elapsedTimeMilliseconds +
                           " milliseconds, or " + elapsedTimeSeconds + " seconds");
    }
}