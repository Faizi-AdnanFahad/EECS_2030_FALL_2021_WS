package composition;

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
			this.arrayOfLines[i] = new Line(lc.arrayOfLines[i]);
			}
		this.noL = lc.noL;
	}
	
	public void addLine(Line l) {
		this.arrayOfLines[this.noL] = l;
		this.noL ++;
	}
	
	public Line[] getLines() {
		Line[] temp = new Line[this.noL];
		for (int i = 0; i < this.noL; i ++) {
			Line l = new Line(this.arrayOfLines[i].getStart(), this.arrayOfLines[i].getEnd());
			temp[i] = l;
		}
		return temp;
	}
	
	public Line getLineAt(int index) {
		Line l = new Line(this.arrayOfLines[index].getStart(), this.arrayOfLines[index].getEnd());
		return l;
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
				equal = this.arrayOfLines[i].equals(other.arrayOfLines[i]);
			}
			return equal;
		}
		else {
			return false;
		}
	} 
}