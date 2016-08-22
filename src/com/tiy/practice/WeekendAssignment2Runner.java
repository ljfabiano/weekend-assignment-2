package com.tiy.practice;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Created by jfabiano on 8/15/2016.
 */
public class WeekendAssignment2Runner
{
    public static void main(String[] args) {
        System.out.println("Welcome to My Bank!");
        String bankName = "myBank";
        Bank myBank = new Bank(bankName);
        Scanner bankScanner = new Scanner(System.in);
        String nameInput;
        boolean returningCustomer;
        int intInput;

        System.out.println("Please enter your first name:");
        nameInput = bankScanner.nextLine();

        //If there is already a "bank file" for this user, retrieve their account information and display it to them
        WeekendAssignment2Runner myRunner = new WeekendAssignment2Runner();
        returningCustomer = myRunner.isCustomerReturning(nameInput);
        //Customer customer = new Customer();
        if (returningCustomer == true)
        {
            myRunner.retrieveUserAccounts(nameInput, myBank);
        }
        else
        {
            System.out.println("you don't have an account with us yet. Please create an initial account:");
            myRunner.addNewAccount(bankScanner);
        }

    }

        public Boolean isCustomerReturning(String input)
        {
            boolean returningCustomer = false;
            try {
                File testFile = new File("src/com/tiy/practice/bank.txt");//read my source code noobs.txt to read the actually written file
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
                //return returningCustomer;
                /*

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

                 */
                //while(fileScanner.hasNext())
                //{
                    //String currentLine = fileScanner.nextLine();
                    //numLines++;
                    //numChars += currentLine.length();
                    //System.out.println(currentLine);
                    //int intIndex = currentLine.indexOf("int");
                    //if(intIndex  != -1)
                    //{
                    //    numInts++;
                    //}
                //}
                //System.out.println("you have " + numLines + " in your file.");
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            return returningCustomer;
        }

        public void retrieveUserAccounts(String customerName, Bank myBank)
        {
            boolean returningCustomer = false;
            try {
                File testFile = new File("src/com/tiy/practice/" + customerName + "accounts.txt");//read my source code noobs.txt to read the actually written file
                Scanner fileScanner = new Scanner(testFile);
                String acctName;
                double acctBalance;
                int acctType;
                LocalDateTime creationDate;
                LocalDateTime lastTransDate;
                int counter = 0;
                HashMap<String, Customer> custList;
                //String[] brokenString = input.split(",");
                /*for (int index = 0; index < brokenString.length; index++)
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
                }*/

                while(fileScanner.hasNext())
                {
                    acctName = fileScanner.nextLine();
                    acctBalance = Double.valueOf(fileScanner.nextLine());
                    acctType = Integer.valueOf(fileScanner.nextLine());
                    //creationDate = fileScanner.nextLine().;
                    myBank.addCustomer(customerName);
                    //add the customer to the customer array list in the bank class
                    //add an account to the customer account array list(in that initialize the account as well if this can be done in one step)
                    custList = myBank.getCustomerList();
                    custList.get(customerName).addBankAccount(acctName, acctBalance, acctType);

                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            //return returningCustomer;
        }

        public void addNewAccount(Scanner bankScanner)
        {
            System.out.println("Please enter the name of the account:");
            String acctName = bankScanner.nextLine();
            System.out.println("Please enter the correct number for the account type:\n1. Checking account\n2. Savings account\n3. Retirement account");
            int accountSelection = Integer.valueOf(bankScanner.nextLine());
            if(accountSelection == 1)
            {

            }
            else if (accountSelection == 2)
            {

            }
            else
            {

            }
            System.out.println("Please enter the starting account balance of the bank account:");
            double dInput = Double.valueOf(bankScanner.nextLine());
            LocalDateTime now = LocalDateTime.now();

            myBank.addBankAccount(now, input, dInput);

            System.out.println("The account has been created.");
        }

        //If this is a new user, ask them to create their first account

        //When you ask a user to create an account, give them 3 choices for the type of account they're creating: checking, savings, retirement (Note: a user may have more than one account of one type)

        //Let the user choose what account to use

        //For each account, let the user withdraw, deposit and transfer money

        //Always allow the user to exit out of the "use account" menu and back to the "select account" menu

        //The "select account" menu should also have an option to create a new account


/*
        System.out.println("Please enter the name of the bank account you want to create:");
        input = bankScanner.nextLine();
        System.out.println("Please enter the starting account balance of the bank account:");
        double dInput = Double.valueOf(bankScanner.nextLine());
        LocalDateTime now = LocalDateTime.now();

        myBank.addBankAccount(now, input, dInput);

        System.out.println("The account has been created.");
        System.out.println("what would you like to do next?\n1. Deposit money to your account\n2. Withdraw money from your account\n3. Print your account information\n4. Print your bank information\n0. Exit");
        do
        {
            intInput = Integer.valueOf(bankScanner.nextLine());
            if (intInput == 1)
            {

                System.out.println("Please enter the dollar amount you want to deposit to your bank account:");
                dInput = Double.valueOf(bankScanner.nextLine());

                myBank.bankAccounts.get(0).deposit(dInput);
            }
            else if (intInput == 2)
            {

                System.out.println("Please enter the dollar amount you want to withdraw from your bank account:");
                dInput = Double.valueOf(bankScanner.nextLine());
                myBank.bankAccounts.get(0).withdraw(dInput);
            }
            else if (intInput == 3)
            {

                String account = myBank.bankAccounts.get(0).printInfo();
                System.out.println(account);

            }
            else if (intInput == 4)
            {

                String bankAccount = myBank.printInfo();
                System.out.println(bankAccount);
            }
        }while(intInput != 0);
        System.out.println("Thanks for visiting the bank. Have a good day!");
    */
    }




