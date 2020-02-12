/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_penniesforpay;

import java.util.Scanner;

/**
 *
 * @author barrymolina
 */
public class SalaryCalculator {

	int days;
	double salary = 0;

	final int PENNIES_IN_DOLLAR = 100;

	Scanner keyboard = new Scanner(System.in);
	
	public void inputDays() {
		System.out.print("\nEnter number of days worked: ");
		days = keyboard.nextInt();
		while (days < 1) {
			System.out.print("\nEnter number of days worked (greater than 0): ");
			days = keyboard.nextInt();
		}
	}

	public void displaySalary() {
		double daysSalary = .01;

		System.out.println("\nDay      Salary");
		System.out.println("===============");
		for (int day = 0; day < days; day++) {
			System.out.printf("%-5d||  $%,.2f\n", day + 1, daysSalary);
			salary += daysSalary;
			daysSalary *= 2;
		}
		System.out.printf("\nTotal Earnings: $%,.2f\n", salary);
	}

	public char again() {
        char again;
		System.out.println("\nWould you like to recalculate?");
		System.out.print("y/n: ");

        again = keyboard.next().toLowerCase().charAt(0);
        keyboard.nextLine();

		return again;
	}
}
