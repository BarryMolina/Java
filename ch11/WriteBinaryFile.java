import java.io.*;

public class WriteBinaryFile {

    public static void main(String[] args) throws IOException {

        int[] numbers = { 2, 4, 6, 8, 10, 12, 14 };

        FileOutputStream fstream = new FileOutputStream("Numbers.dat");
        DataOutputStream outputFile = new DataOutputStream(fstream);

        System.out.println("Writing the numbers to the file...");
        
        for(int i = 0; i < numbers.length; i++) {
              outputFile.writeInt(numbers[i]);
        }

        System.out.println("Done");

        outputFile.close();
    }
}
