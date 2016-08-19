package com.tiy.practice;

import java.time.LocalDateTime;

/**
 * Created by jfabiano on 8/15/2016.
 */
public class CheckingAccount
{
    private double balance = 0.00;
    private String name = "";
    //private createdDate;
    private LocalDateTime createdDate; //= LocalDateTime.now();
    private LocalDateTime lastTransactionDate;
    public CheckingAccount()
    {

    }

    public CheckingAccount(LocalDateTime createdDate, String name, double balance)
    {
        this.createdDate = createdDate;
        this.name = name;
        this.lastTransactionDate = createdDate;
        this.balance = balance;

    }
    public double getBalance()
    {
        return balance;
    }
    public String printInfo()
    {
        String output = "Account Info\n" + "Account balance: $" + balance + "\nAccount name: " + name + "\nAccount creation date: " + createdDate + "\nDate of latest transaction: " + lastTransactionDate;
        return output;
    }
   public void deposit(double amountDeposited)
    {
        balance += amountDeposited;
        LocalDateTime now = LocalDateTime.now();
        lastTransactionDate = now;
    }
    public void withdraw(double withdrawAmount)
    {
        balance -= withdrawAmount;
        LocalDateTime now = LocalDateTime.now();
        lastTransactionDate = now;
    }

}
