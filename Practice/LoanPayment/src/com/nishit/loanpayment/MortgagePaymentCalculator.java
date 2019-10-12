package com.nishit.loanpayment;

import java.util.Scanner;

public class MortgagePaymentCalculator {
	public static double calculateMonthlyPayment(
			int loanAmount, int termInYears, double interestRate) {

		// Convert interest rate into a decimal
		// eg. 6.5% = 0.065

		interestRate /= 100.0;

		// Monthly interest rate 
		// is the yearly rate divided by 12

		double monthlyRate = interestRate / 12.0;

		// The length of the term in months 
		// is the number of years times 12

		int termInMonths = termInYears * 12;

		// Calculate the monthly payment
		// Typically this formula is provided so 
		// we won't go into the details

		// The Math.pow() method is used calculate values raised to a power

		double monthlyPayment = 
				(loanAmount*monthlyRate) / 
				(1-Math.pow(1+monthlyRate, -termInMonths));

		return monthlyPayment;
	}

	public static void main(String[] args) {

		// Scanner is a great class for getting 
		// console input from the user

		Scanner scanner = new Scanner(System.in);

		// Prompt user for details of loan

		System.out.print("Enter loan amount: ");
		int loanAmount = scanner.nextInt();

		System.out.print("Enter loan term (in years): ");
		int termInYears = scanner.nextInt();

		System.out.print("Enter interest rate: ");
		double interestRate = scanner.nextDouble();

		// Display details of loan

		double monthlyPayment = calculateMonthlyPayment(loanAmount, termInYears, interestRate);
		double totalPayed = 0;
		int month = 1;
		double loanAmountRemaining = 0;
		while(totalPayed <= loanAmount){
			totalPayed = totalPayed + monthlyPayment;
			double totalLoanAmount =  loanAmount + interestRate;
			loanAmountRemaining = totalLoanAmount - totalPayed;
			month ++;
			
		}
		if(monthlyPayment > loanAmount)
			totalPayed = totalPayed + loanAmountRemaining;
		System.out.println("total loan amount remaining" +loanAmountRemaining);
		
		System.out.println("total payed" +totalPayed);
		//System.out.printf("%9s      %9s     %9s     %9s\n", "monthlypayment", "interestRate", "loanAmount", "loanAmountRemaining");
	}

	
	//	System.out.println("%9s      %9s     %9s     %9s\n", "monthlypayment", "interestRate", "loanAmount", "loanAmountRemaining");
}

