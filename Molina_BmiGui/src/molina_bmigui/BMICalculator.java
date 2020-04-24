/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_bmigui;

/**
 *
 * @author barry
 */
public class BMICalculator {
	final private double OVERWEIGHT = 25;
	final private double OPTIMAL = 18.5;
	final private int CONVERSION_FACTOR = 703;

	private double weight;
	private double bmi;
	private int height;

    public BMICalculator(double weight, int height){
        this.weight = weight;
        this.height = height;
    }
    
	public void calculateBMI() {
		bmi = weight / Math.pow(height, 2) * CONVERSION_FACTOR;
	}
    public String resultBMI() {
		return String.format("\nYour Body Mass Index is %.1f", bmi);
    }

	public String resultMessage() {
        String msg;
		if (bmi >= OVERWEIGHT) {
			msg = "Looks like you're a bit overweight for your height.";
		}
		else if (bmi >= OPTIMAL) {
			msg = "You're at optimal weight for your height.";
		}
		else {
			msg = "You're underweight for your height.";
		}
        return msg;
	}
    
}
