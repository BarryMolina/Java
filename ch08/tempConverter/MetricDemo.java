package tempConverter;

import javax.swing.JOptionPane;

public class MetricDemo {

    public static void main(String[] args) {

        String input;
        double miles;
        double kilos;

        input = JOptionPane.showInputDialog("Enter a distance in miles.");
        miles = Double.parseDouble(input);

        kilos = Metric.milesToKilometers(miles);
        JOptionPane.showMessageDialog(null, 
                String.format("%,.2f miles equals %,.2f kilometers.", miles, kilos));

        input = JOptionPane.showInputDialog("Enter a distance in kilometers.");
        kilos = Double.parseDouble(input);

        miles = Metric.kilometersToMiles(kilos);
        JOptionPane.showMessageDialog(null, 
                String.format("%,.2f kilometers equals %,.2f miles.", kilos, miles));

        System.exit(0);

    }
}
