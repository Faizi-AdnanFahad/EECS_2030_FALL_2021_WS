package model;

public abstract class SeqEvaluator {
	
	protected String[] arrayOfOperation;
	protected int noO; // number of operations
	
	public abstract void addOperation(String operation, int[] seq1, int[] seq2);
}
