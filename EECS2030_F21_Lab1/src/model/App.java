package model;

public class App {
	
	private String appName;
	private Log[] logHistory;
	private int nol; // records the number of log history
	private final int MAX_NUM_OF_UPADATE_LOG = 20;
	
	private int[] arrayOfRatings;
	private int nor; // Number of Ratings
	
	private int[] arrayForNumOfRatingRecording;
	private double average;
	
	
	public App(String appName, int maxNumOfRating) {
		this.appName = appName;
		this.logHistory = new Log[MAX_NUM_OF_UPADATE_LOG];
		this.arrayOfRatings = new int[maxNumOfRating];
		this.arrayForNumOfRatingRecording = new int[5];
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
			Log lastLog = this.logHistory[this.nol - 1];
			result = lastLog.toString();
		}
		return result;
	}
	
	public Log[] getUpdateHistory() {
		Log[] templogArray = new Log[this.nol];
		for (int i = 0; i < this.nol; i ++) {
			templogArray[i] = this.logHistory[i];
		}
		return templogArray;
	}
	
	public Log getVersionInfo(String versionNum) {
		Log result = null;
		boolean stay = true;
		for (int i = 0; stay && i < this.nol; i ++) {
			Log matchingLog = this.logHistory[i];
			if (matchingLog.getVersion().equals(versionNum)) {
				result = matchingLog;
				stay = false;
			}
		}
		return result;
	}
	
	public String getRatingReport() {
		double sum = 0;
		for (int i = 0; i < 5; i ++) {
			sum += this.arrayOfRatings[i];
		}
		this.average = (sum / this.nor);
		
		String result = "";
		if (this.nor == 0) {
			result =  "No ratings submitted so far!";
		}
		else {
			result = "Average of " + this.nor + " ratings: " + String.format("%.1f", this.average) + 
					" (Score 5: " + this.arrayForNumOfRatingRecording[4] + 
					", Score 4: " + this.arrayForNumOfRatingRecording[3] + 
					", Score 3: " + this.arrayForNumOfRatingRecording[2] + 
					", Score 2: " + this.arrayForNumOfRatingRecording[1] + 
					", Score 1: " + this.arrayForNumOfRatingRecording[0] + ")";
		}
		return result;
	}
	
	public void releaseUpdate(String versionNum) {
		this.logHistory[this.nol] = new Log(versionNum);
		this.nol ++ ;
	}
	
	public void submitRating(int rate) {
		if (rate == 1) {
			this.arrayForNumOfRatingRecording[0] ++;
		}
		else if (rate == 2) {
			this.arrayForNumOfRatingRecording[1] ++;
		}
		else if (rate == 3) {
			this.arrayForNumOfRatingRecording[2] ++;
		}
		else if (rate == 4) {
			this.arrayForNumOfRatingRecording[3] ++;
		}
		else if (rate == 5) {
			this.arrayForNumOfRatingRecording[4] ++;
		}
		
		this.arrayOfRatings[this.nor] = rate;
		this.nor ++;
	}
	
	public String toString() {
		String result = "";
		if (this.nor != 0) {
			result = this.appName + " (Current Version: " + this.getWhatIsNew() + "; Average Rating: " + String.format("%.1f", this.average) + ")";
		}
		else {
			result = this.appName + " (Current Version: " + this.getWhatIsNew() + "; Average Rating: n/a)";
		}
		return result;
	}

	
}
 






















