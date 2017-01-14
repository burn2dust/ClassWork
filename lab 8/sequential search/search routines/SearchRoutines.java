
class SearchRoutines {
    /**
     * A constant to represent unsuccessful search
     */
    public static final int NOT_FOUND = -1;

    /**
     * Default constructor
     */
    public SearchRoutines( )
    {

    }

    /**
     * Searches a specified int value in the array using
     * the linear search method.
     */
    public int linearSearch ( int[] number, int searchValue ) {
        int  loc   = 0;
        while ( loc < number.length  &&
                 number[loc] != searchValue ) {
            loc++;
            
        }
        if ( loc == number.length) { //Not found
            return NOT_FOUND;
        }
        else {
            return loc;              //Found, return the position
        }
    }
    
    public int linearSearchWithSentinel (int[] number, int searchValue) {
      int loc = 0;
      int number2[] = new int[number.length+1];
      for (int z = 0 ; z != number2.length; z++ ) {
        if (z != number.length) {
          number2[z] = number[z];
        }
        else {
          number2[z] = searchValue;
        }
      }
      while (number2[loc] != searchValue) {
        loc++;
      }
      if (loc <= number.length-1)
        return loc;
      else
        return NOT_FOUND;
    }
    
    public int recursiveLinearSearch  (int[] number, int searchValue, int firstIndex) {
      int i = number.length;
      if (i==0) {
        return NOT_FOUND;
      }
      else {
        if (firstIndex >= number.length) {
          return NOT_FOUND;
        }
        else if (number[firstIndex] == searchValue) {
          return firstIndex;
        }
        else {
          return recursiveLinearSearch(number, searchValue, firstIndex+1);
        }
      }
    }
}