import java.util.Scanner;

public class MaximumDeletion {

    public static int maxDel(String str) {

        StringBuilder stack = new StringBuilder();
        int deletion = 0;

        for (int i = 0; i < str.length(); i++) {

            if (stack.length() > 0 &&
                    stack.charAt(stack.length() - 1) == str.charAt(i)) {

                stack.deleteCharAt(stack.length() - 1); // pop
                deletion++;

            } else {
                stack.append(str.charAt(i)); // push
            }
        }

        return deletion;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        int result = maxDel(input);

        System.out.println("Maximum deletions: " + result);
    }
}