package com.bank.accounts;

public class SavingsAccount extends Accounts {

    private double interestRate;

    public SavingsAccount(int accNo, double balance, double rate) throws Exception {
        super(accNo, balance);
        this.interestRate = rate;
    }

    public double calculateInterest() {
        return balance * interestRate / 100;
    }
}