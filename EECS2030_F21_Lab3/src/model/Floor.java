package model;

public class Floor {
	
	private int capacity;
	private double capacityUsedSoFar;
	
	private Unit[] arrayOfUnits;
	private int noU; // Number of units in the current floor.
	
	
	public Floor(int capacity) { // Capacity in square feet
		this.capacity = capacity;
		this.arrayOfUnits = new Unit[20]; // Maximum of 20 Units per floor.
	}
	
	public void addUnit(String function, int width, int length) throws InsufficientFloorSpaceException{
		if ((width * length) <= (this.capacity - this.capacityUsedSoFar)) {
			if (this.noU < 20) {
				capacityUsedSoFar += (width * length);
				this.arrayOfUnits[this.noU] = new Unit(function, width, length);
				this.noU ++;
			
			}
		}
		else {
			throw new InsufficientFloorSpaceException("Max Space capacity has reached!");
		}
	}
	
	public String toString() {
		String result = "";
		String seq = "[";
		for (int i = 0; i < this.noU; i ++) {
			Unit unit = this.arrayOfUnits[i];
			if (i == this.noU - 1) {
				seq += unit.getFunction() + ": " + (unit.getLength() * unit.getWidth()) + " sq ft (" + unit.getWidth() + "' by " + unit.getLength() + "'" + ")";
			}
			else {
				seq += unit.getFunction() + ": " + (unit.getLength() * unit.getWidth()) + " sq ft (" + unit.getWidth() + "' by " + unit.getLength() + "'" + "), ";
			}
		}
		seq += "]";
		result = "Floor's utilized space is " + ((int) this.capacityUsedSoFar) + " sq ft (" + ((int) (this.capacity - this.capacityUsedSoFar)) +  " sq ft remaining): " + seq;
		return result;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		else if (this == obj) {
			return true;
		}
		else if (this.getClass() != obj.getClass()) {
			return false;
		}
		Floor otherFloor =  (Floor) obj;
		boolean equivalent = false;
		return (this.capacity == otherFloor.capacity);
	}
	
	
}
















