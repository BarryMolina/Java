
package jones140week2demo;


public class Demo2 {
    
    
    
    
    public void myMethod()
    {
            
    //boolean statement ? true result: false result
    
        int a = 5;
        int b = 3;
        int max = (a > b) ? a : b;

        System.out.println(max);
    }
    
    public void printFun()
    {
        String stringLike = "Happy String";
        int intLike = 23999;
        double doubleLike = 12345.67;
        
        System.out.println(stringLike + " " + intLike + " " + doubleLike);
        System.out.printf("The text is here with a %S that can also be an integer %,d or a double"
                + " %,.2f. %n", stringLike, intLike, doubleLike );        

    }
    
    public void loopFun()
    {
        //for( data type variable name : arrayname)
        
        
        int[] numbers = {45, 73, 29};
        int total = 0;
        int total2 = 0;
        for(int element : numbers)
        {
            total = total + element;
        }
        System.out.println("Here is the total: " + total);
        
        //Same as:
        for(int i = 0; i < numbers.length; i++)
        {
            total2 = total2 + numbers[i];
            
        }
        System.out.println("Here is the total again: " + total2);
    
    }
    
    
}
