package Task2_CLI_Application;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

    static class Expense {
        int id;
        String name;
        double amount;

        Expense(int id, String name, double amount) {
            this.id = id;
            this.name = name;
            this.amount = amount;
        }
    }

    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1;
    // Add an expense after validating its details
static boolean addExpense(String name, double amount) {
    if (name == null || name.trim().isEmpty()
            || amount <= 0 || !Double.isFinite(amount)) {
        return false;
    }

    expenses.add(new Expense(nextId++, name.trim(), amount));
    return true;
}

// Delete an expense using its ID
static boolean deleteExpenseById(int id) {
    return expenses.removeIf(e -> e.id == id);
}

// Calculate and return the total expense amount
static double getTotalExpenses() {
    double total = 0;

    for (Expense e : expenses) {
        total += e.amount;
    }

    return total;
}

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Calculate Total");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addExpense();
                        break;

                    case 2:
                        viewExpenses();
                        break;

                    case 3:
                        deleteExpense();
                        break;

                    case 4:
                        calculateTotal();
                        break;

                    case 5:
                        System.out.println("Thank you for using Expense Tracker!");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = 0;
            }

        } while (choice != 5);

        sc.close();
    }

    static void addExpense() {
        System.out.print("Enter expense name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Expense name cannot be empty.");
            return;
        }

        System.out.print("Enter expense amount: ");

        try {
            double amount = Double.parseDouble(sc.nextLine());

            if (amount <= 0) {
                System.out.println("Amount must be greater than zero.");
                return;
            }

            expenses.add(new Expense(nextId++, name, amount));
            System.out.println("Expense added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount.");
        }
    }

    static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\n----- EXPENSE LIST -----");

        for (Expense e : expenses) {
            System.out.println("ID: " + e.id
                    + " | Name: " + e.name
                    + " | Amount: Rs. " + e.amount);
        }
    }

    static void deleteExpense() {
        System.out.print("Enter expense ID to delete: ");

        try {
            int id = Integer.parseInt(sc.nextLine());

            for (Expense e : expenses) {
                if (e.id == id) {
                    expenses.remove(e);
                    System.out.println("Expense deleted successfully!");
                    return;
                }
            }

            System.out.println("Expense ID not found.");

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid ID.");
        }
    }

    static void calculateTotal() {
        double total = 0;

        for (Expense e : expenses) {
            total += e.amount;
        }

        System.out.println("Total Expenses: Rs. " + total);
    }
}
