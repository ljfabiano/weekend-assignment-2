package com.tiy.practice;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by jfabiano on 8/19/2016.
 */
public class RetirementAccount extends CheckingAccount
{

    private double interestRate = .10;

    private LocalTime initialTime;
    private LocalTime currentTime;

    public RetirementAccount()
    {

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


}
