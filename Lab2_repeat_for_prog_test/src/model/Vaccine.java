package model;

public class Vaccine {
	
	private String codeName;
	private String type;
	private String manufactuer;
	private boolean recognizedVaccine;
	private final String[] listOfRecognizedVaccines = {"mRNA-1273", "BNT162b2", "Ad26.COV2.S", "AZD1222"};
	
	public Vaccine(String codeName, String type, String manufacturer) {
		this.codeName = codeName;
		this.type = type;
		this.manufactuer = manufacturer;
		this.recognizedVaccine = false;
		for (int i = 0; !this.recognizedVaccine && i < listOfRecognizedVaccines.length; i ++) {
			this.recognizedVaccine = listOfRecognizedVaccines[i].equals(codeName);
		}
	}
	
	
	public String toString() {
		String result = "";
		if (this.recognizedVaccine) {
			result = "Recognized vaccine: " + this.codeName + " (" + this.type + "; " + this.manufactuer + ")";
		}
		else {
			result = "Unrecognized vaccine: " + this.codeName + " (" + this.type + "; " + this.manufactuer + ")";
		}
		return result;
	}
	
	public String getVaccineType() {
		return this.type;
	}
	
	public String getCodeName() {
		return this.codeName;
	}
	
	public String getManufuctuer() {
		return this.manufactuer;
	}
	
	public String getIsRecognized() {
		if (this.recognizedVaccine) {
			return "Recognized vaccine";
		}
		else {
			return "Unrecognized vaccine";
		}
	}
}

















