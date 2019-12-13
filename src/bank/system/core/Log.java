package bank.system.core;

/**
 * The Log class represents a single bank transaction
 */
public class Log {

	// Attributes
	private long timestamp; // When
	private int clientId; // By who
	private String description; // What was the transaction
	private float amount; // Transaction amount

	// CTORs
	public Log(long timestamp, int clientId, String description, float amount) {
		this.timestamp = timestamp;
		this.clientId = clientId;
		this.description = description;
		this.amount = amount;
	}

	// Methods:
	/**
	 * The getData method returns a textual representation of a Log object.
	 * 
	 * @return The textual representation of a Log object.
	 */
	public String getData() {
		String str = "LOG: time = " + timestamp;
		str += ", client id = " + clientId;
		str += ", description = " + description;
		str += ", amount = " + amount;
		return str;
	}

}
