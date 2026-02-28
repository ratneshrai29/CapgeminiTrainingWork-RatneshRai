import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> itemList = new ArrayList<>();

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        while (true) {
            System.out.println("\nCustomer: " + customerName);
            System.out.println("1. Add items");
            System.out.println("2. Get item by index");
            System.out.println("3. Remove item by index");
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
                        itemList.add(sc.nextLine());
                    }
                    break;

                case 2:
                    System.out.print("Enter index: ");
                    int index = sc.nextInt();

                    if (index >= 0 && index < itemList.size()) {
                        System.out.println("Item: " + itemList.get(index));
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 3:
                    System.out.print("Enter index to remove: ");
                    int removeIndex = sc.nextInt();

                    if (removeIndex >= 0 && removeIndex < itemList.size()) {
                        itemList.remove(removeIndex);
                        System.out.println("Item removed");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 4:
                    System.out.println("Total items: " + itemList.size());
                    break;

                case 5:
                    System.out.println("Items of " + customerName + ":");
                    for (int i = 0; i < itemList.size(); i++) {
                        System.out.println(i + " → " + itemList.get(i));
                    }
                    break;

                case 6:
                    System.out.println("Thank you for shopping");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
