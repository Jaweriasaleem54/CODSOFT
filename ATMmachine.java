import java.util.Scanner;

public class ATMmachine {

    public static void main(String args[]) {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int amount;

        ATM atm = new ATM();
        BankAccount bankaccount = new BankAccount();
        System.out.println("***********************************************");
        System.out.println("Welcome to Your Bank Account");
        System.out.println("***********************************************");
        System.out.println("Enter a choice");
        System.out.println("1.Login");
        System.out.println("2.signup");
        System.out.println("3.Exit");

        int option = scanner.nextInt();

        if (option == 1) {
            System.out.println("***********************************************");
            System.out.println("Enter Your Account Name:");
            String Accountname = scanner1.nextLine();
            System.out.println("Enter Password");
            String Password = scanner1.nextLine();
            if (atm.login(Accountname, Password)) {
                atm.Options();
            } else {
                System.out.println("Invalid login credentials. Please try again.");
            }
        } else if (option == 2) {
            System.out.println("***********************************************");
            System.out.println("Enter Your Account Name:");
            String Accountname = scanner1.nextLine();
            System.out.println("Enter Password");
            String Password = scanner1.nextLine();
            System.out.println("Amount Created Successfully");
            atm.Options();
        } else if (option == 3) {
            System.out.println("Exiting the ATM. Thank you!");
        } else {

            System.out.println("Invalid Options");
        }
    }
}

class ATM {
    BankAccount bankaccount = new BankAccount();
    Scanner scanner = new Scanner(System.in);

    public boolean login(String accountName, String password) {
        // Replace with actual login logic
        return true;
    }

    void Options() {
        while (true) {
            System.out.println("***********************************************");
            System.out.println("Select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("***********************************************");
            int choice = scanner.nextInt();
            int amountt = 0;
            if (choice == 1) {
                Balance();
            } else if (choice == 2) {
                System.out.print("Enter  Amount to deposit: ");
                amountt = scanner.nextInt();
                Deposit(amountt);
                System.out.println("***********************************************");

            } else if (choice == 3) {
                System.out.print("Enter the amount to withdraw: ");
                amountt = scanner.nextInt();
                withdraw(amountt);
                System.out.println("***********************************************");

            } else if (choice == 4) {
                System.out.println("Thank you for using our ATM services. Have a great day!");
                System.out.println("***********************************************");
                break;
            } else {
                System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }

    public void withdraw(int amount1) {
        if (bankaccount.Amount == 0) {
            System.out.println("Your Account is Empty");
        } else if (amount1 > bankaccount.Amount) {
            System.out.println("Insufficient Balance");
        } else if (amount1 <= bankaccount.Amount) {
            bankaccount.Amount -= amount1;
            System.out.println("Withdrawal Successful: " + amount1 + " Rupees");
            System.out.println("Remaining Balance: " + bankaccount.Amount + " Rupees");
        }
    }

    void Deposit(int amount) {
        bankaccount.Amount = bankaccount.InitialAmount += amount;

        System.out.println("Deposit Successful: " + amount + " Rupees");
        System.out.println("Updated Balance: " + bankaccount.Amount + " Rupees");
    }

    void Balance() {
        System.out.println("Your Current Balance: " + bankaccount.Amount + " Rupees");
    }

}

class BankAccount {
    float InitialAmount = 0;
    float Amount = 0;
}
