import java.io.*;

public class ReadRandomLetters {

    public static void main(String[] args) throws IOException {

        final int CHAR_SIZE = 2;
        long byteNum;
        char ch;

        RandomAccessFile randomFile = new RandomAccessFile("Letters.dat", "r");

        byteNum = CHAR_SIZE * 5;
        randomFile.seek(byteNum);
        ch = randomFile.readChar();
        System.out.println(ch);

        byteNum = CHAR_SIZE * 10;
        randomFile.seek(byteNum);
        ch = randomFile.readChar();
        System.out.println(ch);

        byteNum = CHAR_SIZE * 3;
        randomFile.seek(byteNum);
        ch = randomFile.readChar();
        System.out.println(ch);

        randomFile.close();
    }
}
