package model;

public class Subscriber extends Follower {

	private String[] arrayOfVideo;
	private int noV;
	
	public Subscriber(String name, int maxChannel, int maxVid) {
		this.name = name;
		this.arrayOfChannels = new Channel[maxChannel];
		this.arrayOfVideo = new String[maxVid];
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

				if (i == this.noC - 1) {
					this.arrayOfChannels[i] = null;
				}
				else {
					this.arrayOfChannels[i] = null;
					this.arrayOfChannels[i] = this.arrayOfChannels[i + 1];
				}

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
	
		if (channelClass != null) {
			/*
			 * marks a channel as watched.
			 */
			channelClass.watched(true);
		}
		
		for (int i = 0; i < channelClass.getNoF(); i ++) {
			if (channelClass.getArrayOfFollowers()[i] instanceof Monitor) {
				((Monitor) channelClass.getArrayOfFollowers()[i]).incrementView();
				((Monitor) channelClass.getArrayOfFollowers()[i]).setMaxViewSoFar(minutes);
			}
		}

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
