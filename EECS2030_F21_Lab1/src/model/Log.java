package model;

public class Log {
	
	private String versionNum;
	private String[] arrayOfFixes;
	private int nof; // Number of Fixes
	private final int MAX_NUM_OF_FIX = 10;
	
	public Log(String versionNum) {
		this.versionNum = versionNum;
		this.nof = 0;
		this.arrayOfFixes = new String[MAX_NUM_OF_FIX];
	}
	
	public String getVersion() {
		return this.versionNum;
	}
	
	public int getNumberOfFixes() {
		return this.nof;
	}
	
	public String getFixes() {
		String result = "[";
		for (int i = 0; i < this.nof; i ++) {
			if (i == this.nof - 1) {
				result += this.arrayOfFixes[i];
			}
			else {
				result += this.arrayOfFixes[i] + ", ";
			}
		}
		result += "]";
		return result;
	}
	
	public void addFix(String fix) {
		this.arrayOfFixes[this.nof] = fix;
		this.nof ++;
	}
	
	public String toString() {
		return "Version " + this.versionNum + " contains " + this.nof + " fixes " + this.getFixes(); 
	}
	

}























