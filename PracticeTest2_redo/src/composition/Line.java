package composition;

public class Line {
	
	private Point p1;
	private Point p2;
	
	public Line(Point p1, Point p2) {
		this.p1 = new Point(p1.getX(), p1.getY());
		this.p2 = new Point(p2.getX(), p2.getY());
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