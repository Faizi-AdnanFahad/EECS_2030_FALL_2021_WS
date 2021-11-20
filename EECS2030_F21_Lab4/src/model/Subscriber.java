package model;

public class Subscriber extends Follower {
	
	private String[] arrayOfVideo;
	private int noV;
	private static Channel tempChannel;
	
	private boolean reset;
	
	public Subscriber(String name, int maxChannel, int maxVid) {
		this.name = name;
		this.arrayOfChannels = new Channel[maxChannel];
		this.arrayOfVideo = new String[maxVid];
		this.reset = false;
	}
	
	public void recommendVideo(String videoName) {
		this.arrayOfVideo[this.noV] = videoName;
		this.noV ++;
	}
	
	public void addChannel(Channel c) {
		this.arrayOfChannels[this.noC] = c;
		this.noC ++;
	}
	
	public void removeChannel(Channel c) {
		for (int i = 0; i < this.noC; i ++) {
			if (this.arrayOfChannels[i].getChannelName().equals(c.getChannelName())) {
				this.arrayOfChannels[i] = null;
				this.arrayOfChannels[i] = this.arrayOfChannels[i + 1];
				this.noC -= 1;
			}
		}
	}
	
	public void watch(String videoReleased, int minutes) {
		Channel channelClass = null;
		boolean found = false;
	
		for (int i = 0; !found && i < this.noC; i ++) {
			for (int m = 0; m < this.arrayOfChannels[i].getNoV(); m ++) {
				if (this.arrayOfChannels[i].getArrayOfReleasedVid()[m].equals(videoReleased)) {
					channelClass = this.arrayOfChannels[i];
					found = true;
				}
			}
		}
		
		channelClass.incrementView();
		channelClass.setMaxViewSoFar(minutes);
		channelClass.watched(true);
		
//		if (found) {
//			channelClass.setWatched(true);
//		}
//		else {
//			channelClass.setWatched(false);
//		}
//		if (Subscriber.tempChannel != null && Subscriber.tempChannel != channelClass) {
//			this.reset = true;
//		}
//		else {
//			Subscriber.tempChannel = channelClass;
//		}
//		
//		for (int i = 0; i < channelClass.getNoF(); i ++) {
//			if (channelClass.getArrayOfFollowers()[i] instanceof Monitor) {
//				
//				
//				
//				if (this.reset) {
//					((Monitor) channelClass.getArrayOfFollowers()[i]).reset();
//				}
//			}
//		}
	}
	
	public String toString() {
		String result = "";
		if (this.noV == 0 && this.noC == 0) { /* No Recommended video and No Channels*/
			result = "Subscriber " 
					+ this.name + " follows no channels and has no recommended videos.";
		}
		else if (this.noV == 0 && this.noC != 0) { /* Recommended video and No Channels*/
			String seqChannels = "[";
			for (int i = 0; i < this.noC; i ++) {
				seqChannels += this.arrayOfChannels[i].getChannelName();
				if (i < this.noC - 1) {
					seqChannels += ", ";
				}
			}
			seqChannels += "]";
			result = "Subscriber " 
					+ this.name + " follows " 
					+ seqChannels + " and has no recommended videos.";
		}
		else if (this.noC != 0 && this.noV != 0) { /* Recommended video and Channels*/
			String seqChannels = "[";
			for (int i = 0; i < this.noC; i ++) {
				seqChannels += this.arrayOfChannels[i].getChannelName();
				if (i < this.noC - 1) {
					seqChannels += ", ";
				}
			}
			seqChannels += "]";

			String vidSeq = "<";
			for (int i = 0; i < this.noV; i ++) {
				vidSeq += this.arrayOfVideo[i];
				if (i < this.noV - 1) {
					vidSeq += ", ";
				}
			}
			vidSeq += ">";
			result = "Subscriber " + this.name + " follows " 
					+ seqChannels 
					+ " and is recommended " 
					+ vidSeq + ".";
		}
		return result;
	}
}
