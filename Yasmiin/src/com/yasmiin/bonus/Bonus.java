package com.yasmiin.bonus;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
public class Bonus {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("What's your first name?"); 
		String fName = scan.next();
		
		System.out.println("What's your last name?"); 
		String lName = scan.next();
		
		System.out.println("What's your current base salary?");
		System.out.print("$"); 
		double currSalary = scan.nextDouble();
		
		System.out.println("How would you like to be rewarded for the next 3 years?");
		System.out.println("Option 1: $5,000 annual bonus (no pay increase)\r\n"
				+ "Option 2: 10% annual bonus based on salary (no pay increase)\r\n"
				+ "Option 3: 3% salary increase every year (no bonus)");
		int opt = scan.nextInt();
		
		System.out.println("Hello, " + fName + " " + lName);
		double totalEarnnings = 0.0d;
		if(opt==1) {
			System.out.println("You chose Option 1: $5,000 annual bonus (no pay increase)");
			totalEarnnings = (currSalary+5000)*3;
		}
		if (opt==2) {
			System.out.println("You chose Option 2: 10% annual bonus based on salary (no pay increase)");
			totalEarnnings =((0.10 * currSalary) + currSalary)*3; 
		}
		if (opt==3) {
			System.out.println("You chose Option 3: 3% salary increase every year (no bonus)");
			for(int i=1; i<=3; i++) {
				currSalary = (0.03*currSalary) + currSalary;
				totalEarnnings += currSalary;
			}
		}
		
		DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

		symbols.setGroupingSeparator(',');
		formatter.setDecimalFormatSymbols(symbols);
				
		System.out.println("Your total earnings after 3 years will be : ");
		System.out.println(formatter.format(totalEarnnings));
	}

}
