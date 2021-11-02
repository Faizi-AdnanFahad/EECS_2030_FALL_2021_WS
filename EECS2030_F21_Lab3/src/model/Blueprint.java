package model;

public class Blueprint {
	
	private int numOfFloors;
	private Floor[] arrayOfFloors;
	private int noF; // Number Of Floors Added so far
	
	public Blueprint(int numOfFloors) {
		this.numOfFloors = numOfFloors;
		this.arrayOfFloors = new Floor[numOfFloors];
		this.noF = 0;
	}
	
	// Copy Constructor 
	public Blueprint(Blueprint blueprint) {
		this(blueprint.numOfFloors);
		for (int i = 0; i < blueprint.noF; i ++ ) {
			this.addFloorPlan(blueprint.arrayOfFloors[i]);
		}
		this.noF = blueprint.noF;
	}
	
	public void addFloorPlan(Floor floor) {
		Floor floorDeepCompy = new Floor(floor.getCapacity());
		floorDeepCompy.setArrayOfUnits(floor); // Makes new units from each units stored in arrayOfUnits to maintain composition
		floorDeepCompy.setCapacityUsedSorFar(floor);
		floorDeepCompy.setNOU(floor);
		this.arrayOfFloors[this.noF] = floorDeepCompy;
		this.noF ++;
	}

	public Floor[] getFloors() {
		Floor[] tempArrayOfFloors = new Floor[this.noF];
		for (int i = 0; i < this.noF; i ++) {
			Floor f = this.arrayOfFloors[i];
			tempArrayOfFloors[i] = f;
		}
		return tempArrayOfFloors;
	}
	
	public String toString() {
		double percentage = 0;
		if (this.numOfFloors != 0) {
			percentage = (100.0 * this.noF) / this.numOfFloors; // Percentage of added floors so far compare to the total number of floors that could be possibly added.
		}
		return String.format("%.1f", percentage) + " percents of building blueprint completed (" + this.noF +  " out of " + this.numOfFloors + " floors)";
	}
}