package model;

public class SeqOperation {
	
	protected String toString;
	
	public String toString() {
		return this.toString;
	}
	
	// Helper Method
	public String arrayObjectToString(int[] array) {
		String seq1String = "[";
		for (int i = 0; i < array.length; i ++) {
			seq1String += array[i];
			
			if (i < array.length - 1) {
				seq1String += ", ";
			}
		}
		seq1String += "]";
		return seq1String;
	}
}


















