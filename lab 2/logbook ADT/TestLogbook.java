
import java.util.*;     // added by me

class TestLogbook
{
    public static void main( String args[])  
    {
        int month,              // Input month
            year,               // Input year
            day,                // Input day
            entry,              // Input logbook entry
            dofw,               // Day of the week
            j;                  // Loop counter
        boolean stop = false;   // Signals end of test
        char ans;               // Y/N answer for report of test 1
        Logbook testLog;
        
        Scanner sc; // added by me
        sc = new Scanner(System.in); // added by me
        
        // Create a logbook (not used in Test 4).
        System.out.print("\n\nEnter the month and year for the logbook month: ");
        month = sc.nextInt(); // added by me
        year = sc.nextInt(); // added by me
        testLog = new Logbook(month,year);

        // Test 1 : Tests the month, year, and daysInMonth operations.
        System.out.println("Month : " + testLog.month());
        System.out.println("Year  : " + testLog.year());
        System.out.println("# days in month : " + testLog.daysInMonth());

        System.out.print("Another Logbook (Y/N)?  ");
        ans = sc.next().charAt(0);
        if (ans == 'N' || ans == 'n') stop = true;

        while ( !stop )           // repeat if desired
        {
            System.out.print("\n\nEnter the month and year for the logbook month: ");
            month = sc.nextInt(); // added by me
            year = sc.nextInt(); // added by me
            testLog = new Logbook(month,year);

            // Test 1 : Tests the month, year, and daysInMonth operations.
            System.out.println("Month : " + testLog.month());
            System.out.println("Year  : " + testLog.year());
            System.out.println("# days in month : " + testLog.daysInMonth());

            System.out.print("Another Logbook (Y/N)?  ");
            ans = sc.next().charAt(0);
            if (ans == 'N' || ans == 'n') stop = true;
        }

        // Test 2 : Tests the putEntry and getEntry operations.
        stop = false;
        while ( !stop )
        {
            System.out.print("\nEnter day and entry (0 0 to exit Test 2) : ");
            day = sc.nextInt(); // added by me
            entry = sc.nextInt(); // added by me
            if ( day != 0 )
            {
                testLog.putEntry(day, entry);
                System.out.println("Logbook:");
                for ( day = 1 ; day <= testLog.daysInMonth() ; day++ )
                {                    
                    System.out.print(day + " " + testLog.getEntry(day) + "\t");
                    if ( day % 7 == 0 )
                        System.out.println( );
                }
                System.out.println( );
            }
            else stop = true;
        }

        // Test 3 : Tests the calendar operation.
        //3
          System.out.println( );
          testLog.displayCalendar();
          System.out.println( );

    } // main( )
    
} // class TestLogbook