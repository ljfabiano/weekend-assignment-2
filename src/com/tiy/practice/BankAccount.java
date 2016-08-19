package com.tiy.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by dbashizi on 8/15/16.
 */
public class BankAccount {
    private double balance;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime lastTransactionDate;

    public BankAccount() {
        this.createdDate = LocalDateTime.now();
    }

    public void printInfo() {
        System.out.println("Account name: " + name);
        System.out.println("Account balance: " + balance);
        System.out.println("Created on: " + createdDate);
        if (lastTransactionDate == null) {
            System.out.println("Last transaction on: N/A");
        } else {
            DateTimeFormatter localFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
            System.out.println("Last transaction on: " + lastTransactionDate.format(localFormat));
        }
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(LocalDateTime lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amountToDeposit) {
        balance += amountToDeposit;
        lastTransactionDate = LocalDateTime.now();
        return balance;
    }

    public double withdraw(double amountToWithdraw) {
        balance -= amountToWithdraw;
        lastTransactionDate = LocalDateTime.now();
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/* setters and getter look slightly different for booleans
   see examples below

    private boolean isActive;
    private boolean regularFlag;

    public boolean isRegularFlag() {
        return regularFlag;
    }

    public void setRegularFlag(boolean regularFlag) {
        this.regularFlag = regularFlag;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
*/
