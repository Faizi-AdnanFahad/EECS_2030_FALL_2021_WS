package model;

/*
 *  Template of a unit of storage in the apple refurbished shop.
 *  Think of the refurbished shop as a collection of entries.
 */
public class Entry {
	private String serialNumber; // e.g., F9FDN4NKQ1GC (unique)
	private Product product; 
	/*
	 * the type of attribute is a reference type, denoting an existing class.
	 * Consequently, at the runtime, this attribute will store the address 
	 * of some Product object
	 */
	
	public Entry(String serialNumber, Product product) {
		this.serialNumber = serialNumber;
		this.product = product;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	/* 
	 * An overloaded version of the setProduct mutator.
	 * This version of setProduct does not expect the user to create a Product object and pass it as argument.
	 * Instead, we would expect the user to pass a String model and a value of the original price.
	 * (Internally inside the method, it's expected that a local, new Product object is created accordingly.)
	 */
	public void setProduct(String model, double originalPrice) {
//		this.product = new Product(model, originalPrice);
		Product p = new Product(model, originalPrice);
		this.product = p;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public String toString() {
		return "[" + this.serialNumber + "] " + this.product.toString();
	}
}
