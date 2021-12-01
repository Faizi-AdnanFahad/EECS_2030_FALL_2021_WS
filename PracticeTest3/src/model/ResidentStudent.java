package model;

public class ResidentStudent extends Student {
	
	private double pr;
	
	public ResidentStudent(String name) {
		this.name = name;
	}
	
	public void setPremiumRate(double pr) {
		this.pr = pr;
	}
	
	public double getPremiumRate() {
		return this.pr;
	}
	
	public double getTuition() {
		return super.getTuition() * this.pr;
	}
}
