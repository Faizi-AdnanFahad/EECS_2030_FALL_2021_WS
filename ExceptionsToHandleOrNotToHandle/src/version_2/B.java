package version_2;

public class B {
	B() { }
	
	void mb(int i) throws NegValException {
		A oa = new A();
		// From the method call below,
		// we know that B.mb is the caller of A.ma.
		// To handle the exception below, we choose to
		// specify it.
		oa.ma(i);
	}
}

// For version 2, since we are catching the exception in Tester.main, why did we had class B, couldn't we specify the exception directly from class A to Tester.main without having class B? 
// Or in a general case, if an exception is thrown at the top of the our method stacks, shouldn't the the exception be specified to the caller coming after it? 
// Why should we just have another caller after the place where exception was originated, throw it to its caller (2nd method call in the stack from the top) and 
// then throw it again to its caller (3rd method call in the stack from the top)?

// In the class A, in NegValException exception, we passed a String for initialization and when it was the abnormal case, the part from the catch method got prinited
// in to the console, what is the point of having an argument passed over the exception?

// Should we do exception handling as we develop our program, or we should finish the program and then do it.