import java.util.Stack;
import java.util.Scanner;

public class JVMCallStacks {

    static Stack<String> callStack = new Stack<>();

    // Simulate method call
    static void callMethod(String methodName) {
        callStack.push(methodName);
        System.out.println("\nCalling " + methodName + "()");
        printStack();
    }

    // Simulate method return
    static void returnMethod() {
        if (callStack.isEmpty()) {
            System.out.println("\nNo method to return from");
            return;
        }
        String method = callStack.pop();
        System.out.println("\nReturning from " + method + "()");
        printStack();
    }

    // Print current call stack
    static void printStack() {
        System.out.println("Current Call Stack:");
        if (callStack.isEmpty()) {
            System.out.println("[ empty ]");
            return;
        }

        // JVM style: top to bottom
        for (int i = callStack.size() - 1; i >= 0; i--) {
            System.out.println("→ " + callStack.get(i) + "()");
        }
    }

    // Driver with menu
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- JVM CALL STACK MENU ----");
            System.out.println("1. Call Method");
            System.out.println("2. Return Method");
            System.out.println("3. View Call Stack");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter method name: ");
                    String method = sc.nextLine();
                    callMethod(method);
                    break;

                case 2:
                    returnMethod();
                    break;

                case 3:
                    printStack();
                    break;

                case 4:
                    System.out.println("Exiting simulation...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}