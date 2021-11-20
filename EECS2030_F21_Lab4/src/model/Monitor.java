package model;

public class Monitor extends Follower {
	
	
	
	boolean watched;
	boolean resetCalled;
	
	public Monitor(String name, int maxChannel) {
		this.name = name;
		this.arrayOfChannels = new Channel[maxChannel];
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

	@Override
	public String toString() {
		String result = "";

		if (this.noC == 0) {
			result = "Monitor " + this.name + " follows no channels.";
		}
		else { 
			String seqChannels = "[";
			for (int i = 0; i < this.noC; i ++) {
				Channel currentChannel = this.arrayOfChannels[i];
				if (!currentChannel.watched) {
					seqChannels += currentChannel.getChannelName();
					if (i < this.noC - 1) {
						seqChannels += ", ";
					}
				}
				else {
					seqChannels += currentChannel.getChannelName();
					seqChannels += " {#views: " 
							+ currentChannel.getNumView()
									+ ", max watch time: " + (int) currentChannel.getMaxView()
											+ ", avg watch time: " + String.format("%.2f", ((double) currentChannel.getMaxViewSoFar() / currentChannel.getNumView())) + "}";
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
}
