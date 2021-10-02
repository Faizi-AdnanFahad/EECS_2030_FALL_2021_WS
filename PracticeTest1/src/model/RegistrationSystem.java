package model;

public class RegistrationSystem {
	private Transcript[] transcriptsArray;
	private int not;
	
	public RegistrationSystem() {
		this.transcriptsArray = new Transcript[500];
	}
	
	public Transcript[] getReport() {
		Transcript[] t = new Transcript[this.not];
		for (int i = 0; i < this.not; i ++) {
			t[i] = this.transcriptsArray[i];
		}
		return t;
	}
	
	public void addTranscript(Transcript t) {
		this.transcriptsArray[this.not] = t;
		this.not ++;
	}
	
	public int getMarks(String studentName, String courseName) {
		int mark = -1;
		for (int i = 0; i < this.not; i ++) {
			if (this.transcriptsArray[i].getStudentName().equals(studentName)) {
				mark = this.transcriptsArray[i].getMarks(courseName);
			}
		}
		return mark;
	}
	
}




























