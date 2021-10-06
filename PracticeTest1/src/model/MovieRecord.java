package model;

public class MovieRecord {
	
	private String movieName;
	private int numOfDvds;
	private Zone zoneLocation;
	private static int id = 1;
	private int nonStaticId;
	
	public MovieRecord(String movieName, int numOfDvds, Zone zoneLocation) {
		this.movieName = movieName;
		this.numOfDvds = numOfDvds;
		this.zoneLocation = zoneLocation;
		this.nonStaticId = MovieRecord.id;
		MovieRecord.id += 1;
	}
	
	public String getName() {
		return this.movieName;
	}
	
	public int getNumberOfDVDs() {
		return this.numOfDvds;
	}
	
	public Zone getZone() {
		return this.zoneLocation;
	}
	
	public void addNumberOfDvds(int moreDvds) {
		this.numOfDvds += moreDvds;
	}
	
	
	public String getID() {
		return this.zoneLocation.getID() + "-" + this.movieName + "-" + this.nonStaticId;
	}
}