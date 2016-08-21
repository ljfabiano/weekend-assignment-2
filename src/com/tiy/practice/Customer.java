package com.tiy.practice;

import java.util.ArrayList;

/**
 * Created by jfabiano on 8/19/2016.
 */
public class Customer
{
    private ArrayList<CheckingAccount> bankAccounts = new ArrayList<CheckingAccount>();

    public ArrayList<CheckingAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(ArrayList<CheckingAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
