package model;

public class Monitor extends Follower {

	int numView = 0;
	int maxViewSoFar;
	double totalSorFar;

	private int maxChannel;

	public Monitor(String name, int maxChannel) {
		this.name = name;
		this.arrayOfChannels = new Channel[maxChannel];
		this.maxChannel = maxChannel;
	}

	public Monitor(Monitor m) {
		this(m.name, m.maxChannel);
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
				
				/*
				 * Finding the (Follower) Monitor object that matches 
				 * with the context object; once found,
				 * using the second index of the found array, 
				 * change the values of attributes based on the 1st index.
				 */
				for (int f = 0; f < currentChannel.getNoF(); f ++) {
					if ((currentChannel.getArrayOfFollowers()[f] instanceof Monitor)) {
						
						for (int l = 0; l < currentChannel.getNOMR(); l ++) {
							if (this == currentChannel.getArrayOfLinkedMonitors()[l][0]) {
								this.numView = ((Monitor) currentChannel.getArrayOfLinkedMonitors()[l][1]).getNumView();
								this.maxViewSoFar = ((Monitor) currentChannel.getArrayOfLinkedMonitors()[l][1]).getMaxView();
								this.totalSorFar = ((Monitor) currentChannel.getArrayOfLinkedMonitors()[l][1]).getTotalSoFar();
							}
						}
					}			
				}

				if (this.numView == 0 || !currentChannel.watched()) {
					seqChannels += currentChannel.getChannelName();
					if (i < this.noC - 1) {
						seqChannels += ", ";
					}
				}
				else {
					seqChannels += currentChannel.getChannelName();
					seqChannels += " {#views: " 
							+ this.numView
							+ ", max watch time: " + this.maxViewSoFar
							+ ", avg watch time: " + String.format("%.2f", this.totalSorFar / this.numView) + "}";
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

	public void incrementView() {
		this.numView ++;
	}

	public void setMaxViewSoFar(int view) {
		this.totalSorFar += view;
		if (this.maxViewSoFar < view) {
			this.maxViewSoFar = view;
		}
	}

	public int getNumView() {
		return this.numView;
	}

	public double getTotalSoFar() {
		return this.totalSorFar;
	}

	public int getMaxView() {
		return this.maxViewSoFar;
	}
}