package ClientInfo;

/**
 * Client holds information about name, address, and phone number.
 * 
 * A unique id is generated and balance is set to 0.
 * 
 * Current iteration states the balance will remain 0 for now.
 */
public class Client {

	protected String clientName, address, phoneNumber;
	protected int clientID;
	protected double balance;
	
	/**
	 * Client constructor that asks for the given input of name, address, and phone number.
	 * Then, the unique id is generated and balance gets set to 0.
	 * 
	 * @param clientName Name of client
	 * @param address Client's address
	 * @param phoneNumber Client's phone number
	 */
	public Client (String clientName, String address, String phoneNumber) {
		this.clientName = clientName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.clientID = 0; //TODO: Generate unique ID
		this.balance = 0;
	}
	
	/**
	 * Change the client's balance
	 * 
	 * @param balance Client's balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
