package test_monica;

public class TestClass {
	
	Point[] p;
	int noP;
	
	public TestClass() {
		this.p = new Point[2];
	}
	
	public void addPoint(Point p) {
		this.p[this.noP] = p;
		this.noP ++;
	}
	
	public String getAddressOfEachPoint() {
		return "Point in index 0: " + this.p[0] 
				+ " | Point in index 0:" + this.p[1];
	}
}
