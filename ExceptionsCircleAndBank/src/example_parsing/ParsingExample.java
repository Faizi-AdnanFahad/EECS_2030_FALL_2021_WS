package example_parsing;

import java.util.Scanner;

public class ParsingExample {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean writeAgain = false;
		
		while (!writeAgain) {
			System.out.println("Please enter a string literal to change to integer: ");
			String s = input.next();
			
			try {
				int r = Integer.parseInt(s);
				writeAgain = true;
				System.out.println(r);
			}
			catch (NumberFormatException nfe) {
				System.out.println("Try again");
			}
			
		}
		
		input.close();
	}

}
