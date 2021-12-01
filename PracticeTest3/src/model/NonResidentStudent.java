package model;

public class NonResidentStudent extends Student {
	
	private double dr;
	
	public NonResidentStudent(String name) {
		this.name = name;
	}
	
	public void setDiscountRate(double dr) {
		this.dr = dr;
	}
	
	public double getDiscountRate() {
		return this.dr;
	}
	
	public double getTuition() {
		return super.getTuition() * this.dr;
	}
	
}
