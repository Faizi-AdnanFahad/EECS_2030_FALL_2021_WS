package model;

public class Account {
	
	private String name;
	private AppStore appStore;
	
	private String[] arrayOfNamesDownload;
	private final int MAX_NUM_DOWNLOAD = 50;
	private int nod; // Number of Downloads
	
	private App[] arrayOfObjectDownload;
	
	private String errorMsg;
	
	public Account(String name, AppStore appStore) {
		this.name = name;
		this.appStore = appStore;
		this.arrayOfNamesDownload = new String[MAX_NUM_DOWNLOAD];
		this.arrayOfObjectDownload = new App[MAX_NUM_DOWNLOAD];
		this.errorMsg = "An account linked to the " + this.appStore.getBranch() + " store is created for " + this.name + ".";

	}
	
	public String[] getNamesOfDownloadedApps() {
		String[] arrayOfResults = new  String[this.nod];
//		for (int i = 0; )
		return arrayOfResults;
	}
	
	public App[] getObjectsOfDownloadedApps() {
		App[] arrayOfResults = new  App[this.nod];
		return arrayOfResults;
	}
	
	public void uninstall(String appName) {
		if (this.nod == 0) {
			this.errorMsg = "Error: " + appName + " has not been downloaded for " + this.name + ".";
		}
	}
	
	public void submitRating(String appName, int rate) {
		if (this.nod == 0) {
			this.errorMsg = "Error: " + appName + " is not a downloaded app for " + this.name + ".";
		}
	}
	
	public void switchStore(AppStore newAppStore) {
		this.appStore = newAppStore;
		this.errorMsg = "Account for " + this.name + " is now linked to the " + newAppStore.getBranch() + " store.";
	}
	
	public void download(String appName) {
		this.arrayOfNamesDownload[this.nod] = appName;
		
		/* Searching for the correct app to add it to the array of Objects in the AppStore */
		for (int i = 0; i < this.appStore.getNOA(); i ++) {
			App app = this.appStore.getArrayOfApps()[i];
			if (app.getName().equals(appName)) {
				this.arrayOfObjectDownload[this.nod] = app;
				this.nod ++;
			}
			
		}
		this.errorMsg = appName + " is successfully downloaded for " + this.name + ".";
	}
	
	public String toString() {
		String result = "";
		return this.errorMsg;
	}
	
	
	
	
}
































