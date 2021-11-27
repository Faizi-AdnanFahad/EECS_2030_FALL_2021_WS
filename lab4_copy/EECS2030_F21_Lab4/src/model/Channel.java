package model;

public class Channel {
	private String name;
	private Follower[] listOfF;
	private String[] listOfVideos;
	private int nof;
	private int nov;

	public Channel(String string, int i, int j) {
		// TODO Auto-generated constructor stub
		name = string;
		listOfF = new Follower[i];
		listOfVideos = new String[j];
	}

	public void releaseANewVideo(String string) {
		// TODO Auto-generated method stub
		getListOfVideos()[getNov()] = string;
		nov = getNov() + 1;
		for(int i =0;i<getNof();i++) {
			if (getListOfF()[i].type.equals("Subscriber")) {
				Subscriber x = (Subscriber) getListOfF()[i];
				x.addRec(string);
			}
		}
	}
	
	public String toString() {
		String result = getName() + " released ";
		if (getNov()==0) result += "no videos and";
		else result += "<" + getVids() + "> and";
		if (getNof() == 0) result += " has no followers.";
		else result += " is followed by [" + getList() +"].";
		return result;
	}

	public void follow(Follower f1) {
		// TODO Auto-generated method stub
		getListOfF()[getNof()] = f1;
		nof = getNof() + 1;
		f1.follow(this);
	}

	public String getList() {
		String result = "";
		for (int i = 0; i < getNof(); i++) {
			result += getListOfF()[i].type + " " + getListOfF()[i].name;
			if ( i < getNof() - 1) result += ", ";
		}
	return result;	
	}
	
	public String getVids() {
		String result = "";
		for (int i = 0; i <getNov();i++) {
			result += getListOfVideos()[i];
			if (i <getNov()-1) result += ", ";
		}
		return result;
	}

	public void unfollow(Follower f2) {
		// TODO Auto-generated method stub
		int temp = -1;
		for (int i = 0; i < getNof(); i ++) {
			if (getListOfF()[i].equals(f2)) temp = i;
		}
		if (temp != -1) {
			getListOfF()[temp].unfollow(this);
			for (int i = temp; i < getNof() - 1; i++) {
				getListOfF()[i] = getListOfF()[i+1];
			}
			nof = getNof() - 1;
		}
	}

	public String getName() {
		return name;
	}

	public int getNov() {
		return nov;
	}

	public String[] getListOfVideos() {
		return listOfVideos;
	}

	public Follower[] getListOfF() {
		return listOfF;
	}

	public int getNof() {
		return nof;
	}
	
}
