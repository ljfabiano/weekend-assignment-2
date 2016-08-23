package com.tiy.practice;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.tiy.practice.WeekendAssignment2Runner.runThreads;

/**
 * Created by jfabiano on 8/19/2016.
 */
public class RetirementAccount extends CheckingAccount implements Runnable
{
    //private double interestRate = .10;
    private LocalTime initialTime;
    private LocalTime currentTime;

    public RetirementAccount()
    {

    }
    public RetirementAccount(String name, double balance)
    {
        super(name, balance);
        Thread newThread = new Thread(this);
        newThread.start();




    }
    public RetirementAccount(LocalDateTime createdDate, String name, double balance, LocalTime initialTime)
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
        double interestValue = 1.1;
        int interestInterval = 120000;
        //System.out.println("Running " + Thread.currentThread().getId());

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
