import java.io.*;
import java.util.*;

public class Main {
    public static int calculate(int n){
        int sum=0;
        while(n>0){
            int digit =n%10;
            sum += digit * digit;
            n = n/10;
        }
        return sum;
    }
    public static void main(String[] args)   {
//        String s = "Hello";
//        s = s+ " World";  // Have to Create a new object thus waste of time and memory.
//        System.out.println(s);
//
//        StringBuffer sb = new StringBuffer("Hello");
//        sb.append(" World ");
//        sb.append("Ratnesh");
//        System.out.println( sb.charAt(5));
//        System.out.println(sb);


//        class Test extends Thread {
//
////             static StringBuilder sb = new StringBuilder();  Different output everytime
//           //  static StringBuffer sb = new StringBuffer();  Same output always
//
//            public void run() {
//                for(int i = 0; i < 1000; i++) {
//                    sb.append("A");
//                }
//            }
//        }
//
//        public class Main {
//            public static void main(String[] args) throws Exception {
//
//                Test t1 = new Test();
//                Test t2 = new Test();
//
//                t1.start();
//                t2.start();
//
//                t1.join();
//                t2.join();
//
//                System.out.println("Length: " + Test.sb.length());
//            }
//        }

//        BUFFEREDREADER
//        InputStream input = System.in;
//        InputStreamReader input1 = new InputStreamReader(input);
//        BufferedReader reader = new BufferedReader(input1);
//        System.out.println(reader.readLine());

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try{
//            System.out.println(br.readLine());
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }


        Scanner sc = new Scanner(System.in);
        int original = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();

        int current = original;
        int count=0;
        while(true) {
            current = calculate(current);
            count++;

            if (current == original) {
                System.out.println(count);
                break;
            }

            if(set.contains(current)){
                System.out.println(-1);
                break;
            }

set.add(current);

        }
        sc.close();
    }
}
