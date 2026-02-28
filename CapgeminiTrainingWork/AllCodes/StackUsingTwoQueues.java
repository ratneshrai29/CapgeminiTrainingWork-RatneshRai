import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class StackUsingTwoQueues {

    // ===== METHOD 1 : COSTLY PUSH =====
    static class CostlyPushStack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            System.out.println("Pushed: " + x);
        }

        void pop() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            System.out.println("Popped: " + q1.remove());
        }

        void peek() {
            if (q1.isEmpty())
                System.out.println("Stack is empty");
            else
                System.out.println("Top: " + q1.peek());
        }
    }

    // ===== METHOD 2 : COSTLY POP =====
    static class CostlyPopStack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        void push(int x) {
            q1.add(x);
            System.out.println("Pushed: " + x);
        }

        void pop() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }

            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            System.out.println("Popped: " + q1.remove());

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        void peek() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }

            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            int top = q1.peek();
            q2.add(q1.remove());

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            System.out.println("Top: " + top);
        }
    }

    // ===== MAIN PROGRAM =====
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Stack Implementation Method:");
        System.out.println("1. Costly Push");
        System.out.println("2. Costly Pop");
        System.out.print("Enter choice: ");
        int method = sc.nextInt();

        CostlyPushStack s1 = null;
        CostlyPopStack s2 = null;

        if (method == 1) s1 = new CostlyPushStack();
        else if (method == 2) s2 = new CostlyPopStack();
        else {
            System.out.println("Invalid method");
            return;
        }

        while (true) {
            System.out.println("\n---- MENU ----");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    if (method == 1) s1.push(val);
                    else s2.push(val);
                    break;

                case 2:
                    if (method == 1) s1.pop();
                    else s2.pop();
                    break;

                case 3:
                    if (method == 1) s1.peek();
                    else s2.peek();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}