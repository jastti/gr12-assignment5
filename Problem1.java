
/**
 * @author Jasmine Tian
 * Due Date: May 6, 2021
 * ICS4U
 * Ms. Wong
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

public class Problem1 {
	
	public static int Problem1(String s) {
		HashSet<String> hs = new HashSet<String>();
		// To store distinct output subStrings
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j <= s.length(); j++) {
				hs.add(s.substring(i, j));
				// One by one generate subStrings ending with s[j]
			}
		}
		return hs.size();
		// Print all subStrings one by one
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Finding the number of Substrings: ");
		System.out.println("Enter the file name: ");
		Scanner inputStream = new Scanner(System.in);
		// ask the user to input
		try {
			String data = inputStream.nextLine();
			inputStream = new Scanner(new FileReader(data));
			String line = null;
			line = inputStream.nextLine();
			//read the input line by line once the file has the next line
			while (inputStream.hasNextLine()) {
				// while the file has the next line
				line = inputStream.nextLine();
				// skip the first line which represents the number of strings that is going to be read
				if (line.length() <= 1000) {
					// if the length of the string is less than 1000(since the maximum number of characters input is 1000)
					System.out.println("String: " + line);
					// print the string
					System.out.println("No. of Substrings: " + Problem1(line));
					// print the number of substrings of the string
				} else {
					System.out.println("\nThis string has " + line.length()
							+ " characters, which this line of string too long to read:( "
							+ "\nPlease re-write this line to have a string that has less than 1000 characters to read\n");
					// else print the notice (since the maximum number of characters input is 1000)
				} 
			}
			inputStream.close();
			// close the file after finishing reading

		} catch (FileNotFoundException e) {
			System.out.println("File cannot found");
			System.exit(0);
			// if the file cannot found, print the notice and exit
		}
	}
}
