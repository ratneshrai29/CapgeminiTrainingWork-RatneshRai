import java.util.*;

public class Shopping1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> itemList = new ArrayList<>();
        ArrayList<String> ownerList = new ArrayList<>();

        while (true) {
            System.out.println("1. Press 1 to add");
            System.out.println("2. Press 2 to get");
            System.out.println("3. Press 3 to remove");
            System.out.println("4. Press 4 to size");
            System.out.println("5. Press 5 to exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("How many items to add: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter item name: ");
                        String item = sc.nextLine();

                        System.out.print("Enter owner name: ");
                        String owner = sc.nextLine();

                        itemList.add(item);
                        ownerList.add(owner);
                    }
                    break;

                case 2:
                    System.out.print("Enter index: ");
                    int index = sc.nextInt();

                    if (index >= 0 && index < itemList.size()) {
                        System.out.println("Item: " + itemList.get(index)
                                + ", Owner: " + ownerList.get(index));
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 3:
                    System.out.print("Enter index to remove: ");
                    int removeIndex = sc.nextInt();

                    if (removeIndex >= 0 && removeIndex < itemList.size()) {
                        itemList.remove(removeIndex);
                        ownerList.remove(removeIndex);
                        System.out.println("Item removed successfully");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 4:
                    System.out.println("Total items: " + itemList.size());
                    break;

                case 5:
                    System.out.println("Thank you");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
