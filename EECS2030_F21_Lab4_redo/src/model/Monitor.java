package model;

public class Monitor extends Follower {
	
	// Data attributes
	/*
	 * Having an array with the size of the array of Channels will help to differentiate the data for each channel.
	 */
	private int[] viewsOfEachChannel;
	private int[] maxViewOfEachChannel;
	private int[] totalViewOfEachChannel;

	public Monitor(String name, int maxChannel) {
		this.name = name;
		this.arrayOfChannels = new Channel[maxChannel];
		
		this.viewsOfEachChannel = new int[maxChannel];
		this.maxViewOfEachChannel = new int[maxChannel];
		this.totalViewOfEachChannel = new int[maxChannel];
	}

	public String toString() {
		String result = "";

		if (this.noC == 0) {
			result = "Monitor " + this.name + " follows no channels.";
		}
		else {
			String seq = "[";
			for (int i = 0; i < this.noC; i ++) {

				seq += this.arrayOfChannels[i].getChannelName();
				if (this.viewsOfEachChannel[i] != 0) {
					seq += " {#views: " + this.viewsOfEachChannel[i] 
							+ ", max watch time: " + this.maxViewOfEachChannel[i] 
							+ ", avg watch time: " 
							+ String.format("%.2f", this.totalViewOfEachChannel[i] / (double) this.viewsOfEachChannel[i]) + "}";
				}

				if (i < this.noC - 1) {
					seq += ", ";
				}
			}
			seq += "]";
			result = "Monitor " + this.name + " follows " + seq + ".";
		}
		return result;
	}
	
	public void addDate(int indexOfChannelFound, int minutes) {
		this.viewsOfEachChannel[indexOfChannelFound] ++;
		this.totalViewOfEachChannel[indexOfChannelFound] += minutes;

		if (this.maxViewOfEachChannel[indexOfChannelFound] < minutes) {
			this.maxViewOfEachChannel[indexOfChannelFound] = minutes;
		}
	}
}