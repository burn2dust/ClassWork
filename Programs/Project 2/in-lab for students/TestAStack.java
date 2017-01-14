/* Nicholas Kaide
 * 2/18/12
 * CS 120
 * 
 * Infix Evaluator
 * 
 * I made an attempt to fixing this and could not for the life of me
 * figure out what was happening even in the Debug Mode. I wanted to
 * complete this but couldn't due to the infinite loop that happens
 * at the first number. 
 * 
 * The program was designed to pass the "(" in a stack when it runs
 * into a "(". For the ")", it would take everything out of the stack
 * untill it ran into a "(". For a "+" or "-", it would pop everything
 * out of the stack unless it ran into a "*" or "/". For the "*" or
 * "/" the program would pop everthing in front of the stack unless
 * there was a "(".
 *  
 * */




//--------------------------------------------------------------------
//  Program 2 A infix to postfix evaluator
//--------------------------------------------------------------------

import java.util.*;
// Driver class for Stack implementation tests
class TestAStack
{
    // Main routine for Stack implementation tests
    public static void main(String args[]) 
    {
        char ch, ch1;    // operand or operator
        String charStr;
        char operand,
             opResult;
        
        do {
            AStack resultStack = new AStack(20);         
            Scanner sc;
            sc = new Scanner(System.in);

            System.out.println();
            resultStack.clear();
            resultStack.push('#');
            System.out.print("Enter expression in infix form ($ to quit): ");
            charStr = sc.next();
            int i = 0;
            if (charStr.charAt(0) == '$') {
              System.out.println("\nEnd of Program\n");
              return;
            }
            ch = charStr.charAt(i);
            while (i < charStr.length()) {
              
              switch (ch) {
                
                case '0' : case '1' : case '2' : case '3' : case '4' : 
                case '5' : case '6' : case '7' : case '8' : case '9' :
                  System.out.print(ch);
                  break;
                  
                case '(' :
                  resultStack.push(ch);
                  break;
                  
                case ')' :
                  do {
                  resultStack.pop();
                } while (ch != '(');
                  break;
                  
                case '*' : case '/' :
                  do {
                    resultStack.push(ch);
                } while (ch != ')');
                  resultStack.pop();
                  resultStack.pop();
                  break;
                  
                case '+' : case '-' :
                  resultStack.push(ch);
                  break;
              }
            }
        } while (ch != '#');
    }// end main
} // end class
                    
