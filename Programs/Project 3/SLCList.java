class SLCList 
{ 
  private SLCLNode start;
  
  public SLCList() {  // the SLCList constructor                  
      start = null;
  } // end of constructor                          
                       
  public SLCLNode seatKnights ( int m ) {
    SLCLNode p, q;
    start = new SLCLNode( 1, start );
    p = start;
    for ( int i = 2 ; i <= m ; i++ ) {
      q = new SLCLNode(i, p);
      p.setNext(q);
      p = q;
    } // end of for
    return start;
  } // end of method
    
  
  public int findKnight ( SLCLNode table, int m, int k ) {
    SLCLNode p, q;
    p = start;
    q = start;
    do {
      for ( int j = 0 ; j != (k-1) ; j++ ) {
        p = table.getNext();
        q = p;
      } // end of for
      p = table.getNext();
      q.setNext(p);
      q = p;
    } while ( m != 1 );
    int a = table.getElement();
    return a;
  } // end of method
  
  
} // class LStack

