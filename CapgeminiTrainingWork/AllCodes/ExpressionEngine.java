import java.util.Stack;
import java.util.Scanner;

public class ExpressionEngine {

    // Operator precedence
    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }

    //  Validate infix expression (parentheses only)
    static boolean isValid(String exp) {
        Stack<Character> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    //  Infix → Postfix (MULTI-DIGIT SUPPORT)
    static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // Read full number
            if (Character.isDigit(ch)) {
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    postfix.append(infix.charAt(i));
                    i++;
                }
                postfix.append(" ");
                i--;
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); // remove '('
            }
            else if ("+-*/".indexOf(ch) != -1) {
                while (!stack.isEmpty() &&
                        precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    //  Evaluate postfix + store intermediate results for UNDO
    static int evaluatePostfix(String postfix, Stack<Integer> undoStack) {
        Stack<Integer> stack = new Stack<>();

        for (String token : postfix.split(" ")) {

            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            }
            else {
                int b = stack.pop();
                int a = stack.pop();

                int result = 0;
                switch (token.charAt(0)) {
                    case '+': result = a + b; break;
                    case '-': result = a - b; break;
                    case '*': result = a * b; break;
                    case '/': result = a / b; break;
                }

                stack.push(result);
                undoStack.push(result); // ⭐ save intermediate result
            }
        }
        return stack.pop();
    }

    //  Main Menu
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> undoStack = new Stack<>();

        while (true) {
            System.out.println("1. Evaluate Expression");
            System.out.println("2. UNDO");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter infix expression: ");
                    String infix = sc.nextLine().replaceAll("\\s+", "");

                    if (!isValid(infix)) {
                        System.out.println("❌ Invalid Expression");
                        break;
                    }

                    undoStack.clear(); // clear previous evaluation

                    String postfix = infixToPostfix(infix);
                    int result = evaluatePostfix(postfix, undoStack);

                    System.out.println("Postfix: " + postfix);
                    System.out.println("Result: " + result);
                    break;

                case 2:
                    if (undoStack.isEmpty()) {
                        System.out.println("Nothing to UNDO");
                    } else {
                        undoStack.pop();
                        if (!undoStack.isEmpty()) {
                            System.out.println("UNDO → Previous Result: " + undoStack.peek());
                        } else {
                            System.out.println("UNDO → No previous intermediate result");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}