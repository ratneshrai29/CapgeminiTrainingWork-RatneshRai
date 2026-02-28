import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class StudentAttendanceSystemWithHashMap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // HashMaps
        HashMap<String, String> userPassword = new HashMap<>();
        HashMap<String, String> userName = new HashMap<>();
        HashMap<String, Integer> userMarks = new HashMap<>();

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = sc.nextInt();

            // 🔹 REGISTER
            if (choice == 1) {

                System.out.print("Enter name: ");
                String name = sc.next();

                System.out.print("Enter username: ");
                String username = sc.next();

                // check duplicate username
                if (userPassword.containsKey(username)) {
                    System.out.println("Username already exists!");
                    continue;
                }

                System.out.print("Enter password: ");
                String password = sc.next();

                userName.put(username, name);
                userPassword.put(username, password);
                userMarks.put(username, random.nextInt(501));

                System.out.println("Registration successful");
            }

            // 🔹 LOGIN
            else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = sc.next();

                System.out.print("Enter password: ");
                String password = sc.next();

                if (userPassword.containsKey(username) &&
                        userPassword.get(username).equals(password)) {

                    System.out.println("Login successful. Welcome " + userName.get(username));

                    while (true) {
                        System.out.println("\n1. Download Study Material");
                        System.out.println("2. View Semester Marks");
                        System.out.println("3. Logout");
                        int opt = sc.nextInt();

                        if (opt == 1) {
                            System.out.println("Study material PDF downloaded");
                        }
                        else if (opt == 2) {
                            System.out.println("Total Semester Marks: " + userMarks.get(username));
                        }
                        else if (opt == 3) {
                            System.out.println("Logged out");
                            break;
                        }
                        else {
                            System.out.println("Invalid choice");
                        }
                    }
                }
                else {
                    System.out.println("Invalid credentials");
                }
            }

            // 🔹 EXIT
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
