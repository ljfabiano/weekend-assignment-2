package com.tiy.practice;

import java.util.Scanner;

/**
 * Created by dbashizi on 8/15/16.
 */
public class Assignment6Runner {

    public static void addHarcodedBankAccounts(Bank thisCanBeNamedWhatever, String acctName, double initBal) {
        for (int accountIndex = 0; accountIndex < 5; accountIndex++) {
            BankAccount myAccount = new BankAccount();
            myAccount.setName(acctName + " - " + accountIndex);
            myAccount.setBalance(initBal * (accountIndex + 1));
            thisCanBeNamedWhatever.addBankAccount(myAccount);
        }

    }

    public static void main(String[] args) {
        System.out.println("Running ... with " + args.length + " arguments");
        System.out.println("MyChange!");

        String commandLineBankName = "Default Bank Name"; 
        String commandLineAcctName = "Default Account Name";
        double commandLineInitBalance = 0.0;
        if (args.length == 3) { 
            commandLineBankName = args[0];
            commandLineAcctName = args[1];
            commandLineInitBalance = Double.valueOf(args[2]);
        }

        Bank myBank = new Bank();
        myBank.setName(commandLineBankName);

        System.out.println("How many bank accounts do you have?");
        Scanner inputScanner = new Scanner(System.in);
        int numBankAccounts = Integer.valueOf(inputScanner.nextLine());
        for (int accountIndex = 0; accountIndex < numBankAccounts; accountIndex++) {
            System.out.println("Enter information for Account " + (accountIndex+1));
            System.out.println("Account Name please: ");
            String accountName = inputScanner.nextLine();
            System.out.println("Initial Balance please: ");
            double initBalance = Double.valueOf(inputScanner.nextLine());
            BankAccount bankAccount = new BankAccount();
            bankAccount.setName(accountName);
            bankAccount.setBalance(initBalance);
            myBank.addBankAccount(bankAccount);
        }

//        addHarcodedBankAccounts(myBank, commandLineAcctName, commandLineInitBalance);
//
/* example of hardcoded accounts created manually (before we created in a loop

        BankAccount myAccount = new BankAccount();
        myAccount.setName(commandLineAcctName);
        myAccount.setBalance(commandLineInitBalance);

        myBank.addBankAccount(myAccount);

        BankAccount secondAcct = new BankAccount();
        secondAcct.setName("Savings");
        secondAcct.setBalance(100.00);

        myBank.addBankAccount(secondAcct);

        System.out.println("My Account Info: ");
        myAccount.printInfo();
*/

        System.out.println("My Bank Info: ");
        myBank.printInfo();

        while (true) {

            System.out.println("Enter the name of the account you would like to use: ");
            System.out.println("(Enter exit to exit ;-)");
            for (String accountKey : myBank.getBankAccountsByName().keySet()) {
                System.out.println(accountKey);
            }

            String userChoice = inputScanner.nextLine();
            System.out.println("The user chose: " + userChoice);

            if (userChoice == null || userChoice.equals("exit")) {
                break;
            }

            BankAccount userChosenAccount = myBank.getBankAccountsByName().get(userChoice);

            if (userChosenAccount == null) {
                System.out.println("Unknown account");
            } else {

                while (true) {

                    System.out.println("What would you like to do: ");
                    System.out.println("0. Exit");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Print Info");
                    System.out.println("4. Transfer");

                    int actionChoice = Integer.valueOf(inputScanner.nextLine());
                    if (actionChoice == 1) {
                        System.out.println("Enter deposit amount");
                        double amount = Double.valueOf(inputScanner.nextLine());
                        userChosenAccount.deposit(amount);
                    } else if (actionChoice == 2) {
                        System.out.println("Enter withdrawal amount");
                        double amount = Double.valueOf(inputScanner.nextLine());
                        userChosenAccount.withdraw(amount);
                    } else if (actionChoice == 3) {
                        userChosenAccount.printInfo();
                    } else if (actionChoice == 0) {
                        break;
                    } else if (actionChoice == 4) {
                        System.out.println("How much money would you like to transfer?");
                        double amountToTransfer = Double.valueOf(inputScanner.nextLine());
                        System.out.println("What account would you like to transfer this money to?");


                        for (String accountKey : myBank.getBankAccountsByName().keySet()) {
                            System.out.println(accountKey);
                        }

                        String transferChoice = inputScanner.nextLine();
                        System.out.println("We will transfer to your " + transferChoice + " account");
                        BankAccount transferAccount = myBank.getBankAccountsByName().get(transferChoice);
                        if (transferAccount == null) {
                            System.out.println("Invalid account");
                            break;
                        } else {
                            userChosenAccount.withdraw(amountToTransfer);
                            transferAccount.deposit(amountToTransfer);
                        }
                    }
                }
            }
        }

/*
        myAccount.deposit(100.00);
        System.out.println("++++++++++++++++++++++++++++++++");
        myAccount.printInfo();

        myAccount.withdraw(35.00);
        System.out.println("--------------------------------");
        myAccount.printInfo();
*/
    }

}
