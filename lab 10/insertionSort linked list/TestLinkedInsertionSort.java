
import java.io.*;
import java.util.*;
    
class TestLinkedInsertionSort
{
    public static void main(String args[]) 
    {
         final int SIZE = 10000;  // size of array to be sorted
         //static int[] values = new int[SIZE]; // values to be sorted
    
        // initializes the values array with random ints in range 0 to 
        
        //
        List testQueue = new List();        // Test queue of char
        Random rand = new Random();
        int num;
        for (int index =0; index < SIZE; index++) {
           // num = Math.abs(rand.nextInt()) % 100000;
           num = Math.abs(rand.nextInt(2*SIZE));
           testQueue.enqueue(num);
        }
        
        //testQueue.showStructure();
        System.out.println("Starting sort: ");
        testQueue.linkedInsertionSort();
        System.out.println("Sort ended");
        //testQueue.showStructure();
        
    } // main
    
} // class TestAQueue