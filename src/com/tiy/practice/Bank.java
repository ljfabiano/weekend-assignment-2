package com.tiy.practice;

import java.util.HashMap;

/**
 * Created by dbashizi on 8/16/16.
 */
public class Bank {
    private String name;
    private HashMap<String, BankAccount> bankAccountsByName;

    public Bank() {
        bankAccountsByName = new HashMap<String, BankAccount>();
    }

    public double getTotalInDeposits() {
        double total = 0.0;
        for (BankAccount currAcct : bankAccountsByName.values()) {
            total += currAcct.getBalance();
        }
        return total;
    }

    public void printInfo() {

        // this is how I would loop through all the names of every account
//        for (String currName : bankAccountsByName.keySet()) {
//            System.out.println("Current Bank Account Name: " + currName);
//        }

        System.out.println("###############################");
        System.out.println("Bank Name: " + name);
        System.out.println("Total in deposits: " + getTotalInDeposits());
        System.out.println("###############################");
        /*
        for (BankAccount currAcct : bankAccountsByName.values()) {
            System.out.println("******** Account Info *************");
            currAcct.printInfo();
            System.out.println("***********************************");
        }
        */
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBankAccount(BankAccount acct) {
        bankAccountsByName.put(acct.getName(), acct);
    }

    public HashMap<String, BankAccount> getBankAccountsByName() {
        return bankAccountsByName;
    }

    public void setBankAccountsByName(HashMap<String, BankAccount> bankAccountsByName) {
        this.bankAccountsByName = bankAccountsByName;
    }
}
