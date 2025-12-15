package com.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {
    private int balance;
    private final List<Transaction> transactions;
    
    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }
    
    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        
        balance += amount;
        transactions.add(new Transaction(amount, balance));
    }
    
    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        
        balance -= amount;
        transactions.add(new Transaction(-amount, balance));
    }
    
    @Override
    public void printStatement() {
        System.out.println("Date || Amount || Balance");
        
        for (int i = transactions.size() - 1; i >= 0; i--) {
            System.out.println(transactions.get(i).formatForStatement());
        }
    }
    
    public int getBalance() {
        return balance;
    }
    
    public int getTransactionCount() {
        return transactions.size();
    }
}
