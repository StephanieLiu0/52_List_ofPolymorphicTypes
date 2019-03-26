/**
  Implement a list of integer elements, including
  both data and operations.
 */

public class List_inArraySlots {

    private Object[] elements;     // container for the elements of the list
    private int filledElements; // the number of elements in this list

    private static final int INITIAL_CAPACITY = 10;

    
    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
        elements = new Object[ INITIAL_CAPACITY];
        // filledElements has been initialized to the desired value, 0
    }
    
    /**
      @return the number of elements in this list
     */
    public int size() {
        return filledElements;
    }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
        String result = "[";
        for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
            result += elements[ elemIndex] + ",";
        return result + "]";
    }


    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( Object value) {
         // expand if necessary
         if( filledElements == elements.length)
	     expand();
         elements[ filledElements] = value;
         filledElements++;
         // idiomatic version: elements[ filledElements++] = value;
	 return true;
     }

     //overloaded add methods, allows us to pass primitives
     //(easier to use)
     public boolean add(int intValue) {
         return add(Integer.valueOf(intValue));
     } //valueOf turns intValue into an Integer
       //so it can be stored in an array of Objects

     public boolean add(double doubleValue) {
         return add(Double.valueOf(doubleValue));
     } //similar concept as adding the int.

     public boolean add(boolean booleanValue) {
	 return add(Boolean.valueOf(booleanValue));
     }

    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
     private void expand() {
        System.out.println( "expand... (for debugging)");
           /* S.O.P. rules for debugging:
              Working methods should be silent. But during
              development, the programmer must verify that
              this method is called when that is appropriate.
              So test using the println(), then comment it out.
              */
        Object[] bigger = new Object[ elements.length * 2];
        for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
            bigger[ elemIndex] = elements[ elemIndex];
        elements = bigger;
     }

    
    /**
      accessor
      @return element @index from this list
      precondition: @index is within the bounds of the array.
     */
    public Object get( int index ) {
	return elements[index];
    }
    
    /**
      Set value at @index to @newValue

      @return old value at @index
      @precondition: @index is within the bounds of this list.
     */
    public Object set( int index, Object newValue ) {
	Object oldValue = elements[index];
	elements[index] = newValue;
	return oldValue;
    }

    
    /**
      Insert @value at position @index in this list.

      Shift the element currently at that position (if any)
      and any subsequent elements to the right
      (that is, increase the index associated with each).
     */
     public void add( int index, Object value) {
	 if( filledElements == elements.length) expand();
	 for ( int elemIndex = filledElements;  elemIndex > index ; elemIndex--)
	     elements[elemIndex] = elements[elemIndex - 1];
	 filledElements++;
	 elements[index] = value;
     }
	
     //same concept as the add methods without the index
     public void add(int index, int intValue) {
         add(index, Integer.valueOf(intValue));
     }

     public void add(int index, double doubleValue) {
         add(index, Double.valueOf(doubleValue));
     }

     public void add(int index, boolean booleanValue) {
	 add(index, Boolean.valueOf(booleanValue));
     }

    //add value at beginning
    public void addAsHead(Object value) {
	add(0, value);
    }

    /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the 
      left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
     public Object remove( int index) {
	 Object oldValue = elements[index];
	 for ( int elemIndex = index ; elemIndex < filledElements; elemIndex++)
	     elements[elemIndex] = elements[elemIndex + 1];
	 filledElements--;
	 return oldValue;
     }
}



