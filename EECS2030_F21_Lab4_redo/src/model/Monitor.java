package model;

public class Monitor extends Follower {

	private Channel[] arrayOfChannels;
	private int noC;
	
	private int maxChannel;
	
	// Data attributes
	private int numOfViews;
	private double maxViews;

	public Monitor(String name, int maxChannel) {
		this.name = name;
		this.maxChannel = maxChannel;
		this.arrayOfChannels = new Channel[maxChannel];
	}
	
	public Monitor(Monitor m) {
		
	}

	public void addChannel(Channel c) {
		this.arrayOfChannels[this.noC] = c;
		this.noC ++;
	}

	public String toString() {
		String result = "";

		if (this.noC == 0) {
			result = "Monitor " + this.name + " follows no channels.";
		}
		else {
			String seq = "[";
			for (int i = 0; i < this.noC; i ++) {

				seq += this.arrayOfChannels[i].getChannelName();

				if (this.numOfViews != 0 ) {
					seq += " {#views: " + this.numOfViews
							+ ", max watch time: " + (int) this.maxViews + ", avg watch time: " 
							+ String.format("%.2f", this.maxViews / this.numOfViews) + "}";
				}

				if (i < this.noC - 1) {
					seq += ", ";
				}
			}
			seq += "]";

			//////////////

			result = "Monitor " + this.name + " follows " + seq + ".";
		}
		return result;
	}

	public void unfollow(Channel c) {
		boolean stay = true;
		for (int i = 0; stay && i < this.noC; i ++) {
			if (this.arrayOfChannels[i].getChannelName().equals(c.getChannelName())) {
				if (i < this.noC - 1) {
					this.arrayOfChannels[i] = this.arrayOfChannels[i + 1];
					this.noC -= 1;
					stay = false;
				}
				else if (i == this.noC - 1) {
					this.arrayOfChannels[i] = null;
					this.noC -= 1;
					stay = false;
				}
			}
		}
	}

	public void incrementViews() {
		this.numOfViews ++;
	}

	public void setMaxView(double maxView) {
		this.maxViews = maxView;
	}

	public int getNumView() {
		return this.numOfViews;
	}
	
	public int getMaxChannel() {
		return this.maxChannel;
	}



















}
