
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ExpenseTracker {

    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static final String FILE_NAME = "expenses.txt";

    public static void main(String[] args) {

        loadExpenses();

        int choice;

        do {
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {

                case 1:
                    addExpense();
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    viewTotal();
                    break;

                case 4:
                    deleteExpense();
                    break;

                case 5:
                    saveExpenses();
                    System.out.println("Thank you for using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }

    static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.nextLine();
        }

        int number = sc.nextInt();
        sc.nextLine();

        return number;
    }

    static void addExpense() {

        System.out.print("Enter expense name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty() || name.contains(",")) {
            System.out.println("Invalid name. Please try again.");
            return;
        }

        System.out.print("Enter amount: ");

        double amount;

        while (true) {
            String input = sc.nextLine().trim();

            try {
                amount = Double.parseDouble(input);

                if (Double.isFinite(amount) && amount > 0) {
                    break;
                }

                System.out.print("Enter an amount greater than zero: ");

            } catch (NumberFormatException e) {
                System.out.print("Invalid amount. Enter a number: ");
            }
        }

        System.out.print("Enter category: ");
        String category = sc.nextLine().trim();

        if (category.isEmpty() || category.contains(",")) {
            System.out.println("Invalid category. Please try again.");
            return;
        }

        expenses.add(new Expense(name, amount, category));
        saveExpenses();

        System.out.println("Expense added successfully!");
    }

    static void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\n===== ALL EXPENSES =====");

        for (int i = 0; i < expenses.size(); i++) {
            Expense e = expenses.get(i);

            System.out.println("\nExpense No: " + (i + 1));
            System.out.println("Name: " + e.name);
            System.out.println("Amount: Rs. " + e.amount);
            System.out.println("Category: " + e.category);
        }
    }

    static void viewTotal() {

        double total = 0;

        for (int i = 0; i < expenses.size(); i++) {
            total += expenses.get(i).amount;
        }

        System.out.println("Total Expenses: Rs. " + total);
    }

    static void deleteExpense() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses available to delete.");
            return;
        }

        viewExpenses();

        System.out.print("\nEnter expense number to delete: ");
        int number = readInt();

        if (number >= 1 && number <= expenses.size()) {
            Expense removed = expenses.remove(number - 1);
            saveExpenses();

            System.out.println(removed.name + " deleted successfully!");
        } else {
            System.out.println("Invalid expense number.");
        }
    }

    static void saveExpenses() {

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (int i = 0; i < expenses.size(); i++) {
                writer.println(expenses.get(i));
            }

        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    static void loadExpenses() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", 3);

                if (data.length == 3) {
                    try {
                        double amount = Double.parseDouble(data[1]);

                        if (Double.isFinite(amount) && amount > 0) {
                            expenses.add(
                                    new Expense(data[0], amount, data[2])
                            );
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid saved expense.");
                    }
                }
            }

            System.out.println("Saved expenses loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }
    }
}
