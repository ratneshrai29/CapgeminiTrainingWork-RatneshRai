import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Student implements Serializable {
    int rollNo;
    int marks;
    String name;

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }
}