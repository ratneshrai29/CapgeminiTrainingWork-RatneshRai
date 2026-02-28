import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    // Method to check precedence
    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter infix expression: ");
        String infix = sc.nextLine();

        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // If operand, add to postfix
            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            }
            // If '(' push to stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If ')', pop till '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop(); // remove '('
            }
            // If operator
            else {
                while (!stack.isEmpty() &&
                        precedence(stack.peek()) >= precedence(ch)) {
                    postfix += stack.pop();
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        System.out.println("Postfix (RPN): " + postfix);
        sc.close();
    }
}