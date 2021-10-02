package model;

public class Registration {
	
	private String courseName;
	private int creditNum;
	private int mark;
	private int gradePoint;
	
	public Registration(String courseName, int creditNum, int mark) {
		this(courseName, creditNum);
		this.mark = mark;
	}
	
	public Registration(String courseName, int creditNum) {
		this.courseName = courseName;
		this.creditNum = creditNum;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public int getNumberOfCredits() {
		return this.creditNum;
	}
	
	public int getMarks() {
		return this.mark;
	}
	
	public void setMarks(int newMark) {
		this.mark = newMark;
	}
	
	public String getLetterGrade() {
		String result = "";
		if (this.mark >= 90) {
			result = "A+";
			this.gradePoint = 9;
		}
		else if (this.mark >= 80 && this.mark < 90) {
			result = "A";
			this.gradePoint = 8;
		}
		else if (this.mark >= 70 && this.mark < 80) {
			result = "B";
			this.gradePoint = 7;
		}
		else if (this.mark >= 60 && this.mark < 70) {
			result = "C";
			this.gradePoint = 6;
		}
		else if (this.mark >= 50 && this.mark < 60) {
			result = "D";
			this.gradePoint = 5;
		}
		else {
			result = "F";
			this.gradePoint = 0;
		}
		return result;
	}
	
	public int getWeightedGradePoint() {
		if (this.mark >= 90) {
			this.gradePoint = 9;
		}
		else if (this.mark >= 80 && this.mark < 90) {
			this.gradePoint = 8;
		}
		else if (this.mark >= 70 && this.mark < 80) {
			this.gradePoint = 7;
		}
		else if (this.mark >= 60 && this.mark < 70) {
			this.gradePoint = 6;
		}
		else if (this.mark >= 50 && this.mark < 60) {
			this.gradePoint = 5;
		}
		else {
			this.gradePoint = 0;
		}
		return this.gradePoint * this.creditNum;
	}
}











































