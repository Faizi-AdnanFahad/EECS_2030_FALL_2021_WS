package model;

public class Follower {
	
	protected String name;
	protected Channel[] arrayOfChannel;
	protected int noC;
	
	public Follower(String name, int maxChannel) {
		this.name = name;
		this.arrayOfChannel = new Channel[maxChannel];
	}
	
	public void addChannel(Channel c) {
		this.arrayOfChannel[this.noC] = c;
		this.noC ++;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void unfollowChannel(Channel c) {
		int index = -1;
		for (int i = 0; i < this.noC; i ++) {
			if (this.arrayOfChannel[i].getChannelName().equals(c.getChannelName())) {
				this.arrayOfChannel[i] = null;
				index = i;
			}
		}
		
		if (index != -1) {
			for (int i = index; i < this.noC; i ++) {
				if (i < this.noC - 1) {
					this.arrayOfChannel[i] = this.arrayOfChannel[i + 1];
				}
				else if (i == this.noC) {
					this.arrayOfChannel[i] = null;
				}
			}
			this.noC -= 1;
		}
	}
	
	protected String getChannelArray() {
		String seq = "[";
		for (int i = 0; i < this.noC; i ++) {
			seq += this.arrayOfChannel[i].getChannelName();
			if (i < this.noC - 1) {
				seq += ", ";
			}
		}
		seq += "]";
		return seq;
	}
}


















