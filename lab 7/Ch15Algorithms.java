/**
    Collection of recursive algorithms
    (Recursion is Chapter 15 in our text) 
*/

import java.io.*;
import java.util.*;

/**
 * Service Class for collecting all sample algorithms
 * in Chapter 15.
 *
 */

class Ch15Algorithms {
    
    Scanner scanner = new Scanner(System.in);
//----------------------------------
//    Constructors
//----------------------------------
    /**
     * Default constructor
     */
    public Ch15Algorithms( ) {
    } // end of constructor

    /**
     * Recursively sum the ints in the range m..n
     */
    
    public int sumRange(int m, int n)
    {
        int sum;
        if (m == n)
            sum = m;
        else
            sum = m + sumRange(m+1, n);
        return sum;
    } // end of sumRange method
    
    /** 
     * Recursively find binomial coefficient C(n,r)
     */
    public int binomialCoefficient(int n, int r)
    {
        if ( (r == 0) || (n == r) )
            return 1;
        else
            return (n*binomialCoefficient(n-1, r-1))/r;
    } // end of binomialCoefficient method

    /**
     * Recursively output lines of shorter length
     */
    public void linesGetShorter(int n)
    {
        for (int i=1; i<=n; ++i) 
            System.out.print('*');
        System.out.println();
        if (n != 1)
            linesGetShorter(n-1);
    } // end of linesGetShorter method

    /**
     * Recursive factorial method.
     */
    public int factorial( int N )
    {
        if ( N == 1 ) {
            return 1;
        } // end of if
        else {
            return N * factorial( N-1 );
        } // end of else
    } // end of factorial method
    
    /**
     * Recursive Fibonnaci
     */
    public int fib(int n) {
        if (n <= 0)
            return 1;
        else if (n == 1)
            return 1;
        else 
            return fib(n-1) + fib(n-2);
    } // end of fib method
    
    /**
     * Nonrecursive Fibonnaci
     */
    public int nonRecursiveFib(int N) {
        int fibN = -1, fibN1, fibN2, cnt;
        if (N == 0  ||  N == 1) {
            return 1;
        } // end of if
        else {
            fibN1 = fibN2 = 1;
            cnt = 2;
            while (cnt <= N) {
                fibN = fibN1 + fibN2;  // get the next fib no.
                fibN1 = fibN2;
                fibN2 = fibN;
                ++cnt;
            } // end of while
            return fibN;
        } // end of else
    } // end of nonRecursiveFib method
    
    /**
     * recursive reverse string
     */
    public void reverseString(String inputStr, int i) {
        int len = inputStr.length();
        if (i == len) {
            System.out.println("Here is the string reversed: ");
        } // end of if
        else {
            char c = inputStr.charAt(i);
            ++i;
            reverseString(inputStr,i);
            System.out.print(c);
        } // end of else
    } // end of reverseString method
    
    /**
     * Recursively computes the movement for solving the
     * Tower of Hanoi problem.
     */
    public void towersOfHanoi(  int N,       //number of disks
                                int from,    //origin peg
                                int to,      //destination peg
                                int spare )  //"middle" peg
    {
        if ( N == 1 ) {
            System.out.println( from + " ---> " + to );
        } else {
            towersOfHanoi( N-1, from, spare, to );
            System.out.println( from + " ---> " + to );
            towersOfHanoi( N-1, spare, to, from );
        } // end of else
    } // end of towersOfHanoi method
    
    public void anagram(String prefix, String suffix) {
        String newPrefix, newSuffix;
        int numOfChars = suffix.length();
        if (numOfChars == 1) {  // end case: print out one anagram
            System.out.println(prefix + suffix);
        } // end of if
        else {
            for(int i=1; i<=numOfChars; i++) {
                newSuffix = suffix.substring(1, numOfChars);
                newPrefix = prefix + suffix.charAt(0);
                anagram(newPrefix, newSuffix); // the recursive call
                // now rotate left to create a rearranged suffix
                suffix = newSuffix + suffix.charAt(0); 
            } // end for
        } // end else
    } // end anagram method
    
    public void decToBin(int num, int base) {
        if (num > 0) {
            decToBin(num/base, base);
            System.out.print(num % base);
        } // end of if
    } // end of decToBin method
    
    public int countDigits(int n) { 
      if ( n == 0 )
        return 0;
      else {
        n = n/10;
        return 1 + countDigits(n);
      } // end of else
    } // end of countDigits method
    
    public double sumHarmonicTerms(int n) {
      if ( n == 1 )
        return 1;
      else
        return ( (double) 1. / (double) n ) + sumHarmonicTerms(n-1);
    } // end of sumHarmonicTerms method
    
    public int countRandom(int i, int[] a, int start, int stop) {
      if (start > stop)
        return 0;
      else {
        if ( i == a[start])
          return 1 + countRandom( i, a, start + 1, stop );
        else 
          return 0 + countRandom( i, a, start + 1, stop );
      } // end of else
    } // end of countRandom method
    
    public int sum(int[] list) {
      int n = list.length;
      return sum(list, n);
    } // end of sum method
    
    public int sum(int[] list, int index) {
      if (index == 0)
        return 0;
      else
        return sum(list, index - 1) + index;
    }
        
    public void writeSequence(int n) {
      int j = n;
      System.out.print(intSequence(n,j) + " ");
    } // end of writeSequence method
    
    public int intSequence(int n, int j) {
      int i = (int) Math.ceil(((double) n)/(2));
      return 0;
    }
    
    public boolean isPal(String s) {
       if(s.length() == 0 || s.length() == 1)
          return true;
       if(s.charAt(0) == s.charAt(s.length()-1))
          return isPal(s.substring(1, s.length()-1));
       return false;
    } // end of isPal method


} // end of Ch15Algorithms class



