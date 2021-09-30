package Written_test_1_practice;

public class Divide {
	
	private double dinominator;
	private double nominator;
	
	public Divide(double n, double d) {
		this.nominator = n;
		this.dinominator = d;
	}
	
	public double getDivision() throws DinominatorZeroError {
		double result = 0;
		if (this.dinominator == 0) {
			throw new DinominatorZeroError("Dividing by zero is not allowed!");
		}
		else {
			result = nominator / dinominator;
		}
		return result;
	}
}
