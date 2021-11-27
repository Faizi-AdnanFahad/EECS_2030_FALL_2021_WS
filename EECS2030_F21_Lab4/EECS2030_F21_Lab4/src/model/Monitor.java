package model;

public class Monitor extends Follower {
	private int[] views;
	private int[] time;
	private int[] totalTime;
	
	public Monitor(String string, int i) {
		// TODO Auto-generated constructor stub
		name = string;
		this.listOfChannels = new Channel[i];
		views = new int[i];
		time = new int[i];
		totalTime = new int[i];
		type = "Monitor";

	}

	public String toString() {
		String result = "";
		if (noC == 0) result = "Monitor " + name + " follows no channels.";
		else {
			result += "Monitor " + name + " follows [";
			for (int i = 0;i<noC;i++) {
				result += listOfChannels[i].getName();
				if(views[i]>0) {
					double avg = (double) totalTime[i]/views[i];
					result += " {#views: " + views[i] + ", max watch time: " + time[i] + ", avg watch time: " + String.format("%.2f", avg) + "}";
				}
				if (i <noC-1) result += ", ";
			}
			result += "].";
		}
		return result;
	}
	
	//Monitor Stat Sensor A follows [Cafe Music BGM {#views: 1, max watch time: 40, avg watch time: 40.00}, I Love You Venice]."
	public void newWatch(int index, int time) {
		views[index] += 1;
		if (time > this.time[index]) this.time[index] = time;
		totalTime[index] += time;
	}

}
