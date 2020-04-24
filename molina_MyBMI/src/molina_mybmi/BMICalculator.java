/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_mybmi;

import java.util.Scanner;

/**
 *
 * @author barrymolina
 */
public class BMICalculator {
	final private double OVERWEIGHT = 25;
	final private double OPTIMAL = 18.5;
	final private int CONVERSION_FACTOR = 703;

	private double weight;
	private double bmi;
	private int height;

	Scanner keyboard = new Scanner(System.in);

	public void getInfo() {
		System.out.print("Enter your weight in pounds: ");
		weight = keyboard.nextDouble();

		System.out.print("\nEnter your height in inches: ");
		height = keyboard.nextInt();
	}

	public void calculateBMI() {
		bmi = weight / Math.pow(height, 2) * CONVERSION_FACTOR;
	}

	public void displayResults() {
		System.out.printf("\nYour Body Mass Index is %.1f\n\n", bmi);
		if (bmi >= OVERWEIGHT) {
			System.out.println("Looks like you're a bit overweight for your height.");
		}
		else if (bmi >= OPTIMAL) {
			System.out.println("You're at optimal weight for your height.");
		}
		else {
			System.out.println("You're underweight for your height.");
		}
	}
}
