import java.util.Stack;
import java.util.Scanner;

public class CelebrityProblem {

    static int findCelebrity(int[][] M, int n) {

        Stack<Integer> stack = new Stack<>();

        // Step 1: Push all people into stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Step 2: Eliminate non-celebrities
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (M[a][b] == 1) {
                // a knows b → a is not celebrity
                stack.push(b);
            } else {
                // a does not know b → b is not celebrity
                stack.push(a);
            }
        }

        // Step 3: Verify candidate
        int candidate = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // Candidate should not know anyone
                // Everyone should know candidate
                if (M[candidate][i] == 1 || M[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }

    // Driver code with user input
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        int[][] M = new int[n][n];

        System.out.println("Enter matrix values (0 or 1):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = sc.nextInt();
            }
        }

        int celeb = findCelebrity(M, n);

        if (celeb == -1) {
            System.out.println("No Celebrity Found");
        } else {
            System.out.println("Celebrity is person: " + celeb);
        }
    }
}
