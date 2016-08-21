package com.tiy.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


/**
 * Created by jfabiano on 8/15/2016.
 */
public class Bank
{
    private String name;
    //HashMap<String, BankAccount> bankAccounts;// = new HashMap<String, Account>();
    //public ArrayList<CheckingAccount> bankAccounts = new ArrayList<CheckingAccount>();
    private ArrayList<Customer> customerList = new ArrayList<Customer>();

    public Bank()
    {

    }
    public Bank(String name)
    {

        this.name = name;

    }

    //public void addBankAccount(LocalDateTime createdDate, String name, double balance)

    //{
        //bankAccounts.add(0, new CheckingAccount(createdDate, name, balance));

    //}
    public String printInfo()
    {

        String printSummary = "Bank Account summary\nBank Name: " + name + "\nTotal Deposits: $" + getTotalInDeposits();
        return printSummary;
    }
    public double getTotalInDeposits()
    {
        double totalMoney = 0.0;

        for(int custIndex = 0; custIndex < customerList.size(); custIndex++)
        {
            for(int accountIndex = 0; accountIndex < customerList.get(custIndex).getBankAccounts().size(); accountIndex++)
            {
                totalMoney += customerList.get(custIndex).getBankAccounts().get(accountIndex).getBalance();
            }
        }
        return totalMoney;
    }
}
