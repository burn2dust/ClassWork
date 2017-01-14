//--------------------------------------------------------------------
//
//  SOLUTION: Linked list implementation of the Stack ADT
//
//--------------------------------------------------------------------

//Facilitator class for the Stack class
class StackNode             // A singly linked list node
{  
  private Object element;   // Object for this node
  private StackNode next;    // Reference to next node in list
  
  // because there are no access labels (public, private or protected),
  // access is limited to the package where these methods are declared
  StackNode(Object newElement, StackNode nextval) // Constructor 1
  { 
    element = newElement;  
    next = nextval; 
  }  //  Given Object

  // Other classes in this package need to know about next and element
  // or set next
  StackNode getNext() { // Return reference to next node
    return next; 
  }      
  
  Object getElement() { // Return element's value
    return element; 
  } 
  
  void setNext(StackNode nextVal) { // set this nodes "next" field
    next = nextVal; 
  }

} // class StackNode
