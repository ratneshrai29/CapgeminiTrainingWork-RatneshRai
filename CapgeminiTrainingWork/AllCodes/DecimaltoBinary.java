import java.util.Scanner;
import java.util.Stack;

public class DecimaltoBinary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("How many times do you want to give input? ");
        int times = sc.nextInt();

        for (int i = 1; i <= times; i++) {

            System.out.print("Enter decimal number " + i + ": ");
            int num = sc.nextInt();

            if (num == 0) {
                System.out.println("Binary: 0");
                continue;
            }

            Stack<Integer> stack = new Stack<>();
            int temp = num;
            while(temp>0){
                stack.push(temp%2);
                temp = temp/2;
            }

            System.out.print("Binary: ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
            System.out.println();
        }

        sc.close();
    }
}