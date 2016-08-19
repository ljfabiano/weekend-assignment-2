package com.tiy.practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;
/**
 * Created by jfabiano on 8/15/2016.
 */
public class Assignment6Runner
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to My Bank!");
        String bankName = "myBank";
        Bank myBank = new Bank(bankName);
        Scanner bankScanner = new Scanner(System.in);
        String input;
        int intInput;
        //add a bank account to the bank
        //myBank.addBankAccount();
        System.out.println("Please enter the name of the bank account you want to create:");
        input = bankScanner.nextLine();
        System.out.println("Please enter the starting account balance of the bank account:");
        double dInput = Double.valueOf(bankScanner.nextLine());
        LocalDateTime now = LocalDateTime.now();
        //DateTimeFormatter localFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        //now.format(localFormat);
        myBank.addBankAccount(now, input, dInput);

        System.out.println("The account has been created.");
        System.out.println("what would you like to do next?\n1. Deposit money to your account\n2. Withdraw money from your account\n3. Print your account information\n4. Print your bank information\n0. Exit");
        do
        {
            intInput = Integer.valueOf(bankScanner.nextLine());
            if (intInput == 1)
            {
               // System.out.println("Please enter the name of the bank account you want to create:");
               // String input = bankScanner.nextLine();
                System.out.println("Please enter the dollar amount you want to deposit to your bank account:");
                dInput = Double.valueOf(bankScanner.nextLine());
                //The localDateTime gather
                //LocalDateTime now = LocalDateTime.now();
                //deposit money to account
                //myBank.addBankAccount(now, input, dInput);
                //System.out.println("The account has been created.");
                myBank.bankAccounts.get(0).deposit(dInput);
            }
            else if (intInput == 2)
            {

                //withdraw money from their account
                System.out.println("Please enter the dollar amount you want to withdraw from your bank account:");
                dInput = Double.valueOf(bankScanner.nextLine());
                myBank.bankAccounts.get(0).withdraw(dInput);
            }
            else if (intInput == 3)
            {

                //print account information
                String account = myBank.bankAccounts.get(0).printInfo();
                System.out.println(account);

            }
            else if (intInput == 4)
            {

                //print bank information
                String bankAccount = myBank.printInfo();
                System.out.println(bankAccount);
            }
        }while(intInput != 0);
        System.out.println("Thanks for visiting the bank. Have a good day!");
    }
}

