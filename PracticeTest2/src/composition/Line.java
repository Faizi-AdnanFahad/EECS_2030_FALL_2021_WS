package composition;


public class Line {
	
	private Point p1;
	private Point p2;
	
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Line(Line l) {
		this(l.p1, l.p2);
		Point p1 = new Point(l.p1);
		Point p2 = new Point(l.p2);

		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Point getStart() {
		Point p1 = new Point(this.p1.getX(), this.p1.getY());
		return p1;
	}
	
	public Point getEnd() {
		Point p2 = new Point(this.p2.getX(), this.p2.getY());
		return p2;
		}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		else if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Line other = (Line) obj;
		return this.p1.equals(other.p1) && p2.equals(other.p2);
	}
	
	
	
}










