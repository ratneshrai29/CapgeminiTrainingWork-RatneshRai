import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StudentAttendanceSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();
        ArrayList<Integer> marks = new ArrayList<>();

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.next();
                System.out.print("Enter username: ");
                String username = sc.next();
                System.out.print("Enter password: ");
                String password = sc.next();

                names.add(name);
                usernames.add(username);
                passwords.add(password);
                marks.add(random.nextInt(501));

                System.out.println("Registration successful");
            }

            else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = sc.next();
                System.out.print("Enter password: ");
                String password = sc.next();

                boolean found = false;

                for (int i = 0; i < usernames.size(); i++) {
                    if (usernames.get(i).equals(username) && passwords.get(i).equals(password)) {
                        found = true;

                        while (true) {
                            System.out.println("1. Download Study Material");
                            System.out.println("2. View Semester Marks");
                            System.out.println("3. Logout");
                            int opt = sc.nextInt();

                            if (opt == 1) {
                                System.out.println("Study material PDF downloaded");
                            }
                            else if (opt == 2) {
                                System.out.println("Total Semester Marks: " + marks.get(i));
                            }
                            else if (opt == 3) {
                                System.out.println("Logged out");
                                break;
                            }
                            else {
                                System.out.println("Invalid choice");
                            }
                        }
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Invalid credentials");
                }
            }

            else if (choice == 3) {
                System.out.println("Program ended");
                break;
            }

            else {
                System.out.println("Invalid choice");
            }
        }
    }
}

