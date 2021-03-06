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
		double remainingCapacity = this.capacity - this.capacityUsedSoFar;
		double currentUnitsCapacity = width * length;
		if (currentUnitsCapacity <= remainingCapacity) {
			if (this.noU < 20) { // If there is space left in the array of units (Max allowed 20)
				this.capacityUsedSoFar += currentUnitsCapacity;
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
				seq += unit.getFunction() + ": " + (unit.getLength() * unit.getWidth()) + " sq ft (" + unit.getWidth() + "' by " + unit.getLength() + "')";
			}
			else {
				seq += unit.getFunction() + ": " + (unit.getLength() * unit.getWidth()) + " sq ft (" + unit.getWidth() + "' by " + unit.getLength() + "'), ";
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
		boolean forAllIndexInOtherFloorHasntFoundSimilar = false;
		if (this.noU == otherFloor.noU) { // If each floor has the same number of units -> check for equality
			if (this.noU != 0) {
				for (int i = 0; !forAllIndexInOtherFloorHasntFoundSimilar && i < this.noU; i ++) {
					int reachedTheLastIndexThisNoU = 0; // this being equal to this.noU && equivalent being false after all iterations mean that one unit in floor (this) doesn't have any equivalent in (otherFloor) 
					equivalent = false;
					for(int m = 0; !equivalent && m < this.noU; m ++) {
						equivalent = this.arrayOfUnits[i].equals(otherFloor.arrayOfUnits[m]);
						reachedTheLastIndexThisNoU ++;
						forAllIndexInOtherFloorHasntFoundSimilar = ((reachedTheLastIndexThisNoU == this.noU) && (equivalent == false));
					}
				}
			}
			else { // If no floor is added, they are directly equivalent
				equivalent = true;
			}
		}
		else { // If each floor has the same number of units -> NO need to check -> false
			equivalent = false;
		}
		
		return (this.capacity == otherFloor.capacity) && equivalent;
	}
	
	// Getters
	public int getCapacity() {
		return this.capacity;
	}
	
	public int getNOU() {
		return this.noU;
	}
	
	public Unit[] getArrayOfUnit() {
		return this.arrayOfUnits;
	}
	
	// Setters for deep copy
	public void setArrayOfUnits(Floor floor) {
		/*
		 * Makes a new unit object for each units in the array of units given as argument.
		 */
		for (int i = 0; i < floor.noU; i ++) {
			arrayOfUnits[i] = new Unit(floor.getArrayOfUnit()[i].getFunction(), floor.getArrayOfUnit()[i].getWidth(), floor.getArrayOfUnit()[i].getLength());
		}
	}
	
	public void setCapacityUsedSorFar(Floor floor) {
		this.capacityUsedSoFar = floor.capacityUsedSoFar;
	}
	
	public void setNOU(Floor floor) {
		this.noU = floor.noU;
	}
}