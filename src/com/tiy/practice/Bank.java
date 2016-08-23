package com.tiy.practice;

import java.io.File;
import java.io.FileWriter;
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

    public void saveCustomers() {
        try {
            File bankFile = new File("src/com/tiy/practice/bank.txt");
            FileWriter bankWriter = new FileWriter(bankFile);
            for(Customer currentCustomer : customerList.values())
            {
                bankWriter.write(currentCustomer.getCustomerName() + ",");
            }
            //bankWriter.write(customerList.name + "\n");
            //bankWriter.write(this.getTotalMoneyAtTheBank() + "\n");
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
            String userName = "";
            //double acctBalance;
            //int acctType;
            //LocalDateTime creationDate;
            //LocalDateTime lastTransDate;
            //int counter = 0;
            HashMap<String, Customer> custList;
            String[] brokenString = fileScanner.nextLine().split(",");
            for (int index = 0; index < brokenString.length; index++)
            {
                addCustomer(brokenString[index]);
            }

            /*while(fileScanner.hasNext())
            {
                //userName = fileScanner.();

                    //variable
                    String[] brokenString = input.split(",");
                    for (int index = 0; index < brokenString.length; index++)
                    {
                        if (index == 0)
                        {
                            correctedInput += brokenString[index].toLowerCase();
                        }
                        else
                        {
                            correctedInput += brokenString[index].substring(firstLetter, secondLetter).toUpperCase();
                            correctedInput += brokenString[index].substring(secondLetter).toLowerCase();
                        }
                    }
                //acctBalance = Double.valueOf(fileScanner.nextLine());
                //acctType = Integer.valueOf(fileScanner.nextLine());
                addCustomer(userName);
                //custList = myBank.getCustomerList();
                //custList.get(customerName).addBankAccount(acctName, acctBalance, acctType);
            }*/
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

        String printSummary = "Bank Account summary\nBank Name: " + name + "\nTotal Deposits: $" + getTotalInDeposits(customerName);
        return printSummary;
    }
    public double getTotalInDeposits(String customerName)
    {
        double totalMoney = 0.0;

        for(int custIndex = 0; custIndex < customerList.size(); custIndex++)
        {
            for(int accountIndex = 0; accountIndex < customerList.get(customerName).getBankAccounts().size(); accountIndex++)
            {
                totalMoney += customerList.get(customerName).getBankAccounts().get(accountIndex).getBalance();//.getBankAccounts().get(accountIndex).getBalance();
            }
        }
        return totalMoney;
    }
}
