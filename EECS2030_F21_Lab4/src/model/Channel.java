package model;

public class Channel {
	
	private String nameChannel;
	
	private Follower[] arrayOfFollowers;
	private int noF;
	
	private String[] arrayOfVideo;
	private int noV;
	
	
	public Channel(String nameChannel, int maxFollower, int maxVid) {
		this.nameChannel = nameChannel;
		this.arrayOfVideo = new String[maxVid];
		this.noV = 0;
		
		this.arrayOfFollowers = new Follower[maxFollower];
		this.noF = 0;
	}
	
	public void releaseANewVideo(String videoName) {
		this.arrayOfVideo[this.noV] = videoName;
		this.noV ++;
	}
	
	public void follow(Follower f) {
		this.arrayOfFollowers[this.noF] = f;
		this.noF ++;
		
		// Adding channels to the list of followers
		f.addChannel(nameChannel);
	}
	
	public void unfollow(Follower f) {
		
	}
	
	@Override
	public String toString() {
		String result = "";
		if (this.noV == 0 && this.noF == 0) {
			result = this.nameChannel + " released no videos and has no followers.";
		}
		else if (this.noV != 0 && this.noF == 0){
			String vidSeq = "<";
			for (int i = 0; i < this.noV; i ++) {
				vidSeq += this.arrayOfVideo[i];
				if (i < this.noV - 1) {
					vidSeq += ", ";
				}
			}
			vidSeq += ">";
			result = this.nameChannel 
					+ " released " + vidSeq 
					+ " and has no followers.";
		}
		else if (this.noF != 0 && this.noV == 0) {
			String followerSeq = "[";
//			for (int i = 0; i < this.noF; i ++) {
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
			result = this.nameChannel + 
						" released no videos and is followed by " + followerSeq + ".";
		}
		return result;
	}
}























