package model;

public class Channel {
	
	private String channelName;
	
	private String[] arrayOfVideos;
	private int noV; // number of videos
	
	private Follower[] arrayOfFollower;
	private int noF; // number of followers
	
	public Channel(String channelName, int maxFollower, int maxVid) {
		this.channelName = channelName;
		
		this.arrayOfVideos = new String[maxVid];
		this.arrayOfFollower = new Follower[maxFollower];
	}
	
	public void releaseANewVideo(String videoName) {
		this.arrayOfVideos[this.noV] = videoName;
		this.noV ++;
		
		for (int i = 0; i < this.noF; i ++) {
			if (this.arrayOfFollower[i] instanceof Subscriber) {
				this.arrayOfFollower[i].addVideo(videoName);
			}
		}
	}
	
	public void follow(Follower f) {
		this.arrayOfFollower[this.noF] = f;
		this.noF ++;
		
		f.addChannel(this);
	}
	
	public void unfollow(Follower f) {
		boolean stay = true;
		for (int i = 0; stay && i < this.noF; i ++) {
			if (this.arrayOfFollower[i].name.equals(f.name)) {
				if (i < this.noF - 1) {
					this.arrayOfFollower[i] = this.arrayOfFollower[i + 1];
					this.noF -= 1;
					stay = false;
				}
				else if (i == this.noF - 1) {
					this.arrayOfFollower[i] = null;
					this.noF -= 1;
					stay = false;
				}
			}
		}
		
		f.unfollow(this);
	}	
	
	public String toString() {
		String result = "";
		
		if (this.noV == 0 && this.noF == 0) {
			result = this.channelName + " released no videos and has no followers.";
		}
		else if (this.noV != 0 && this.noF == 0) {
			result = this.channelName + 
					" released " + this.vidSeqGenerator() + " and has no followers.";
		}
		else if (this.noF != 0 && this.noV == 0) {
			result = this.channelName + 
					" released no videos and is followed by " + this.seqFollowerGenerator() + ".";
		}
		else if (this.noF != 0 && this.noV != 0) {
			result = this.channelName + 
					" released " + this.vidSeqGenerator() 
						+ " and is followed by " + this.seqFollowerGenerator() + ".";
		}
		return result;
	}
	
	// Getters
	public String getChannelName() {
		return this.channelName;
	}
	
	public Follower[] getArrayOfFollowers() {
		return this.arrayOfFollower;
	}
	
	public int getNOF() {
		return this.noF;
	}
	
	public String[] getArrayOfVideos() {
		return this.arrayOfVideos;
	}
	
	public int getNOV() {
		return this.noV;
	}
	
	// Helper methods
	public String vidSeqGenerator() {
		String seqVid = "<";
		for (int i = 0; i < this.noV; i ++) {
			seqVid += this.arrayOfVideos[i];
			
			if (i < this.noV - 1) {
				seqVid += ", ";
			}
		}
		seqVid += ">";
		return seqVid;
	}
	
	public String seqFollowerGenerator() {
		String seq = "[";
		for (int i = 0; i < this.noF; i ++) {
			if (this.arrayOfFollower[i] instanceof Monitor) {
				seq += "Monitor ";
			}
			else if (this.arrayOfFollower[i] instanceof Subscriber) {
				seq += "Subscriber ";
			}
			
			seq += this.arrayOfFollower[i].name;
			
			if (i < this.noF - 1) {
				seq += ", ";
			}
		}
		seq += "]";
		return seq;
	}
}