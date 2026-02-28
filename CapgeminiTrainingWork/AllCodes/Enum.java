//public class Enum {
//    enum Color{
//        Red,
//        Green,
//        Yellow;
//
//        Color(){
//            System.out.println("Constructor called for "+ this);
//        }
//
//        void display(){
//            System.out.println("Color is "+this);
//        }
//    }
//    public static void main(String[] args) {
//        Color c = Color.Red;
//        c.display();
//    }
//}



// ENUM WITH CONSTRUCTOR BASED
enum Level {

    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private int value;

    Level(int value) {
        this.value = value;
        System.out.println("Hello " + value);
    }

    public int getValue() {
        return value;
    }
}

public class Enum {
    public static void main(String[] args) {

        Level l = Level.HIGH;

        System.out.println("Level: " + l);
        System.out.println("Value: " + l.getValue());
    }
}


