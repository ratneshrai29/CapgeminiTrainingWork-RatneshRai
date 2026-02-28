import java.io.IOException;
import java.io.*;

public class ReadWord {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("z.txt");
        FileWriter fw = new FileWriter("zCopy.txt");
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);
        String line;
        boolean copy=true;
        while((line=br.readLine()) != null){
//            String[] words = line.split("[ ]+");
            String[] words = line.split("\\s+");
            for(String word:words){
                if(copy){
                    bw.write(word+" ");
                }
                copy=!copy;
            }
            bw.newLine();
        }
        br.close();
        bw.close();
        System.out.println("File copied");
    }
}
