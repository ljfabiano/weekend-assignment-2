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
    private HashMap<String, Customer> customerList = new HashMap<String, Customer>();
    //public ArrayList<CheckingAccount> bankAccounts = new ArrayList<CheckingAccount>();
    //private ArrayList<Customer> customerList = new ArrayList<Customer>();

    public Bank()
    {

    }
    public Bank(String name)
    {

        this.name = name;

    }

    public void addCustomer(String name)
    {
        customerList.put(name, new Customer(name));

    }

    public HashMap<String, Customer> getCustomerList()
    {
        return customerList;
    }

    public void setCustomerList(HashMap<String, Customer> customerList)
    {
        this.customerList = customerList;
    }

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
