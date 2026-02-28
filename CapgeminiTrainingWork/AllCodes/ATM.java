import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int pin = 1234;
        int enteredPin;
        double balance = 10000;
        int choice;

        System.out.print("Enter your PIN: ");
        enteredPin = sc.nextInt();

        if (enteredPin == pin) {

                System.out.println("ATM MENU");
                System.out.println("1. Deposit");
                System.out.println("2. Withdrawal");
                System.out.println("3. Quick Withdrawal");
                System.out.println("4. Change PIN");
                System.out.println("5. Check Balance");

                System.out.print("Choose an option: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double deposit = sc.nextDouble();
                        balance += deposit;
                        System.out.println("Amount deposited successfully");
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdraw = sc.nextDouble();

                        if (withdraw <= balance) {
                            balance -= withdraw;
                            System.out.println("Please collect your cash");
                            System.out.println("Updated Balance :"+balance);
                        } else {
                            System.out.println("Insufficient balance");
                        }
                        break;

                    case 3:
                        System.out.println("Quick Withdrawal Options:");
                        System.out.println("1. 500");
                        System.out.println("2. 1000");
                        System.out.println("3. 2000");
                        System.out.println("4. 5000");

                        int q = sc.nextInt();
                        int amount = 0;

                        if (q == 1) amount = 500;
                        else if (q == 2) amount = 1000;
                        else if (q == 3) amount = 2000;
                        else if (q == 4) amount = 5000;
                        else {
                            System.out.println("Invalid choice");
                            break;
                        }

                        if (amount > 5000) {
                            System.out.print("Enter PIN for security: ");
                            int pinCheck = sc.nextInt();
                            if (pinCheck != pin) {
                                System.out.println("Incorrect PIN");
                                break;
                            }
                        }

                        if (amount <= balance) {
                            balance -= amount;
                            System.out.println("Please collect your cash");
                            System.out.println("Updated Balance :" + balance);
                        } else {
                            System.out.println("Insufficient balance");
                        }
                        break;

                    case 4:
                        System.out.print("Enter current PIN: ");
                        int oldPin = sc.nextInt();

                        if (oldPin == pin) {
                            System.out.print("Enter new PIN: ");
                            pin = sc.nextInt();
                            System.out.println("PIN changed successfully");
                        } else {
                            System.out.println("Incorrect current PIN");
                        }
                        break;

                    case 5:
                        System.out.println("Available Balance: ₹" + balance);
                        break;

                    default:
                        System.out.println("Invalid option");
                }
        } else {
            System.out.println("Incorrect PIN. Access Denied.");
        }
    }
}

