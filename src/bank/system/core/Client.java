package bank.system.core;

public class Client {

	// Attributes
	private int id; // Client ID number.
	private String name; // Client string name.
	private float balance; // Client balance: The amount of money in the client but not in the accounts.
	private Account[] accounts = new Account[5]; // Every client has maximum 5 accounts organized in an array.
	private float commisionRate = 0; // This will be an amount of money that enters or leaves the client balance(?).
	private float interestRate = 0.1F; // Interest rate, will be different for each client level (will be added later).
	private Logger logger = new Logger("logger-client name"); // Logger, needs to ask how this stuff works still.

	// CTORs
	public Client(int id, String name, float balance) { // Constructor for client object. it has ID number, string name and money.
		super(); // This was added by eldar in class.
		setBalance(balance);
		setName(name);
		this.id = id;
	}

	// Methods
	public int getId() {
		return id;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * this method adds account to the client.
	 * 
	 * You should seek the array and place the Account where the first null value is
	 * found.
	 * 
	 * @param newAccount the account to add to the client
	 */
	public void addAccount(Account newAccount) {
		for (int i = 0; i < accounts.length; i++) { // Looking for a free spot in the array of 5 accounts (a null is a free spot).
			if (accounts[i] == null) {
				accounts[i] = newAccount; // newAccount is the Account object that is now assigned a reference in the array with index i.
				// === LOG THE OPERATION ================
				// 1. create a Log object (with all relevant details)
				long timestamp = 0; // System.currentTimeMillis(); // When
				int clientId = this.id; // By who
				String description = "Client added an acount with id: " + newAccount.getId();
				float amount = newAccount.getBalance();
				Log addAccountLog = new Log(timestamp, clientId, description, amount);
				// 2. Use the logger attribute to log (store) the Log object
				logger.log(addAccountLog);
				// ======================================
				return;
			}
		}
	}

	/**
	 * getAccount returns an account of a specified index and null if it does not
	 * exist.
	 * 
	 * @param index - is the index in the accounts[] array.
	 * @return accoutAtIndex - the account id and balance of the specific account.
	 */
	public Account getAccount(int id) { // I guess this is meant to see what are the stats of the account.
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) { // Making sure that the required account is indeed in the array.
				if (accounts[i].getId() == id) {
					Account accountAtIndex = new Account(accounts[i].getId(), accounts[i].getBalance()); // accountAtIndex is the reference for the account at index i.
					System.out.println("id: " + accounts[i].getId() + ", balance: " + accounts[i].getBalance()); // Just so the printing looks nice.
					return accountAtIndex;
				} else {
					break; // If account at index i (with id = id) is null, do nothing.
				}
			} 
			
		}
		
		return null;

	}

	/**
	 * remove the account with the same id from the array (by assigning a 'null'
	 * value to the array[position]) & transfers the money to the clients balance.
	 * Log the operation via creating Log object with appropriate data and sending
	 * it to the Logger.log(..) method.
	 * 
	 * @param id - the id of the account that is to be removed.
	 */
	public void removeAccount(int id) { // Removing an account requires that the money in the account stays with the client!
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getId() == id) {
				balance += accounts[i].getBalance(); // Adding the money in the account that is being removed into the CLIENT BALANCE THAT IS SEPARATE FROM ACCOUNTS BALANCE.
				// === LOG THE OPERATION ================
				// 1. create a Log object (with all relevant details)
				long timestamp = 0; // System.currentTimeMillis(); // When
				int clientId = this.id; // By who
				String description = "Client removed an acount with id: " + accounts[i].getId();
				float amount = accounts[i].getBalance();
				Log addAccountLog = new Log(timestamp, clientId, description, amount);
				// 2. Use the logger attribute to log (store) the Log object
				logger.log(addAccountLog);
				// ======================================
				accounts[i] = null; // This is the deletion of the account from the array.
				return;
			}
		}

	}

	/**
	 * deposit(float) & withdraw(float) : void - implement to add of remove the
	 * amount from clients balance according to the commission (which is now zero).
	 * Use the commission data member in your calculation)
	 * 
	 * These two have no purpose currently because they are used in the next step but we didnt learn what that stuff is.
	 * But in general, i think, those are adding and removing money from the CLIENT BALANCE.
	 */
	public void deposit(float commisionRate) {
		balance += commisionRate;
	}

	public void withdraw(float commisionRate) {
		balance -= commisionRate;
	}

	/**
	 * autoUpdateAccounts() : void – run over the accounts, calculate the amount to
	 * add according to the client interest (meanwhile it is zero) and add it to
	 * each account balance. Use the interest data member in your calculation. Log
	 * this operation.
	 */
	public void autoUpdateAccounts() {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {

				// === LOG THE OPERATION ================
				// 1. create a Log object (with all relevant details)
				long timestamp = 0; // System.currentTimeMillis(); // When
				int clientId = this.id; // By who
				String description = "Client account id: " + accounts[i].getId() + " had: "
						+ accounts[i].getBalance() * interestRate + " interest added to it"; // These two lines are just for printing something that looks nice later.
				accounts[i].setBalance(accounts[i].getBalance() + accounts[i].getBalance() * interestRate); // This ugly thing is adding the interest rate to the individual account balance.
				float amount = accounts[i].getBalance();
				Log addAccountLog = new Log(timestamp, clientId, description, amount);
				// 2. Use the logger attribute to log (store) the Log object
				logger.log(addAccountLog);
				// ======================================

			}
		}
	}

	/**
	 * getFortune() : float – returns the sum of client balance + total account
	 * balance.
	 */
	public float getFortune() {
		float total = 0f; // If I dont do this then when I do getFortune() more than once then it just adds them up to each other.
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				total += accounts[i].getBalance(); // This adds up to all the accounts balance from individual accounts.
			}

		}
		total += getBalance(); // This adds up the CLIENT BALANCE THAT IS SEPERATE FROM ACCOUNT BALANCE.
		return total;
	}
}