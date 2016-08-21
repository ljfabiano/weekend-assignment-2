package com.tiy.practice;

/**
 * Created by jfabiano on 8/19/2016.
 */
public class Timer implements Runnable
{
    int sleepDuration;
    Timer()
    {

    }
    Timer(int sleepDuration)
    {
        this.sleepDuration = sleepDuration;
    }
    //int timeDifference = currentTime.compareTo(initialTime);
    public void run() {
        System.out.println("Running " + Thread.currentThread().getId());
        boolean done = false;
        try {
            Thread.sleep(sleepDuration);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("Done running " + Thread.currentThread().getId());
    }
}
