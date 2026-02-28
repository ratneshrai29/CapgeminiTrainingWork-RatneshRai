import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


//class Myints{    // CUSTOM CLASS
//    public int first(){
//        return  (int) System.currentTimeMillis() % 100;
//    }
//
//    public int sencond(){
//        return new Random().nextInt(500);
//    }
//}

public class LambdaInBuilt{
    public static void main(String[] args) {
        Consumer<String> consumer = (str) ->{
            System.out.println("This is consumer");
            System.out.println("This is consuming "+str);
        };
        consumer.accept("SPRING FRAMEWORK");
        List<Integer> list = List.of(4,5,6,7,23,45,56);
        list.forEach((x)-> System.out.println("Consuming "+x));  // Line no. 13 == Line no.14 - Line no. 19
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("Consuming "+t);
            }
        });
        list.forEach(System.out::println);

        // Function
        Function<String, Integer> fun2 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return null;
            }
        };

        Function<String, Integer> fun1 = (str) -> str.length();  // Line no. 33 == Line no.26 - Line no. 31
        Integer len = fun1.apply("Aman Rai");
        System.out.println(len);

        // Write a lambda to get first 2 chars in uppercase of the string using 'Function' as Functional interface
        Function<String, String> fun3 = (str) -> str.substring(0,2).toUpperCase();
        String nick = fun3.apply("ratnesh rai");
        System.out.println(nick);

        // Supplier
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(400);
            }
        };

//       Supplier<Integer> supplier = () -> new Random().nextInt(400);     // Line no. 50 == Line no.43 - Line no. 48
         supplier = () -> new Random().nextInt(400);
        for(int i=0;i<=10;i++){
            System.out.println(supplier.get());
        }

        Random random = new Random();
        supplier = random::nextInt;
//      supplier.get() = random.nextInt();   // This is the meaning

//        MyInts obj = new MyInts();       // Custom class object
//        supplier = obj::first;
//        supplier = obj::second;

        // Predicate
        Predicate<String> pred = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()>=0;
            }
        };
        pred = (str) -> str.length()>= 0;
        Integer[] arr = {23,34,54,654,56,54,3445,4322,5667,55,3,6};
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(arr));
        list2.removeIf(x -> x > 100);
        System.out.println(list2);










    }
}