import java.io.*;

public class LastTwoByte {
    public static void main(String[] args) throws Exception {

        RandomAccessFile raf = new RandomAccessFile("empData.bin", "r");

        long length = raf.length();

        if (length >= 2) {
            raf.seek(length - 2);
            int byte1 = raf.read();
            int byte2 = raf.read();

            System.out.println("Second Last Byte: " + byte1);
            System.out.println("Last Byte: " + byte2);
        } else {
            System.out.println("File too small");
        }

        raf.close();
    }
}