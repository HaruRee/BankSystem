package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the banking system!");

        List<BankAccount> accounts = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. View account details");
            System.out.println("5. Create new account");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4 && accounts.isEmpty()) {
                System.out.println("No accounts available. Please create an account first.");
                continue;
            }

            switch (choice) {
                case 1:
                case 2:
                case 4:
                    System.out.println("Choose an account index:");
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println(i + ": Account Number " + accounts.get(i).getAccountNumber() + ", Owner Name: " + accounts.get(i).getOwnerName());
                    }
                    int accountIndex = scanner.nextInt();
                    if (accountIndex < 0 || accountIndex >= accounts.size()) {
                        System.out.println("Invalid account index. Please enter a valid index.");
                        continue;
                    }
                    BankAccount selectedAccount = accounts.get(accountIndex);

                    if (choice == 1) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        selectedAccount.deposit(depositAmount);
                        System.out.println("Deposited " + depositAmount + " into account " + accountIndex);
                    } else if (choice == 2) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        selectedAccount.withdraw(withdrawalAmount);
                        System.out.println("Withdrew " + withdrawalAmount + " from account " + accountIndex);
                    } else {
                        System.out.println("Account " + accountIndex + " balance: " + selectedAccount.getBalance());
                    }
                    break;
                case 3:
                    System.out.print("Enter source account index: ");
                    int sourceAccountIndex = scanner.nextInt();
                    System.out.print("Enter destination account index: ");
                    int destinationAccountIndex = scanner.nextInt();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    accounts.get(sourceAccountIndex).transfer(accounts.get(destinationAccountIndex), transferAmount);
                    System.out.println("Transferred " + transferAmount + " from account " + sourceAccountIndex + " to account " + destinationAccountIndex);
                    break;
                case 5:
                    createAccount(scanner, accounts);
                    break;
                case 6:
                    System.out.println("Exiting the banking system. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    public static void createAccount(Scanner scanner, List<BankAccount> accounts) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter owner name: ");
        String ownerName = scanner.next();
        BankAccount newAccount = new BankAccount(accountNumber, ownerName);
        accounts.add(newAccount);
        System.out.println("Created new account with number " + accountNumber + " for " + ownerName);
    }
}