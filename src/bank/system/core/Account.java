package bank.system.core;

public class Account {
	// Attributes
	private int id; // Account ID number.
	private float balance; // Account balance: money in an individual account.

	// CTORs
	public Account(int id, float balance) {
		this.id = id;
		setBalance(balance);
	}

	// Methods
	public int getId() {
		return id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
