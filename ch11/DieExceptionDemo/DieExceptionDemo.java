package DieExceptionDemo;

public class DieExceptionDemo {

    public static void main(String[] args) {

        final int DIE_SIDES = 6;

        Die die = new Die(DIE_SIDES);

        System.out.println("Initial value of the die: ");
        System.out.println(die.getValue());


    }
}
