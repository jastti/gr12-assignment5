
/**
 * @author Jasmine Tian
 * Due Date: May 6, 2021
 * ICS4U
 * Ms. Wong
 */

import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String lowerString = "";
		String upperString = "";

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the maximum denominator: ");
		String inString = input.nextLine();
		// ask the user to input the maximum denominator
		int number = Integer.parseInt(inString);
		// convert the string to an integer

		Scanner lower = new Scanner(System.in);
		System.out.println("Enter the lower limit: ");
		lowerString = lower.nextLine();
		// ask the user to input the lower limit

		Scanner upper = new Scanner(System.in);
		System.out.println("Enter the upper limit: ");
		upperString = upper.nextLine();
		// ask the user to input the upper limit

		Fraction fra = new Fraction(number, lowerString, upperString);
		// get the instance of class Fraction
		fra.getFraction(number);
		fra.printTreeSet();
		// call two methods that is going to use from class Fraction
	}
}
