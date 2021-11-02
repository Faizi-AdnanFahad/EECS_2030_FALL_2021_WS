package composition;

public class Point {
	
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this(p.x, p.y);
		this.x = p.x;
		this.y = p.y;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		else if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Point other = (Point) obj;
		return other.x == this.x && other.y == this.y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	
	public void setX(int newX) {
		this.x = newX;
	}
}
