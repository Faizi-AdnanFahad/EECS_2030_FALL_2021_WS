package Written_test_1_practice;

import java.util.Scanner;
import Written_test_1_practice.Divide;

public class DivisionMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please Enter the nominator: ");
		double n = input.nextDouble();
		System.out.println("Please Enter the dinominator: ");
		double d = input.nextDouble();
		
		Divide divObj = new Divide(n, d);
		try {
			double result = divObj.getDivision();
			System.out.println(n + " divided by " + d + " is " + result);
		}
		catch (DinominatorZeroError di) {
			System.out.println(di);
		}
		
		
	}

}
