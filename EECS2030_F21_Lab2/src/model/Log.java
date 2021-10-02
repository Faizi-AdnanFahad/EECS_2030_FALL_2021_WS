package model;

public class Log {
	
	public String updateVersion;
	public String[] arrayOfLogs;
	public int nof;
	
	public Log(String updateVersion) {
		this.updateVersion = updateVersion;
		this.arrayOfLogs = new String[10];
	}
	
	public String getVersion() {
		return this.updateVersion;
	}
	
	public int getNumberOfFixes() {
		return this.nof;
	}
	
	public String getFixes() {
		String result = "[";
		for (int i = 0; i < this.nof; i ++) {
			if (i == this.nof - 1) {
				result += this.arrayOfLogs[i];
			}
			else {
				result += this.arrayOfLogs[i] + ", ";
			}
		}
		result += "]";
		return result;
	}
	
	public void addFix(String updateDetail) {
		this.arrayOfLogs[this.nof] = updateDetail;
		this.nof ++;
	}
	
	public String toString() {
		return "Version " + this.updateVersion + " contains " + this.nof + " fixes " +  this.getFixes(); 
	}
	
	
	
	
}



























