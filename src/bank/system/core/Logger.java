package bank.system.core;

/**
 * 
 * @author Ofir
 * 
 *         A Logger object is used for storing Log objects in some repository
 *         (database, file, console)
 *
 */
public class Logger {
	// Attributes
	private String driverName;

	// CTORs
	public Logger(String driverName) {
		this.driverName = driverName;
	}

	// Methods
	/**
	 * print Log on screen
	 * 
	 * @param log the log object to be stored (printed to screen)
	 */
	public void log(Log log) {
		System.out.println(log.getData());
	}

	public Log[] getLogs() {
		return null;
	}

	/**
	 * The getLogs method is not yet supported.
	 * 
	 * @return All logs stored in the system (for now returns null)
	 */

}
