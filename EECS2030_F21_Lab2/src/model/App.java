package model;

public class App {
	
	public String appName;
	public Log[] arrayOfLogs;
	public int nol;
	
	public int maxRatingAllowed;
	public int[] arrayOfRating;
	public int nor;
	
	private double average;
	
	public int rate5;
	public int rate4;
	public int rate3;
	public int rate2;
	public int rate1;
	
	public App(String appName, int maxRatingAllowed) {
		this.appName = appName;
		this.arrayOfRating = new int[maxRatingAllowed];
		this.arrayOfLogs = new Log[20];
	}
	
	public String getName() {
		return this.appName;
	}
	
	public String getWhatIsNew() {
		String result = "";
		if (this.nol == 0) {
			result = "n/a";
		}
		else {
			result = this.arrayOfLogs[this.nol - 1].toString();
		}
		return result;
	}
	
	public Log[] getUpdateHistory() {
		Log[] l = new Log[this.nol];
		for (int i = 0; i < this.nol; i ++) {
			l[i] = this.arrayOfLogs[i];
		}
		return l;
	}
	
	public Log getVersionInfo(String updateVersion) {
		Log result = null;
		for (int i = 0; i < this.nol; i ++) {
			if (this.arrayOfLogs[i].getVersion().equals(updateVersion)) {
				result = this.arrayOfLogs[i];
			}
		}
		return result;
	}
	
	public String getRatingReport() {
		String result = "";
		if (this.nol == 0) {
			result = "No ratings submitted so far!"; 
		}
		else {
			double sum = 0;
			for (int i = 0; i < this.nor; i ++) {
				sum += this.arrayOfRating[i];
			}
			
			this.average = sum/this.nor;
			result = "Average of " + this.nor + " ratings: " + String.format("%.1f", this.average) + 
					" (Score 5: " + this.rate5 
					+ ", Score 4: " + this.rate4 
					+ ", Score 3: " + this.rate3
					+ ", Score 2: " + this.rate2 
					+ ", Score 1: " + this.rate1 + ")";
		}
		return result;
	}
	
	public void releaseUpdate(String newUpdateVersion) {
		Log l = new Log(newUpdateVersion);
		this.arrayOfLogs[this.nol] = l;
		this.nol ++;
	}
	
	public void submitRating(int rate) {
		if (rate == 1) {
			this.rate1 ++;
		}
		else if (rate == 2) {
			this.rate2 ++;
		}
		else if (rate == 3) {
			this.rate3 ++;
		}
		else if (rate == 4) {
			this.rate4 ++;
		}
		else if (rate == 5) {
			this.rate5 ++;
		}
		
		this.arrayOfRating[this.nor] = rate;
		this.nor ++;
	}
	
	public String toString() {
		return this.appName + " (Current Version: " + this.arrayOfLogs[this.nor - 1].toString() + "; Average Rating: " + String.format("%.1f", this.average)  + ")";
	}	
	
}
































