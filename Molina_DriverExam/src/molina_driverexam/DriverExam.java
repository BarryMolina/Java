/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_driverexam;

/**
 *
 * @author barrymolina
 */
public class DriverExam {
	char[] correct = {'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D',
					  'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'};
	char[] attempt;

	private final int PASSING_SCORE = 15;
	private int missed;

	public void setAttempt(char[] attempt) {
		this.attempt = attempt;
		checkAnswers();
	}
	public void checkAnswers() {
		for (int x = 0; x < correct.length; x++) {
			if (attempt[x] != correct[x])
				missed++;
		}
	}
	public Boolean passed() {
		boolean passed = false;
		if (totalCorrect() >= PASSING_SCORE)
			passed = true;
		return passed;
	}
	public int totalCorrect() {
		return correct.length - missed;
	}
	public int questionsMissed() {
		return missed;
	}
}
