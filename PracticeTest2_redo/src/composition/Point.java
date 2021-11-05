package composition;

public class Point {
	
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.x;
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		else if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Point other = (Point) obj;
		return other.x == this.x && this.y == other.y;
	}
}
