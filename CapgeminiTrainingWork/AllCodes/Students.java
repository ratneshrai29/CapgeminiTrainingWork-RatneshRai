import java.io.Serializable;
import java.util.HashMap;

public class Students  implements Serializable {
    public int roll;
    public int marks;

    HashMap<Integer, Integer> map = new HashMap<>();

    public Students(int roll, int marks) {
        this.roll = roll;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Students{" +
                "roll=" + roll +
                ", marks=" + marks +
                '}';
    }
}
