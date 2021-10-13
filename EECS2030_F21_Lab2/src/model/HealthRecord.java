package model;

public class HealthRecord {
	
	private String patientName;
	private int numOfDosesLimit;
	private String[][] arrayOfRecords;
	private int noR;
	
	public HealthRecord(String patientName, int numOfDosesLimit) {
		this.patientName = patientName;
		this.numOfDosesLimit = numOfDosesLimit;
		this.arrayOfRecords = new String[numOfDosesLimit][5];
	}
	
	public String getVaccinationReceipt() {
		return this.patientName + " has not yet received any doses.";
	}
	
	public String getAppointmentStatus() {
		return "No vaccination appointment for " + this.patientName + " yet";
	}
	
	
	public void addRecord(Vaccine vaccine, String nameOfTheSite, String vaccinationDate) {
		String[] record = new String[5];
		record[0] = vaccine.getCodeNameVaccine();
		record[1] = vaccine.getTypeVaccine();
		record[2] = vaccine.getManufacturerVaccine();
		record[3] = nameOfTheSite;
		record[4] = vaccinationDate;
		this.arrayOfRecords[this.noR] = record;
		this.noR ++;
	}
	
	











}

























