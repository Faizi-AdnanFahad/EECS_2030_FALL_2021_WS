package model;

public class Channel {

	private String nameChannel;
	private int maxFollower;
	private int maxVid;

	private Follower[] arrayOfFollowers;
	private int noF;

	private String[] arrayOfVideo;
	private int noV;

	private double[] monitorData;  /* {NumberOfViews, TotalWatchTime, AverageWatchTime} */
	private int totalTimeWatched;

	public Channel(String nameChannel, int maxFollower, int maxVid) {
		this.nameChannel = nameChannel;
		this.maxFollower = maxFollower;
		this.maxVid = maxVid;
		
		this.arrayOfVideo = new String[maxVid];
		this.noV = 0;

		this.arrayOfFollowers = new Follower[maxFollower];
		this.noF = 0;
		this.monitorData = new double[3];
	}
	
//	public Channel(Channel c) {
//		this(c.nameChannel, c.maxFollower, c.maxVid);
//		for (int i = 0; i < c.noF; i ++) {
//			c.arrayOfFollowers[i] = this.arrayOfFollowers[i];
//		}
//	}

	public void releaseANewVideo(String videoName) {
		this.arrayOfVideo[this.noV] = videoName;
		this.noV ++;

		for (int i = 0; i < this.noF; i ++) {
			if (this.arrayOfFollowers[i].getDT().equals("Subscriber")) {
				this.arrayOfFollowers[i].recommendVideo(videoName);
			}
		}
	}

	public void follow(Follower f) {
		this.arrayOfFollowers[this.noF] = f;
		this.noF ++;
		this.monitorData = new double[3];
		f.addChannel(this);
	}

	public void unfollow(Follower f) {
		for (int i = 0; i < this.noF; i ++) {
			if (this.arrayOfFollowers[i].name.equals(f.name)) {
				f.removeChannel(this);
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
			result = this.nameChannel + " released no videos and has no followers.";
		}
		else if (this.noV != 0 && this.noF == 0){
			result = this.nameChannel 
					+ " released " 
					+ this.getSequenceVideoReleased() 
					+ " and has no followers.";
		}
		else if (this.noF != 0 && this.noV == 0) {
			result = this.nameChannel + 
					" released no videos and is followed by " 
					+ this.getSequenceFollower() + ".";
		}
		else { // Both videos are released and followers are gained.		
			result = this.nameChannel 
					+ " released " 
					+ this.getSequenceVideoReleased() 
					+ " and is followed by " 
					+ this.getSequenceFollower() + ".";
		}
		return result;
	}

	private String getSequenceFollower() {
		String followerSeq = "[";
		//			for (int i = 0; i < this.noF; i ++) { // instanceOf
		//				if (this.arrayOfFollowers[i].getClass().getSimpleName().equals("Subscriber")) {
		//					followerSeq += "Subscriber " + this.arrayOfFollowers[i].name;
		//					if (i < this.noF - 1) {
		//						followerSeq += ", ";
		//					}
		//				}
		//				else if (this.arrayOfFollowers[i].getClass().getSimpleName().equals("Monitor")) {
		//					followerSeq += "Monitor " + this.arrayOfFollowers[i].name;
		//					if (i < this.noF - 1) {
		//						followerSeq += ", ";
		//					}
		//				}
		//			}
		for (int i = 0; i < this.noF; i ++) {
			if (this.arrayOfFollowers[i].getDT().equals("Subscriber")) {
				followerSeq += "Subscriber " + this.arrayOfFollowers[i].name;
				if (i < this.noF - 1) {
					followerSeq += ", ";
				}
			}
			else if (this.arrayOfFollowers[i].getDT().equals("Monitor")) {
				followerSeq += "Monitor " + this.arrayOfFollowers[i].name;
				if (i < this.noF - 1) {
					followerSeq += ", ";
				}
			}
		}
		followerSeq += "]";
		return followerSeq;
	}

	public String getSequenceVideoReleased() {
		String vidSeq = "<";
		for (int i = 0; i < this.noV; i ++) {
			vidSeq += this.arrayOfVideo[i];
			if (i < this.noV - 1) {
				vidSeq += ", ";
			}
		}
		vidSeq += ">";
		return vidSeq;
	}

	public String getChannelName() {
		return this.nameChannel;
	}

	public String[] getArrayOfVidReleased() {
		return this.arrayOfVideo;
	}

	public double[] getMonitorData() {
		return this.monitorData;
	}

	public int getNumberOfFollowers() {
		return this.noF;
	}
	
	public int getNumberVid() {
		return this.noV;
	}

	public Follower[] getArrayOfFollower() {
		return this.arrayOfFollowers;
	}

	public void TotalTimeWatched(int time) {
		this.totalTimeWatched += time;
	}

	public int getTotalTimeWatched() {
		return this.totalTimeWatched;
	}
}






















