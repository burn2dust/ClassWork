import java.text.DecimalFormat;
class List 
{
  private Node first;                
  private Node rear;
  
  public List() {                    
      first = null; 
      rear = null;
  }                          
                       
  public void enqueue(int newElement) {  
     Node newNode = new Node(newElement, null);
     if (isEmpty()) {
         first = rear = newNode;
     }
     else {
         rear.setNext(newNode);
         rear = newNode;
     }
  }

    public boolean isEmpty() {          // Return true if empty stack
     return first == null; 
  }
 
  public void linkedInsertionSort() {
      Node lastInOrder;
      Node firstOutOfOrder;
      Node current;
      Node trailCurrent;
      
      firstOutOfOrder = first;
      lastInOrder = first;
      
      if (first == null)
        System.out.println("Queue is empty");
      else if (first.getNext() == null)
        System.out.println("Sorted");
      else {
        while (lastInOrder.getNext() != null) {
          if (firstOutOfOrder.getElement() < first.getElement())
            firstOutOfOrder = first;
          else {
            trailCurrent = first;
            current = first.getNext();
            // now search the list
            while (current.getElement() < firstOutOfOrder.getElement()) {
              trailCurrent.getNext();
              current.getNext();
            } // end small while
            if (current != firstOutOfOrder) {
              // insert firstOutOfOrder between current and trail current
              lastInOrder.setNext(firstOutOfOrder.getNext());
              firstOutOfOrder.setNext(current);
              trailCurrent.setNext(firstOutOfOrder);
            } // end if
            else // firstOutOfOrder is already at the proper place
              lastInOrder = lastInOrder.getNext();
          }// end small else
        }// end big while
      }// end big else
   }
  
  public void showStructure ()
  {
    Node p;   // Iterates through the stack

    if (isEmpty())
        System.out.println("Queue is empty");
    else
    {
       //System.out.print("front ");
       int index;
       DecimalFormat fmt = new DecimalFormat("000");
       for ( p = first,index=0 ; p != null ; p = p.getNext(), ++index )
           //System.out.print(p.getElement() + " ");
           if ( ( (index+1) % 20) == 0)
               System.out.println(fmt.format(p.getElement()) + " ");
           else
               System.out.print(fmt.format(p.getElement()) + " ");
       //System.out.println("rear");
    }
  } // showStructure

} // class LStack

