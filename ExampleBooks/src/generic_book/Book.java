package generic_book;

/*
 * A generic book of objects whose static types 
 * are descendants of E, which is to be
 * instantiated when declaring a variable of type Book
 * e.g., Book<Date>
 */
public class Book<E> {
	
	private String[] names;
	private int noN;
	
	private E[] records;
	private int noR;
	
	public Book() {
		this.names = new String[100];
	}

	/* add a name-record pair to the book */
	public void add (String name, E record) {
		/* Your Exercise */
		this.names[this.noN] = name;
		this.records[this.noR] = record;
	}

	/* return the record associated with a given name */
	public E get (String name) {
		/* Your Exercise */
		E result = null;
		for (int i = 0; i < this.noN; i ++) {
			if (this.names[i].equals(name)) {
				result = this.records[i];
			}
		}
		return result;
	}
}
