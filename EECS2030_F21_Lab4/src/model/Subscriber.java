package model;

public class Subscriber extends Follower {

	protected String[] arrayOfVidRec;
	protected int noR;


	public Subscriber(String name, int maxChannelToFollow, int maxRecVi) {
		this.name = name;
		this.arrayOfChannels = new Channel[maxChannelToFollow];
		this.noC = 0;
		this.arrayOfVidRec = new String[maxRecVi];
		this.noR = 0;
	}

	@Override
	public void addChannel(Channel c) {
		this.arrayOfChannels[this.noC] = c;
		this.noC ++;
	}

	public void recommendVideo(String videoName) {
		this.arrayOfVidRec[this.noR] = videoName;
		this.noR ++;
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

	public void watch(String videoName, int timeInMin) {
		boolean found = false;
		for (int i = 0; !found && i < this.noC; i ++) {
			for (int m = 0; !found && m < this.arrayOfChannels[i].getNumberVid(); m ++) {
				if (this.arrayOfChannels[i].getArrayOfVidReleased()[m].equals(videoName)) {
					this.cForMonitor = this.arrayOfChannels[i];
					found = true;
				}
			}
		}
		this.releasedVideo = videoName;

		for (int i = 0; i < this.cForMonitor.getNumberOfFollowers(); i ++) {
			if (this.cForMonitor.getArrayOfFollower()[i].getDT().equals("Monitor")) {
				for (int m = 0; m < this.cForMonitor.getArrayOfFollower()[i].getNOC(); m ++) {
					if (this.cForMonitor.getArrayOfFollower()[i].getChannel()[m] == this.cForMonitor) {
						this.cForMonitor.getArrayOfFollower()[i].getChannel()[m].TotalTimeWatched(timeInMin);
						this.cForMonitor.getArrayOfFollower()[i].getChannel()[m].getMonitorData()[0] ++; // View counter
						if (this.cForMonitor.getArrayOfFollower()[i].getChannel()[m].getMonitorData()[1] < timeInMin) {
							this.cForMonitor.getArrayOfFollower()[i].getChannel()[m].getMonitorData()[1] = timeInMin;
						}
						if (this.cForMonitor.getArrayOfFollower()[i].getChannel()[m].getMonitorData()[0] != 0) {
							this.cForMonitor.getArrayOfFollower()[i].getChannel()[m].getMonitorData()[2] = 
									this.cForMonitor.getArrayOfFollower()[i].getChannel()[m].getTotalTimeWatched() / this.cForMonitor.getArrayOfFollower()[i].getChannel()[m].getMonitorData()[0];
						}
					}
				}
			}
		}


	}



	@Override
	public String toString() {
		String result = "";
		if (this.noC == 0 && this.noR == 0) { /* No Recommended video and No Channels*/
			result = "Subscriber " 
					+ this.name + " follows no channels and has no recommended videos.";
		}
		else if (this.noR == 0 && this.noC != 0) { /* Recommended video and No Channels*/
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
		else if (this.noC != 0 && this.noR != 0) { /* Recommended video and Channels*/
			String seqChannels = "[";
			for (int i = 0; i < this.noC; i ++) {
				seqChannels += this.arrayOfChannels[i].getChannelName();
				if (i < this.noC - 1) {
					seqChannels += ", ";
				}
			}
			seqChannels += "]";

			String vidSeq = "<";
			for (int i = 0; i < this.noR; i ++) {
				vidSeq += this.arrayOfVidRec[i];
				if (i < this.noR - 1) {
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

	@Override
	public String getDT() {
		/*
		 * Used for the method toString in Channel class.
		 */
		return "Subscriber";
	}
}