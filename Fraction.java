
import java.util.TreeSet;

public class Fraction {
	int number;
	double lowerNum;
	double upperNum;
	String lowerString;
	String upperString;
	TreeSet<String> fractionset = new TreeSet<String>();
	TreeSet<String> subfraction = new TreeSet<String>();

	public Fraction(int number, String lowerString, String upperString) {
		// create a constructor of the class Fraction
		this.number = number;
		this.lowerString = lowerString;
		this.upperString = upperString;
		lowerNum = getResult(lowerString);
		upperNum = getResult(upperString);
		// initialized
	}

	public double getResult(String str) {
		if (str.contains("/")) {
			String[] string = str.split("/");
			// if the string contains a forward slash (/), split the string into two strings
			return Double.parseDouble(string[0]) / Double.parseDouble(string[1]);
		} else {
			return Double.parseDouble(str);
		}
	}

	public void printTreeSet() {
		System.out.println("Total number of fractions: " + fractionset.size());
		// print the total number of fractions
		System.out.println("Number of Fractions between " + lowerString + " and " 
		+ upperString + " inclusive: " + subfraction.size());
		// print the Number of Fractions between a fraction and another fraction
	}

	public void getFraction(int number) {
		double numerator = 0;
		double denumerator = 1;
		boolean addResult = false;

		TreeSet<Double> fraction = new TreeSet<Double>();

		while (0 < denumerator && denumerator <= number) {
			do {
				double result = numerator / denumerator;
				// convert the fraction into a double first
				addResult = fraction.add(result);
				// determine if there are any duplicates

				if (addResult) {
					fractionset.add(String.valueOf((int) (numerator)) + "/" + String.valueOf((int) (denumerator)));
					// convert the double to the string to represents the total fraction
					if (result >= lowerNum && result <= upperNum) {
						subfraction.add(String.valueOf((int) (numerator)) + "/" + String.valueOf((int) (denumerator)));
						// convert the double to the string that is between a fraction and another fraction
					}
				}
				numerator = numerator + 1;
				// finish one loop, numerator + 1
			} while (numerator <= denumerator);
			numerator = 0;
			denumerator = denumerator + 1;
			// initialize numerator, denumerator + 1
		}
	}
}
