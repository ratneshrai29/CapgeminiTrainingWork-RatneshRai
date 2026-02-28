import java.io.Serializable;
public class Employees implements Serializable {
    public int empid;
    public String name;

    public Employees(int empid, String name) {
        this.empid = empid;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "empid=" + empid +
                ", name='" + name + '\'' +
                '}';
    }
}
