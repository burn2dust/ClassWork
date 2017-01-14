//--------------------------------------------------------------------                                        LStack.java
//
//  Linked list implementation of the Stack ADT
//
//--------------------------------------------------------------------

//class LStack implements Stack, Cloneable  // Linked stack class
class LStack implements Stack
{
  private StackNode top;                // Reference to top of stack

  public LStack() {                    // Default Constructor 
      setup(); 
  }                          
  
  public LStack(int size) {             // Constructor: ignore size
     setup(); 
  }              

  private void setup() {               // Initialize stack for constructors
     top = null; 
  }                       

  public void clear() {                 // Remove Objects from stack
     top = null; 
  }                       
  
  public void push(Object newElement) {  // Push Object onto stack
     // make sure newElement isn't null
     if (newElement == null) {
          System.out.println("Element is null -- added nothing to the stack");
          return;
     }
     top = new StackNode(newElement, top); 
  }

  public Object pop() {                 // Pop Object at top of stack 
    // make sure stack isn't empty
    if(isEmpty()) {
        System.out.println("Empty stack -- removed nothing from stack");
        return null;
    }
    Object it = top.getElement();
    top = top.getNext();
    return it;
  }

  public boolean isEmpty() {          // Return true if empty stack
     return top == null; 
  }
  
  public boolean isFull() {           // isFull() is always false since
     return false;   
 }                                     // Java will automatically generate an
                                      // OutOfMemoryError if there is insufficient
                                      // memory and will abort the program
  
  public void showStructure ()
  // Linked list implementation. Outputs the elements in a stack. If
  // the stack is empty, outputs "Empty stack". This operation is
  // intended for testing and debugging purposes only.
  {
    StackNode p;   // Iterates through the stack

    if (isEmpty())
        System.out.println("Stack is empty");
    else
    {
       System.out.print("top ");
       for ( p = top ; p != null ; p = p.getNext() )
           System.out.print(p.getElement() + " ");
       System.out.println("bottom");
    }
  } // showStructure

} // class LStack

