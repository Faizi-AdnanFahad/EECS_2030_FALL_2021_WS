package test_monica;

public class Point {
	
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static String test(Point p1, Point p2) {
		
		Point testP = new Point(1, 2);
		p1 = p2;
		p1 = testP;
		
		String result = "address is " + p1;
		
		return result;
	}
	
//	public static String testList(Point[] p) {
//		
//	}
	
	
}
