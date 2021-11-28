package model;

public class Follower {
	
	protected String name;
	
	protected Channel[] arrayOfChannels;
	protected int noC;
	
	public void addChannel(Channel c) {
		this.arrayOfChannels[this.noC] = c;
		this.noC ++;
	}
	
	public void addVideo(String v) {}
	
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
}