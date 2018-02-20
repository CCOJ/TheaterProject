package ClientInfo;
import java.io.Serializable;

/**
 * Client holds information about name, address, and phone number.
 * 
 * A unique id is generated and balance is set to 0.
 * 
 * Current iteration states the balance will remain 0 for now.
 */
public class Client implements Serializable{

	private static final long serialVersionUID = 1L;
	private String clientName, address, phoneNumber;
	private int clientId;
	private double balance;
	
	/**
	 * A client object is created with given inputs, unique ID, and balance set to 0.
	 * Client will be added to clientList once created.
	 * 
	 * @param clientName Name of client
	 * @param address Client's address
	 * @param phoneNumber Client's phone number
	 */
	public Client (String clientName, String address, String phoneNumber) {
		this.clientName = clientName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.clientId = 0; //TODO: Generate unique ID
		this.balance = 0;
	}
	
	/**
	 * Gets name of client's Name
	 * @return clientName
	 */
	public String getClientName() {
		return clientName;
	}
	
	/**
	 * Gets client's address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Get client's phone number
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Get client's ID
	 * @return clientID
	 */
	public int getClientId() {
		return clientId;
	}
	
	/**
	 * Get client's balance
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Set client's name
	 * @param clientName Client's address
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * Set client's address
	 * @param address Client's address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Set client's phone number
	 * @param phoneNumber Client's phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Set client's ID (must be unique)
	 * @param clientId Client's ID
	 */
	public void setclientId(int clientId) {
		this.clientId = clientId;
	}
	
	/**
	 * Set the client's balance
	 * @param balance Client's balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
