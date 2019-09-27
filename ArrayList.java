//********************************************************************
//  ArrayList.java     
//
//  This is my very pared-down and simplified version of an ArrayList definition.
//********************************************************************

package generics;

public class ArrayList<T>
{
   private final int DEFAULT_CAPACITY = 100;  //maximum number of elements in the array is 100
   private int open;                          // indicates the next open slot
   private T[] array;                         //declares an arraylist of type T
  

   //-----------------------------------------------------------------
   //  Creates an empty ArrayList using the default capacity.
   //-----------------------------------------------------------------
   public ArrayList()                              
   {
      open = 0;
      array = (T[])(new Object[DEFAULT_CAPACITY]);  //creates an arraylist //default capacity = 100(size of the array).
   }

   //-----------------------------------------------------------------
   //  Creates an empty ArrayList using the specified capacity.
   //-----------------------------------------------------------------
   public ArrayList(int initialCapacity)
   {
      open = 0;
      array = (T[])(new Object[initialCapacity]);   //creates an arraylist //initial capacity = amount entered by the user
   }

   //-----------------------------------------------------------------
   //  Adds the specified element to the next available slot in the array
   //-----------------------------------------------------------------
   public void add (T element)
   {
	  if (size() == array.length )      //if the size of the array is equal to the arraylist actual size which is 100
		  expandCapacity();         //we call the expand capacity method that doubles the size of th earraylist to 200...
	  
	  array[open] = element;            //element(the item being added) is put put to where the open is located which is the next available slot in the arraylist.
      open++;                               //open++ means adding one to the open slot each time an element is added to the arraylist.
   }
   
   

   //-----------------------------------------------------------------
   //  Removes the last element added to the array. 
   //-----------------------------------------------------------------
   public T remove()
   {
      if (isEmpty())                                  //if the arraylist is empty.
        System.out.println("The list is empty");      //displays that it is empty.

      open--;                                         //minus(removes) the last element from the slot in the arraylist
      T result = array[open];                         //the new result in the arraylist after the removal is...
      array[open] = null;                             //setting the last slot where the last element was removed to null so that another element can be added.
 
      return result;                                  //returns the  result 
   }
   
   //-----------------------------------------------------------------
   //  Returns true if the array is empty and false otherwise. 
   //-----------------------------------------------------------------
   public boolean isEmpty()
   {
	   
	return (open == 0);           //returns true if the arraylist is empty, else returns false otherwise.
   }
 
   //-----------------------------------------------------------------
   //  Returns the number of elements in the array.
   //-----------------------------------------------------------------
   public int size()
   {
	return open;                 //returns the number of elements in the arraylist- open contains the number of elements.
   }

   //-------------------------------------------------
	//  Creates a new array to store the contents of the array with
	//  twice the capacity of the old one.
	//-----------------------------------------------------------------
	private void expandCapacity()
	{
	    T[] larger = (T[])(new Object[array.length*2]);    //creates a second arraylist called larger, wth twice the size(200, 400, 600 etc...)

	      for (int scan=0; scan < array.length; scan++)    //scan or i is just an integer variable, used to control the number of times the loop is executed
	         larger[scan] = array[scan];                   //this larger[scan] = array[scan] means it copies over the elements from the first arraylist to the new one.
                                                              
	      array = larger;                                  //and renames the first arraylist to larger
	   }

   
   //-----------------------------------------------------------------
   //  Returns a string representation of the entire array. 
   //-----------------------------------------------------------------
   public String toString()
   {
      String result = "";                                     //initializes the variable String

      for (int scan=0; scan < open; scan++)                   //for loop for which scan/i is less than open(which is the slot of elements).
         result = result + array[scan].toString() + "\n";     //result is being set to result plus the elements in the arralylist. array[scan].toString() displays the elements in the arraylist.

      return result;                                          //returns a toString() representation of the objects values.
   }

   
}
