package aggregation;

public class LineCollector {
	
	private Line[] arrayOfLines;
	private int noL;
	
	public LineCollector() {
		this.arrayOfLines = new Line[20];
		this.noL = 0;
	}
	
	public LineCollector(LineCollector lc) {
		this();
		this.arrayOfLines = lc.arrayOfLines;
		this.noL = lc.noL;
	}
	
	public void addLine(Line l) {
		this.arrayOfLines[this.noL] = l;
		this.noL ++;
	}
	
	public Line getLineAt(int index) {
		return this.arrayOfLines[index];
	}
	
	public Line[] getLines() {
		Line[] tempLines = new Line[this.noL];
		
		for (int i = 0; i < this.noL; i ++) {
			tempLines[i] = this.arrayOfLines[i];
		}
		return tempLines;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		else if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		LineCollector other = (LineCollector) obj;
		
		boolean result = true;
		for (int i = 0; result && i < other.noL; i ++) {
			result = this.arrayOfLines[i].equals(other.arrayOfLines[i]);
		}
		return result;
	}
	
}














