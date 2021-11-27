package model;

public class Follower {
	protected String name;
	protected Channel[] listOfChannels;
	protected int noC;
	protected String type;
	
	public void follow(Channel x) {
		listOfChannels[noC] = x;
		noC++;
	}
	
	public void unfollow(Channel x) {
		int temp = -1;
		for (int i =0;i<noC;i++) {
			if (listOfChannels[i].equals(x)) temp = i;
		}
		if (temp!=-1) {
			for (int i=temp;i<noC-1;i++) {
				listOfChannels[i] =listOfChannels[i+1];
			}
			noC--;
		}
	}
	
}
