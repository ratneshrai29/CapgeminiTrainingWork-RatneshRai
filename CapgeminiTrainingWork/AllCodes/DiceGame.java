import java.util.*;

public class DiceGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int p1 = 0, p2 = 0;
        int choice;


        while (true) {
            System.out.println("Player 1:");
            System.out.println("1. Roll");
            System.out.println("2. Stop");
            choice = sc.nextInt();

            if (choice == 1) {
                p1 = rand.nextInt(6) + 1;
                System.out.println("Player 1 rolled: " + p1);
            }
            else if (choice == 2) {
                System.out.println("Player 1 stopped at: " + p1);
                break;
            }
            else {
                System.out.println("Invalid choice");
            }
        }

        while (true) {
            System.out.println("Player 2:");
            System.out.println("1. Roll");
            System.out.println("2. Stop");
            choice = sc.nextInt();

            if (choice == 1) {
                p2 = rand.nextInt(6) + 1;
                System.out.println("Player 2 rolled: " + p2);
            }
            else if (choice == 2) {
                System.out.println("Player 2 stopped at: " + p2);
                break;
            }
            else {
                System.out.println("Invalid choice");
            }
        }

        System.out.println("Final Results:");
        System.out.println("Player 1: " + p1);
        System.out.println("Player 2: " + p2);

        if (p1 > p2) {
            System.out.println(" Player 1 Wins!");
        }
        else if (p2 > p1) {
            System.out.println(" Player 2 Wins!");
        }
        else {
            System.out.println(" Match Draw!");
        }
    }
}
