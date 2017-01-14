//--------------------------------------------------------------------
//  Laboratory 2                                   TestPointList.java
//--------------------------------------------------------------------

import java.util.*;    
import java.awt.Point;

class TestPointList
{
    public static void main( String args[] ) // 
    {
        PointList testList = new PointList(8),  // Test list
            assignList = new PointList(4);      // List assigned to
        Point testPoint = null;                 // List element
        char cmd;                               // Input command
        Scanner sc;                     
        sc = new Scanner(System.in);
        int index = 0;
        
        System.out.println("\nCommands:");
        System.out.println("  + x y  : Append point (x,y) to the end of the list");
        System.out.println("  @      : Display the point marked by the cursor");
        System.out.println("  # x y  : Insert point (x,y) at the beginning of the list");
        System.out.println("  <      : Go to the beginning of the list");
        System.out.println("  >      : Go to the end of the list");
        System.out.println("  N      : Go to the next point");
        System.out.println("  P      : Go to the prior point");
        System.out.println("  C      : Clear the list");
        System.out.println("  E      : Empty list?");
        System.out.println("  F      : Full list?");
        System.out.println("  Q      : Quit the test program");
        System.out.println( );

        do
        {
            testList.showStructure();                     // Output list

            System.out.print("\nCommand: ");               // Read command
            cmd = sc.next().charAt(0);
            while (Character.isWhitespace(cmd))           // ignore whitespace
                cmd = sc.next().charAt(0);               
            if ( cmd == '+'  || cmd == '#' )
            {
                testPoint = new Point( );
                testPoint.x = sc.nextInt();
                testPoint.y = sc.nextInt();
            }
            else if ( cmd == 'M' || cmd == 'm' )
            {
                testPoint = new Point( );
                testPoint.x = sc.nextInt();
                testPoint.y = sc.nextInt();
                index = sc.nextInt();
            }
            else if ( cmd == 'd' || cmd == 'D' )
            {
                index = sc.nextInt();
            }
            switch ( cmd )
            {
            case '+' :                                  // append
                System.out.println("Append (" + testPoint.x
                                   + "," + testPoint.y + ")");
                testList.append(testPoint);
                break;
            case '#' :
                System.out.println("Insert at beginning (" + testPoint.x
                                   + "," + testPoint.y + ")");
                testList.insertAtBeginning(testPoint);
                break;
            case '@' :                                  // getCursor
                testPoint = testList.getCursor();
                if (testPoint == null)
                  System.out.println("empty list; cannot return value");
                System.out.println("Point marked by the cursor is (" 
                                   + testPoint.x + "," + testPoint.y + ")");
                break;
            case '<' :                                  // gotoBeginning
                if ( testList.gotoBeginning() )
                    System.out.println("Go to the beginning of the list");
                else
                    System.out.println("Failed -- list is empty");
                break;
            case '>' :                                  // gotoEnd
                if ( testList.gotoEnd() )
                    System.out.println("Go to the end of the list");
                else
                    System.out.println("Failed -- list is empty");
                break;
            case 'N' : case 'n' :                       // gotoNext
                if ( testList.gotoNext() )
                    System.out.println("Go to the next element");
                else
                    System.out.println("Failed -- either at the end of the list " 
                                       + "or the list is empty");
                break;
            case 'P' : case 'p' :                       // gotoPrior
                if ( testList.gotoPrior() )
                    System.out.println("Go to the prior element");
                else
                    System.out.println("Failed -- either at the beginning of the " 
                                       + "list or the list is empty");
                break;
            case 'C' : case 'c' :                       // clear
                System.out.println("Clear the list");
                testList.clear();
                break;
            case 'E' : case 'e' :                       // empty
                if ( testList.isEmpty() )
                    System.out.println("List is empty");
                else
                    System.out.println("List is NOT empty");
                break;
            case 'F' : case 'f' :                       // full
                if ( testList.isFull() )
                    System.out.println("List is full");
                else
                    System.out.println("List is NOT full");
                break;
            case 'm' : case 'M' : 
                testList.insertAnywhere(testPoint, index);
                break;
            case 'D' : case 'd' :
                testList.deleteAtIndex(index);
                break;
            case 'Q' : case 'q' :                   // Quit test program
                break;
            default :                               // Invalid command
                System.out.println("Inactive or invalid command");
            }
        }
            while ( cmd != 'Q'  &&  cmd != 'q' );
    } // main( )   
} // class TestPointList