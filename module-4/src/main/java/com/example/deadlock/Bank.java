package com.example.deadlock;

public class Bank {
    public void transfer(BankAccount from, BankAccount to, double amount) {
        from.withdraw(amount);
        to.deposit(amount);
    }
}


