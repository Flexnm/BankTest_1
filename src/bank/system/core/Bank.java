package bank.system.core;

public class Bank {

	// Attributes

	private Client[] clients = new Client[100]; // There are maximum 100 clients for the bank.
	private Logger logService = new Logger("logService name");
	// private accountUpdater; // Is commented out because the instructions didnt define what kind of object this is and it gives a serious error.
	private Logger logger = new Logger("logger-bank name");
	// I guess the two logs are used later, we didnt get to that part of the instructions yet.
	// CTORs
	public Bank() { // Instructions says to leave empty but I just wrote there what I think "instantiates the clients array and logService" means. I dont know...
		// logService = new Logger("logService name");
		// Client[] clients = new Client[100];
	}

	// Methods
	/**
	 * setBalance() : void - this operation returns the bank balance. The balance is
	 * calculated by summing the total clients balance and the total accounts
	 * balance – you should use Client.getFortune() method of each client.
	 * 
	 * ============================== ITS BULLSHIT TIME =======================================
	 * These two, getBalance and setBalance are the other way
	 * around in here than it is written in the instructions. You might want to know
	 * why: simply because when I write it exactly as they ask, it doesnt work. They
	 * ask to set the methods the other way around than how we do getters and
	 * setters. It says in the instructions that "setBalance(): void - this
	 * operation retuns the bank balance" but "void" doesnt return anything.... Also
	 * they want bank current value and bank balance, idk really what is the
	 * difference here. So this is probably a giant mistake or something but now if
	 * you do .getBalance() it will return the total amount of the .getFortune of
	 * all the clients in the bank. Also, if you remove a client from the bank it
	 * will remove its money from the bank balance, so it does calculate the
	 * "current value" or whatever.
	 * 
	 */
	public float getBalance() {
		float bankBalance = 0f;
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] != null) {
				bankBalance += clients[i].getFortune();
			}

		}
		return bankBalance;

	}

	// getBalance() : float – just returns bank current value.
	public void setBalance(float bankBalance) { // I guess this needs a local variable bankBalance defined, but it works
												// without it too. I dont know what this is supposed to do honestly.

	}

	//========================== END OF BULLSHIT =====================
	/**
	 * addClient(Client) : void - add the client to the array and log the operation.
	 * You should seek the array and place the Client where the first null value is
	 * found.
	 * 
	 * @param newClient - is the new client that was added to the bank.
	 */
	public void addClient(Client newClient) {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null) { // Looking for a free spot in the Clients array, similar to addAccount.
				clients[i] = newClient; // Again, similar to addAccount.

				// === LOG THE OPERATION ================
				// 1. create a Log object (with all relevant details)
				long timestamp = 0; // System.currentTimeMillis(); // When
				int clientId = newClient.getId(); // By who
				String description = "Client was added to bank database";
				float amount = newClient.getFortune();
				Log addClientLog = new Log(timestamp, clientId, description, amount);
				// 2. Use the logger attribute to log (store) the Log object
				logger.log(addClientLog);
				// ======================================
				return;

			}
		}
	}

	/**
	 * removeClient(int id) : void - remove the client with the same id from the
	 * array (by assigning a 'null' value to the array[position]). Log the operation
	 */

	public void removeClient(int id) {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] != null) { // Checking first to see if the element is a client.
				if (clients[i].getId() == id) { // now checking if the ID is the correct one.
					// === LOG THE OPERATION ================
					// 1. create a Log object (with all relevant details)
					long timestamp = 0; // System.currentTimeMillis(); // When
					int clientId = clients[i].getId(); // By who
					String description = "Client removed from bank database"; // + accounts[i].getId();
					float amount = clients[i].getFortune();
					Log removeClientLog = new Log(timestamp, clientId, description, amount);
					// 2. Use the logger attribute to log (store) the Log object
					logger.log(removeClientLog);
					// ======================================
					clients[i] = null; // Removing the client from the array.
					return;
				}
			}
		}
	}

	// getClients() : Client []
	public Client[] getClients() { // This doesnt work yet because it will be used in the next stage that we didnt learn yet.
		return clients;
	}

	/**
	 * view logs – prints all logs that are stored in the logger – leave empty for
	 * now
	 */
	// public viewLogs()

	/**
	 * startAccountUpdater() : void - leave empty for now
	 */
	public void startAccountUpdater() {

	}

}
