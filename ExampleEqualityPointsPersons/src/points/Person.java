package points;

public class Person {
	private String firstName;
	private String lastName;
	private double weight;
	private double height;
	
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public double getWeight() {
		return this.weight;
	}
	public double getHeight() {
		return this.height;
	}
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Person other = (Person) obj;
		return (this.firstName.equals(other.firstName))
				&& (this.lastName.equals(other.lastName))
				&& (this.weight == other.weight)
				&& (this.height == other.height);
	}
}
