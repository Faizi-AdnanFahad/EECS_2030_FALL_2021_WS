package console_testers;

import implementation.Counter;
import implementation.ValueTooSmallException;

public class CounterTester1 {
	public static void main(String[] args) {
		Counter c = new Counter();
		System.out.println("Init val: " + c.getValue());
		try {
			c.decrement();
			System.out.println("Error: ValueTooSmallException NOT thrown as expected.");
		} 
		catch (ValueTooSmallException e) {
			System.out.println("Success: ValueTooSmallException thrown as expected.");
		}
	}
}
