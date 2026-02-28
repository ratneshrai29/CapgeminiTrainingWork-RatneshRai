import java.util.ArrayList;
import java.util.Scanner;

public class collection1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("1. Press 1 to Add");
            System.out.println("2. Press 2 to Delete");
            System.out.println("3. Press 3 to Update");
            System.out.println("4. Press 4 for Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter 5 Element to add");
                    for(int i =0;i<5;i++){
                        list.add(sc.nextLine());   // ADD
                    }
                    System.out.println(list);
                    break;

                case 2:
                    list.remove(sc.nextInt());
                    System.out.println(list);
                    break;


                case 3:
                    list.set(sc.nextInt(), sc.nextLine());
                    System.out.println(list);
                    break;

                case 4:
                    System.out.println("Thankyou for using");
                    System.exit(0);

                default:
                    System.out.println("Invalid option");
            }
        }






    }
}
