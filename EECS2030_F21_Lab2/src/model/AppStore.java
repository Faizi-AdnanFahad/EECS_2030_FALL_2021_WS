package model;

public class AppStore {
	
	public String branchCountry;
	public App[] arrayOfApps;
	public int noa;
	
	public AppStore(String branchCountry, int maxNumApp) {
		this.branchCountry = branchCountry;
		this.arrayOfApps = new App[maxNumApp];
	}
	
	public String getBranch() {
		return this.branchCountry;
	}
	
	public App getApp(String appName) {
		App result = null;
		for (int i = 0; i < this.noa; i ++) {
			if (this.arrayOfApps[i].getName().equals(appName)) {
				result = this.arrayOfApps[i];
			}
		}
		return result;
	}
	
	public String[] getStableApps(int stableAppNum) {
		String[] s = new String[this.noa];
		for (int i = 0; i < this.noa; i  ++) {
			App app = this.arrayOfApps[i];
			if (app.getUpdateHistory().length >= stableAppNum) {
				s[i] =  app.getName() + " (" + app.getUpdateHistory().length 
						+ " versions; Current Version: " + app.getUpdateHistory()[app.getUpdateHistory().length - 1].toString();
			}
		}
		return s;
	}
	
	public void addApp(App app) {
		this.arrayOfApps[this.noa] = app;
		this.noa ++;
	}
	
	
}


























