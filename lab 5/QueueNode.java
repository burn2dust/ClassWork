

class QueueNode              // A linked list node
{  
   private char element;     // 2 fields in a QueueNode; the first is a char and the 
   private QueueNode next;   // 2nd is a reference to the next QueueNode in the queue 
  
   public QueueNode(char newElement, QueueNode nextval) { // QueueNode constructor 
     element = newElement;  
     next = nextval; 
   } 

  // Things you can do to a QueueNode
  public QueueNode getNext() { // Return reference to next QueueNode
      return next; 
  }      
  public char getElement() { // Return element's value
      return element; 
  }   
  public void setNext(QueueNode nextVal) { // set this QueueNodes next field
      next = nextVal; 
  }
} // end class QueueNode
