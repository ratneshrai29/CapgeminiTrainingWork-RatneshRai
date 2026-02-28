import java.util.Stack;
import java.util.Scanner;
import java.util.HashSet;

public class RemoveInvalidParenthesis {

    static String removeInvalid(String s) {

        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> removeIndex = new HashSet<>();

        // Step 1: Identify invalid parentheses
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            }
            else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // valid pair
                } else {
                    removeIndex.add(i); // invalid ')'
                }
            }
        }

        // Step 2: Remaining '(' in stack are invalid
        while (!stack.isEmpty()) {
            removeIndex.add(stack.pop());
        }

        // Step 3: Build result
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removeIndex.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    // Driver code
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        System.out.println("Valid string: " + removeInvalid(input));
    }
}