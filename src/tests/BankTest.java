package tests;



import bank.system.core.Account;
import bank.system.core.Bank;
import bank.system.core.Client;

public class BankTest { // This is all example of how this works:
	public static void main(String[] args) {
		
		Bank bank1 = new Bank(); // Creating a new bank (called bank1)
		Client c1 = new Client(1001, "Name", 0); // Creating client c1
		Client c2 = new Client(1002, "Derp", 500); // Creating client c2
		
		
		// Creating accounts, their names suggest where each account will go.
		
		Account c1acc1 = new Account(101, 5000); 
		Account c1acc2 = new Account(102, 10000);
		
		Account c2acc1 = new Account(201, 3000);
		Account c2acc2 = new Account(202, 6000);
		Account c2acc3 = new Account(203, 9000);
		
		
		// Adding accounts to client c1, then printing the total money in the client (both CLIENT BALANCE AND ACCOUNT BALANCE).
		c1.addAccount(c1acc1);
		System.out.println("Client total balance: " + c1.getFortune());
		System.out.println();
		c1.addAccount(c1acc2);
		System.out.println("Client total balance: " + c1.getFortune());
		System.out.println();
		
		// Adding accounts to client c2, then printing the total money in the client (both CLIENT BALANCE AND ACCOUNT BALANCE).
		c2.addAccount(c2acc1);
		System.out.println("Client total balance: " + c2.getFortune());
		System.out.println();
		c2.addAccount(c2acc2);
		System.out.println("Client total balance: " + c2.getFortune());
		System.out.println();
		c2.addAccount(c2acc3);
		System.out.println("Client total balance: " + c2.getFortune());
		System.out.println();
		
		// Adding both clients to the bank. Each time a client is added we check how much money is now in the bank.
		bank1.addClient(c1);
		System.out.println("Bank total balance: " + bank1.getBalance());
		System.out.println();
		
		bank1.addClient(c2);
		System.out.println("Bank total balance: " + bank1.getBalance());
		System.out.println();
		
		c2.autoUpdateAccounts(); // This is the interest calcualtion.
		System.out.println();
		
		c1.removeAccount(101); // Removing account 101 (c1acc1) from the client - THIS WILL MOVE THE ACCOUNT BALANCE TO THE CLIENT BALANCE.
		System.out.println("Client balance: " + c1.getBalance()); // Checking c1 CLIENT BALANCE.
		System.out.println("Client total balance: " + c1.getFortune()); // Checking c1 TOTAL BALANCE.
		System.out.println();
		
		System.out.println("Client total balance: " + c2.getFortune()); // Checking client c2 total money.
		System.out.println();
		System.out.println("Bank total balance: " + bank1.getBalance()); // Checking bank1 total money.
		System.out.println();
		System.out.println("Client balance: " + c2.getBalance()); // Checking c2 CLIENT BALANCE (WITHOUT ACCOUNTS MONEY).
		System.out.println();
		c2.getAccount(201); // Checking the stats of account 201 (c2acc1)
		System.out.println();
		bank1.removeClient(1002); // Removing c2 from the bank.
		System.out.println();
		System.out.println("Bank total balance: " + bank1.getBalance()); // Checking bank total money.
	}

}
