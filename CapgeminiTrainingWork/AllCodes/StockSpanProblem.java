import java.util.Stack;
import java.util.Scanner;

public class StockSpanProblem {

    static int[] calculateSpan(int[] price, int n) {

        Stack<Integer> stack = new Stack<>();
        int[] span = new int[n];

        // First day span is always 1
        span[0] = 1;
        stack.push(0);

        for (int i = 1; i < n; i++) {

            // Pop elements while current price is higher
            while (!stack.isEmpty() && price[i] >= price[stack.peek()]) {
                stack.pop();
            }

            // If empty, span = i + 1
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index
            stack.push(i);
        }

        return span;
    }

    // Driver code
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] price = new int[n];

        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        int[] span = calculateSpan(price, n);

        System.out.println("Stock Span:");
        for (int i = 0; i < n; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
