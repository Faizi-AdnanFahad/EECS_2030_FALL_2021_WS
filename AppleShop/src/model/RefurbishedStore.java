package model;
	
	/*
	 * Template of a collection of entries.
	 */
public class RefurbishedStore {
	private Entry[] entries; // an array of Entry object references: each slot stores the reference of some Entry object.
	private int noe;
	/*
	 * Two purposes of the auxiliary counter;
	 *	1. Records how many (non-null) entries have been stored in the 'entries' array.
	 *	2. Indicates the index of the 'entries' array that will store the next new entry reference.
	 */
	private final int MAX_CAPACITY = 5; // a constant maximum capacity.
	
	public RefurbishedStore() {
		this.entries = new Entry[this.MAX_CAPACITY];
		this.noe = 0;
	}
	
	public Entry[] getPrivateEntriesArray() {
		return this.entries;
	}
	
	public int getNumberOfEntries() {
		return this.noe;
	}
	/*
	 * Retrieve the array of entries, arrange in the chronological order 
	 * in which they were inserted
	 * That is, the earlier an entry was inserted, the more front it appears in the return array.
	 */
	public Entry[] getEntries( ) {
		Entry[] es = new Entry[this.noe];
		for (int i = 0; i < this.noe; i ++) {
			es[i] = this.entries[i];
		}
		return es;
	}
	
	public Product getProduct(String sn) {		
		/*
		 * First Solution --> Adnan
		 */
//		Product result = null;
//		boolean stay = true;
//		for (int i = 0; stay && i < this.noe; i ++) {
//			if (this.entries[i].getSerialNumber().equals(serialNumber)) {
//				result = this.entries[i].getProduct();
//				stay = false;
//			}
//		}
		
		/*
		 * Second Solution --> Instructor
		 */
		int index = -1; // expected to be re-assigned to a valid index if the 'sn' exists in the store.
		for (int i = 0; i < this.noe; i ++) {
			Entry e = this.entries[i];
			if (e.getSerialNumber().equals(sn)) {
				index = i;
			}
		}
		
		if (index < 0) {
			return null;
		}
		else {
			return this.entries[index].getProduct();
		}
	}
	
	// For now, assume that the serial number of input entry 'e' does not exist in the collection.
	public void addEntry(Entry e) {
		this.entries[this.noe] = e;
		this.noe ++;
	}
	
	public void addEntry(String sn, Product p) {
		this.addEntry(new Entry(sn, p));
	}
	
	public void addEntry(String sn, String model, double originalPrice) {
		this.addEntry(new Entry(sn, new Product(model, originalPrice)));
	}
	
	/*
	 * Return the serial numbers of all product that are 
	 * either with Space Grey finish or is a Pro.
	 */
	public String[] getSpaceGreyOrPro() {
		/*
		 * First Method: Adnan
		 */
//		int count = 0;
//		String[] arrayMatchingTheSearchCritera = new String[this.noe];
//		for (int i = 0; i < this.noe; i ++) {
//			String model = this.entries[i].getProduct().getModel();
//			String finish = this.entries[i].getProduct().getFinish();
//			if (model.contains("iPad Pro") || finish.contains("Space Grey")) {
//				arrayMatchingTheSearchCritera[count] = this.entries[i].getSerialNumber();
//				count ++;
//			}
//		}
//		
//		String[] result = new String[count];
//		for (int i = 0; i < count; i ++) {
//			result[i] = arrayMatchingTheSearchCritera[i];
//		}
//		return result;
		
		
		/*
		 * Second Method: Instructor
		 */
		int count = 0; // number of product satisfying the search criteria;
		int[] indices = new int[this.noe]; // indices of entry objects, in the entries array, that satisfy the search criteria;
		
		// Step 1: Collect all the products satisfying the search criteria
		for (int i = 0; i < this.noe; i ++) {
			Product p = this.entries[i].getProduct();
			if (p.getModel().contains("Pro") || (p.getFinish() != null && p.getFinish().equals("Space Grey"))) {
				indices[count] = i;
				count ++;
			}
		}
		// Step 2: Create an array of Strings for serial numbers whose size is 'count'.
		String[] sns = new String[count];
		for (int i = 0; i < count; i ++) {
			sns[i] = this.entries[indices[i]].getSerialNumber();
		}
		return sns;
	}
	
	/*
	 * Return the serial numbers of all product that are 
	 * Space Grey finish and is a Pro.
	 */
	public String[] getSpaceGreyPro() {
		int count = 0; // number of product satisfying the search criteria;
		int[] indices = new int[this.noe]; // indices of entry objects, in the entries array, that satisfy the search criteria;
		
		// Step 1: Collect all the products satisfying the search criteria
		for (int i = 0; i < this.noe; i ++) {
			Product p = this.entries[i].getProduct();
			if (p.getModel().contains("Pro") && p.getFinish() != null && p.getFinish().equals("Space Grey")) {
				indices[count] = i;
				count ++;
			}
		}
		// Step 2: Create an array of Strings for serial numbers whose size is 'count'.
		String[] sns = new String[count];
		for (int i = 0; i < count; i ++) {
			sns[i] = this.entries[indices[i]].getSerialNumber();
		}
		return sns;
	}
}