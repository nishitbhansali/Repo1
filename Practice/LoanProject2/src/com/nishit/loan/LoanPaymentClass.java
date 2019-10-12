package com.nishit.loan;

import java.text.DecimalFormat;
import java.util.Scanner;

public class LoanPaymentClass {

			public static void main(String[] strings) {
				
		    Scanner input = new Scanner(System.in);
		    System.out.printf("Loan amount: ");
		    double loanAmount = input.nextDouble();
		    System.out.print("Number of Years: ");
		    int numberOfYears = input.nextInt();
		    System.out.print("Annual Interest Rate (8.25): ");
		    double annualInterestRate = input.nextDouble();
		    input.close();

		    double dailyInterestRate = annualInterestRate / 36500;
		    

		    double dailyPayment = dailyPayment(loanAmount, numberOfYears,
		            dailyInterestRate);
		    
		    
		    
		    ///

		    double balance = loanAmount;
		    double interest;
		    double principal;
		    double principalPaid = 93.18;;

		    DecimalFormat df = new DecimalFormat("#.####");
		    System.out.println("Payment# \t Interest \t Principal \t Balance");
		    for (int i = 1; i <= numberOfYears ; i++) {
		        interest = dailyInterestRate * balance * 100 / 100.0;
		        principal = loanAmount;
		        
		        if(numberOfYears == 15) {
		        balance = principal - principalPaid * 100 / 100.0;
		        }
		        else{
		        	balance = principal;	
		        }
		        System.out.println(i + "\t\t" + df.format(interest) + "\t\t"
		                + df.format(principal) + "\t\t" + df.format(balance));
		    }
		    
		    
		}

		
		private static double dailyPayment(double loanAmount, int numberOfYears,
		        double dailyInterestRate) { 
		    double dailypayment = loanAmount
		            * dailyInterestRate
		            / (1 - (Math.pow(1 / (1 + dailyInterestRate),
		                    numberOfYears * 365)));
		    
			
	return dailypayment;
		}
	}

