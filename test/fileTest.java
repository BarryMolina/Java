import java.io.*;
import java.util.Scanner;

public class fileTest {

    public static void main(String[] args) throws IOException {

        File file = new File("test.txt");

        if (file.exists()) {
            Scanner outputFile = new Scanner(file);

            while (outputFile.hasNext()) {
                System.out.println(outputFile.nextLine());
            }
        }
        else {
            System.out.println("File not found.");
        }
    }
}
