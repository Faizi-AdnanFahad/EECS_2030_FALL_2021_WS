package model;

public class VaccineDistribution {
	
	private Vaccine vaccine;
	private int numOfDoses;
	
//	private Vaccine[] arrayOfvaccinationSite;
	private int noV;
	
	private String vaccinationSite;
	private String date; 
	
	
	public VaccineDistribution(Vaccine vaccine, int numOfDoses) {
		this.vaccine = vaccine;
		this.numOfDoses = numOfDoses;
		this.noV = 0;
	}
	
	public VaccineDistribution(Vaccine vaccine, String vaccinationSite, String date) {
//		this.arrayOfvaccinationSite = new Vaccine[limit];
		this.vaccine = vaccine;
		this.vaccinationSite = vaccinationSite;
		this.date = date;
	}
	
	public String toString() {
		return this.numOfDoses + " doses of " 
				+ this.vaccine.getCodeName() + " by " + this.vaccine.getManufuctuer();
	}
	
	public Vaccine getVaccine() {
		return this.vaccine;
	}
	
	public String getVaccineSite() {
		return this.vaccinationSite;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public int getNumDoses() {
		return this.numOfDoses;
	}
	
	public void addDoses(int n) {
		this.numOfDoses += n;
	}
}
