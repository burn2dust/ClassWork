
//class AQueue implements Queue           // Array-based queue class
class AQueue 
{
    private int maxSize;        // Maximum number of elements in the queue
    private int front;          // Index of the front element
    private int rear;           // Index of the rear element
    private char [] element;    // Array containing the queue elements
    
    // Constructors
    public AQueue ( )               // Constructor: default size
    { 
        setup(50); 
    }
    
    public AQueue ( int size )      // Constructor: sets size
    { 
        setup(size);    
    }
    
    private void setup(int size)    // Called by constructor
    // Creates an empty queue.  
    // Allocates enough memory for size elements.
    { 
        maxSize = size; 
        front = -1;
        rear = -1;
        element = new char[size];
    }

    // Queue manipulation operations
    public void enqueue ( char newElement )   // Enqueue element at rear
    {
        if (isFull())
        {
            System.out.println("Queue is full, nothing added to queue");
            return;
        }
        rear = (++rear) % maxSize;
        element[rear] = newElement;
        if (front == -1)
            front = 0;
    }
    
    public char dequeue ()              // Dequeue element from front
    {
        char temp;                      // stores front element
        if (isEmpty())
        {
            System.out.println("Empty Queue, removed nothing from queue");
           // return null;
            return '0';
        }
        temp = element [front];
        if (front == rear)
        {
            front = -1;
            rear = -1;
        }
        else
            front = (++front) % maxSize;
        
        return temp;
    }
    
    public void clear ()              // Remove all elements from queue
    {   
        front = -1;
        rear = -1;
    }
    
    // Queue status operations
    public boolean isEmpty ()                   // Is Queue empty?
    {
        return ( front == -1);
    }
    
    public boolean isFull ()                    // Is Queue full?
    {                           
        return ( (rear + 1) % maxSize == front );
    }
 } // class AQueue