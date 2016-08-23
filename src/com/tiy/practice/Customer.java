package com.tiy.practice;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

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
                if(currentAccount.getClass() == SavingsAccount.class)
                {
                    accountWriter.write(2 + "\n");
                }
                else if(currentAccount.getClass() == RetirementAccount.class)
                {
                    accountWriter.write(3 + "\n");
                }
                else
                {
                    accountWriter.write(1 + "\n");
                }
            }
            accountWriter.close();
        } catch (Exception exception) {
            System.out.println("Exception while writing to file ...");
        }
    }

    public void addBankAccount(String name, double balance, int acctType)
    {
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
