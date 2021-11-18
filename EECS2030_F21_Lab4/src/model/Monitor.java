package model;

public class Monitor extends Follower {
	
	protected Channel[] arrayOfChannels;
	protected int noC;
	
	public Monitor(String name, int maxChannelFollow) {
		this.name = name;
		this.arrayOfChannels = new Channel[maxChannelFollow];
		this.noC = 0;
	}
	
	@Override
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
	
	@Override
	public String toString() {
		String result = "";
		if (this.noC == 0) {
			result = "Monitor " + this.name + " follows no channels.";
		}
		else { 
			String seqChannels = "[";
			for (int i = 0; i < this.noC; i ++) {
				if (this.arrayOfChannels[i].getMonitorData()[0] == 0) {
					seqChannels += this.arrayOfChannels[i].getChannelName();
					if (i < this.noC - 1) {
						seqChannels += ", ";
					}
				}
				else {
					seqChannels += this.arrayOfChannels[i].getChannelName();
					seqChannels += "{#views: " 
							+ this.arrayOfChannels[i].getMonitorData()[0] 
							+ ", max watch time: " + this.arrayOfChannels[i].getMonitorData()[1] 
							+ ", avg watch time: " + String.format("%.2f", (double) this.arrayOfChannels[i].getMonitorData()[0]) + "}";
					if (i < this.noC - 1) {
						seqChannels += ", ";
					}
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
