import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private int accountNumber;
    private String name;
    private String phone;
    private double balance;

    Account(int accountNumber, String name, String phone, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.phone = phone;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Money deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance = balance - amount;
            System.out.println("Money withdrawn successfully.");
        }
    }

    public void displayAccount() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Balance: ₹" + balance);
    }
}

public class BankManagement {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();
    static int nextAccountNumber = 1001;

    public static void createAccount() {

        System.out.println("\n----- CREATE ACCOUNT -----");

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.print("Enter initial deposit: ");

        double balance;

        try {
            balance = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount.");
            return;
        }

        if (balance < 0) {
            System.out.println("Initial deposit cannot be negative.");
            return;
        }

        Account account = new Account(
            nextAccountNumber,
            name,
            phone,
            balance
        );

        accounts.add(account);

        System.out.println("Account created successfully.");
        System.out.println("Your account number is: " + nextAccountNumber);

        nextAccountNumber++;
    }

    public static Account findAccount(int accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    public static void depositMoney() {

        System.out.println("\n----- DEPOSIT MONEY -----");

        System.out.print("Enter account number: ");

        int accountNumber;

        try {
            accountNumber = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid account number.");
            return;
        }

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount: ");

        double amount;

        try {
            amount = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount.");
            return;
        }

        account.deposit(amount);
    }

    public static void withdrawMoney() {

        System.out.println("\n----- WITHDRAW MONEY -----");

        System.out.print("Enter account number: ");

        int accountNumber;

        try {
            accountNumber = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid account number.");
            return;
        }

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount: ");

        double amount;

        try {
            amount = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount.");
            return;
        }

        account.withdraw(amount);
    }

    public static void checkBalance() {

        System.out.println("\n----- CHECK BALANCE -----");

        System.out.print("Enter account number: ");

        int accountNumber;

        try {
            accountNumber = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid account number.");
            return;
        }

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Current balance: ₹" + account.getBalance());
    }

    public static void viewAccount() {

        System.out.println("\n----- ACCOUNT DETAILS -----");

        System.out.print("Enter account number: ");

        int accountNumber;

        try {
            accountNumber = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid account number.");
            return;
        }

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.displayAccount();
    }

    public static void viewAllAccounts() {

        System.out.println("\n----- ALL ACCOUNTS -----");

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (Account account : accounts) {

            System.out.println(
                account.getAccountNumber()
                + " | "
                + account.getName()
                + " | ₹"
                + account.getBalance()
            );
        }
    }

    public static void deleteAccount() {

        System.out.println("\n----- DELETE ACCOUNT -----");

        System.out.print("Enter account number: ");

        int accountNumber;

        try {
            accountNumber = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid account number.");
            return;
        }

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        accounts.remove(account);

        System.out.println("Account deleted successfully.");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==============================");
            System.out.println("     BANK MANAGEMENT SYSTEM");
            System.out.println("==============================");

            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account");
            System.out.println("6. View All Accounts");
            System.out.println("7. Delete Account");
            System.out.println("8. Exit");

            System.out.println("==============================");

            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            if (choice.equals("1")) {
                createAccount();

            } else if (choice.equals("2")) {
                depositMoney();

            } else if (choice.equals("3")) {
                withdrawMoney();

            } else if (choice.equals("4")) {
                checkBalance();

            } else if (choice.equals("5")) {
                viewAccount();

            } else if (choice.equals("6")) {
                viewAllAccounts();

            } else if (choice.equals("7")) {
                deleteAccount();

            } else if (choice.equals("8")) {
                System.out.println("Thank you for using Bank Management System.");
                break;

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}