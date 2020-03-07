/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_driverexam;

import java.util.Scanner;

/**
 *
 * @author barrymolina
 */
public class ExamDemo {
	DriverExam exam;
	char[] attempt;

	Scanner keyboard = new Scanner(System.in);

	public void run() {
		exam = new DriverExam();
		attempt = new char[exam.correct.length];

		for (int i = 0; i < attempt.length; i++) {
			System.out.print("Enter answer for question " + (i + 1) + ": ");
			attempt[i] = keyboard.next().toUpperCase().charAt(0);
		}
		exam.setAttempt(attempt);

		System.out.println("\n\nYou got " + exam.totalCorrect() + " correct and "
							+ "missed " + exam.questionsMissed() + ".");
		System.out.println("Passed: " + exam.passed());
	}
}
