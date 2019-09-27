//********************************************************************
//  ArrayList.java     
//
//  This is my very pared-down and simplified version of an ArrayList definition.
//********************************************************************

package generics;

public class ArrayList2<T>
{
   private final int DEFAULT_CAPACITY = 100;
   private int open;  // indicates the next open slot
   private int count;
   private T[] array; 
  

   //-----------------------------------------------------------------
   //  Creates an empty ArrayList using the default capacity.
   //-----------------------------------------------------------------
   public ArrayList2()
   {
      open = 0;
      array = (T[])(new Object[DEFAULT_CAPACITY]);
      for(int i=0; i<array.length-1; i++){
    	  array[i] = null;
      }
   }

   //-----------------------------------------------------------------
   //  Creates an empty ArrayList using the specified capacity.
   //-----------------------------------------------------------------
   public ArrayList2(int initialCapacity)
   {
      open = 0;
      array = (T[])(new Object[initialCapacity]);
      for(int i=0; i<array.length-1; i++){          
    	  array[i] = null;
      }
   }

   //-----------------------------------------------------------------
   //  Adds the specified element to the next available slot in the array
   //-----------------------------------------------------------------
   public void add (T element)
   {
	  if (size() == array.length )
		  expandCapacity();
	  
	  array[open] = element;
      open++;
   }
   
   public void add (T element, int index)
   {
	  if (size() ==  array.length){
		  expandCapacity();
	  }
	  
	  if(index>array.length)
		  System.out.println("Array is full");
		  
	  if(array[index] != null)                                                      
		  System.out.println("Sorry, element already at position " + index);       
	  
	  if(array[index] == (null)){                                                   
		  array[index] = element;
	      count++;
	      open = index+1;
	  }
		  
	  
   }
   
   

   //-----------------------------------------------------------------
   //  Removes the last element added to the array. 
   //-----------------------------------------------------------------
   public T remove()
   {
      if (isEmpty())
        System.out.println("The list is empty");

      open--;
      T result = array[open];
      array[open] = null; 
 
      return result;
   }
   
   public T remove(int index)
   {
	   T result = null;
      if (isEmpty())
        System.out.println("The list is empty");
      
      if(index>array.length || index<0)                                
    	  System.out.println("Position entered is invalid");
       
      if(array[index] == null)                                         
    	  System.out.println("No element in position " + index);
      
      if(array[index] != null){                                       
    	  result = array[index];
    	  array[index] = null;
    	  for(int i = index; i<array.length-1; i++){
    		  array[i] = array[i+1];
    	  }
    	  count--;
    	  open--;
      }
      
      
 
      return result;
   }

   //MY SECOND VERSION OF THE REMOVE METHOD
   //-------------POLYMORPHISM[OVERLOADING]--------------------//
    public T remove(T element)
    {
        T result = null;
    	for (int i = 0; i < array.length; i++)    
    	{
    		if(element.equals(result))             
    		{
    			System.out.println("Element entered is found and it's the same as an element in the array");
    			result = element;                  
    		}
    		else
    		{
    			System.out.println("Element entered is not found");
    		}
    	}
    	
    	for (int i = 0; i < array.length; i++)
    	{
    		array[i] = array[i + 1];               
    	}
    	count--;
    	
    	return result;
    }
   
   //-----------------------------------------------------------------
   //  Returns true if the array is empty and false otherwise. 
   //-----------------------------------------------------------------
   public boolean isEmpty()
   {
	   
	return (count == 0);
   }
 
   //-----------------------------------------------------------------
   //  Returns the number of elements in the array.
   //-----------------------------------------------------------------
   public int size()
   {
	return count;
   }

   //-------------------------------------------------
	//  Creates a new array to store the contents of the array with
	//  twice the capacity of the old one.
	//-----------------------------------------------------------------
	private void expandCapacity()
	{
	    T[] larger = (T[])(new Object[array.length*2]);

	      for (int scan=0; scan < array.length; scan++)
	         larger[scan] = array[scan];

	      array = larger;
	   }

   
   //-----------------------------------------------------------------
   //  Returns a string representation of the entire array. 
   //-----------------------------------------------------------------
   public String toString()
   {
      String result = "";

      for (int scan=0; scan < array.length; scan++){
    	  if(array[scan] != null)
    	  result = result + "Index position " + scan + " " + array[scan].toString() + "\n";
      }
         

      return result;
   }

   
}
