import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        double balance = 10000;

        int choice;
        double amount;

        do {
            System.out.println("========= ATM System =========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.println("Enter the choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Your balance is: " + balance);
                    break;

                case 2:
                    System.out.println("Enter the amount to Deposit: ");
                    amount = sc.nextDouble();

                if(amount > 0) {
                    balance += amount;
                    
                    System.out.println("Amount deposited successfully.");
                    System.out.println("New Balance: " + balance);   
                } else {
                    System.out.println("Invalid Amount");
                }
                    break;

                case 3:
                    System.out.println("Enter the amount to Withdraw");
                    amount = sc.nextDouble();

                    if(amount > 0 && balance >= amount) {
                        balance -= amount;

                        System.out.println("Amount withdrawn successfully.");
                        System.out.println("New Balance: " + balance);
                    } else if(amount <= 0) {
                        System.out.println("Invalid Amount.");

                    } else {
                        System.out.println("Insufficient Balance");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);

        sc.close();
    }
}