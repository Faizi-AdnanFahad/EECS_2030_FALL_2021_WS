package model;

public class Projection extends BinarySeqOperation {
	
	private int[] seq1;
	private int[] seq2;
	
	public Projection(int[] seq1, int[] seq2) {
		this.seq1 = seq1;
		this.seq2 = seq2;
		this.calculateProjection();
	}
	
	public void calculateProjection() {
		
		if (seq1.length < seq2.length) {
			int[] tempProjectingArray = new int[seq2.length]; // the general number storer for the case where all numbers are included in the first array. 
			int counter = 0;
			for (int i = 0; i < seq2.length; i ++) {
				for (int m = 0; m < seq1.length; m ++) {
					if (seq2[i] == seq1[m]) {
						tempProjectingArray[counter] = seq2[i];
						counter ++;
						break;
					}
				}
			}
			
			int[] projectingArray = new int[counter];
			
			for (int i = 0; i < counter; i ++) {
				projectingArray[i] = tempProjectingArray[i];
			}
			
			super.toString = "Projecting " + super.arrayObjectToString(seq1) 
					+ " to " + super.arrayObjectToString(seq2) + " results in: " 
					+ super.arrayObjectToString(projectingArray);
		}
		else {
			int[] tempProjectingArray = new int[seq2.length]; // the general number storer for the case where all numbers are included in the first array. 
			int counter = 0;
			for (int i = 0; i < seq2.length; i ++) {
				for (int m = 0; m < seq1.length; m ++) {
					if (seq2[i] == seq1[m]) {
						tempProjectingArray[counter] = seq2[i];
						counter ++;
						break;
					}
				}
			}
			
			int[] projectingArray = new int[counter];
			
			for (int i = 0; i < counter; i ++) {
				projectingArray[i] = tempProjectingArray[i];
			}
			
			super.toString = "Projecting " + super.arrayObjectToString(seq1) 
					+ " to " + super.arrayObjectToString(seq2) + " results in: " 
					+ super.arrayObjectToString(projectingArray);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
