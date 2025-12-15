package com.bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final LocalDate date;
    private final int amount;
    private final int balance;
    
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Transaction(int amount, int balance) {
        this.date = LocalDate.now();
        this.amount = amount;
        this.balance = balance;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public String formatForStatement() {
        return String.format("%s || %d || %d", 
            date.format(DATE_FORMAT), 
            amount, 
            balance);
    }
}
