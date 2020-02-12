/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_ofakind2;

/**
 *
 * @author barrymolina
 */
public class Matcher {

	private int[] dice;
	private int mostMatches;
	private int matchValue;

	public Matcher(int[] d) {
		dice = d;
		matchValue = 0;
		mostMatches = 0;
		calcMatches();
	}

	public void calcMatches() {
		int matchesFound;

		int y;

		int[] testedVals = new int[dice.length];
		int numTested = 0;
		boolean tested;

		for (int x = 0; x < dice.length; x++) {
			tested = false;
			y = 0;
			// check if value has been matched already
			while (!tested && y < numTested) {
				if (dice[x] == testedVals[y]) {
					tested = true;
				}
				y++;
			}
			matchesFound = 0;
			if (!tested) {
				for (int i = 0; i < dice.length; i++) {
					if (dice[x] == dice[i]) {
						matchesFound++;
					}
				}
			}
			if (matchesFound > mostMatches) {
				mostMatches = matchesFound;
				matchValue = dice[x];
			}
			else if (matchesFound == mostMatches) {
				if (dice[x] > matchValue) {
					matchValue = dice[x];
				}
			}
			testedVals[numTested] = dice[x];
			numTested++;
		}
	}

	public String getMatches() {
		String str = "";
		for (int x = 0; x < mostMatches; x++) {
			str += "[" + matchValue + "]";
		}
		return str;
	}
	public String getOfAKind() {
		String ofAKind;
		switch (mostMatches) {
			case 1:
				ofAKind = "One of a kind";
				break;
			case 2:
				ofAKind = "Two of a kind";
				break;
			case 3:
				ofAKind = "Three of a kind";
				break;
			case 4:
				ofAKind = "Four of a kind";
				break;
			case 5:
				ofAKind = "Five of a kind";
				break;
			default:
				ofAKind = "Unknown";
				break;
		}
		return ofAKind;
	}

	public int getMostMatches() {
		return mostMatches;
	}
	
	public int getMatchValue() {
		return matchValue;
	}
	public String getDice() {
		String str = ""; 
		for (int i = 0; i < dice.length; i++) {
			str += "[" + dice[i] + "]";
		}
		return str;
	}
	public boolean greaterThan(Matcher m) {
		boolean isGreater = false;

		if (mostMatches > m.getMostMatches()) {
			isGreater = true;
		}
		else if (mostMatches == m.getMostMatches()) {
			if (matchValue > m.getMatchValue()) {
				isGreater = true;
			}
		}
		return isGreater;
	}
}
