

class Node              // A singly linked circular list node
{  
   private int element;     // The number of the knight for this node
   private Node next;   // Reference to next node in SLCL
  
   public Node(int newElement, Node nextval) {// SLCL node constructor 
     element = newElement;  
     next = nextval; 
   } 

  // Things you can do to a SLCL node
  public Node getNext() { // Return reference to next node
      return next; 
  }      
  public int getElement() { // Return element's value
      return element; 
  }   
  public void setNext(Node nextVal) { // set this nodes next field
      next = nextVal; 
  }
} // class SLCLNode
