package com.nishit.loanpayment;

import java.text.DecimalFormat;
import java.util.Scanner;

public class LoanPaymentSchedule {
	public static void main(String[] strings) {

	    Scanner input = new Scanner(System.in);

	    System.out.printf("Loan amount: ");
	    double loanAmount = input.nextDouble();

	    System.out.print("Number of Years: ");
	    int numberOfYears = input.nextInt();

	    System.out.print("Annual Interest Rate (8.25): ");
	    double annualInterestRate = input.nextDouble();

	    input.close();

	    double monthlyInterestRate = annualInterestRate / 1200;
	    

	    // Compute mortgage
	   /* double monthlyPayment = monthlyPayment(loanAmount, numberOfYears,
	            monthlyInterestRate);
	   */ 
	    ///
	    double dailyPayment = dailyPayment(loanAmount, numberOfYears,
	            dailyInterestRate);
	    
	    
	    
	    ///

	    double balance = loanAmount;
	    double interest;
	    double principal;

	    System.out.println("Monthly Payment: " + monthlyPayment * 100 / 100.0);
	    System.out.println("Total Payment: " + monthlyPayment * 12
	            + numberOfYears * 100 / 100.0 + "\n");

	    DecimalFormat df = new DecimalFormat("#.####");
	    System.out.println("Payment#\t\tInterest\t\tPrincipal\tBalance");
	    /*for (int i = 1; i <= numberOfYears * 12; i++) {
	        interest = monthlyInterestRate * balance * 100 / 100.0;
	        principal = monthlyPayment - interest * 100 / 100.0;
	        balance = balance - principal * 100 / 100.0;

	        System.out.println(i + "\t\t" + df.format(interest) + "\t\t"
	                + df.format(principal) + "\t\t" + df.format(balance));
	    }*/
	    
	    
	}

	/*private static double monthlyPayment(double loanAmount, int numberOfYears,
	        double monthlyInterestRate) {
	    double monthlyPayment = loanAmount
	            * monthlyInterestRate
	            / (1 - (Math.pow(1 / (1 + monthlyInterestRate),
	                    numberOfYears * 12)));
	    
	  
	}*/
	
	private static double monthlyPayment(double loanAmount, int numberOfYears,
	        double dailyInterestRate) { 
	    double dailypayment = loanAmount
	            * dailyInterestRate
	            / (1 - (Math.pow(1 / (1 + dailyInterestRate),
	                    numberOfYears * 365)));
	    
		
return dailypayment;
	}
}
