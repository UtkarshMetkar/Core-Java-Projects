import java.util.ArrayList;
import java.util.Scanner;

public class BankManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Account> accounts = new ArrayList<>();

        int choice;

        do {

            System.out.println("========== BANK MANAGEMENT SYSTEM ==========");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Check Balance");
            System.out.println("7. Delete Account");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter account number: ");
                    int accountNumber = sc.nextInt();

                    if (accountNumber <= 0) {
                        System.out.println("Invalid account number.");
                        break;
                    }

                    boolean accountNumberExists = false;

                    for (int i=0; i<accounts.size(); i++) {
                        if (accounts.get(i).accountNumber == accountNumber) {
                            accountNumberExists = true;
                            break;
                        }
                    }

                    if (accountNumberExists) {
                        System.out.println("Account number already exists.");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter account holder name: ");
                    String accountHolderName = sc.nextLine();

                    if (accountHolderName.trim().isEmpty()) {
                        System.out.println("Account holder name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();

                    if (balance < 0) {
                        System.out.println("Initial balance cannot be negative.");
                        break;
                    }

                    Account account = new Account(accountNumber, accountHolderName, balance);

                    accounts.add(account);

                    System.out.println("Account created successfully!");
                    break;

                case 2:

                    if (accounts.isEmpty()) {
                        System.out.print("No accounts found.");
                    } else {

                        for (int i=0; i<accounts.size(); i++) {

                            Account a = accounts.get(i);

                            System.out.println("Account Number: " + a.accountNumber);
                            System.out.println("Account Holder: " + a.accountHolderName);
                            System.out.println("Balance: " + a.balance);
                            System.out.println("--------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the account number to search: ");
                    int searchAccountNumber = sc.nextInt();

                    boolean found = false;

                    for (int i=0; i<accounts.size(); i++) {

                        Account a = accounts.get(i);

                        if (a.accountNumber == searchAccountNumber) {

                            System.out.println("Account found!");
                            System.out.println("Account Number: " + a.accountNumber);
                            System.out.println("Account Holder: " + a.accountHolderName);
                            System.out.println("Balance: " + a.balance);

                            found = true;
                            break;
                        }
                    }

                    if(!found) {
                        System.out.println("Account not found.");
                    }

                    break;

                case 4:
                    System.out.print("Enter the account number: ");
                    int depositAccountNumber = sc.nextInt();

                    boolean depositAccountFound = false;

                    for(int i=0; i<accounts.size(); i++) {
                        Account a = accounts.get(i);

                        if (a.accountNumber == depositAccountNumber) {

                            depositAccountFound = true;

                            System.out.print("Enter the amount to deposit: ");
                            double amount = sc.nextDouble();

                            if(amount > 0) {
                                a.balance = a.balance + amount;

                                System.out.println("Amount deposited successfully!");
                                System.out.println("Updated balance: " + a.balance);
                            } else {
                                System.out.println("Invalid amount.");
                            }

                            break;
                        }
                    }

                    if(!depositAccountFound) {
                        System.out.println("Account not found.");
                    }

                    break;

                case 5:
                    System.out.print("Enter the account number: ");
                    int withdrawAccountNumber = sc.nextInt();

                    boolean withdrawAccountFound = false;

                    for (int i=0; i<accounts.size(); i++) {

                        Account a = accounts.get(i);

                        if (a.accountNumber == withdrawAccountNumber) {

                            withdrawAccountFound = true;

                            System.out.print("Enter the amount to withdraw: ");
                            double amount = sc.nextDouble();

                            if (amount <= 0) {
                                System.out.println("Invalid amount.");
                            } else if (amount > a.balance) {
                                System.out.println("Insufficient balance.");
                            } else {
                                a.balance = a.balance - amount;

                                System.out.println("Amount withdrawn successfully!");
                                System.out.println("Updated balance: " + a.balance);
                            }

                            break;
                        }
                    }

                    if(!withdrawAccountFound) {
                        System.out.println("Account not found.");
                    }

                    break;

                case 6:
                    System.out.print("Enter the account number: ");
                    int balanceAccountNumber = sc.nextInt();

                    boolean balanceAccountFound = false;

                    for (int i=0; i<accounts.size(); i++) {

                        Account a = accounts.get(i);

                        if (a.accountNumber == balanceAccountNumber) {

                            balanceAccountFound = true;

                            System.out.println("Account Number: " + a.accountNumber);
                            System.out.println("Account Holder: " + a.accountHolderName);
                            System.out.println("Current Balance: " + a.balance);

                            break;
                        }
                    }

                    if (!balanceAccountFound) {
                        System.out.println("Account not found.");
                    }

                    break;

                case 7:
                    System.out.print("Enter the account number to delete: ");
                    int deleteAccountNumber = sc.nextInt();

                    boolean deleteAccountFound = false;

                    for (int i=0; i<accounts.size(); i++) {

                        Account a = accounts.get(i);

                        if (a.accountNumber == deleteAccountNumber) {

                            deleteAccountFound = true;

                            accounts.remove(i);

                            System.out.println("Account deleted successfully!");

                            break;
                        }
                    }

                    if (!deleteAccountFound) {
                        System.out.println("Account not found.");
                    }

                    break;

                case 8:
                    System.out.print("Thank you for using the Bank Management System!");
                    break;

                default:
                    System.out.print("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}