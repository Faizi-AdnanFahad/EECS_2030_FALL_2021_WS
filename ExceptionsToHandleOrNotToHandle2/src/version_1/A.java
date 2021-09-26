package version_1;

public class A {
	A() {
		
	}
	
	void ma (int i ) throws NegValException { 
		if (i < 0) {
//			try {
//				throw new NegValException("Neg Vol: "  + i);
//			}
//			catch (NegValException nve) {
//				
//			}
			throw new NegValException("Neg Val: " + i);
		}
		else {
			// Do something else when there's not an error
		}
	}
}