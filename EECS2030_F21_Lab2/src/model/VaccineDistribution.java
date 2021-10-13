package model;

public class VaccineDistribution {
	
	private Vaccine vaccine;
	private int numOfDoses;
	
	public VaccineDistribution(Vaccine vaccine, int numOfDoses) {
		this.vaccine = vaccine;
		this.numOfDoses = numOfDoses;
	}
	
	public String toString() {
		return this.numOfDoses + " doses of " + this.vaccine.getCodeNameVaccine() + " by " 
					+ this.vaccine.getManufacturerVaccine();
	}
	
}

































