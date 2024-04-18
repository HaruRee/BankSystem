package org.example;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String ownerName;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance for withdrawal");
        }
        balance -= amount;
    }

    public void transfer(BankAccount toAccount, double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance for transfer");
        }
        balance -= amount;
        toAccount.deposit(amount);
    }
}