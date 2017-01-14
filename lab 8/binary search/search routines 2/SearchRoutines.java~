// Chapter 11 Sample Program: Search algorithms.

class SearchRoutines {
//    Data Members
    /**
     * A constant to represent unsuccessful search
     */
    public static final int NOT_FOUND = -1;

    // Default constructor 
    public SearchRoutines( )
    {
    }

    /**
     * Searches a specified int value in the array using
     * the binary search method.
     */
    public int binarySearch ( int[] number, int searchValue ) {
        int  low      = 0,
             high     = number.length - 1,
             mid      = (low + high) / 2;
        while ( low <= high && number[mid] != searchValue ) {
                System.out.println(mid);
            if (number[mid] < searchValue) {
                low = mid + 1;
            }
            else  { //number[mid] > searchValue
                high = mid - 1;
            }
            mid  = (low + high) / 2;
        }
        if ( low > high) {
            mid = NOT_FOUND;
        }
        return mid;
    }
}