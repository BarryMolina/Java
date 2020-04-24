/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_mybmi;

/**
 *
 * @author barrymolina
 */
public class Molina_MyBMI {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Admin a = new Admin();
		BMICalculator bmiCalc = new BMICalculator();

		a.intro();

		bmiCalc.getInfo();
		bmiCalc.calculateBMI();
		bmiCalc.displayResults();

		a.goodbye();
	}
	
}
