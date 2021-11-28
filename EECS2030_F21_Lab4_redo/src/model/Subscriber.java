package model;

public class Subscriber extends Follower {
	
	private String[] arrayOfVideo;
	private int noV;
	
	public Subscriber(String name, int maxChannel, int maxVid) {
		this.name = name;
		this.arrayOfChannels = new Channel[maxChannel];
		this.arrayOfVideo = new String[maxVid];
	}
	
	public void watch(String videoName, int minutes) {
		Channel tempChannel = null;
		boolean channelFound = false;
		for (int i = 0; !channelFound && i < this.noC; i ++) {
			for (int m = 0; m < this.arrayOfChannels[i].getNOV(); m ++) {
				if (this.arrayOfChannels[i].getArrayOfVideos()[m].equals(videoName)) {
					tempChannel = this.arrayOfChannels[i];
					channelFound = true;
				}
			}
		}
		
		for (int i = 0; i < tempChannel.getNOF(); i ++) {
			if (tempChannel.getArrayOfFollowers()[i] instanceof Monitor) {
				Monitor monitorFollower = ((Monitor) tempChannel.getArrayOfFollowers()[i]);
				for (int m = 0; m < monitorFollower.noC; m ++) {
					/*
					 * Helps to get the index of the channel that matches the channel found in subscribers.
					 */
					if (monitorFollower.arrayOfChannels[m] == tempChannel) {
						monitorFollower.addDate(m, minutes);
					}
				}
			}
		}
	}
	
	public void addVideo(String v) {
		this.arrayOfVideo[this.noV] = v;
		this.noV ++;
	}
	
	public String toString() {
		String result = "";
		if (this.noC == 0 && this.noV == 0) {
			result = "Subscriber " + this.name
					+ " follows no channels and has no recommended videos.";
		}
		else if (this.noC != 0 && this.noV == 0) {
			result = "Subscriber " + this.name 
					+ " follows " + this.seqChannelGenerator() 
					+ " and has no recommended videos.";
		}
		else if (this.noC != 0 && this.noV != 0) {
			result = "Subscriber " + this.name 
					+ " follows " 
					+ this.seqChannelGenerator() 
					+ " and is recommended " + this.seqVidGenerator() + ".";
		}
		
		return result;
	}
	
	// Helper methods
	public String seqChannelGenerator() {
		String seq = "[";
		for (int i = 0; i < this.noC; i ++) {
			
			seq += this.arrayOfChannels[i].getChannelName();
			
			if (i < this.noC - 1) {
				seq += ", ";
			}
		}
		seq += "]";
		return seq;
	}
	
	public String seqVidGenerator() {
		String seqVid = "<";
		for (int i = 0; i < this.noV; i ++) {
			seqVid += this.arrayOfVideo[i];
			
			if (i < this.noV - 1) {
				seqVid += ", ";
			}
		}
		seqVid += ">";
		return seqVid;
	}
}