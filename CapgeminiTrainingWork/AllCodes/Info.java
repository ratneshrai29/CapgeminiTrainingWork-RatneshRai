import java.util.*;
public class Info {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter roll : ");
//        int roll = sc.nextInt();
//        sc.nextLine();
//        System.out.print("Enter name : " );
//        String name = sc.nextLine();
//        System.out.println("Information : ");
//        System.out.println("Roll : "+roll);
//        System.out.println("Name : "+name);

        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter Roll and Name : ");
        String input = sc1.nextLine();
        String[] input1 = input.split(" ");
        String roll = input1[0];
        if(input1.length == 1){
            String name = sc1.nextLine();
            System.out.println("Roll "+roll+"\nName : "+name);
        }else{
            String name = input1[1];
            System.out.println("Roll : "+roll+"\nName : "+name);
        }
    }
}
