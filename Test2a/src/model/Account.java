package model;

public class Account {
	
	private String name;
	private int balance;
	
	private int vipCounter;
	private int regCounter;
	
	private int deposit;
	
	private boolean regB;
	private boolean vipB;
	
	public Account(String name, int balance) {
		this.name = name;
		this.balance = balance;
		this.vipCounter = 0;
		this.regCounter = 0;
		this.regB = true;
		this.vipB = false;
	}
	
	public Account(Account account) {
		this(account.name, account.balance);
		this.balance = account.balance;
		this.name = account.name;
		this.vipB = account.vipB;
		this.regB = account.vipB;
		this.regCounter = account.vipCounter;
		this.vipCounter = account.vipCounter;
		this.deposit = account.deposit;
	}
	
	public void switchToVIP(int deposit) throws InsufficientBalanceException, InvalidStatusToSwitchException {		
		this.vipB = true;
		if (this.vipB && this.vipCounter % 2 == 0) {
			this.vipCounter ++;
			if (this.balance < deposit) {
				throw new InsufficientBalanceException("");
			}
			else {
				this.deposit = deposit;
				this.balance -= deposit;
			}
		}
		else {
			this.vipB = false;
			throw new InvalidStatusToSwitchException("");
		}
		
	}
	
	public void switchToRegular() throws InvalidStatusToSwitchException {
//		this.regB = false;
		if (this.vipB || this.regCounter % 2 != 0) {
			this.balance += this.deposit;
			this.regCounter ++;
			this.regB = false;
		}
		else {
			throw new InvalidStatusToSwitchException("");

		}
	}
	
	public String toString() {
		String result = "";
		if (this.regB && this.vipCounter % 2 == 1) {
			result = "A VIP account owned by " 
					+ this.name 
					+ " with balance $" + this.balance 
					+ " ($" + this.deposit + " deposited for maintaining the VIP stauts)";
		}
		else if (this.regCounter % 2 == 0 || !this.regB) {
			result =  "A regular account owned by " + this.name + " with balance $" + this.balance;
		}
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		else if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Account other = (Account) obj;
		boolean a = false;
		if ((this.regB == false && other.regB == false) || (this.regB == true && other.regB == true)) {
			a = true;
		}
		else {
			a = false;
		}
		
		return this.name.equals(other.name) && (this.balance == other.balance) && (a);
	}
	
	public String getName() {
		return this.name;
		
	}
	
	public int getBalance() {
		return this.balance;
	}
}



















