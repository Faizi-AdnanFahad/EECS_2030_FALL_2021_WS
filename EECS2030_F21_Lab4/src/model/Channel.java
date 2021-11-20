package model;

public class Channel {

	private String channelName;

	private String[] arrayOfReleasedVid;
	private int noV;

	private Follower[] arrayOfFollowers;
	private int noF;
	
	private boolean watched;

	public Channel(String channelName, int maxFollower, int maxVid) {
		this.channelName = channelName;
		this.arrayOfReleasedVid = new String[maxVid];
		this.noV = 0;
		this.arrayOfFollowers = new Follower[maxFollower];
		this.noF = 0;
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
		this.arrayOfFollowers[this.noF] = f;
		this.noF ++;

		if (f instanceof Subscriber) {
			((Subscriber) f).addChannel(this);
		}
		else if (f instanceof Monitor) {
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
				this.arrayOfFollowers[i] = null;
				this.arrayOfFollowers[i] = this.arrayOfFollowers[i + 1];
				this.noF -= 1;
			}
		}
	}


	@Override
	public String toString() {
		String result = "";
		if (this.noV == 0 && this.noF == 0) {
			result = this.channelName + " released no videos and has no followers.";
		}
		else if (this.noV != 0 && this.noF == 0){
			result = this.channelName 
					+ " released " 
					+ this.getSequenceVideoReleased() 
					+ " and has no followers.";
		}
		else if (this.noF != 0 && this.noV == 0) {
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
		return arrayOfReleasedVid;
	}

	public int getNoV() {
		return noV;
	}

	public Follower[] getArrayOfFollowers() {
		return arrayOfFollowers;
	}

	public int getNoF() {
		return noF;
	}
	
	public void setWatched(boolean watched) {
		this.watched = watched;
	}

	public boolean getWatched() {
		return this.watched;
	}


















}
