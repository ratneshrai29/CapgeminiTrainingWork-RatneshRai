import java.util.*;

public class ShoppingCartWithSet {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        Set<String> itemSet = new LinkedHashSet<>();

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        while (true) {
            System.out.println("Customer: " + customerName);
            System.out.println("1. Add items");
            System.out.println("2. Check item exists");
            System.out.println("3. Remove item by name");
            System.out.println("4. Total items");
            System.out.println("5. Show all items");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("How many items to add: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter item name: ");
                        String item = sc.nextLine();

                        if (itemSet.add(item)) {
                            System.out.println("Item added");
                        } else {
                            System.out.println("Duplicate item ignored (Set rule)");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter item name to search: ");
                    String searchItem = sc.nextLine();

                    if (itemSet.contains(searchItem)) {
                        System.out.println("Item exists in cart");
                    } else {
                        System.out.println("Item not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter item name to remove: ");
                    String removeItem = sc.nextLine();

                    if (itemSet.remove(removeItem)) {
                        System.out.println("Item removed");
                    } else {
                        System.out.println("Item not found");
                    }
                    break;

                case 4:
                    System.out.println("Total items: " + itemSet.size());
                    break;

                case 5:
                    System.out.println("Items of " + customerName + ":");
                    for (String item : itemSet) {
                        System.out.println("→ " + item);
                    }
                    break;

                case 6:
                    System.out.println("Thank you for shopping!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
