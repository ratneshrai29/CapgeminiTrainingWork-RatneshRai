import java.util.*;

public class Shopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            System.out.println("1. Press 1 to add");
            System.out.println("2. Press 2 to get");
            System.out.println("3. Press 3 to remove");
            System.out.println("4. Press 4 to size");
            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("Add no of item to added: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Add item: ");
                    for (int i = 0; i < n; i++) {
                        list.add(sc.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("Get element of specific index: ");
                    System.out.println(list.get(sc.nextInt()));
                    break;

                case 3:
                    System.out.println("Remove element from specific index");
                    list.remove(sc.nextInt());
                    System.out.println(list);
                    break;

                case 4:
                    System.out.println("Get size of list");
                    System.out.println(list.size());


            }
        }
    }
}
