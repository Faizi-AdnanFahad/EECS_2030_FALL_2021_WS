package furniture;

public class Desk {
	void deskMethod() {
		/* Within this method of a different resident class (but the same resident package) 
		 * as of 'i' and 'm' from class Chair,
		 * we can access both 'i' and 'm' since they are declared (without any modifier) 
		 * as accessible at the level of their resident package, i.e., furniture.
		 * Notice that the visibility of this USER method deskeMethod is IRRELEVANT:
		 * it only depends on the visibility of the attribute or method BEING USED.
		 */
		Chair c = new Chair();
		System.out.println(c.i);
		c.m();
	}
}
