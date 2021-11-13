package furniture;

public class BubbleChair extends Chair { // Treat it just like an extension of the Chair class.
	void bubbleChairMethod() {
		/* Within this method of a descendant class (and same resident package) 
		 * as of 'i' and 'm' from class Chair,
		 * we can access any of them, since both 'i' and 'm' are declared as 'protected'.
		 */
		Chair c = new Chair();
		System.out.println(c.i);
		c.m(); 
		
		// We can use 'this' keyword too & 
		System.out.println(this.i);
		this.m();
		
		c.modiferVariable = 3;
	}
}
