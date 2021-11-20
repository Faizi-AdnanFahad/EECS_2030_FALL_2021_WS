package model;

public class Monitor extends Follower {
	
	int numView = 0;
	int maxViewSoFar;
	double averageView;
	int temp;
	double totalSorFar;
	
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
				if (!this.arrayOfChannels[i].getWatched()) {
					seqChannels += this.arrayOfChannels[i].getChannelName();
					if (i < this.noC - 1) {
						seqChannels += ", ";
					}
				}
				else {
					seqChannels += this.arrayOfChannels[i].getChannelName();
					seqChannels += " {#views: " 
							+ this.numView
									+ ", max watch time: " + this.maxViewSoFar
											+ ", avg watch time: " + String.format("%.2f", ((double) this.totalSorFar / this.numView)) + "}";
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
	
	// Setters
	public void incrementView() {
		this.numView ++;
	}
	
	public void setMaxViewSoFar(int view) {
		this.totalSorFar += view;
		if (this.maxViewSoFar < view) {
			this.maxViewSoFar = view;
		}
	}
	
	public void watched(boolean watched) {
		this.watched = watched;
	}
	
	public void reset() {
		this.numView = 0;
		this.totalSorFar = 0;
		this.maxViewSoFar = 0;
		this.resetCalled = true;
	}
}
