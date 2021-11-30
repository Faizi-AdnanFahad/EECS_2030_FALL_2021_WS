package model;

public class ConcatAll extends SeqEvaluator {
	
	
	public ConcatAll(int maxSeqOperation) {
		this.arrayOfOperation = new String[maxSeqOperation];
	}

	@Override
	public void addOperation(String operation, int[] seq1, int[] seq2) {
		if (operation.equals("op:projection")) {
			
		}
	}
}
