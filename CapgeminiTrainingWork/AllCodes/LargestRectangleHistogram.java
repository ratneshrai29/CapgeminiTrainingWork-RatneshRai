import java.util.Stack;
import java.util.Scanner;

public class LargestRectangleHistogram {

    static void largestRectangle(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int maxHeight = 0;
        int maxWidth = 0;

        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];
                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                int area = height * width;

                if (area > maxArea) {
                    maxArea = area;
                    maxHeight = height;
                    maxWidth = width;
                }
            }

            stack.push(i);
        }

        System.out.println(" Largest Rectangle Details:");
        System.out.println("Height used : " + maxHeight);
        System.out.println("Width used  : " + maxWidth);
        System.out.println("Max Area    : " + maxArea);
    }

    // Driver with user input
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bars: ");
        int n = sc.nextInt();

        int[] heights = new int[n];

        System.out.println("Enter heights of bars:");
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        largestRectangle(heights);
    }
}
