package general_book;

/*
 * A book of objects whose static types 
 * are descendants of the Object class.
 */
public class Book {
	private String[] names; 
	int noN; // Number of names
	
	private Object[] records; 
	int noR; // number of records
	
	public Book() {
		this.names = new String[10];
		this.records = new Object[10];
	}
	
	/* add a name-record pair to the book */
	public void add (String name, Object record) {  
		this.names[this.noN] = name;
		this.records[this.noR] = record;
	} 
	
	/* return the record associated with a given name */
	public Object get (String name) {
		Object o = null;
		boolean stay = true;
		for (int i = 0; stay && i < this.noN; i ++) {
			if (this.names[i].equals(name)) {
				o = this.records[i];
				stay = false;
			}
		}
		return o;
	}
}