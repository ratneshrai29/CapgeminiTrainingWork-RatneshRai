import java.util.Stack;
import java.util.Scanner;

public class MinMaxStack {

    private Stack<Integer> stack = new Stack<>();
    private int min, max;

    // Push operation
    void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min = max = x;
            System.out.println("Pushed: " + x);
            return;
        }

        if (x < min) {
            stack.push(2 * x - min); // encode
            min = x;
        } else if (x > max) {
            stack.push(2 * x - max); // encode
            max = x;
        } else {
            stack.push(x);
        }

        System.out.println("Pushed: " + x);
    }

    // Pop operation
    void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        int top = stack.pop();

        if (top < min) {
            System.out.println("Popped: " + min);
            min = 2 * min - top; // restore old min
        }
        else if (top > max) {
            System.out.println("Popped: " + max);
            max = 2 * max - top; // restore old max
        }
        else {
            System.out.println("Popped: " + top);
        }
    }

    // Get minimum
    void getMin() {
        if (stack.isEmpty())
            System.out.println("Stack is empty");
        else
            System.out.println("Minimum: " + min);
    }

    // Get maximum
    void getMax() {
        if (stack.isEmpty())
            System.out.println("Stack is empty");
        else
            System.out.println("Maximum: " + max);
    }

    // Main method with switch case
    public static void main(String[] args) {

        MinMaxStack s = new MinMaxStack();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- MENU ----");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Get Min");
            System.out.println("4. Get Max");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    s.push(val);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    s.getMin();
                    break;

                case 4:
                    s.getMax();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

