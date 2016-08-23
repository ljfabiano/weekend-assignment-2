package com.tiy.practice;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jfabiano on 8/19/2016.
 */
public class Customer
{
    private ArrayList<CheckingAccount> bankAccounts = new ArrayList<CheckingAccount>();
    private String customerName;

    public Customer()
    {

    }
    public Customer(String customerName)
    {
        this.customerName = customerName;
        //this.bankAccounts = bankAccounts;
    }
    public Customer(String customerName, ArrayList<CheckingAccount> bankAccounts)
    {
        this.customerName = customerName;
        this.bankAccounts = bankAccounts;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        customerName = customerName;
    }

    //private String CustomerName;

    public ArrayList<CheckingAccount> getBankAccounts()
    {
        return bankAccounts;
    }

    public void setBankAccounts(ArrayList<CheckingAccount> bankAccounts)
    {
        this.bankAccounts = bankAccounts;
    }
    public void saveAccounts() {
        try {
            File accountFile = new File("src/com/tiy/practice/" + customerName + "Accounts.txt");
            FileWriter accountWriter = new FileWriter(accountFile);
            for(CheckingAccount currentAccount : bankAccounts)
            {
                accountWriter.write(currentAccount.getName() + "\n");
                accountWriter.write(currentAccount.getBalance() + "\n");
                accountWriter.write(1 + "\n");
            }
            //bankWriter.write(customerList.name + "\n");
            //bankWriter.write(this.getTotalMoneyAtTheBank() + "\n");
            accountWriter.close();
        } catch (Exception exception) {
            System.out.println("Exception while writing to file ...");
        }
    }
    /*public void retrieveAccounts()
    {
        try {

            File userFile = new File("src/com/tiy/practice/" + customerName + "Accounts.txt");
            Scanner fileScanner = new Scanner(userFile);
            String userName = "";
            //double acctBalance;
            //int acctType;
            //LocalDateTime creationDate;
            //LocalDateTime lastTransDate;
            //int counter = 0;
            HashMap<String, Customer> custList;


            while(fileScanner.hasNext())
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
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }*/
    public void addBankAccount(String name, double balance, int acctType)
    {
    //bankAccounts.add(new CheckingAccount(name, balance));
        if(acctType == 1)
        {
            bankAccounts.add(new CheckingAccount(name, balance));

            //add the customer to the customer array list in the bank class
            //add an account to the customer account array list(in that initialize the account as well if this can be done in one step)

        }
        else if (acctType == 2)
        {
            bankAccounts.add(new SavingsAccount(name, balance));
        }
        else
        {
            bankAccounts.add(new RetirementAccount(name, balance));
        }

    }
}
