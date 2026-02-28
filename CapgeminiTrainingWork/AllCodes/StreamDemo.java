import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StreamDemo {
    public static void main(String[] args) {
       List<Integer> list = List.of(23,34,54,54,56,54,45,43,80,55,3,6);
//       Stream<Integer> stream = list.stream();
//       boolean allmatch = stream.allMatch(x-> x>=40);  // All greater than
//       System.out.println("ALL greater than 40 : " +allmatch);
//
//       boolean anymatch = list.stream().anyMatch(x-> x>=75);  // Any greater than
//        System.out.println("Any above 75 : "+anymatch);
//
//        System.out.println(list.stream().count()); // Count no of element
//
//        list.stream().distinct().forEach(System.out::println); // Remove duplicate
//        System.out.println();
//
//        list.stream().filter(x->x>=40).forEach(System.out::println); // Filter the elements
        Stream<Integer> filter = list.stream().filter(x->x>=90);
        Optional<Integer> any = filter.findAny();
        System.out.println(any);
//        list.stream().filter(x -> x>=40)
//                .map(x->x/10.0) // function T -> R
//                .forEach(System.out::println);
//
//        list.stream().filter(x -> x>=40)
//                .map(x->x/10.0) // function T -> R
////                .collect(Collectors.toList())
////                .collect(Collectors.toSet());
//                .collect(Collectors.toMap(null, null));

        Integer [] arr = {234,43,45,6,65,67,654,34,567,5674,45};
        Stream<Integer> stream2 = Arrays.stream(arr);





    }
}
