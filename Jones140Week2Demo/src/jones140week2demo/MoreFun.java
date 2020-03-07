
package jones140week2demo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class MoreFun {
    
    Scanner keyboard = new Scanner(System.in);
    public enum Month { JAN, FEB, MARCH, APR, MAY, JUNE, JULY, AUG, SEP, OCT, NOV, DEC };

    int z = 55;
   

    
    public void arrays()
    {
            //Arrays 
    	
    	int arraySize = 3;
    	String[] relatives = new String[arraySize];  //does not need to be a constant
    	//String[] friends = {"Mike", "Dan", "Joe"};
            
//            Compare Arrays
//            Copying Arrays -  assigning an array to another array allows both arrays access to the same data 
    	int[] num1 = {567, 324, 999};
    	int[] num2 = num1;
    	System.out.println("num1 value: " + num1[2]  + "\nnum2 value: " + num2[2]);
                    
        num2[2] = 414;  //change last value in one of the arrays

        System.out.println("\n\nnum1 value: " + num1[2]  + "\nnum2 value: " + num2[2]);
                    
    
    //-Use Arrays.copyOf() to make a copy of an array that does not point to original array addresses
            //Use:     Arrays.copyOf(array, array.length);		
            int[] num3 = Arrays.copyOf(num1, num1.length);
            
    
            System.out.println("\n\nnum1 value: " + num1[2]  + "\nnum3 value: " + num3[2]);
            //change last value in one of the array
            num3[2] = 777;
                   
            System.out.println("\n\nnum1 value: " + num1[2]  + "\nnum3 value: " + num3[2]);
    
    //*****************************
            // Use System.arraycopy to copy arrays without pointing to original address
            // arraycopy(source array, starting element, destination array, starting element, length of array)
            char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
    			    'i', 'n', 'a', 't', 'e', 'd' };
            
            // can be selective in elements taken from old array
            char[] copyTo = new char[7];
    
            System.arraycopy(copyFrom, 2, copyTo, 0, 7);
            System.out.println("\n" + new String(copyTo) +"\n");
              
            //******Using printf with an array.    
            String[] strung = new String[9];
            strung[0] = "Merrily";
              
            System.out.printf("%s we go along", strung[0]);
            
            
         
    //Enhanced For Loop
    //Like ForEach in C#
    //for ( data type variable name : arrayname)
    	
            int[] numbers = {45,73,29};
            int total = 0;
            
            for (int element : numbers)
            {
              total = total + element;
            }						//adds up all of the elements in the array
    	System.out.println("total: " + total);
    
    //Same as: 
    	for (int i = 0; i < numbers.length; i++)
            {
               total = total + numbers[i];
            }
    //*************** using char and String
            String badWord = "";
            
            for(char letter : copyFrom)
            {
                badWord += letter;
            }
            
            System.out.println("BadWord: " + badWord);
    



    //ArrayList<> is similar to List<> in C#
    //ArrayList
        ArrayList<String> names = new ArrayList<String>();  
    //Brackets at end call constructor
         
      
        names.add("Dude");
        names.add("Sally");
        names.add("John");
        names.size();  //gets length of array
        int nameSize = names.size() - 1;  //determines the last useable element in the array
        String name2 = names.get(1);  //
        String name3 = names.set(2, "Alice");

        System.out.println(names); //prints out all of the values in the ArrayList
        names.remove(2);
        System.out.println(names);


/* Wrapper Classes” - used for arraylists for all ‘primitive’ data types. 
   Creates a class that is using the primitive data types. This is why a String data type 
   is not used as ‘string’ as it is really a class. Example: double is a data type, 
   Double is a class. */ 
    ArrayList<Double> values = new ArrayList<Double>();
    values.add(29.95);
    double x = values.get(0);
    System.out.println(x);
  
    }
    /*
        An enum type is a special data type that allows a variable to be a set of predefined constants.
        Constants should be defined in uppercase letters.
        enums have predefined methods available for use.
    
        toString() - returns the name of the calling constant object
        ordinal() - returns an integer of the element position in the set(like an array)
        equals() - returns true if its argument is equal to the calling method
        compareTo() - returns negative if the ordinal value is less than the argument, positive if greater
        
        valueOf() - accepts a string and returns a constant value
        values() - returns an array of all the enumerated constants
    
    */
    public void enumerators()
    {
        Month birthMonth;        //create a variable type called birthMonth
        birthMonth = Month.MAY;  //assign a value to birthMonth from the enum defined above
        int ordinalNum = birthMonth.ordinal();
        String getMonth = birthMonth.toString();
        
        if(birthMonth.equals(Month.NOV))
        {
            System.out.println("Turkey Month! ");
        }
        else
        {
            System.out.println("That's a good month! ");
        }
        System.out.println(birthMonth.valueOf("DEC"));
        
        System.out.println("ordinal: " + ordinalNum);
        
        System.out.println("getMonth is: " + getMonth);   //starts at 0
    
    }
    
    //passing values to and from methods
    public void passingValues()
    {
        
        int a = 5;
        int b = 10;
        int c;
        c = receivingValues(a, b);
        System.out.println("Here is the result: " + c);
    
    }
    
    public int receivingValues(int receiveANumber, int receiveAnotherNumber)
    {
        
        int answer;
        
        answer = receiveANumber + receiveAnotherNumber;
        return answer;
    }
    
    //scope
    public void scope()
    {
        //local variables are accessible/visible inside of the method where they are declared.
        //local variables don't exist after a method is over.
        //class level variables are visible to all the methods of the class where they are declared.
        //The variable x has scope· within the brackets
           
        int x = 50; 
        System.out.println(x); 

    }
   
    public void scope2()
    {
        // Uncommenting below line· would produce·
        // error· since variable x is out of scope· .
  
        //System.out.println(x);  
        
        //this does not produce an error because there is a class level variable named z declared
        //sbove that is accessible/visible to all methods in the class.
        System.out.println(z);
    
    }
    //printF  - print Function
    public void printing()
    {
        
        String stringLike = "Happy String";
        int intLike = 23999;
        double doubleLike = 125603.3546;
               
        System.out.printf("The text is here with a %S that can also be an integer %,d or a double %,.2f . %n", stringLike, intLike, doubleLike);
    }
        
    //using predefined .equals function. talk through this, not for follow along
    public void areCookiesDone()
    {
        System.out.print("\n\n\n\n\n");

        String temp = "warm";
        String color = "golden";
        String timer = "on";

      
        //use of And to see if cookies are ready
        if (temp.equals("warm") && color.equals("golden"))
        {
            System.out.println("Cookies are ready to eat!");
        }
        else
        {
            System.out.println("Keep Cookies in for a minute longer");
        }
        //use of OR to see if cookies are OK to eat.
        if (temp.equals("warm") || color.equals("golden"))
        {
            System.out.println("Cookies are OK to eat!");
        }
        else
        {
            System.out.println("Keep Cookies in for a few more seconds");
        }
        //Combo AND and OR, with AND being True
        if (temp.equals("warm") && color.equals("golden") || timer.equals("on"))
        {
            System.out.println("Cookies are ready to eat!");
        }
        else
        {
            System.out.println("Keep Cookies in for a minute longer");
        }
        //Combo AND and OR, with OR being true, do you really want to eat undercooked cookies?
        color = "pale";
        if (temp.equals("warm") && color.equals("golden") || timer.equals("on"))
        {
            System.out.println("Cookies are ready to eat!");
        }
        else
        {
            System.out.println("Keep Cookies in for a minute longer");
        }
        //Nested if to make sure cookies are done right if the timer goes on

        if (timer.equals("on"))
        {
            if (temp.equals("warm") && color.equals("golden"))
            {
            System.out.println("Cookies are ready to eat!");
            }
        }
        else
        {
           System.out.println("Keep Cookies in for a minute longer");
        }


    }//end RCookiesDone



    public void inLineIfThenElse()
    {
         //An inline if then else, sometimes called a ternary operator. 
         // It takes the following form:
         //  boolean statement ? true result : false result;
        
          

              int a = 5;
              int b = 3;

              int max = (a > b) ? a : b; //this is essentially 
                                         //an inline if then else block 
                   // if a greater than b, then set max to a else set max to b. 
              System.out.println("\n\tMax: " + max);

    }
    
    public void addDollarAmounts()
    {
        double total = 0;
        double counter = 0;
        
       while(counter != -1)
       {
            System.out.println("Enter Dollar Amount or -1 to Quit");
            counter = keyboard.nextDouble();
            if (counter != -1)
            {
                total = total + counter;
            }
       }
        
        System.out.println(total);
    }
}



