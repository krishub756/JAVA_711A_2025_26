package com.bank.accounts;

import com.bank.exceptions.InsufficientBalanceException;
import com.bank.utils.BankUtils;

public class Accounts {

    protected int accountNumber;
    protected double balance;

    public Accounts(int accountNumber, double balance) throws Exception {
        BankUtils.validateMinimumBalance(balance);
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {

        if(amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }

        if(balance - amount < 1000) {
            System.out.println("Cannot go below minimum balance ₹1000");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount);
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}