package model;

public class VaccinationSite {
	
	private String vaccinationSite;
	private int dosesNumLimit;
	
	private VaccineDistribution[] arrayOfDistribution;
	private int noD;
	private int totalDosesAccumulated;
	
	private int noAppoint;
	
	public VaccinationSite(String vaccinationSite, int dosesNumLimit) {
		this.vaccinationSite = vaccinationSite;
		this.dosesNumLimit = dosesNumLimit;
		this.arrayOfDistribution = new VaccineDistribution[200];
	}
	
	public int getNumberOfAvailableDoses() {
		return this.totalDosesAccumulated;
	}
	
	public int getNumberOfAvailableDoses(String vaccineType) {
		int result = 0;
		for (int i = 0; i < this.noD; i ++) {
			if (this.arrayOfDistribution[i].getVaccine().getCodeName().equals(vaccineType)) {
				result = this.arrayOfDistribution[i].getNumDoses();
			}
		}
		return result;	
		}
	
	
	public void addDistribution(Vaccine vaccine, int numOfDoses) throws TooMuchDistributionException, UnrecognizedVaccineCodeNameException {
		if (vaccine.getIsRecognized().equals("Recognized vaccine")) {
			if (this.totalDosesAccumulated + numOfDoses <= dosesNumLimit) {
				boolean found = false;
				for (int i = 0; !found && i < this.noD; i ++) {
					if (this.arrayOfDistribution[i].getVaccine().getCodeName().equals(vaccine.getCodeName())) {
						this.arrayOfDistribution[i].addDoses(numOfDoses);
						found = true;
					}
				}
				
				if (!found) {
					this.arrayOfDistribution[this.noD] = new VaccineDistribution(vaccine, numOfDoses);
					this.noD ++;
				}
				this.totalDosesAccumulated += numOfDoses;
			}
			else {
				throw new TooMuchDistributionException("Excedding the limit!");
			}
		}
		else {
			throw new UnrecognizedVaccineCodeNameException("");
		}
		
		
	}
	
	public void bookAppointment(HealthRecord personHealthRecord) throws InsufficientVaccineDosesException {
		if (this.totalDosesAccumulated > this.noAppoint) {
			this.noAppoint ++;
			String success = "Last vaccination appointment for " + personHealthRecord.getName() + " with " + this.vaccinationSite + " succeeded";
			personHealthRecord.setAppointmentStatus(success);
		}
		else {
			String success = "Last vaccination appointment for " + personHealthRecord.getName() + " with " + this.vaccinationSite + " failed";
			personHealthRecord.setAppointmentStatus(success);
			throw new InsufficientVaccineDosesException("");
		}
	}
	
	public void administer(String date) {
		
	}
	
	public String toString() {
		String result = "";
		String seq = "<";
		for (int i = 0; i < this.noD; i ++) {
			VaccineDistribution vd = this.arrayOfDistribution[i];
			if (i < this.noD - 1) {
				seq += vd.getNumDoses() + " doses of " + vd.getVaccine().getManufuctuer() + ", ";
			}
			else {
				seq += vd.getNumDoses() + " doses of " + vd.getVaccine().getManufuctuer();
			}
		}
		seq += ">";
		
		result += this.vaccinationSite + " has " + this.totalDosesAccumulated + " available doses: " + seq;
		return result;
	}
	
}














