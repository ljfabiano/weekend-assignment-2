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
    public ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();

    public Bank()
    {

    }
    public Bank(String name)
    {
        this.name = name;
    }

    public void addBankAccount(LocalDateTime createdDate, String name, double balance)

    {
        bankAccounts.add(0, new BankAccount(createdDate, name, balance));
        //System.out.println("Please enter the name of the bank account you want to create:");
        //String input = scan.nextLine();
        //System.out.println("Please enter the starting account balance of the bank account:");
        //double dInput = Double.valueOf(scan.nextLine());
        //The localDateTime gather
        //LocalDateTime now = LocalDateTime.now();
        //System.out.println("The account has been created.");
        //BankAccount myAccount = new BankAccount(now, input, dInput);
        //System.out.println("The account has been created.");
    }
    public String printInfo()
    {

        String printSummary = "Bank Account summary\nBank Name: " + name + "\nTotal Deposits: $" + getTotalInDeposits();
        return printSummary;
    }
    public double getTotalInDeposits()
    {
        double totalMoney = 0.0;
        for(int bankIndex = 0; bankIndex < bankAccounts.size(); bankIndex++)
        {
            totalMoney += bankAccounts.get(bankIndex).getBalance();
            //return totalMoney;
        }
        return totalMoney;
    }
}
