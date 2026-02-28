import java.util.Scanner;

public class RemoveConsecutiveDuplicates {

    public static String removeDuplicates(String str) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == str.charAt(i)) {

                // Remove last character (duplicate found)
                sb.deleteCharAt(sb.length() - 1);


            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        String result = removeDuplicates(input);

        System.out.println("Final String: " + result);
    }
}
