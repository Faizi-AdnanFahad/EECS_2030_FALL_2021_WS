package model;

public class Channel {

	private String channelName;

	private String[] arrayOfReleasedVid;
	private int noV; // Number of Videos released

	private Follower[] arrayOfFollowers;
	private int noF; // Number of Followers
	
	private boolean watched;
	
	private Follower[][] arrayOfLinkedMonitors; // To store all the context objects (Monitor) -> 2d array is used where the first array would be the context object and the second array would be the newly created monitor. Crusial for Monitor class.
	private int noMR; // Number of Monitors ROWS

	
	public Channel(String channelName, int maxFollower, int maxVid) {
		this.channelName = channelName;
		this.arrayOfReleasedVid = new String[maxVid];
		this.noV = 0;
		this.arrayOfFollowers = new Follower[maxFollower];
		this.noF = 0;
		
		this.arrayOfLinkedMonitors = new Follower[500][2];
	}

	public void releaseANewVideo(String videoName) {
		this.arrayOfReleasedVid[this.noV] = videoName;
		this.noV ++;

		for (int i = 0; i < this.noF; i ++) {
			if (this.arrayOfFollowers[i] instanceof Subscriber) {
				((Subscriber) this.arrayOfFollowers[i]).recommendVideo(videoName);
			}
		}
	}

	public void follow(Follower f) {
		if (f instanceof Subscriber) {
			this.arrayOfFollowers[this.noF] = f;
			this.noF ++;
			((Subscriber) f).addChannel(this);
		}
		else if (f instanceof Monitor) {
			this.arrayOfFollowers[this.noF] = new Monitor((Monitor) f);
			/***************/
			this.arrayOfLinkedMonitors[this.noMR][0] = f;
			this.arrayOfLinkedMonitors[this.noMR][1] = this.arrayOfFollowers[this.noF];  
			this.noMR ++;
			/***************/
			this.noF ++;
			((Monitor) f).addChannel(this);
		}
	}

	public void unfollow(Follower f) {
		for (int i = 0; i < this.noF; i ++) {
			if (this.arrayOfFollowers[i].name.equals(f.name)) {
				if (f instanceof Subscriber) {
					((Subscriber) f).removeChannel(this);
				}
				else if (f instanceof Monitor) {
					((Monitor) f).removeChannel(this);
				}
				
				if (i == this.noF - 1) {
					this.arrayOfFollowers[i] = null;
				}
				else {
					this.arrayOfFollowers[i] = null;
					this.arrayOfFollowers[i] = this.arrayOfFollowers[i + 1];
				}
				this.noF -= 1;
			}
		}
	}


	@Override
	public String toString() {
		String result = "";
		if (this.noV == 0 && this.noF == 0) { // No video and no Followers
			result = this.channelName + " released no videos and has no followers.";
		}
		else if (this.noV != 0 && this.noF == 0){ // No followers and videos released
			result = this.channelName 
					+ " released " 
					+ this.getSequenceVideoReleased() 
					+ " and has no followers.";
		}
		else if (this.noF != 0 && this.noV == 0) { // No videos released and not followers
			result = this.channelName + 
					" released no videos and is followed by " 
					+ this.getSequenceFollower() + ".";
		}
		else { // Both videos are released and followers are gained.		
			result = this.channelName 
					+ " released " 
					+ this.getSequenceVideoReleased() 
					+ " and is followed by " 
					+ this.getSequenceFollower() + ".";
		}
		return result;
	}

	// Helper Method
	private String getSequenceVideoReleased() {
		String vidSeq = "<";
		for (int i = 0; i < this.noV; i ++) {
			vidSeq += this.arrayOfReleasedVid[i];
			if (i < this.noV - 1) {
				vidSeq += ", ";
			}
		}
		vidSeq += ">";
		return vidSeq;
	}

	private String getSequenceFollower() {
		/*
		 * Helper method that generates the sequence of followers based on the array of followers.
		 */
		String followerSeq = "[";
		for (int i = 0; i < this.noF; i ++) {
			if (this.arrayOfFollowers[i] instanceof Subscriber) {
				followerSeq += "Subscriber " + this.arrayOfFollowers[i].name;
				if (i < this.noF - 1) {
					followerSeq += ", ";
				}
			}
			else if (this.arrayOfFollowers[i] instanceof Monitor) {
				followerSeq += "Monitor " + this.arrayOfFollowers[i].name;
				if (i < this.noF - 1) {
					followerSeq += ", ";
				}
			}
		}
		followerSeq += "]";
		return followerSeq;
	}

	// Getters
	public String getChannelName() {
		return this.channelName;
	}

	public String[] getArrayOfReleasedVid() {
		return this.arrayOfReleasedVid;
	}

	public int getNoV() {
		return this.noV;
	}

	public Follower[] getArrayOfFollowers() {
		return this.arrayOfFollowers;
	}

	public int getNoF() {
		return this.noF;
	}
	
	public void watched(boolean watched) {
		this.watched = watched;
	}
	
	public boolean watched() {
		return this.watched;
	}
	
	public Follower[][] getArrayOfLinkedMonitors() {
		return this.arrayOfLinkedMonitors;
	}
	
	public int getNOMR() {
		return this.noMR;
	}
}