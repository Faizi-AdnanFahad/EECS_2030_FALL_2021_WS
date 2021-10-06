package model;

public class Store {
	
	private Zone[] arrayOfZones;
	private int noz;
	
	public Store() {
		this.arrayOfZones = new Zone[100];
	}
	
	public int[] getStats(String movieName) {
		int totalNumOfMovieRecords = 0;
		int totalNumMovieDvds = 0;
		for (int i = 0; i < this.noz; i ++) {
			for (int m = 0; m < this.arrayOfZones[i].getNOMR(); m ++) {
				if (this.arrayOfZones[i].getArrayOfMovieRecord()[m].getName().equals(movieName)) {
					totalNumMovieDvds += this.arrayOfZones[i].getArrayOfMovieRecord()[m].getNumberOfDVDs();
					totalNumOfMovieRecords ++;
				}	
			}
			
		}
		
		int[] result = new int[2];
		result[0] = totalNumOfMovieRecords;
		result[1] = totalNumMovieDvds;
		return result;
	}
	
	public Zone[] getZones() {
		Zone[] tempZone = new Zone[this.noz];
		for (int i = 0; i < this.noz; i ++) {
			tempZone[i] = this.arrayOfZones[i];
		}
		return tempZone;
	}
	
	public Zone[] getZones(int num) { // ********************
		Zone[] zone = new Zone[this.noz];
		int count = 0;
		for (int i = 0; i < this.noz; i ++) {
			if (this.arrayOfZones[i].maxgetNumDvds() - this.arrayOfZones[i].getNumberOfMovieDVDs() <= num) {
				zone[i] = this.arrayOfZones[i];
				count ++;
			}
		}
		
		Zone[] result = new Zone[count];
		for (int i = 0; i < count; i ++) {
			result[i] = zone[i];
		}
		return result;
	}
	
	public void addZones(Zone[] zoneArray) {
		for (int i = 0; i < zoneArray.length; i ++) {
			this.arrayOfZones[this.noz] = zoneArray[i];
			this.noz ++;
		}
	}
}