import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class CopyFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("data.txt");
        FileOutputStream fout = new FileOutputStream("datacopy.txt");

//        With question mark in copy file because its reads -1
//        int ch =0;
//        while(ch != -1){
//            ch = fin.read();
//
//            fout.write(ch);
//        }

        // WITHOUT QUESTION MARK IN COPY FILE
//        int ch;
//
//        while((ch = fin.read()) != -1) {
//            fout.write(ch);
//        }

        // QUESTION 1
        int ch=0;
        boolean skip=true;
        while(ch  != -1){
            ch = fin.read();
            if(ch==-1){
                break;
            }
            if(skip){
                fout.write(ch);
            }
            skip=!skip;
        }
        fin.close();
        fout.close();
        System.out.println("File copied");


    }

}
