package aggregation;

public class Line {
	
	private Point p1;
	private Point p2;
	
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Line(Line l) {
		this(l.getStart(), l.getEnd());
	}
	
	public Point getStart() {
		return this.p1;
	}
	
	public Point getEnd() {
		return this.p2;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		else if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Line other = (Line) obj;
		return this.getStart().equals(other.getStart()) && this.getEnd().equals(other.getEnd());
	} 
}