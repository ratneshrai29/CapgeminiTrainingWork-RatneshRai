import java.util.Stack;
import java.util.Scanner;

public class ValidParenthesis {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If opening bracket, push into stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If closing bracket
            else {
                // Stack empty → no matching opening
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check matching pair
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack empty → all matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter parenthesis string: ");
        String input = sc.nextLine();

        if (isValid(input)) {
            System.out.println("Valid Parenthesis ✅");
        } else {
            System.out.println("Invalid Parenthesis ❌");
        }
    }
}
