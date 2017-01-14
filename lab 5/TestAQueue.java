//--------------------------------------------------------------------
//
//  Lab 5                                 
//
//  Test program for the operations in the Queue ADT linked list implementation
//
//--------------------------------------------------------------------

import java.io.*;
import java.util.*;
    
class TestAQueue
{
    public static void main(String args[]) throws IOException 
    {
        QueueList testQueue = new QueueList();  // Test queue of char
        char testElement = 'x';                 // Queue element
        char cmd = 'x';                         // Input command
        
        Scanner sc;
        sc = new Scanner(System.in);

        System.out.println("\nCommands:");
        System.out.println("  + x : Enqueue x");
        System.out.println("  -  : Dequeue");
        System.out.println("  #  : Length of the queue");
        System.out.println("  >  : Insert queue at beginning");
        System.out.println("  =  : Remove last queue");
        System.out.println("  C  : Clear the queue");
        System.out.println("  E  : Empty queue?");
        System.out.println("  F  : Full queue?");
        System.out.println("  Q  : Quit the test program");
        System.out.println();

        do
        {
            testQueue.showStructure();                    // Output queue

            System.out.print("\nCommand: ");              
            String str = sc.next();             // read in input string
            cmd = str.charAt(0);                // get first non-whitespace
            if (cmd == '+'  || cmd == '>')
            {
                if (str.length() > 1) {
                    testElement = str.charAt(1);
                }
                else
                    testElement = sc.next().charAt(0);
            }   

            switch (cmd)
            {
                case '+' :                                 // enqueue
                    System.out.println("Enqueue " + testElement);
                    testQueue.enqueue(testElement);
                    break;

                case '-' :                                  // dequeue
                    char ch = testQueue.dequeue();
                    if (ch != '*')
                      System.out.println("Dequeued " + ch);
                    break;

                case 'C' : case 'c' :                       // clear
                    System.out.println("Clear the queue");
                    testQueue.clear();
                    break;

                case 'E' : case 'e' :                       // empty
                    if ( testQueue.isEmpty() )
                        System.out.println("Queue is empty");
                    else
                        System.out.println("Queue is NOT empty");
                    break;

                case 'F' : case 'f' :                       // full
                    if ( testQueue.isFull() )
                        System.out.println("Queue is full");
                    else
                        System.out.println("Queue is NOT full");
                    break;
                case '#' :
                    if ( testQueue.isEmpty() )
                        System.out.println("Queue is empty");
                    else
                        testQueue.length();
                    break;
                case '>' :
                    testQueue.putFront(testElement);
                    break;
                case '=' :
                    testQueue.getRear();
                    break;
                case 'Q' : case 'q' :               // Quit test program
                    break;

                default :                           // Invalid command
                    System.out.println("Inactive or invalid command");
            }
        } while ( cmd != 'Q'  &&  cmd != 'q' );
    } // main
    
} // class TestAQueue