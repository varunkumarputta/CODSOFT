package com.practice.basicpgm;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        System.out.println("Your bank account is successfully created with initial balance of " + initialBalance + " rupees");
    }

    // Method to deposit money
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Method to check the account balance
    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private final BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    // Display the ATM menu
    public void showMenu() {
        System.out.println("\nWelcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    // Method to handle checking balance
    public void checkBalance() {
        double balance = bankAccount.checkBalance();
        System.out.printf("Your current balance is: %.2f rupees\n", balance);
    }

    // Method to handle depositing money
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            boolean success = bankAccount.deposit(amount);
            if (success) {
                System.out.printf("%.2f rupees has been deposited successfully.\n", amount);
            } else {
                System.out.println("Deposit failed! Please check the amount and try again.");
            }
        } else {
            System.out.println("Invalid deposit amount. It must be greater than zero.");
        }
    }

    // Method to handle withdrawing money
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            boolean success = bankAccount.withdraw(amount);
            if (success) {
                System.out.printf("%.2f rupees has been withdrawn successfully.\n", amount);
            } else {
                System.out.println("Insufficient funds or invalid amount.");
            }
        } else {
            System.out.println("Invalid withdrawal amount. It must be greater than zero.");
        }
    }

    // Method to run the ATM system
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            System.out.print("Please select an option (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return; // Exit the loop and end the program
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        // Create a bank account for the user
        BankAccount userAccount = new BankAccount( 500.00); // Initial balance of 500 rupees

        // Create an ATM object linked to the user's bank account
        ATM atmMachine = new ATM(userAccount);

        // Run the ATM
        atmMachine.run();
    }
}

