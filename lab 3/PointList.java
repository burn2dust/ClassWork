
import java.awt.Point;
                               
class PointList
{
    // // Default maximum list size -- a constant
    private static final int DEF_MAX_LIST_SIZE = 10;  
    
    // Data members
    public int  size,         // Actual number of points in the list
                cursor;       // Cursor array index
    Point ptlist[ ];          // Array containing the points

    // Constructors & helper method
    public PointList ( )        // Default Constructor
        // Creates an empty list. Allocates enough memory for maxNumber
        // points (defaults to DEF_MAX_LIST_SIZE, a constant). Note this 
        // one line constructor calls method "setup" which is found a 
        // couple of methods ahead.
    {
        setup ( DEF_MAX_LIST_SIZE );
    }
    
    public PointList ( int maxNumber )
        // Creates an empty list. Allocates enough memory for maxNumber
        // points. One line of code. 
    {
        setup( maxNumber );
    }
    
    private void setup ( int maxNumber )
    // I'll give you this one. Why do you think cursor is -1?
    {
        ptlist = new Point [ maxNumber ];
        size = 0;
        cursor = -1;
    }


    public void append ( Point newPoint )
        // Appends newPoint to a list. If the list is empty, then newPoint is
        // inserted as the first (and only) point in the list. Moves the
        // cursor to newPoint. Remember, you can call other methods that are
        // in this class as is shown here. You need at most 3 more lines of
        // code here, although it can be done in two. You have to update the
        // cursor, the size, and put the new point into the point list array.
        // Piece of cake.
    {
        if ( isFull() )
        {
            System.out.println("List is full -- nothing appended!");
            return;
        }
        else
        {
          cursor = size++;
          ptlist[cursor] = newPoint;
        }
    }

    public void clear ( )
        // Removes all the points from a list. One line of code.
    {
        size = 0;
    }

    public boolean isEmpty ( )
        // Returns true if a list is empty. Otherwise, returns false.
        // One line of code is all you need. 
    {
        return (size == 0);
    }

    public boolean isFull ( )
        // Returns true if a list is full. Otherwise, returns false.
        // One line of code is all you need
    {
        return size >= ptlist.length;
    }

    public Point getCursor ( )
        // Returns the point marked by the cursor. But be careful here
        // The list must not be empty. But suppose it is. This method 
        //returns a Point object. So if it is empty, what should the
        // method return?  Should be clear what to return if it is not
        // empty.  My code is two lines long.
    {
      if (isEmpty()) {
        return null;
      }
      else {
        return ptlist[cursor];
      }
    }

    public boolean gotoBeginning ( )
        // If a list is not empty, then moves the cursor to the beginning of
        // the list and returns true. Otherwise, if the list is empty, it 
        // returns false. Several ways to write this; my code is three 
        // lines long.
    {
      if (isEmpty()) {
        return false;
      }
      else {
        cursor = 0;
        return true;
      }
        
    }

    public boolean gotoEnd ( )
        // If a list is not empty, then moves the cursor to the end of the
        // list and returns true. Otherwise, returns false. Again, my code 
        // is three lines long.
    {
      if (isEmpty()) {
        return false;
      }
      else {
        cursor = size-1;
        return true;
      }
    }

    public boolean gotoNext ( )
        // If the cursor is not at the end of a list, then moves the cursor
        // to the next point in the list and returns true. Otherwise, 
        // returns false. Just implement this and you are done. Three
        // lines of code is what I used.
    {
      if (cursor == size-1) {
        return false;
      }
      else {
        cursor++;
        return true;
      }
    }

    public boolean gotoPrior ( )
        // If the cursor is not at the beginning of a list, then moves the
        // cursor to the preceeding point in the list and returns true.
        // Otherwise, returns false. We are starting to get into a rhythm
        // here. Three more lines of code is what I used. 
    {
      if (cursor <= 0) {
        return false;
      }
      else {
        cursor--;
        return true;
      }
    }

    public void showStructure ( )
        // Outputs the points in a list. If the list is empty, outputs
        // "Empty list". This operation is intended for testing/debugging
        // purposes only.
    {
        int j;   // Loop counter

        if ( size == 0 )
            System.out.println("Empty list");
        else
        {
            System.out.println("size = " + size +  "   cursor = " + cursor);
            for ( j = 0 ; j < ptlist.length ; j++ )
                System.out.print( j + "\t");
            System.out.println( );
            for ( j = 0 ; j < size ; j++ )
                System.out.print("(" + ptlist[j].x + "," + ptlist[j].y + ")\t");
            System.out.println( );
        }
    }

    public void insertAtBeginning(Point newPoint) {
      if (isFull()) {
        System.out.println("Error: List is full!");
      }
      else {
        for (int i = size; i > 0; i--) {
          ptlist[i] = ptlist[i-1];
          ptlist[0] = newPoint;
          cursor = 0;
          size++;
        }
      cursor = 0;
      ptlist[0] = newPoint;
      } 
    } // end of method
    
    public void insertAnywhere(Point newPoint, int index) {
      if ( isFull() ) {
        System.out.println("Error, cannot input point in the array.");
      }
      else if ( isEmpty() ){
          cursor = 0;
          ptlist[0] = newPoint;
        }
        else {
          for (int j = size; j > index; j--)
            ptlist[j] = ptlist[j-1];
          ptlist[index-1] = newPoint;
          cursor = index;
          size++;
      }
   } // end of method
    public void deleteAtIndex(int index){
    if ( isEmpty() ){
          System.out.println("Error: List is Empty!");
        }
    else {
        for (int j = index-1; j < size-1; j++)
          ptlist[j] = ptlist[j+1];
        ptlist[index] = ptlist[index+1];
        cursor = index;
        size--;
      }  
    }
} // class PointList