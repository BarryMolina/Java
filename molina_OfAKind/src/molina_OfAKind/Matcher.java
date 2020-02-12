/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_OfAKind;

/**
 *
 * @author barrymolina
 */
public class Matcher {

	private int[] values;
	private int mostMatches;
	private int matchValue;

	public Matcher(int[] vals) {
		values = vals;
		matchValue = 0;
		mostMatches = 0;
	}

	public void calcMatches() {
		int matchesFound;

		int y;

		int[] testedVals = new int[values.length];
		int numTested = 0;
		boolean tested;

		for (int x = 0; x < values.length; x++) {
			tested = false;
			y = 0;
			// check if value has been matched already
			while (!tested && y < numTested) {
				if (values[x] == testedVals[y]) {
					tested = true;
				}
				y++;
			}
			matchesFound = 0;
			if (!tested) {
				for (int i = 0; i < values.length; i++) {
					if (values[x] == values[i]) {
						matchesFound++;
					}
				}
			}
			if (matchesFound > mostMatches) {
				mostMatches = matchesFound;
				matchValue = values[x];
			}
			testedVals[numTested] = values[x];
			numTested++;
		}
	}

	public int getMostMatches() {
		return mostMatches;
	}
	
	public int getMatchValue() {
		return matchValue;
	}
	public int[] getValues() {
		return values;
	}
}
