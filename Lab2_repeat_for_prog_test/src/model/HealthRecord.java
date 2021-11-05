package model;

public class HealthRecord {
	
	private String name;
	private int limitOnVaccine;
	
	private VaccineDistribution[] arrayOfVaccineDist;
	private int noD;
	
	private String appointmentStatus;
	private boolean appStatusConfirmed;

	
	public HealthRecord(String name, int limitOnVaccine) {
		this.name = name;
		this.limitOnVaccine = limitOnVaccine;
		this.arrayOfVaccineDist = new VaccineDistribution[limitOnVaccine];
		this.appointmentStatus = null;
		this.appStatusConfirmed = false;
	}
	
	public String getVaccinationReceipt() {
		String result = "";
		String seq = "[";
		if (this.noD != 0) {
			for (int i = 0; i < this.noD; i ++) {
				VaccineDistribution vd = this.arrayOfVaccineDist[i];
				if (i < this.noD - 1) {
					seq += vd.getVaccine().getIsRecognized() + ": " 
							+ vd.getVaccine().getCodeName() + " (" 
							+ vd.getVaccine().getVaccineType() + "; " 
							+ vd.getVaccine().getManufuctuer() +  ") in " 
							+ vd.getVaccineSite() + " on " + vd.getDate() + "; ";
				}
				else {
					seq += vd.getVaccine().getIsRecognized() + ": " 
							+ vd.getVaccine().getCodeName() + " (" 
							+ vd.getVaccine().getVaccineType() + "; " 
							+ vd.getVaccine().getManufuctuer() +  ") in " 
							+ vd.getVaccineSite() + " on " + vd.getDate();			}
			}
			seq += "]";
			result += "Number of doses " + this.name + " has received: " + this.noD + " " +  seq;
		}
		else {
			result = this.name + " has not yet received any doses.";
		}
		
		return result;
	}
	
	public String getAppointmentStatus() {
		String result = "";
		if (this.appointmentStatus == null) {
			result = "No vaccination appointment for " + this.name + " yet";
		}
		else {
			result = this.appointmentStatus;
		}
		return result;
	}
	
	public void addRecord(Vaccine vaccine, String vaccinationSite, String date) {
		VaccineDistribution vd = new VaccineDistribution(vaccine, vaccinationSite, date);
		this.arrayOfVaccineDist[this.noD] = vd;
		this.noD ++;
	}
	
	public void setAppointmentStatus(String s) {
		this.appointmentStatus = s;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAppointmentStatus(boolean status) {
		this.appStatusConfirmed = status;
	}

}
