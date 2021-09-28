package model;

public class AppStore {
	
	private String branchName;	
	private App[] arrayOfApps;
	private int noa;
	
	public AppStore(String branchName, int maxNumOfApps) {
		this.branchName = branchName;
		this.arrayOfApps = new App[maxNumOfApps];
	}
	
	public String getBranch() {
		return this.branchName;
	}
	
	/***************************************************/
	public App[] getArrayOfApps() {
		return this.arrayOfApps;
	}
	
	public int getNOA() {
		return this.noa;
	}
	/***************************************************/

	public App getApp(String appName) {
		App result = null;
		boolean stay = true;
		for (int i = 0; stay && i < this.noa; i ++) {
			App app = this.arrayOfApps[i];
			if (app.getName().equals(appName)) {
				result = app;
				stay = false;
			}
		}
		return result;
	}
	
	public String[] getStableApps(int num) {
		App[] matchedApps = new App[this.noa];
		int count = 0;
		for (int i = 0; i < this.noa; i ++) {
			App app = this.arrayOfApps[i];
			if (app.getNol() >= num) {
				matchedApps[count] = app;
				count ++;
			}
		}
		String[] result = new String[count];
		String structure = "";
		for (int i = 0; i < count; i ++) {
			structure = matchedApps[i].getName() + " (" + matchedApps[i].getNol() + " versions; " + "Current Version: " + matchedApps[i].getWhatIsNew() + ")";
			result[i] = structure;
		}
		return result;
	}
	
	public void addApp(App newApp) {
		this.arrayOfApps[this.noa] = newApp;
		this.noa ++;
	}	
}