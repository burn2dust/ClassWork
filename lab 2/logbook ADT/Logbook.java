
import javax.swing.*;
import java.util.*;                 // For GregorianCalendar class

class Logbook
{
    // Data members
    private int logMonth,                   // Logbook month
                logYear;                    // Logbook year
    private int[]
                entry = new int[31];        // Array of Logbook entries
    private GregorianCalendar logCalendar;  // Java's built-in Calendar

    // Constructors
    public Logbook ()
    // Default constructor. Creates a logbook for the current month.
    // Uses the system clock to initialize the calendar.
    // Note:  Unlike mankind, Java's built-in Calendar numbers months
    //        from January = 0

    {
        int j;    // Loop counter

        logCalendar = new GregorianCalendar( );
        logMonth = logCalendar.get(Calendar.MONTH) + 1;
        logYear = logCalendar.get(Calendar.YEAR);
        
        // Initialize all entries to 0        
        for ( j = 0 ; j < 31 ; j++ )
            entry[j] = 0;
    }

    public Logbook ( int month, int year )
    // Creates an empty logbook for the specified month and year.
    // Note:  Unlike mankind, Java's built-in Calendar numbers months
    //        from January = 0
    {
        int j;   // Loop counter
        
        if ( month < 1 || month > 12 )
        {
            System.out.println("NOT a valid calendar month -- Defaulting to today!");
            logCalendar = new GregorianCalendar( );
            logMonth = logCalendar.get(Calendar.MONTH) + 1;
            logYear = logCalendar.get(Calendar.YEAR);
        }
        else
        {
            // Assumes a default DAY_OF_MONTH as first day of month
            logCalendar = new GregorianCalendar(year, month -1, 1);
            logMonth = month;
            logYear = year;
            // Your code goes here. Initial the private data members 
            // logMonth and logYear
            
        }
        for ( j = 0 ; j < 31 ; j++ )
            entry[j] = 0; // Initialize all entries of the logbook to 0
    }  // end of this constructor

    // Methods
    public void putEntry ( int day, int value )
    // Stores entry for the specified day.
    {
      if (day <= daysInMonth() ) {
        entry[day-1] = value;
      }
      else {
        System.out.println("Invalid day of month");
      }
        // Day must be less than or equal to 
        // the number of days in the logbook month.
        // Be careful with the index. Use a simple if-then-else
    }

    public int getEntry ( int day )
    // Returns entry for the specified day.
    {
        // Day must be less than or equal to 
        // the number of days in the logbook month.
        // Use an if-then-else; I've left you the "else" part
        if ( day <= daysInMonth() ) {
          return entry[day-1];
        }
        else
        {
            System.out.println("Invalid Day of Month!");
            return -1;
        }
    }

    public int month ( )
    // Returns the logbook month.
    {
        return logMonth;// Your code goes here. One return statement is all you need
    }

    public int year ( )
    // Returns the logbook year.
    {
        return logYear;// Your code goes here. One return statement is all you need
    }

    public int daysInMonth ( )
    // Returns the number of days in the logbook month.
    {
        int result;   // Result returned
        switch (logMonth) {
          case 4 : case 6 :case 9 : case 11 :
            result  = 30;
            break;
          case 2 :
            if (leapYear())
              result = 29;
            else
              result = 28;
            break;
          default :
              result = 31;
          }
        return result;
    }

    // Facilitator (helper) method  
    private boolean leapYear ( )
    // If the logbook month occurs during a leap year, then returns true.
    // Otherwise, returns false.
    {
        return (logCalendar.isLeapYear(logYear) );
    }
    
    private int dayOfWeek (int day) {
      logCalendar.set(logYear, logMonth -1, day);
      return logCalendar.get(Calendar.DAY_OF_WEEK)-1;
    }
    
    public void displayCalendar() {
      //int dotw = 0;  // NICK - I COMMENTED THIS OUT
      //int day = 1;   // NICK - I COMMENTED THIS OUT
      int dotw = dayOfWeek(1);
      //display title
      System.out.println("\t\t\t" + month() + " / " + year());
      //display weekday headings
      System.out.println("SUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT");
      //display calendar body
      for (int a= 0; a < dotw ; a++) {
        System.out.print("\t");
        //dotw++;  // NICK - I COMMENTED THIS OUT
      }
      for ( int d = 1 ; d <= daysInMonth() ; d++, dotw++ ) {  // NICK - I CHANGED THIS LINE
        if (dotw == 7) {                                      // NICK - I CHANGED THIS LINE
          System.out.println();                               // NICK - I CHANGED THIS LINE
          dotw = 0;                                           // NICK - I CHANGED THIS LINE
        }
        System.out.print(d + " " + entry[d-1] + "\t");        // NICK - I CHANGED THIS LINE
      }
    }
            
    
} // class Logbook