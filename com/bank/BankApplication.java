package com.bank;

import com.bank.accounts.SavingsAccount;
import com.bank.customers.Customer;
import com.bank.loans.Loan;
import com.bank.exceptions.InsufficientBalanceException;

import static com.bank.utils.BankUtils.generateAccountNumber;

public class BankApplication {

    public static void main(String[] args) {

        try {

            Customer customer = new Customer(101, "Krish");

            int accNo = generateAccountNumber();

            SavingsAccount account = new SavingsAccount(accNo, 5000, 5);

            customer.linkAccount(account);

            account.deposit(2000);

            account.withdraw(1500);

            double interest = account.calculateInterest();
            System.out.println("Interest: ₹" + interest);

            Loan loan = new Loan(100000, 8, 2);
            System.out.println("Loan EMI: ₹" + loan.calculateEMI());

            customer.displayCustomerDetails();

        } 
        catch(InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}