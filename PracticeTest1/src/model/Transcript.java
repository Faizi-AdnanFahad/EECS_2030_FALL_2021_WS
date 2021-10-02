package model;

public class Transcript {
	
	private String name;
	private Registration[] registrationArray;
	private int nor;
	
	public Transcript(String name) {
		this.name = name;
		this.registrationArray = new Registration[60];
	}
	
	public Registration[] getReport() {
		Registration[] r = new Registration[this.nor];
		for (int i = 0; i < this.nor; i ++) {
			r[i] = this.registrationArray[i];
		}
		return r;
	}
	
	public void addRegistration(Registration r) {
		this.registrationArray[this.nor] = r;
		this.nor ++;
	}
	
	public void addRegistration(String courseName, int creditNum) {
		Registration r = new Registration(courseName, creditNum);
		this.registrationArray[this.nor] = r;
		this.nor ++;
	}
	
	public void addRegistrations(Registration[] r) {
		for (int i = 0; i < r.length; i ++) {
			this.registrationArray[this.nor] = r[i];
			this.nor ++;
		}
	}
	
	public int getMarks(String courseName) {
		int mark = -1;
		for (int i = 0; i < this.nor; i ++) {
			 Registration r = this.registrationArray[i];
			if (r.getCourseName().equals(courseName)) {
				mark = r.getMarks();
			}
		}
		return mark;
	}
	
	public String getStudentName() {
		return this.name;
	}
	
	public void setMarks(String courseName, int mark) {
		for (int i = 0; i < this.nor; i ++) {
			 Registration r = this.registrationArray[i];
			if (r.getCourseName().equals(courseName)) {
				r.setMarks(mark);;
			}
		}
	}
	
	public double getWeightedGPA() {
		double sum = 0;
		for (int i = 0; i < this.nor; i ++) {
			sum += this.registrationArray[i].getWeightedGradePoint();
		}
		double total = sum / this.nor;
		return total;
	}
	
	
}






























