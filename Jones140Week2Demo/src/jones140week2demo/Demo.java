
package jones140week2demo;

import java.util.Scanner;

/**
 *
 * @author student
 */
public class Demo {
    
    public enum Month { JAN, FEB, MARCH, APR, MAY, JUNE, JULY, AUG, SEP, OCT, NOV, DEC };

    
    
    public Demo()
    {
        doubleValue(5);
        //enumerators();   
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
    
  
    
    public double doubleValue(int numDays)
    {   
        //use a for loop when you know how many times you want to loop 
        double amount = 0;
  
        for(int j = 0; j < numDays; j++)
        {
            amount = Math.pow(j, 2);
            
        }  
        
        System.out.println(amount);
        return amount;
    }

    public void looping()
    {
        for(int i = 0; i< 10; i++){
            System.out.println("loop index: " + i);
        }
    
    }
    
    public void myloop()
    {
       int[] myArray = new int[20];     
    
       int i = 1;
       while(i < 21)
       {
           myArray[i - 1] = i;
           i++;
       }
       
       
       for(int j = 0; j< 20; j++){
            System.out.println(myArray[j]);
       }
       
    }
    
    public void addMoney(){
        
    Scanner input = new Scanner(System.in);
        
    double money = 0;
    boolean exit = false;
    
        System.out.println("Enter amount to add or -1 to quit!");
    
    do{
       if(input.hasNextInt()){
           int userVal = input.nextInt();
           
           if(userVal == -1){//exit
               exit = true;
           }else{
               money += userVal;
           }
           
       }else{
           System.out.println("Enter a valid number!");
       }
       
        System.out.println("Total : $"+ money);
        
    }while(!exit);
    
    
    
    
    
    }
 
    
}
