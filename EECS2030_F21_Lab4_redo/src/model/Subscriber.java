package model;

public class Subscriber extends Follower {
	
	private Channel[] arrayOfChannels;
	private int noC;
	
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
				monitorFollower.incrementViews();
				if (monitorFollower.getNumView() < minutes) {
					monitorFollower.setMaxView(minutes);
				}
			}
		}
	}
	
	public void addChannel(Channel c) {
		this.arrayOfChannels[this.noC] = c;
		this.noC ++;
	}
	
	public void addVideo(String v) {
		this.arrayOfVideo[this.noV] = v;
		this.noV ++;
	}
	
	public void unfollow(Channel c) {
		boolean stay = true;
		for (int i = 0; stay && i < this.noC; i ++) {
			if (this.arrayOfChannels[i].getChannelName().equals(c.getChannelName())) {
				if (i < this.noC - 1) {
					this.arrayOfChannels[i] = this.arrayOfChannels[i + 1];
					this.noC -= 1;
					stay = false;
				}
				else if (i == this.noC - 1) {
					this.arrayOfChannels[i] = null;
					this.noC -= 1;
					stay = false;
				}
			}
		}
	}
	
	public String toString() {
		String result = "";
		if (this.noC == 0 && this.noV == 0) {
			result = "Subscriber " + this.name
					+ " follows no channels and has no recommended videos.";
		}
		else if (this.noC != 0 && this.noV == 0) {
			String seq = "[";
			for (int i = 0; i < this.noC; i ++) {
				
				seq += this.arrayOfChannels[i].getChannelName();
				
				if (i < this.noC - 1) {
					seq += ", ";
				}
			}
			seq += "]";
			result = "Subscriber " + this.name 
					+ " follows " + seq + " and has no recommended videos.";
		}
		else if (this.noC != 0 && this.noV != 0) {
			String seq = "[";
			for (int i = 0; i < this.noC; i ++) {
				
				seq += this.arrayOfChannels[i].getChannelName();
				
				if (i < this.noC - 1) {
					seq += ", ";
				}
			}
			seq += "]";
			
			String seqVid = "<";
			for (int i = 0; i < this.noV; i ++) {
				seqVid += this.arrayOfVideo[i];
				
				if (i < this.noV - 1) {
					seqVid += ", ";
				}
			}
			seqVid += ">";
			result = "Subscriber " + this.name 
					+ " follows " + seq + " and is recommended " + seqVid + ".";
		}
		
		return result;
	}
}

















