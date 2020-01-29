public class enumDay {

    enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, 
        SATURDAY }

    public static void main(String[] args) {

        Day workDay = Day.WEDNESDAY;

        System.out.println(workDay);

        if (workDay.equals(Day.WEDNESDAY)) {
            System.out.println("The days are the same");

        }
    }
}
