package com.tiy.practice;

import java.io.File;
import java.io.FileWriter;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jfabiano on 8/15/2016.
 */
public class Bank
{
    private String name;
    private HashMap<String, Customer> customerList = new HashMap<String, Customer>();

    public Bank()
    {

    }
    public Bank(String name)
    {

        this.name = name;

    }

    public void saveCustomers() {
        try {
            File bankFile = new File("src/com/tiy/practice/bank.txt");
            FileWriter bankWriter = new FileWriter(bankFile);
            for(Customer currentCustomer : customerList.values())
            {
                bankWriter.write(currentCustomer.getCustomerName() + ",");
            }
            bankWriter.close();
        } catch (Exception exception) {
            System.out.println("Exception while writing to file ...");
        }
    }

    public void retrieveCustomers()
    {
        try {

            File userFile = new File("src/com/tiy/practice/bank.txt");
            Scanner fileScanner = new Scanner(userFile);
            String[] brokenString = fileScanner.nextLine().split(",");
            for (int index = 0; index < brokenString.length; index++)
            {
                addCustomer(brokenString[index]);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
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

    public String printInfo(String customerName)
    {

        String printSummary = "Bank Account summary\nBank Name: " + name + "\nTotal Deposits: $" + getTotalInDeposits();
        return printSummary;
    }
    public double getTotalInDeposits()
    {
        double totalMoney = 0.0;

        for (Customer customer : customerList.values()) {
            for (CheckingAccount account : customer.getBankAccounts()) {
                totalMoney += account.getBalance();
            }
        }
        return totalMoney;
    }
}
