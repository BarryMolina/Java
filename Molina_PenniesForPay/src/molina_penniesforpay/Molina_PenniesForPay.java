/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_penniesforpay;

/**
 *
 * @author barrymolina
 */
public class Molina_PenniesForPay {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		Admin a = new Admin();
		SalaryCalculator sCalc;

		a.intro();

		do {
		sCalc = new SalaryCalculator();
		sCalc.inputDays();
		sCalc.displaySalary();
		} while (sCalc.again() == 'y');

		a.goodbye();
	}
	
}
