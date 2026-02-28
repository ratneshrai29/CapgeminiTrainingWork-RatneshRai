import java.util.*;

public class collection {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Mango");
        list.add("Apple");
        list.add("Banana");
        list.add("cherry");
        list.add("strawberry");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.add(1,"grapes");
        System.out.println(list);
        System.out.println( list.size());
        list.remove("apple");
        System.out.println(list);
        System.out.println(list.isEmpty());
        System.out.println(list.contains("mango"));
        list.clear();
        System.out.println(list);


        for (int i =0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
