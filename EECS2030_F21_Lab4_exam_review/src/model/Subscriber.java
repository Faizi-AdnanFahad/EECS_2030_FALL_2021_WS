package model;

public class Subscriber extends Follower {
		
	private String[] arrayOfVideo;
	private int noV;
	
	public Subscriber(String name, int maxChannel, int maxRecVideo) {
		super(name, maxChannel);
		this.arrayOfVideo = new String[maxRecVideo];
	}
	
	public void recommendVideo(String video) {
		this.arrayOfVideo[this.noV] = video;
		this.noV ++;
	}
	
	public void watch(String videoName, int minutes) {
		Channel watchedChannel = null; // the channel watched for at least one minutes
		for (int i = 0; i < this.noC; i ++) {
			for (int m = 0; m < this.arrayOfChannel[i].getNoV(); m ++) {
				if (this.arrayOfChannel[i].getArrayOfVideo()[m].equals(videoName)) {
					watchedChannel = this.arrayOfChannel[i];
					break;
				}
			}
		}
		
		for (int i = 0; i < watchedChannel.getNoF(); i ++) {
			if (watchedChannel.getArrayOfFollower()[i] instanceof Monitor) {
				((Monitor) watchedChannel.getArrayOfFollower()[i]).addStat(watchedChannel.getChannelName(), minutes);
			}
		}
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
		
		if (this.noC == 0 && this.noV == 0) {
			result = "Subscriber " + this.name
					+" follows no channels and has no recommended videos.";
		}
		else if (this.noC != 0 && this.noV == 0) {
			result = "Subscriber " + this.name
					+ " follows " + this.getChannelArray() + " and has no recommended videos.";
		}
		else if (this.noC == 0 && this.noV != 0) {
			
		}
		else if (this.noC != 0 && this.noV != 0) {
			result = "Subscriber " + this.name
					+ " follows " + this.getChannelArray() + " and is recommended " + seq  + ".";
		}
		
		
		return result;
	}
}












