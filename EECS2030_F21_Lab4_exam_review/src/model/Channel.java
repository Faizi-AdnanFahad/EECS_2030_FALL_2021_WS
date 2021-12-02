package model;

public class Channel {

	private String channelName;

	private Follower[] arrayOfFollower;
	private int noF;

	private String[] arrayOfVideo;
	private int noV;

	public Channel(String channelName, int maxFollower, int maxRelVideo) {
		this.channelName = channelName;
		this.arrayOfVideo = new String[maxRelVideo];
		this.arrayOfFollower = new Follower[maxFollower];
	}

	public void releaseANewVideo(String video) {
		this.arrayOfVideo[this.noV] = video;
		this.noV ++;
		
		for (int i = 0; i < this.noF; i ++) {
			if (this.arrayOfFollower[i] instanceof Subscriber) {
				((Subscriber) this.arrayOfFollower[i]).recommendVideo(video);
			}
		}
	}

	public void follow(Follower f) {
		this.arrayOfFollower[this.noF] = f;
		this.noF ++;

		f.addChannel(this);
	}

	public void unfollow(Follower f) {
		int index = -1;
		for (int i = 0; i < this.noF; i ++) {
			if (this.arrayOfFollower[i].getName().equals(f.getName())) {
				this.arrayOfFollower[i] = null;
				index = i;
			}
		}
		
		if (index != -1) {
			for (int i = index; i < this.noF; i ++) {
				if (i < this.noF - 1) {
					this.arrayOfFollower[i] = this.arrayOfFollower[i + 1];
				}
				else if (i == this.noF) {
					this.arrayOfFollower[i] = null;
				}
			}
			this.noF -= 1;
		}
		
		f.unfollowChannel(this);
	}

	public String toString() {
		String result = "";

		String seq = "<";
		for (int i = 0; i < this.noV; i ++) {
			seq += this.arrayOfVideo[i];
			if (i < this.noV - 1) {
				seq += ", ";
			}
		}
		seq += ">";

		String seqFollower = "[";
		for (int i = 0; i < this.noF; i ++) {
			if (this.arrayOfFollower[i] instanceof Subscriber) {
				seqFollower += "Subscriber " + this.arrayOfFollower[i].getName();
				if (i < this.noF - 1) {
					seqFollower += ", ";
				}
			}
			else if (this.arrayOfFollower[i] instanceof Monitor) {
				seqFollower += "Monitor " + this.arrayOfFollower[i].getName();
				if (i < this.noF - 1) {
					seqFollower += ", ";
				}
			}
		}
		seqFollower += "]";

		if (this.noV == 0 && this.noF == 0) {
			result =  this.channelName + " released no videos and has no followers.";
		}
		else if (this.noV != 0 && this.noF == 0) {
			result = this.channelName + " released " + seq + " and has no followers.";
		}
		else if (this.noV == 0 && this.noF != 0) {
			result = this.channelName + " released no videos and is followed by " + seqFollower + ".";
		}
		else if (this.noV != 0 && this.noF != 0) {
			result = this.channelName + " released " + seq + " and is followed by " + seqFollower + ".";
		}

		return result;
	}

	public String getChannelName() {
		return this.channelName;
	}
	
	public Follower[] getArrayOfFollower() {
		return arrayOfFollower;
	}

	public int getNoF() {
		return noF;
	}

	public String[] getArrayOfVideo() {
		return arrayOfVideo;
	}

	public int getNoV() {
		return noV;
	}
}






















