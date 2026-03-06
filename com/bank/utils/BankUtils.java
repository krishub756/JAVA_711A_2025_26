package com.bank.utils;

public class BankUtils {

    public static int generateAccountNumber() {
        return (int)(Math.random() * 100000);
    }

    public static void validateMinimumBalance(double balance) throws Exception {
        if(balance < 1000) {
            throw new Exception("Minimum balance must be ₹1000");
        }
    }
}