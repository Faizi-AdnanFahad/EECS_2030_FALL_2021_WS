package shape;

/*
 * Since class Chair is declared as 'public',
 * it can be accessed within all classes (across packages) in its resident project.
 * but must be imported.
 */

import furniture.Chair;
 
public class Square {
	
	@SuppressWarnings("unused")
	void squareMethod() {
		Chair c = new Chair();
	}
	
}
