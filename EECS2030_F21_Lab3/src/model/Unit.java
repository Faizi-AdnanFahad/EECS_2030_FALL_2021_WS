package model;

public class Unit {
	
	private String function; // Name of the space utilized. 
	
	private int widthInFeet;
	private int lengthInFeet;
	
	private double widthInMeter;
	private double lengthInMeter;
	
	private int toogleCounter; // Helper Attribute // Counting the number of times the toogleMeasurement mutator is called. Specifically, for keeping note of whether to use feet or meter.
	
	public Unit(String function, int width, int length) { // Width and Length in feet
		this.function = function;
		this.widthInFeet = width;
		this.lengthInFeet = length;
	}
	
	public void toogleMeasurement() { 
		/*
		 *  mutator to convert from feet to meters
		 */
		if (this.toogleCounter % 2 == 0) {
			this.widthInMeter = this.widthInFeet * 0.3048;
			this.lengthInMeter = this.lengthInFeet * 0.3048;
		}
		this.toogleCounter ++;
	}
	
	public String toString() {
		String result = "";
		if ((this.toogleCounter + 1) % 2 == 1) {
			result = "A unit of " 
					+ (this.widthInFeet * this.lengthInFeet)
					+ " square feet (" + this.widthInFeet + "' wide and " 
					+ this.lengthInFeet + "' long) functioning as " + this.function;
		}
		else {
			double area = (this.widthInMeter * this.lengthInMeter);
			result = "A unit of " 
					+ String.format("%.2f", area)
					+ " square meters (" + String.format("%.2f", this.widthInMeter) + " m wide and " 
					+  String.format("%.2f", this.lengthInMeter) + " m long) functioning as " + this.function;
		}
		return result;
	}
	
	// Overridden Equals method from Object class
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		else if (obj == this) {
			return true;
		}
		else if (this.getClass() != obj.getClass()) {
			return false;
		}
		Unit otherUnit = (Unit) obj;
		return this.function.equals(otherUnit.function) 
				&& ((this.lengthInFeet * this.widthInFeet) == (otherUnit.lengthInFeet * otherUnit.widthInFeet));
	}
	
	// Additional Getters
	public String getFunction() {
		return this.function;
	}
	
	public int getWidth() {
		return this.widthInFeet;
	}
	
	public int getLength() {
		return this.lengthInFeet;
	}
}