import java.util.Stack;
import java.util.Scanner;

public class DecodeString {

    static String decode(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String current = "";
        int k = 0;

        for (char ch : s.toCharArray()) {

            // Multi-digit number
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            }

            // Opening bracket
            else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = "";
                k = 0;
            }

            // Closing bracket
            else if (ch == ']') {
                int repeat = countStack.pop();
                String previous = stringStack.pop();

                StringBuilder temp = new StringBuilder(previous);
                for (int i = 0; i < repeat; i++) {
                    temp.append(current);
                }
                current = temp.toString();
            }

            // Alphabet character
            else {
                current += ch;
            }
        }
        return current;
    }

    // Driver code
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter encoded string: ");
        String input = sc.nextLine();

        System.out.println("Decoded string: " + decode(input));
    }
}