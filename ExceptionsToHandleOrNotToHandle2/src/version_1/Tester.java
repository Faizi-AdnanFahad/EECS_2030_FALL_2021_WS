package version_1;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an inter value i: ");
		int i = input.nextInt();
		
		B ob = new B();
		ob.mb(i);
		
		input.close();
	}

}
