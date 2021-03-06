package model;

public class Account {
	
	private String name;
	private AppStore appStore;
	
	private String[] arrayOfNamesDownload; // Stores "ONLY" the name of the downloaded apps
	private final int MAX_NUM_DOWNLOAD = 50;
	private int nod; // Number of Downloads
	
	private App[] arrayOfObjectDownload; // Stores "ONLY" the object of the downloaded apps
	
	private String statusMsg;
	private boolean someAppUninstalled; // used for tracking if there's an installed app so it can carefully return its arrays in *getNamesOfDownloadedApps* 
										// and *getObjectsOfDownloadedApps* methods
	
	public Account(String name, AppStore appStore) {
		this.name = name;
		this.appStore = appStore;
		this.arrayOfNamesDownload = new String[MAX_NUM_DOWNLOAD];
		this.arrayOfObjectDownload = new App[MAX_NUM_DOWNLOAD];
		this.statusMsg = "An account linked to the " + this.appStore.getBranch() + " store is created for " + this.name + ".";

	}
	
	public String[] getNamesOfDownloadedApps() {
		String[] arrayOfResults = new String[this.nod];
		int index = 0;
		if (!someAppUninstalled) {
			for (int i = 0; i < this.nod; i ++) {
				arrayOfResults[i] = this.arrayOfNamesDownload[i];
			}
			return arrayOfResults;
		}
		else {
			String[] updatedArray = new String[this.nod - 1];
			for (int i = 0; i < this.nod; i ++) {
				if (this.arrayOfNamesDownload[i] != null) {
					updatedArray[index] = this.arrayOfNamesDownload[i];
					index ++;
				}
			}
			return updatedArray;
		}
	}
	
	public App[] getObjectsOfDownloadedApps() {
		App[] arrayOfResults = new  App[this.nod];
		int index = 0;
		if (!someAppUninstalled) {
			for (int i = 0; i < this.nod; i ++) {
				arrayOfResults[i] = this.arrayOfObjectDownload[i];
			}
			return arrayOfResults;
		}
		else {
			App[] updatedArray = new App[this.nod - 1];
			for (int i = 0; i < this.nod; i ++) {
				if (this.arrayOfObjectDownload[i] != null) {
					updatedArray[index] = this.arrayOfObjectDownload[i];
					index ++;
				}
			}
			return updatedArray;
		}
		
	}
	
	public void uninstall(String appName) {
		boolean stay = true;
		boolean found = false;
		this.someAppUninstalled = false;
		if (this.nod == 0) {
			this.statusMsg = "Error: " + appName + " has not been downloaded for " + this.name + ".";
		}
		else {
			for (int i = 0; stay && i < this.nod; i ++) {
				App app = this.arrayOfObjectDownload[i];
				if (app.getName().equals(appName)) {
					this.arrayOfNamesDownload[i] = null;
					this.arrayOfObjectDownload[i] = null;
					someAppUninstalled = true;
					stay = false;
					found = true;
				}	
			}
			this.statusMsg = appName + " is successfully uninstalled for " + this.name + ".";
		}
		
		if (!found) {
			this.statusMsg = "Error: " + appName + " has not been downloaded for " + this.name + ".";
		}
	}
	
	public void submitRating(String appName, int rate) {
		boolean found = false;
		if (this.nod == 0) {
			this.statusMsg = "Error: " + appName + " is not a downloaded app for " + this.name + ".";
		}
		else {
			for (int i = 0; i < this.nod; i ++) {
				App app = this.arrayOfObjectDownload[i];
				if (app.getName().equals(appName)) {
					app.submitRating(rate);
					this.statusMsg = "Rating score " + rate + " of " + this.name + " is successfully submitted for " + appName + ".";
					found = true;
				}	
			}
		}
		
		if (!found) {
			this.statusMsg = "Error: " + appName + " is not a downloaded app for " + this.name + ".";
		}
	}
	
	public void switchStore(AppStore newAppStore) {
		this.appStore = newAppStore;
		this.statusMsg = "Account for " + this.name + " is now linked to the " + newAppStore.getBranch() + " store.";
	}
	
	public void download(String appName) {
		boolean search = true;
		boolean stay = true;
		for (int i = 0; stay && i < this.nod; i ++) {
			if (this.arrayOfNamesDownload[i].equals(appName) || this.arrayOfObjectDownload[i].getName().equals(appName)) {
				search = false;
				this.statusMsg = "Error: " + appName + " has already been downloaded for " + this.name + ".";
				stay = false;
			}
		}
		
		if (search) {
			this.arrayOfNamesDownload[this.nod] = appName;
			/* Searching for the correct app to add it to the array of Objects in the AppStore */
			for (int i = 0; i < this.appStore.getNOA(); i ++) {
				App app = this.appStore.getArrayOfApps()[i];
				if (app.getName().equals(appName)) {
					this.arrayOfObjectDownload[this.nod] = app;
					this.nod ++;
				}	
			}
			this.statusMsg = appName + " is successfully downloaded for " + this.name + ".";
		}
		
	}
	
	public String toString() {
		return this.statusMsg;
	}
}