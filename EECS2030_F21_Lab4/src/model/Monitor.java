package model;

public class Monitor extends Follower {
	
	protected String[] arrayOfChannels;
	protected int noC;
	
	public Monitor(String name, int maxChannelFollow) {
		this.name = name;
		this.arrayOfChannels = new String[maxChannelFollow];
		this.noC = 0;
	}
	
	@Override
	public void addChannel(String channelName) {
		this.arrayOfChannels[this.noC] = channelName;
		this.noC ++;
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
	
	@Override
	public String toString() {
		String result = "";
		if (this.noC == 0) {
			result = "Monitor " + this.name + " follows no channels.";
		}
		else {
			String seqChannels = "[";
			for (int i = 0; i < this.noC; i ++) {
				seqChannels += this.arrayOfChannels[i];
				if (i < this.noC - 1) {
					seqChannels += ", ";
				}
			}
			seqChannels += "]";
			result = "Monitor " 
					+ this.name + " follows " + seqChannels + ".";
		}
		return result;
	}
	
	@Override
	public String getDT() {
		/*
		 * Used for the method toString in Channel class.
		 */
		return "Monitor";
	}
}
