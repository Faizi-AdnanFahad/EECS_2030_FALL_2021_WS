package model;

/*
 *  Template for individual Apple product in refurbished store.
 */
public class Product {
	/*attributes: Should be private so that they are only visible within the current class.
	 * If you intend to make an attribute public, it will be visible to all classes. 
	 * Instead, create a public accessor for this private attribute. */
	
	private String model; // e.g., iPad Pro 12.9
	private String finish; // e.g., Silver, Black
	private int storage; // in the units of GB, e.g., 356, 512, 1000 (1TB)
	private boolean hasCellularConnectivity; // e.g., false (only wifi), true (wifi & cellular)
	private double originalPrice; // e.g., 1789.00
	private double discountValue; // e.g., 200.00
	
	/*Constructors*/
	// If no constructors are declared here, an implicit, default constructor is available.
	public Product() {
		// Store the default values of attributes
	}
	
	// An overloaded version of the constructor.
	public Product(String model, double originalPrice) {
		this.model = model;
		this.originalPrice = originalPrice;	
	}
	
	/*------------------------- Accessor -------------------------------*/
	public String getModel() {
		return this.model;
	}
	
	public String getFinish() {
		return this.finish;
	}
	
	public int getStorage() {
		return this.storage;
	}
	
	public double getDiscountValue() {
		return this.discountValue;
	}
	
	public double getOriginalPrice() {
		return this.originalPrice;
	}
	
	public boolean hasCellularConnectivity() {
		return this.hasCellularConnectivity;
	}
	
	public double getPrice() {
		// local variable declaration
		double price = 0;
		// Computation
		price = this.originalPrice - this.discountValue;
		return price;
	}
	
	public String toString() { // toString is a special method that whenever an object is printed, the return value of toString function will be printed.
		String s = "";
		
		// Method 1
//		StringBuilder sb = new StringBuilder();
//		sb.append(this.model + " " + this.finish + " " + this.storage + "GB " + "(cellular connectivity: " + this.hasCellularConnectivity + "): $(" + String.format("%.2f", this.originalPrice) + " - " +
//				String.format("%.2f", this.discountValue) + ")");
//		s = sb.toString();
		
		// Method 2
//		s += this.model + " " + this.finish + " " + this.storage + "GB " + "(cellular connectivity: " + this.hasCellularConnectivity + "): $(" + String.format("%.2f", this.originalPrice) + " - " +
//				String.format("%.2f", this.discountValue) + ")";
		
		// Method 3 
		s = String.format("%s %s %dGB (cellular connectivity: %s): $(%.2f - %.2f)", this.model, this.finish, this.storage, this.hasCellularConnectivity, this.originalPrice, this.discountValue);
		return s;
	}
	
	
	
	/*--------------------------- Mutators --------------------------------*/
	public void setModel(String model) {
		this.model = model;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}
	
	public void setHasCellularConnectivity(boolean hasCellularConnectivity) {
		this.hasCellularConnectivity = hasCellularConnectivity;
	}
	
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	
	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
}