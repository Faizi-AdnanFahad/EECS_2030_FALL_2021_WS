package model;

public class Course {
	
	private String courseName;
	private double fee;
	
	public Course(String courseName, double fee) {
		this.courseName = courseName;
		this.fee = fee;
	}
	
	public double getFee() {
		return this.fee;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
}