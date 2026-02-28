import java.util.HashMap;
import java.util.Scanner;

class UsernameExistsException extends RuntimeException {
    public UsernameExistsException(String message) {
        super(message);
    }
}

class UserMap extends HashMap<String, String> {
    @Override
    public String put(String username, String password) {
        if (this.containsKey(username)) {
            throw new UsernameExistsException("Username already exists: " + username);
        }
        return super.put(username, password);
    }
}


public class Question2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserMap users = new UserMap();

        System.out.print("Enter number of users: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            try {
                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                users.put(username, password);

                System.out.println("User added successfully!");

            } catch (UsernameExistsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("\nFinal Users List:");
        System.out.println(users);
        sc.close();
    }
}