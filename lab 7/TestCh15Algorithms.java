 /**
    Test various recursive algorithms
*/

import javax.swing.*;
import java.awt.*;
import java.io.*;

class TestCh15Algorithms {

//--------------------------------
//  Data Members
//--------------------------------
    /**
     * A NL (new line) constant
     */
    private static final String NL = System.getProperty("line.separator");

    /**
     * The Ch15Algorithms object for running the selected algorithm
     */
    private Ch15Algorithms algorithmRunner;

//--------------------------------
//  Constructors
//--------------------------------
    /**
     * Default constructor.
     */
    public TestCh15Algorithms() {
        algorithmRunner = new Ch15Algorithms( );
    }

    public static void main( String[] args ) {
        TestCh15Algorithms driver = new TestCh15Algorithms(  );
        driver.start( );
    }

    public void start( ) {
        int selection;
        do {
            selection = getSelection( );
            switch ( selection ) {
                case 1: runFactorial( );
                        break;
                case 2: runLinesGetShorter();
                        break;
                case 3: runSumRange( );
                        break;            
                case 4: runBinomialCoefficient();
                        break;
                case 5: runFibonnaci();
                        break;
                case 6: runReverseString();
                        break;
                case 7: runTowersOfHanoi( );
                        break;
                case 8: runNonRecursiveFib();
                        break;
                case 9: runAnagram();
                        break;
               case 10: runDecimalToBinary();
                        break;
               case 11: runCountDigits();
                        break;
               case 12: runHarmonic();
                        break;
               case 13: runCountRandom();
                        break;
              case 14:  runSumValues();
                        break;
              case 15:  runWriteSequence();
                        break;
              case 16:  runPalindrome();
            }
        } while ( selection != 0 );
        System.exit(0);
    }

    private void runFactorial( ) {
        int N;
        while (true) {
            N = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Compute N! Enter N:" ));
            if (N > 0) break;
            JOptionPane.showMessageDialog(null, "N must be positive" );
        }
        int answer = algorithmRunner.factorial( N );
        System.out.println(NL + NL);
        System.out.println( "Factorial of " + N + " is " + answer );
    }

    private void runLinesGetShorter( ) {
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter n: "));
        System.out.println(NL + NL);
        algorithmRunner.linesGetShorter(n);
    }

    private void runSumRange( ) {
        int m, n;
        m = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter m: "));
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter n: "));
        System.out.println(NL + NL);
        System.out.println("The sum of the ints between "
            + m + " and " + n + " is: " + algorithmRunner.sumRange(m, n));
    }
    
    private void runBinomialCoefficient() {
        int n, r;
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter n: "));
        r = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter r: "));
        System.out.println(NL + NL);
        System.out.println("The binomial coefficient C("
            + n + "," + r + ") is: " + algorithmRunner.binomialCoefficient(n, r));
    }
    
    private void runFibonnaci() {
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter n: "));
        for (int i=0; i<=n; ++i) {
            System.out.println("fib(" + i + ") = " + algorithmRunner.fib(i));
        }
    }
    
    private void runNonRecursiveFib() {
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "Fib: nonrecursive.  Enter n: "));
        for (int i=0; i<=n; ++i) {
            System.out.println("fib(" + i + ") = " + algorithmRunner.nonRecursiveFib(i));
        }
    }
    
    private void runReverseString() {
        String inputStr = JOptionPane.showInputDialog(null,
                                                  "Enter a string" );

        algorithmRunner.reverseString(inputStr,0);
    }
    
    private void runTowersOfHanoi( ) {
        int diskCnt = Integer.parseInt(
                        JOptionPane.showInputDialog(null,
                                                    "Towers of Hanoi. How many disks?"));

        System.out.println(NL + NL);

        algorithmRunner.towersOfHanoi( diskCnt, 1, 3, 2 );
    }
    
    private void runAnagram() {
        String inputStr = JOptionPane.showInputDialog(null,
                                                  "Enter a string" );
        algorithmRunner.anagram("",inputStr);
    }
    
    private void runDecimalToBinary() {
        int decimalNum = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Enter the positive integer in decimal: "));
        System.out.println();
        System.out.print("Decimal " + decimalNum + " = ");
        algorithmRunner.decToBin(decimalNum, 2);
        System.out.println(" binary");
    }
    
    private void runCountDigits() {
        int num = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Enter a positive integer: "));
        System.out.println();
        System.out.println("The number of digits in " + num +
                " is " + algorithmRunner.countDigits(num));
    }
    
    private void runHarmonic() {
        int num = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Enter a positive integer: "));
        System.out.println();
        System.out.println("The sum of the first " + num + 
                " terms of the harmonic series is " + algorithmRunner.sumHarmonicTerms(num));
    }
    
    private void runCountRandom() {
        int num = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Enter n - (the # of elements and range of elements in array): "));
        System.out.println();
        int[] a = new int[num];
        for (int i=0; i<num; ++i) {
            a[i] = (int) ((Math.random()*num) + 1);
        }
        System.out.println("Here are the numbers in the array: ");
        for (int i=0; i< num; ++i) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();
        for (int i=1; i<=num; ++i) {
            System.out.println("Number of " + i + "s is " +
                        algorithmRunner.countRandom(i,a,0,num-1));
       }
    }
    
    private void runSumValues() {
      int[] list = {1,2,3,4,5,6,7,8,9,10};
      System.out.println("The sum of the integers in array list is " + 
                     algorithmRunner.sum(list));
    }
    
    private void runWriteSequence() {
      int n = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Enter a positive integer n:" ));
      System.out.println("The output sequence for this n is ");
      algorithmRunner.writeSequence(n);
    }
    
    private void runPalindrome() {
      String inputStr = JOptionPane.showInputDialog(null, "Enter a string" );
      System.out.println("TESTING\n " + inputStr + "\n");
      //boolean isPal = algorithmRunner.palindrome(inputStr, 0, inputStr.length()-1);  
      if (algorithmRunner.isPal(inputStr))
        System.out.println(inputStr + " is a palindrome");
      else
        System.out.println(inputStr + " is NOT a palindrome");
    }
        
    private int getSelection( ) {
        int selection;

        String menu = "Select Algorithm:"         + NL +
                        "   1) Factorial"         + NL +
                        "   2) Lines Get Shorter" + NL +
                        "   3) Sum Range"         + NL +
                        "   4) Binomial Coeff."   + NL +
                        "   5) Fibonnaci"         + NL +
                        "   6) Reverse String"    + NL +
                        "   7) Towers of Hanoi"   + NL +
                        "   8) Nonrecursive fib"  + NL +
                        "   9) Anagrams"          + NL +
                        "  10) Decimal to Binary" + NL +
                        "  11) Count # 0f Digits" + NL +
                        "  12) Harmonic Series"   + NL +
                        "  13) Count Random"      + NL + 
                        "  14) Sum array values"  + NL +
                        "  15) Write sequence"    + NL +
                        "  16) Palindromes"       + NL +
                        "   -------------------"  + NL +
                        "   0) Quit" ;

        selection = Integer.parseInt(
                        JOptionPane.showInputDialog(null, menu));
        return selection;
    }
}