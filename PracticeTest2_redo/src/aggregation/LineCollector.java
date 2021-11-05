package aggregation;

public class LineCollector {
	
	private Line[]	arrayOfLines;
	private int noL;
	
	public LineCollector() {
		this.arrayOfLines = new Line[20];
		this.noL = 0;
	}
	
	public LineCollector(LineCollector lc) {
		this();
		for (int i = 0; i < lc.noL; i ++) {
			Line l = new Line(lc.arrayOfLines[i]);
			this.arrayOfLines[i] = l;
		}
		this.noL = lc.noL;
	}
	
	public void addLine(Line l) {
		this.arrayOfLines[this.noL] = l;
		this.noL ++;
	}
	
	public Line[] getLines() {
		return this.arrayOfLines;
	}
	
	public Line getLineAt(int index) {
		return this.arrayOfLines[index];
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		else if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		LineCollector other = (LineCollector) obj;
		if (this.noL == other.noL) {
			boolean equal = true;
			for (int i = 0; equal && i < this.noL; i ++) {
				equal = this.arrayOfLines[i] == other.arrayOfLines[i];
			}
			return equal;
		}
		else {
			return false;
		}
	} 
}