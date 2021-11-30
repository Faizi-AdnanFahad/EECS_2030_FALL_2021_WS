package model;

public class ConcatAll extends SeqEvaluator {
	
	
	public ConcatAll(int maxSeqOperation) {
		this.arrayOfOperation = new int[maxSeqOperation][];
	}

	@Override
	public void addOperation(String operation, int[] seq1, int[] seq2) throws IllegalOperationException {
		if (operation.equals("op:projection")) {
			this.arrayOfOperation[this.noO] = Projection.calculateProjection(seq1, seq2);
			this.noO ++;
		}
		else if (operation.equals("op:sumsOfPrefixes")) {
			this.arrayOfOperation[this.noO] = SumsOfPrefixes.calculateSumPrefix(seq1);
			this.noO ++;
		}
		else {
			throw new IllegalOperationException("Operation is not recognized!");
		}
	}
	
	public String toString() {
		String seq = "[";
		for (int i = 0; i < this.noO; i ++) {
			for (int m = 0; m < this.arrayOfOperation[i].length; m ++) {
				seq += this.arrayOfOperation[i][m];
				if (m < this.arrayOfOperation[i].length - 1) {
					seq += ", ";
				}
			}
			if (i < this.noO - 2) {
				seq += ", "; 
			}
		}
		seq += "]";
		
		String concatString = "Concat(";
		for (int i = 0; i < this.noO; i ++) {
			concatString += SeqOperation.arrayObjectToString(this.arrayOfOperation[i]);
			if (i < this.noO - 1) {
				concatString += ", ";
			}
		}
		concatString += ")";
		return concatString + " = " + seq;
	}
}
