import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class SalesReport {

    public static void main(String[] args) {
        String filename = "SalesData.txt";
        int months = 0;

        double oneMonth;
        double totalSales = 0.0;
        double averageSales;

        try {
            File file = new File(filename);
            Scanner inputFile = new Scanner(file);

            while (inputFile.hasNext()){
                oneMonth = inputFile.nextDouble();

                totalSales += oneMonth;

                months++;
            }

            inputFile.close();

            averageSales = totalSales / months;

            JOptionPane.showMessageDialog(null, String.format("Number of months: %d\n" +
                                                            "Total Sales: $%,.2f\n" +
                                                            "Average Sales: $%,.2f",
                                                            months, totalSales, averageSales));
        }
            catch(FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "The file " + filename + " does not exist.");
            }
            catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "Non-numeric data found in the file.");
            }
        System.exit(0);
    }
}
