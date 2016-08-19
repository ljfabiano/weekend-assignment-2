package com.tiy.practice;

//import java.util.Scanner;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;

public class Day6Runner
{

	String testString = "Initial value";
	boolean testFlag = false;

	public static void main(String[] args) {
		System.out.println("Day6Runner.main()");

		Day6Runner myRunner = new Day6Runner();
		System.out.println("testString = " + myRunner.testString);
		myRunner.doSomethingInteresting();

		myRunner.playWithDates();
		System.out.println(myRunner.toString());
		System.out.println("Day6Runner done!");


		//LocalDateTime then = LocalDateTime.of(1998, Month.MAY, 30, 12, 0);
		//System.out.println(then.toString());

	}

	/*public static day6Runner giveMeOne()
	{
		Day6Runner hereIsOne = new Day6Runner();
		return hereisOne;
	}*/

	public void playWithDates()
	{
		LocalDateTime now = LocalDateTime.now();//public static
		System.out.println(now.toString());

		//LocalDateTime myDate = LocalDateTime.of();//public static
		//System.out.println(now.toString());

		LocalDateTime then = LocalDateTime.of(1984, Month.SEPTEMBER, 21, 12, 0);
		System.out.println(then.toString());

		// output: Then was: Saturday, May 30, 1998
		DateTimeFormatter localFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);//a final constant type variable.
		System.out.println("I was born on " + then.format(localFormat) + ".");
		// output: Then was: May 30 1998 12:00 PM
		DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("EEEE");//formatting a particular date
		System.out.println("My birthday is on a " + then.format(myFormatter) + ".");


	}



		public void testHashMap() {
		HashMap<String, Day6Runner> myAccounts = new HashMap<String, Day6Runner>();
		myAccounts.put("Checking", new Day6Runner());
		myAccounts.put("Savings", new Day6Runner());
		myAccounts.put("Retirement", new Day6Runner());
		myAccounts.get("Checking");
		Day6Runner aRunner = myAccounts.get("Checking");

	}



	public void doSomethingInteresting() {
		System.out.println("\tdoSomethingInteresting() - started");
		testFlag = !testFlag;
		if (testFlag) {
			testString = "Test flag was true";
		} else {
			testString = "Test flag was false";
		}
		System.out.println("\ttestString = " + testString);
		System.out.println("\tdoSomethingInteresting() - ended");
	}

}