import java.util.*;

public class ExceptionHandling {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sum = 0;

        System.out.println("Enter 5 numbers:");

        try {
            for (int i = 1; i <= 5; i++) {
                try {
                    System.out.print("Enter number " + i + ": ");
                    int num = sc.nextInt();
                    sum += num;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter integer only.");
                    sc.next();
                    i--;
                }
            }
            System.out.println("Sum = " + sum);
        } catch (NoSuchElementException e) {
            System.out.println("Input Exhausted");
        } catch (IllegalStateException e) {
            System.out.println("Scanner closed");
        } catch (Exception e) {
            System.out.println("Some error occured");
        }
        finally {
            sc.close();
        }
    }
}