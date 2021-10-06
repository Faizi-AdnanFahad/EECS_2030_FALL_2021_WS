package model;

public class Zone {
	
	private static int id = 23;
	private int nonStaticId;
	
	private MovieRecord[] arrayOfMovieRecords;
	private int noMR;
	
	private int numOfDvds;
	private String errorStatus;
	private boolean errorExist;
	
	public Zone(int numOfDvds) {
		this.arrayOfMovieRecords = new MovieRecord[numOfDvds];
		this.nonStaticId = Zone.id;
		Zone.id += 11;
		
		this.numOfDvds = numOfDvds;
	}
	
	public MovieRecord[] getArrayOfMovieRecord() {
		return this.arrayOfMovieRecords;
	}
	
	public int getNOMR() {
		return this.noMR;
	}
	
	public String getID() {
		return "Zone-" + this.nonStaticId;
	}
	
	public int maxgetNumDvds() {
		return this.numOfDvds;
	}
	
	public int getNumberOfMovieRecords() {
		
		return this.noMR;
	}
	
	public int getNumberOfMovieDVDs() {
		int sum = 0;
		for (int i = 0; i < this.noMR; i ++) {
			sum += this.arrayOfMovieRecords[i].getNumberOfDVDs();
		}
		return sum;
	}
	
	public String getStatus() {
		String result = "";
		String list = "{";
		
		if (this.errorExist) {
			result = this.errorStatus;
		}
		else {
			for (int i = 0; i < this.noMR; i ++) {
				if (i == this.noMR - 1) {
					list += this.arrayOfMovieRecords[i].getName() 
							+ " (" + this.arrayOfMovieRecords[i].getNumberOfDVDs() + ")";
				}
				else {
					list += this.arrayOfMovieRecords[i].getName() + " (" 
							+ this.arrayOfMovieRecords[i].getNumberOfDVDs() + "), ";
				}
			}
			list += "}";
			result = this.getNumberOfMovieRecords() + " records and " 
					+  this.getNumberOfMovieDVDs() + " DVDs: " + list;
		}
		
		return result;
	}
	
	public void addMovieRecord(MovieRecord mv) {
		this.errorExist = false;
		
		if ((this.numOfDvds - this.getNumberOfMovieDVDs()) == 0) {
			this.errorExist = true;
			this.errorStatus = "Error: maximum number of movie DVDs (" 
					+ this.numOfDvds + ") reached";
		}
		else if ((this.numOfDvds - this.getNumberOfMovieDVDs()) < mv.getNumberOfDVDs()) {
			this.errorExist = true;
			this.errorStatus = "Error: insufficient space left in the zone (" 
					+ (mv.getNumberOfDVDs() - (this.numOfDvds - this.getNumberOfMovieDVDs())) + " DVDs short)";
		}
		else {
			boolean found = false;
			for (int i = 0; i < this.noMR; i ++) {
				if (this.arrayOfMovieRecords[i].getName().equals(mv.getName())) {
					this.arrayOfMovieRecords[i].addNumberOfDvds(mv.getNumberOfDVDs());
					found = true;
				}
			}
			
			if (!found) {
				this.arrayOfMovieRecords[this.noMR] = mv;
				this.noMR ++;
			}	
		}
	}
}