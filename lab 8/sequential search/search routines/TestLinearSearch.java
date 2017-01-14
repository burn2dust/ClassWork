/*
 * Nicholas Kaide and Renan Custodio
 * 3/26/12
 * CS 120
 * Lab 8
 * 
 *  Welcome to the program. This program will first ask the user how he/she
 * would like to search for a particular number in a "randomly" generated
 * array of numbers. The first option goes throught the array, one by one,
 * and looks at each value and compares for equality to the value that it
 * is searching for. The second option adds the searched value one the end
 * of the array. It then searches one by one for the searched value. If it
 * runs into the searched value before the end of the array then it returns
 * the location of the value. The third option is a recursive call to search
 * through the array value and then calles itself if it is not the searched
 * value
 * 
 * NOTE: THIS PROGRAM WILL NOT DO THE RECURSIVE CALL FOR 10,000 IN AN ARRAY.
 * 
 * 
 * 
 */
import java.util.*;  // for date, time 
import java.text.*;  // for SimpleDateFormat
class TestLinearSearch {
    
    private final static int EMPTY = -1;
    public static void main (String[] args) {
        Date now;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
        int[ ] number = new int[10000];
        SearchRoutines mySearch = new SearchRoutines( );
        int    position;
        Scanner sc = new Scanner(System.in);
        
        //Initialize the array elements to empty
        for (int i = 0; i < number.length; i++ ) {
            number[i] = EMPTY;
        }

        //Store numbers from 0 to 999999
        //into an array of int at a random position
        int num = 0, loc;
        while (num < number.length) {
            //Generate a random number between 0 and number.length-1
            //and use this value as the index of the position to
            //store the number. BE SURE YOU SEE WHAT IS HAPPENING HERE
            loc   = (int) Math.floor( Math.random() * number.length );
            while ( number[loc] != EMPTY ) {
                //loc already has a number in it
                //generate another location
                loc = (int) Math.floor( Math.random() * number.length );
            }
            number[loc] = num;
            num++;
        }
        System.out.println("Welcome to the Program. This program will");
        System.out.println("search through a randomly generated list ");
        System.out.println("of numbers and give when I found the     ");
        System.out.println("number. The choices for searching are:   ");
        System.out.println("1. Linear Search                         ");
        System.out.println("2. Linear Search with Sentinel           ");
        System.out.println("3. Recursive Linear Search\n             ");
        System.out.println("Numbered choice? :\n                     ");
        
        int cmd = sc.nextInt();
        
        switch (cmd) {
        
      case 1 :
                  
        //Test linear search
        now = new Date();
        System.out.println("current time is " + sdf.format(now));
        position = mySearch.linearSearch( number, 435 );
        System.out.println( "Search 435; Index returned:   " + position ); 
        now = new Date();
        System.out.println("current time is " + sdf.format(now)); 
        position = mySearch.linearSearch( number,23 );
        System.out.println( "Search 23; Index returned:   " + position );
        now = new Date();
        System.out.println("current time is " + sdf.format(now));
        position = mySearch.linearSearch( number, 1198765 );
        System.out.println( "Search 1198765; Index returned: " + position );
        now = new Date();
        System.out.println("current time is " + sdf.format(now));
        break;
        
      case 2 :
        
        //Test linear search with Sentinel
        now = new Date();
        System.out.println("current time is " + sdf.format(now));
        position = mySearch.linearSearchWithSentinel( number, 435 );
        System.out.println( "Search 435; Index returned:   " + position ); 
        now = new Date();
        System.out.println("current time is " + sdf.format(now)); 
        position = mySearch.linearSearchWithSentinel( number,23 );
        System.out.println( "Search 23; Index returned:   " + position );
        now = new Date();
        System.out.println("current time is " + sdf.format(now));
        position = mySearch.linearSearchWithSentinel( number, 1198765 );
        System.out.println( "Search 1198765; Index returned: " + position );
        now = new Date();
        System.out.println("current time is " + sdf.format(now));
        break;
        
      case 3 :
        
        //Test recursive linear search
        now = new Date();
        System.out.println("current time is " + sdf.format(now));
        position = mySearch.recursiveLinearSearch( number, 435, 0 );
        System.out.println( "Search 435; Index returned:   " + position ); 
        now = new Date();
        System.out.println("current time is " + sdf.format(now)); 
        position = mySearch.recursiveLinearSearch( number, 23, 0);
        System.out.println( "Search 23; Index returned:   " + position );
        now = new Date();
        System.out.println("current time is " + sdf.format(now));
        position = mySearch.recursiveLinearSearch( number, 1198765, 0 );
        System.out.println( "Search 1198765; Index returned: " + position );
        now = new Date();
        System.out.println("current time is " + sdf.format(now));
        break;
        
      default :
        
        System.out.println("You entered something that was not");
        System.out.println("between 1 and 3.                  ");
        }
    }
}