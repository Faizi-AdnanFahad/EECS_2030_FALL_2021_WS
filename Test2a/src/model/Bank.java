package model;

public class Bank {
	
	private Account[] arrayOfAccouts;
	private int noA;
	
	public Bank() {
		this.arrayOfAccouts = new Account[5];
		this.noA = 0;
	}
	
	public Bank(Bank bank) {
		
	}
	
	public int getNumberOfAccounts() {
		return this.noA;
	}
	
	public Account[] getReferencesOfAccounts() {
		Account[] temp = new Account[this.noA];
		for (int i = 0; i < this.noA; i ++) {
			temp[i] = this.arrayOfAccouts[i];
		}
		return temp;
	}
	
	public Account[] getCopiesOfAccounts() {
		Account[] temp = new Account[this.noA];
		for (int i = 0; i < this.noA; i ++) {
			temp[i] = new Account(this.arrayOfAccouts[i]);
		}
		return temp;
	}
	
	public void addAccount(Account a) {
		this.arrayOfAccouts[this.noA] = a;
		this.noA ++;
	}
	
	public void addAccounts(Account[] accs) {
		
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		else if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Bank other = (Bank) obj;
		boolean equal = true;
		if (this.noA == other.noA) {
			for (int i = 0; equal && i < this.noA; i ++) {
				equal = this.arrayOfAccouts[i].equals(other.arrayOfAccouts[i]);
			}
		}
		else {
			equal = false;
		}
		
		return equal;
		
	}
}






















