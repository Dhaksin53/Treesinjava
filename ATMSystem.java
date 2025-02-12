import java.util.Scanner;


abstract class BankAccount {
    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void checkBalance();
}

// **2. Inheritance** (ATMAccount inherits from BankAccount)
class ATMAccount extends BankAccount {
    private String accountHolder;

    public ATMAccount(String accountHolder, double balance) {
        super(balance);
        this.accountHolder = accountHolder;
    }

    // **3. Polymorphism (Method Overriding)**
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println(accountHolder + ", your current balance is: ₹" + balance);
    }
}

// **4. Encapsulation** (ATM class restricting direct access to data)
class ATM {
    private ATMAccount account;

    public ATM(ATMAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

// **Main Class**
public class ATMSystem {
    public static void main(String[] args) {
        ATMAccount myAccount = new ATMAccount("John Doe", 5000); // Creating an account
        ATM atm = new ATM(myAccount);
        atm.start(); // Start ATM operations
    }
}
