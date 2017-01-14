//--------------------------------------------------------------------
//
//  Lab 4
//
//  Stack Interface:  will allow declaration of any kind of stack
//   object as long as the stack variant class 'implements Stack'
//
//--------------------------------------------------------------------

public interface Stack  // Constants & Methods common to all stack ADTs
{
  // Default maximum stack size
  public static final int DEF_MAX_STACK_SIZE = 10;

  //Stack manipulation operations
  public void push(Object newElement); // Push Object onto stack
  public Object pop();                 // Pop Object from top of stack
  public void clear();                 // Remove all Objects from stack

  //Stack status operations
  public boolean isEmpty();        // Return true if stack is empty
  public boolean isFull();         // Return true if stack is full
  public void showStructure ();    // Outputs the elements in the stack
                                   // For testing/debugging purposes only
} // interface Stack
