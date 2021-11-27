package model;

public class Channel {
	
	private String channelName;
	
	private String[] arrayOfVideos;
	private int noV;
	
	private Follower[] arrayOfFollower;
	private int noF;
	
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
		
		
//		if (f instanceof Monitor) {
//			Follower newF = new Monitor(f.name, ((Monitor) f).getMaxChannel() );
//			this.arrayOfFollower[this.noF] = newF;
//			this.noF ++;
//		}
//		else if (f instanceof Subscriber) {
//			this.arrayOfFollower[this.noF] = f;
//			this.noF ++;
//		}
		
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
			String seq = "<";
			for (int i = 0; i < this.noV; i ++) {
				seq += this.arrayOfVideos[i];
				
				if (i < this.noV - 1) {
					seq += ", ";
				}
			}
			seq += ">";
			result = this.channelName + 
					" released " + seq + " and has no followers.";
		}
		else if (this.noF != 0 && this.noV == 0) {
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
			result = this.channelName + 
					" released no videos and is followed by " + seq + ".";
		}
		else if (this.noF != 0 && this.noV != 0) {
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
			
			String seqVid = "<";
			for (int i = 0; i < this.noV; i ++) {
				seqVid += this.arrayOfVideos[i];
				
				if (i < this.noV - 1) {
					seqVid += ", ";
				}
			}
			seqVid += ">";
			
			result = this.channelName + 
					" released " + seqVid 
						+ " and is followed by " + seq + ".";
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
}


















