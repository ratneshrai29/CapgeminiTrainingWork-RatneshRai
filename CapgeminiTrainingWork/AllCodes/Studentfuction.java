//import java.io.*;
//import java.util.*;
//public class Studentfuction {
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Menu");
//        System.out.println("Enter roll and marks: ");
//        Studentfuction.writedata(sc.nextInt(), sc.nextInt());
//        System.out.println("Enter second roll and marks: ");
//        Studentfuction.writedata(sc.nextInt(), sc.nextInt());
//        printdata();
//    }
//
//
//
//
//    public static void writedata(int roll, int marks) throws IOException, ClassNotFoundException {
//        FileOutputStream fout = new FileOutputStream("filename.bin");
//        ObjectOutputStream oos = new ObjectOutputStream(fout);
//        oos.writeObject(new Students(roll, marks));
//        oos.writeObject(new Students(roll, marks));
//
//        fout.close();
//        oos.close();
//        System.out.println("written");
//    }
//
//    public static void printdata() throws IOException, ClassNotFoundException{
//        FileInputStream fin = new FileInputStream("filename.bin");
//        ObjectInputStream oin = new ObjectInputStream(fin);
//        Object o1 = oin.readObject();
//        Object o2 = oin.readObject();
//
//
//        fin.close();
//        oin.close();
//
//        System.out.println(o1);
//        System.out.println(o2);
//
//    }
//}
//

//import java.io.*;
//import java.util.*;
//public class Studentfuction {
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Menu");
//        System.out.println("Enter roll and marks: ");
//        Studentfuction.writedata(sc.nextInt(), sc.nextInt());
//        System.out.println("Enter second roll and marks: ");
//        Studentfuction.writedata(sc.nextInt(), sc.nextInt());
//        printdata();
//    }
//
//
//
//
//    public static void writedata(int roll, int marks) throws IOException, ClassNotFoundException {
//        FileOutputStream fout = new FileOutputStream("filename.bin");
//        ObjectOutputStream oos = new ObjectOutputStream(fout);
//        oos.writeObject(new Students(roll, marks));
//        oos.writeObject(new Students(roll, marks));
//
//        fout.close();
//        oos.close();
//        System.out.println("written");
//    }
//
//    public static void printdata() throws IOException, ClassNotFoundException{
//        FileInputStream fin = new FileInputStream("filename.bin");
//        ObjectInputStream oin = new ObjectInputStream(fin);
//        Object o1 = oin.readObject();
//        Object o2 = oin.readObject();
//
//
//        fin.close();
//        oin.close();
//
//        System.out.println(o1);
//        System.out.println(o2);
//
//    }
//}
//

import java.io.*;
import java.util.*;

public class Studentfuction {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        FileOutputStream fout = new FileOutputStream("filename.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fout);

        System.out.println("Enter roll and marks:");
        writedata(oos, sc.nextInt(), sc.nextInt());
        System.out.println("Enter second roll and marks:");
        writedata(oos, sc.nextInt(), sc.nextInt());


        oos.close();
        fout.close();

        printdata();
    }
    public static void writedata(ObjectOutputStream oos, int roll, int marks)
            throws IOException {

        oos.writeObject(new Students(roll, marks));
        System.out.println("Written");
    }

    public static void printdata() throws Exception {

        FileInputStream fin = new FileInputStream("filename.bin");
        ObjectInputStream oin = new ObjectInputStream(fin);

        try {
            while (true) {
                Students s = (Students) oin.readObject();
                System.out.println(s);
            }
        } catch (EOFException e) {
            System.out.println("End of file");
        }

        oin.close();
        fin.close();
    }
}



