import java.util.Stack;
import java.util.Scanner;

public class SortStackRecursion {

    // Sort the stack using recursion
    static void sortStack(Stack<Integer> stack) {

        // Base case
        if (stack.isEmpty()) {
            return;
        }

        // Remove top element
        int top = stack.pop();

        // Sort remaining stack
        sortStack(stack);

        // Insert element at correct position
        insertSorted(stack, top);
    }

    // Insert element into sorted stack
    static void insertSorted(Stack<Integer> stack, int element) {

        // Base case: correct position found
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Remove top element
        int top = stack.pop();

        // Recursive call
        insertSorted(stack, element);

        // Put back the removed element
        stack.push(top);
    }

    // Driver with user input
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter stack elements:");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}