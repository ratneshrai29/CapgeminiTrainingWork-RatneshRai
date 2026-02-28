import java.io.*;

public class Serializationdemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fout = new FileOutputStream("empData.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(new Employees(234, "Aditya"));
        oos.writeObject(new Employees(235, "Shubham"));
        oos.writeInt(987);
        oos.close();
        fout.close();
        System.out.println("Data Written");


        FileInputStream fin = new FileInputStream("empData.bin");
        ObjectInputStream ois =new ObjectInputStream(fin);
        Object ob1 = ois.readObject();
        Object ob2 = ois.readObject();
        int x = ois.readInt();

        ois.close();
        fin.close();

        System.out.println(ob1);
        System.out.println(ob2);
        System.out.println(x);
    }

}
