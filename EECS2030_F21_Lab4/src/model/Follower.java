package model;

public class Follower {
	
	protected String name;
	
	protected Channel[] arrayOfChannels;
	protected int noC;
	
	protected Channel cForMonitor;
	
	protected String releasedVideo;
		
	public Follower() {
		this.cForMonitor = null;
	}
 
	public String toString() {
		return null;
	}
	
	public String getDT() {
		/*
		 * Used for the method toString in Channel class.
		 */
		return null;
	}
	
	public void addChannel(Channel c) {
	}
	
	public void removeChannel(Channel c) {
	}
	
	public void recommendVideo(String videoName) {
	}
	
	public Channel[] getChannel() {
		return null;
	}
	
	public int getNOC() {
		return 0;
	}
	
}