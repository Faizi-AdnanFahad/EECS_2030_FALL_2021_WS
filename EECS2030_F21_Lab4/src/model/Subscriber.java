package model;

public class Subscriber extends Follower {

	protected Channel[] arrayOfChannels;
	protected int noC;

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
//			Monitor monitorAccess = (Monitor) ((Follower) this);
//			Channel[] arrayChannelInMonitor = monitorAccess.arrayOfChannels;
//			for (int m = 0; !found && m < arrayChannelInMonitor[i].getArrayOfVidReleased().length; m ++) {
//				if (arrayChannelInMonitor[i].getArrayOfVidReleased()[m].equals(videoName)) {
//					arrayChannelInMonitor[i].getMonitorData()[0] ++; // View counter
//					arrayChannelInMonitor[i].getMonitorData()[1] += timeInMin;
//					if (arrayChannelInMonitor[i].getMonitorData()[0] != 0) {
//						arrayChannelInMonitor[i].getMonitorData()[2] = arrayChannelInMonitor[i].getMonitorData()[1] / arrayChannelInMonitor[i].getMonitorData()[0];
//					}
//					found = true;
//				}
//			}
			for (int m = 0; !found && m < this.arrayOfChannels[i].getArrayOfVidReleased().length; m ++) {
				if (this.arrayOfChannels[i].getArrayOfVidReleased()[m].equals(videoName)) {
					this.cForMonitor = this.arrayOfChannels[i];
					found = true;
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
