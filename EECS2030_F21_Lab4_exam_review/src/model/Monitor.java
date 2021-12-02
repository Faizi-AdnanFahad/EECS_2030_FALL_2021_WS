package model;

public class Monitor extends Follower {
	
	private int[] arrayOfViews;
	private int[] totalSoFar;
	private int[] maxSoFar;

	public Monitor(String name, int maxChannel) {
		super(name, maxChannel);
		this.arrayOfViews = new int[maxChannel];
		this.totalSoFar = new int[maxChannel];
		this.maxSoFar = new int[maxChannel];
	}
	
	public String toString() {
		String result = "";
		
		if (this.noC == 0) {
			result = "Monitor " + this.name + " follows no channels.";
		}
		else {
			String seq = "[";
			for (int i = 0; i < this.noC; i ++) {
				if (this.arrayOfViews[i] > 0) {
					seq += this.arrayOfChannel[i].getChannelName();
					seq += " {#views: " + this.arrayOfViews[i] 
							+ ", max watch time: " + this.maxSoFar[i] 
							+ ", avg watch time: " + String.format("%.2f", (double) this.totalSoFar[i] / this.arrayOfViews[i]) + "}";
					if (i < this.noC - 1) {
						seq += ", ";
					}
				}
				else {
					seq += this.arrayOfChannel[i].getChannelName();
					if (i < this.noC - 1) {
						seq += ", ";
					}
				}
			}
			seq += "]";
			result = "Monitor " + this.name + " follows " + seq + ".";
		}
		
		return result;
	}
	
	public void addStat(String ChannelName, int minutes) {
		/*
		 *  Go over the channels Followed and 
		 *  check which channel name matches the channel 
		 *  that has been watched.
		 */
		
		int indexOfChannelWatched = -1;
		for (int i = 0; i < this.noC; i ++) {
			if (this.arrayOfChannel[i].getChannelName().equals(ChannelName)) {
				indexOfChannelWatched = i;
			}
		}
		
		if (indexOfChannelWatched != -1) {
			this.arrayOfViews[indexOfChannelWatched] ++;
			this.totalSoFar[indexOfChannelWatched] += minutes;
			
			if (this.maxSoFar[indexOfChannelWatched] < minutes) {
				this.maxSoFar[indexOfChannelWatched] = minutes;
			}
		}
		
		
	}
}























