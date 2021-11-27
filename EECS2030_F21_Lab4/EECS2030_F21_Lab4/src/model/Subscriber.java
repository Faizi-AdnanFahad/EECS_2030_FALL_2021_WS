package model;

public class Subscriber extends Follower {
	private String[] recVids;
	private int noR;

	public Subscriber(String string, int i, int j) {
		// TODO Auto-generated constructor stub
		recVids = new String[j];
		this.listOfChannels = new Channel[j];
		this.name = string;
		type = "Subscriber";
	}

	public String toString() {
		String result = "";
		if (noC == 0)
			result = "Subscriber " + name + " follows no channels and has no recommended videos.";
		else {
			result += "Subscriber " + name + " follows [";
			for (int i = 0; i < noC; i++) {
				result += listOfChannels[i].getName();
				if (i < noC - 1)
					result += ", ";
			}
			result += "]";
			if (noR == 0)
				result += " and has no recommended videos.";
			else
				result += " and is recommended <" + getRecs() + ">.";
		}
		return result;
	}

	public void addRec(String n) {
		recVids[noR] = n;
		noR++;
	}

	public String getRecs() {
		String result = "";
		for (int i = 0; i < noR; i++) {
			result += recVids[i];
			if (i < noR - 1)
				result += ", ";
		}
		return result;
	}

	public void watch(String string, int j) {
		// TODO Auto-generated method stub
		int temp = -1;
		Channel found = null;
		for(int i=0;i<noC;i++) {
			for(int k=0;k<listOfChannels[i].getNov();k++) {
				if (string.equals(listOfChannels[i].getListOfVideos()[k]))  {
					temp = i;
					found = listOfChannels[i];
					break;
				}
			}
		}
		if (temp != -1) {
			for(int i=0;i<listOfChannels[temp].getNof();i++) {
				if (listOfChannels[temp].getListOfF()[i].type.equals("Monitor")) {
					Monitor x = (Monitor) listOfChannels[temp].getListOfF()[i];
					for (int m=0;m<x.noC;m++) {
						if(x.listOfChannels[m].equals(found)) {
							x.newWatch(m, j);
						}
					}
				}
			}
		}
	
	}
}
