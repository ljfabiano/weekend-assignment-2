package com.tiy.practice;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Created by jfabiano on 8/15/2016.
 */
public class WeekendAssignment2Runner
{
    public static boolean runThreads = true;
    public static void main(String[] args) {
        System.out.println("Welcome to My Bank!");
        String bankName = "myBank";
        Bank myBank = new Bank(bankName);
        myBank.retrieveCustomers();
        HashMap<String, Customer> customerArray = myBank.getCustomerList();
        //System.out.println("Customers in the file: " + myBank.getCustomerList());
        Scanner bankScanner = new Scanner(System.in);
        int selection;
        String nameInput;
        boolean returningCustomer;
        int intInput;
        System.out.println("Please enter your first name:");
        nameInput = bankScanner.nextLine();

        //If there is already a "bank file" for this user, retrieve their account information and display it to them
        WeekendAssignment2Runner myRunner = new WeekendAssignment2Runner();
        returningCustomer = myRunner.isCustomerReturning(nameInput);
        for (Customer currentCustomer : myBank.getCustomerList().values())
        {
            System.out.println("stuff in the file: " + currentCustomer.getCustomerName());
            myRunner.retrieveUserAccounts(currentCustomer.getCustomerName(), myBank);
        }
        if (returningCustomer == false)
        {

            System.out.println("you don't have an account with us yet. Please create an initial account:");
            myBank.addCustomer(nameInput);
            myRunner.addNewAccount(nameInput, myBank, bankScanner);
        }

        do
        {
            selection = myRunner.accountSelection(nameInput, myBank, bankScanner);

                if (selection == -1)
                {
                    myRunner.addNewAccount(nameInput, myBank, bankScanner);
                }
                else if (selection == 0)
                {
                    break;
                }
                else
                {
                    myRunner.accountInteraction(nameInput, myBank, bankScanner, (selection - 1));
                }
        }
        while(selection != 0);

        //call account interaction method
        runThreads = false;
        myBank.saveCustomers();
        customerArray.get(nameInput).saveAccounts();

        System.out.println("Thanks for visiting the bank. Have a good day!");

    }

        public Boolean isCustomerReturning(String input)
        {
            boolean returningCustomer = false;
            try {
                File testFile = new File("src/com/tiy/practice/bank.txt");
                Scanner fileScanner = new Scanner(testFile);
                String[] brokenString = fileScanner.nextLine().split(",");
                for (int index = 0; index < brokenString.length; index++)
                {
                    if (brokenString[index].equals(input))
                    {
                       returningCustomer = true;
                        break;
                    }
                    else
                    {
                        returningCustomer = false;
                    }
                }

            }catch(Exception e)
            {
                e.printStackTrace();
            }
            return returningCustomer;
        }

        public void retrieveUserAccounts(String customerName, Bank myBank)
        {

            try {
                File testFile = new File("src/com/tiy/practice/" + customerName + "Accounts.txt");//read my source code noobs.txt to read the actually written file
                Scanner fileScanner = new Scanner(testFile);
                String acctName;
                double acctBalance;
                int acctType;
                HashMap<String, Customer> custList;

                while(fileScanner.hasNext())
                {
                    acctName = fileScanner.nextLine();
                    acctBalance = Double.valueOf(fileScanner.nextLine());
                    acctType = Integer.valueOf(fileScanner.nextLine());

                    custList = myBank.getCustomerList();
                    custList.get(customerName).addBankAccount(acctName, acctBalance, acctType);
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }

        }

        public void addNewAccount(String customerName, Bank myBank, Scanner bankScanner)
        {
            System.out.println("Please enter the name of the account:");
            String acctName = bankScanner.nextLine();
            System.out.println("Please enter the correct number for the account type:\n1. Checking account\n2. Savings account\n3. Retirement account");
            int accountSelection = Integer.valueOf(bankScanner.nextLine());
            System.out.println("please enter the starting balance for the account:");
            double startBalance = Double.valueOf(bankScanner.nextLine());
            HashMap<String, Customer> custList;

            custList = myBank.getCustomerList();
            custList.get(customerName).addBankAccount(acctName, startBalance, accountSelection);

            System.out.println("The account has been created.");
        }
        public void accountInteraction(String customerName, Bank myBank, Scanner bankScanner, int accountSelect)
        {
            HashMap<String, Customer> custList = myBank.getCustomerList();
            ArrayList<CheckingAccount> accountList = custList.get(customerName).getBankAccounts();
            int intInput;
            int count = 1;
            int selection;
            do
            {
                System.out.println("What would you like to do next?\n1. Deposit money to your account\n2. Withdraw money from your account\n3. Print your account information\n4. Transfer money to another account\n0. Exit");

                intInput = Integer.valueOf(bankScanner.nextLine());
                double dInput;
                if (intInput == 1)
                {

                    System.out.println("Please enter the dollar amount you want to deposit to your bank account:");
                    dInput = Double.valueOf(bankScanner.nextLine());
                    accountList.get(accountSelect).deposit(dInput);

                }
                else if (intInput == 2)
                {

                    System.out.println("Please enter the dollar amount you want to withdraw from your bank account:");
                    dInput = Double.valueOf(bankScanner.nextLine());
                    accountList.get(accountSelect).withdraw(dInput);

                }
                else if (intInput == 3)
                {

                    String account = accountList.get(accountSelect).printInfo();
                    System.out.println(account);
                    System.out.println(myBank.printInfo(customerName));

                }
                else if (intInput == 4)
                {

                    System.out.println("Which account do you want to transfer money to:");
                    for(CheckingAccount currentAccount : accountList)
                    {
                        System.out.println(count + ". " + currentAccount.getName());
                        count++;
                    }
                    selection = Integer.valueOf(bankScanner.nextLine());
                    System.out.println("Please enter the dollar amount you want to transfer:");
                    dInput = Double.valueOf(bankScanner.nextLine());
                    accountList.get(accountSelect).withdraw(dInput);
                    accountList.get(selection - 1).deposit(dInput);
                }
                else
                {
                    break;
                }
            }while(intInput != 0);
        }
        public int accountSelection(String customerName, Bank myBank, Scanner bankScanner)
        {
            HashMap<String, Customer> custList = myBank.getCustomerList();
            ArrayList<CheckingAccount> accountList = custList.get(customerName).getBankAccounts();
            int selection;
            int count = 1;
            System.out.println("Please enter the appropriate account number to interact with one of your accounts:");
            System.out.println("-1 Create a new account");
            System.out.println("0. Exit");
            for(CheckingAccount currentAccount : accountList)
            {
                System.out.println(count + ". " + currentAccount.getName());
                count++;
            }
            selection = Integer.valueOf(bankScanner.nextLine());
            return selection;

        }

    }




