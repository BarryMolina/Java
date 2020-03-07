package Interface;

public class Person implements Displayable
{
    private String name;

    public Person(String n)
    {
        name = n;
    }

    public void display()
    {
        System.out.println("My name is " + name);
    }
}
