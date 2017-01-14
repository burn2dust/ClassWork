//--------------------------------------------------------------------
//
//  Lab 4                          
//
//  Driver program for the operations in the AStack ADT; an array implementation of a stack
//
//--------------------------------------------------------------------

//import java.io.*; ORIG
import java.util.*;

// Driver class for Stack implementation tests
class TestAStack 
{
    // Main routine for Stack implementation tests
    public static void main(String args[]) //throws IOException ORIG
    {
        Stack testStack = new AStack(8);    // Test stack
        Stack assignStack = new AStack(8);  // Destination for assignment
        char testElement = 'x';             // Stack element 
        //double testElement = 1.23;
        //char cmd = 'w';                     // Input command
        char cmd;  //temp!!
        
        Scanner sc;
        sc = new Scanner(System.in);
    
        System.out.println("Commands:");
        System.out.println("  + x : Push x");
        System.out.println("  -   : Pop");
        System.out.println("  C   : Clear");
        System.out.println("  E   : Empty stack?");
        System.out.println("  F   : Full stack?");
        System.out.println("  Q   : Quit the test program");
        System.out.println();

        do
        {
            testStack.showStructure();              // Output stack

            System.out.print("Command: ");          // Read command
            //cmd = (char)System.in.read();  ORIG
            cmd = sc.next().charAt(0);
            while (Character.isWhitespace(cmd))     // ignore whitespace
                //cmd = (char)System.in.read(); ORIG
                cmd = sc.next().charAt(0);
            if ( cmd == '+' )
            {
                //testElement = (char)System.in.read();  ORIG
                testElement = sc.next().charAt(0);
                if (Character.isWhitespace(testElement))  // testElement is whitespace
                    System.out.print("Element to add: ");
                while (Character.isWhitespace(testElement))
                    //testElement = (char)System.in.read();  ORIG // get valid testElement
                    testElement = sc.next().charAt(0);
            }
            
            switch ( cmd )
            {
                case '+' :                          // push
                    System.out.println("Push " + testElement);
                    testStack.push(new Character(testElement));
                    break;

                case '-' :                          // pop
                    System.out.println("Popped " + testStack.pop());
                    break;

                case 'C' : case 'c' :               // clear
                    System.out.println("Clear the stack");
                    testStack.clear();
                    break;

                case 'E' : case 'e' :               // empty
                    if ( testStack.isEmpty() )
                        System.out.println("Stack is empty");
                    else
                        System.out.println("Stack is NOT empty");
                    break;

                case 'F' : case 'f' :               // full
                    if ( testStack.isFull() )
                        System.out.println("Stack is full");
                    else
                        System.out.println("Stack is NOT full");
                    break;

                case 'Q' : case 'q' :               // Quit test program
                    break;

                default :                           // Invalid command
                    if (!(Character.isWhitespace(cmd))) 
                        System.out.println("Inactive or invalid command");
            } // switch
        } while ( cmd != 'Q'  &&  cmd != 'q' );

    } // main
    
} //class TestAStack

