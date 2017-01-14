/*
 * Nicholas Kaide and Renan Custodio
 * CS 120
 * 3/19/2012
 * 
 * We used the lab 6 for the beginning part of the coding. We then went in for help
 * for the first method of the program. 
 *    The findKnight method was not as hard as we had originally thought it to be. 
 * First we intiallized the Node Variables that we would be using. Then we set the
 * nodes to the "start" point. Then implemented a "do-while" loop that goes to the
 * Node right before the Node that we want to "delete", and set the next Node after
 * the "deleted Node." At the end of the "do-while" is the m-1, which is one lower
 * than the total amount of Nodes that we have. It repeates the process untill m,
 * our total amount of Nodes, is one. Then the interger a is set to the last node
 * value that is there and is returned in the end.
 *    The checkKnightNum was simple as it was given to us on how to write that one.
 * We just entered it in and there it is.
 * 
 * 
 */
import java.util.*;

class RoundTable
{
    public static void main(String args[]) //throws IOException 
    {
        Scanner sc;
        sc = new Scanner(System.in);
        int m, k;
        
        System.out.print("Enter number of knights (m) and cycle (k) (0 0 to stop): ");
        m = sc.nextInt();  // number of knights
        k = sc.nextInt();  // cycle number
        while ( m != 0 ) {
           SLCList knights = new SLCList(); 
           SLCLNode table = knights.seatKnights( m );
           System.out.println("Surviving knights is " +
                            knights.findKnight( table, m, k ));
           System.out.println("We will now confirm our answer using our recursive formula:");
           System.out.println("The recursive function returns: " + checkKnightNum(m, k) );
           
           System.out.print("\nEnter number of knights (m) and cycle (k) (0 0 to stop): ");
           m = sc.nextInt();  // number of knights
           k = sc.nextInt();  // cycle number
       } // end of while
       System.out.println("\nKing Arthur reminds you to be chivalrous and always");
       System.out.println("help the weak, the helpless, and the oppressed.");
    } // end of main
    
    
    public static int checkKnightNum( int m, int k ) {
      if ( m == 1 )
        return 1;
      else
        return 1 + (checkKnightNum( m-1, k ) + k-1 ) % m;
    } // end of method checkKnightNum
    
} //class RoundTable
