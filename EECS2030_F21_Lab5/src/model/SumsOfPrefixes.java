package model;

public class SumsOfPrefixes extends SeqOperation {
	
	protected int[] sequence;
	
	public SumsOfPrefixes(int[] sequence) {
		this.sequence = sequence;
	}
	
	public String toString() {		
		
		int[] result = new int[this.sequence.length + 1];
		
		for (int i = 0; i < this.sequence.length + 1; i ++) {
			result[i] = this.summation(i);
		}
		
		return "Sums of prefixes of " 
			+ super.arrayObjectToString(this.sequence) + " is: " 
			+ super.arrayObjectToString(result);
	}
	
	// Helper method
	public int summation(int index) {
		int sum = 0;
		
		for (int i = 0; i < index; i ++) {
			sum += this.sequence[i];
		}
		return sum;
	}
}
