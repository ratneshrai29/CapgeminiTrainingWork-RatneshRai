public class class2 {
    public static void main(String[] args) {
        // ARRAY EXAMPLE
//        int [] arr = new int[4];
//        System.out.println(arr[0]);
//        System.out.println(arr);
//        System.out.println(arr.length);
//
//        char[] c = new char[3];
//        System.out.println(c[0]);
//        System.out.println(c);
//        System.out.println(c.length);
//
//        String [] str = new String[2];
//        System.out.println(str[0]);
//        System.out.println(str);
//        System.out.println(str.length);


        // ARRAY EXAMPLE THROUGH METHOD
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8};
//        disp(a);
//        lastvalue(a);
        even(a);
    }

//    1
//    public static void disp(int [] a) {
//        for (int i : a) {
//            System.out.println(i);
//        }
//    }

//    2
//        public static void lastvalue(int [] a){
//            System.out.println(a[a.length-1]);
//        }

    //  3
    public static void even(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (i % 2 == 0) {
                System.out.println(a[i]);
            }
        }
    }
}
