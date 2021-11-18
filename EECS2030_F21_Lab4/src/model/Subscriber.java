package model;

public class Subscriber extends Follower {
	
	protected String[] arrayOfChannels;
	protected int noC;
	
	protected Channel[] a;
	
	protected String[] arrayOfVidRec;
	protected int noR;
	
	public Subscriber(String name, int maxChannelToFollow, int maxRecVi) {
		this.name = name;
		this.arrayOfChannels = new String[maxChannelToFollow];
		this.noC = 0;
		this.arrayOfVidRec = new String[maxRecVi];
		this.noR = 0;
		
		a = new Channel[40];
	}
	
	@Override
	public void addChannel(String channelName) {
		this.arrayOfChannels[this.noC] = channelName;
		this.noC ++;
		
	}
	
	public void add(Channel c) {
		this.a[this.noC] = c;
		this.noC ++;
	}
	
	public void recommendVideo(String videoName) {
		this.arrayOfVidRec[this.noR] = videoName;
		this.noR ++;
	}
	
	public void removeChannel(String channelName) {
		for (int i = 0; i < this.noC; i ++) {
			if (this.arrayOfChannels[i].equals(channelName)) {
				this.arrayOfChannels[i] = null;
				this.arrayOfChannels[i] = this.arrayOfChannels[i + 1];
				this.noC -= 1;
			}
		}
	}
	
	public void watch(String videoName, int timeInMin) {
		
	}
	
	@Override
	public String toString() {
		String result = "";
		if (this.noC == 0) {
			result = "Subscriber " 
					+ this.name + " follows no channels and has no recommended videos.";
		}
		else if (this.noR == 0 && this.noC != 0) {
			String seqChannels = "[";
			for (int i = 0; i < this.noC; i ++) {
				seqChannels += this.arrayOfChannels[i];
				if (i < this.noC - 1) {
					seqChannels += ", ";
				}
			}
			seqChannels += "]";
			result = "Subscriber " 
					+ this.name + " follows " 
					+ seqChannels + " and has no recommended videos.";
		}
		else if (this.noC != 0 && this.noR != 0) {
			String seqChannels = "[";
			for (int i = 0; i < this.noC; i ++) {
				seqChannels += this.arrayOfChannels[i];
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
