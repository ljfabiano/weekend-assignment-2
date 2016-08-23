package com.tiy.practice;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.tiy.practice.WeekendAssignment2Runner.runThreads;

/**
 * Created by jfabiano on 8/19/2016.
 */
public class SavingsAccount extends CheckingAccount implements Runnable
{
    //private double interestRate = .05;
    private LocalTime initialTime;
    private LocalTime currentTime;

    public SavingsAccount()
    {

    }
    public SavingsAccount(String name, double balance)
    {
        super(name, balance);
        Thread newThread = new Thread(this);
        newThread.start();

    }
    public SavingsAccount(LocalDateTime createdDate, String name, double balance, LocalTime initialTime)
    {
        super(createdDate, name, balance);
        this.initialTime = initialTime;

    }

    public int compareTimes()
    {
        int timeDifference = currentTime.compareTo(initialTime);
        return timeDifference;
    }
    public void run()
    {
        System.out.println("Running " + Thread.currentThread().getId());
        double interestValue = 1.05;
        int interestInterval = 10000;

        try
        {
            while (runThreads == true)
            {

                Thread.sleep(interestInterval);
                if (runThreads == true)
                {
                    this.setBalance(this.getBalance() * interestValue);
                    //System.out.println("new balance for " + this.getName() + ": " + this.getBalance());
                }
                else
                {
                    break;
                }
            }

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        //System.out.println("Done running " + Thread.currentThread().getId());
    }
}
