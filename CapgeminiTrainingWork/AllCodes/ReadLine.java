import java.io.IOException;
import java.io.*;

public class ReadLine {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("z.txt");
        FileWriter fw = new FileWriter("zCopy.txt");
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);
        String line1;
        boolean copyLine=true;
        while((line1=br.readLine())!=null){
            if(copyLine){
                bw.write(line1);
                bw.newLine();
            }
            copyLine=!copyLine;
        }
        br.close();
        bw.close();
        System.out.println("File Copied");
    }
}
