import java.util.Scanner;

public class ClosestPerfectSquare {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter positive integer: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Enter positive integer.");
            return;
        }

        int lowerRoot = (int) Math.sqrt(number);
        int upperRoot = lowerRoot + 1;

        int lowerSquare = lowerRoot * lowerRoot;
        int upperSquare = upperRoot * upperRoot;

        if ((number - lowerSquare) <= (upperSquare - number)) {
            System.out.println("Closest integer: " + lowerSquare);
        } else {
            System.out.println("Closest integer: " + upperSquare);
        }
    }
}