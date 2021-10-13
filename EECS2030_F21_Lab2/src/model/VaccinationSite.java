package model;

public class VaccinationSite {
	
	private final int MAX_NUM_VAC_IN_A_SITE = 4;
	private final int MAX_NUM_OF_APPOINTS = 200;	
	
	private String nameOfTheSite;
	private int limitNumOfDosesFromAddedDistribution;
	
	private VaccineDistribution[] arrayOfVaccinationDistribution;
	private int noDist;
	private int accumulatedVaccineNumber;
	
	private HealthRecord[] arrayOfVaccinationAppointments;
	private int noAppointments;	
	private String appointmentStatus;
	
	
	public VaccinationSite(String nameOfTheSite, int limitNumOfDosesFromAddedDistribution) {
		this.nameOfTheSite = nameOfTheSite;
		this.limitNumOfDosesFromAddedDistribution = limitNumOfDosesFromAddedDistribution;
		this.arrayOfVaccinationDistribution = new VaccineDistribution[MAX_NUM_VAC_IN_A_SITE];
		this.arrayOfVaccinationAppointments = new HealthRecord[MAX_NUM_OF_APPOINTS];
	}
	
	public int getNumberOfAvailableDoses() {
		return this.accumulatedVaccineNumber;
	}
	
	public int getNumberOfAvailableDoses(String vaccineCodeName) {
		int result = 0;
		for (int i = 0; i < this.noDist; i ++) {
			VaccineDistribution vd = this.arrayOfVaccinationDistribution[i];
			if (vd.getVaccine().getCodeNameVaccine().equals(vaccineCodeName)) {
				result = vd.getSupplyNum();
			}
		}
		return result;
	}
	
	public void addDistribution(Vaccine vaccine, int supplyNum) throws UnrecognizedVaccineCodeNameException, TooMuchDistributionException {
		if (vaccine.isVaccineRecognized() && (supplyNum <= this.limitNumOfDosesFromAddedDistribution - this.accumulatedVaccineNumber)) {
			// Check to see if the vaccine is already included in the array before adding it as a new distribution
			boolean found = false;
			for (int i = 0; !found && i < this.noDist; i ++) {
				if (this.arrayOfVaccinationDistribution[i].getVaccine().getCodeNameVaccine().equals(vaccine.getCodeNameVaccine())) {
					this.arrayOfVaccinationDistribution[i].addSupply(supplyNum);
					found = true;
				}
			}
			if (!found) {
				this.arrayOfVaccinationDistribution[this.noDist] = new VaccineDistribution(vaccine, supplyNum);
				this.noDist ++;
			}
			
			this.accumulatedVaccineNumber += supplyNum;
		}
		else if (!vaccine.isVaccineRecognized()) {
			throw new UnrecognizedVaccineCodeNameException("Unexpected exception thrown");
		}
		else if ((supplyNum > this.limitNumOfDosesFromAddedDistribution - this.accumulatedVaccineNumber)) {
			throw new TooMuchDistributionException("Unexpected exception thrown");
		}
	}
	
	public void bookAppointment(HealthRecord healthRecord) {
		if (this.noAppointments < this.getNumberOfAvailableDoses()) {
			this.arrayOfVaccinationAppointments[this.noAppointments] = healthRecord;
			this.noAppointments ++;
		}
	}
	
	public void administer(String dateOfVaccination) {
		
	}
	
	public String toString() {
		String result = "";
		String seq = "<";
		for (int i = 0; i < this.noDist; i ++) {
			if (i < this.noDist - 1) {
				seq += this.arrayOfVaccinationDistribution[i].getSupplyNum() + " doses of " + this.arrayOfVaccinationDistribution[i].getVaccine().getManufacturerVaccine() + ", ";
			}
			else {
				seq += this.arrayOfVaccinationDistribution[i].getSupplyNum() + " doses of " + this.arrayOfVaccinationDistribution[i].getVaccine().getManufacturerVaccine();
			}
		}
		seq += ">";
		result = this.nameOfTheSite + " has " + this.accumulatedVaccineNumber + " available doses: " + seq;

		return result;
	}
	
	
	
}

























