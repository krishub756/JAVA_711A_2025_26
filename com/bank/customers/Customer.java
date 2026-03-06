package com.bank.customers;

import com.bank.accounts.Accounts;

public class Customer {

    private int customerId;
    private String name;
    private Accounts account;

    public Customer(int id, String name) {
        this.customerId = id;
        this.name = name;
    }

    public void linkAccount(Accounts account) {
        this.account = account;
    }

    public void displayCustomerDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);

        if(account != null) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: ₹" + account.getBalance());
        }
    }
}