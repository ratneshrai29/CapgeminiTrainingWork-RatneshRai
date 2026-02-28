public class Hashcode_Equal {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1.equals(s2)); // True compare content
        System.out.println((s1 == s2)); // False Compare memory Refrences
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        int a = 4;
        int b = 4;
        System.out.println(a == b); // True Primitive stores value directly


        String s3 = "Aman";
        String s4 = "Aman";
        System.out.println(s3.equals(s4));
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        System.out.println((s3 == s4));    // Because of String Constant Pool.
//                                            Both refer to same pooled object.
    }
}
