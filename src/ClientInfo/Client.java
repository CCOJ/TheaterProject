package ClientInfo;
import com.project1.Theatre.Person;
import java.io.Serializable;

/**
 * Client holds information about name, address, and phone number.
 * A unique id is generated and balance is set to 0. 
 * Current iteration states the balance will remain 0 for now.
 * 
 * @author Ricky, Noah, Randy
 */
public class Client extends Person implements Serializable{

	private String clientId;
	private double balance;
	
	/**
	 * A client object is created with given inputs, unique ID, and balance set to 0.
	 * 
	 * @param clientName Name of client
	 * @param address Client's address
	 * @param phoneNumber Client's phone number
	 */
	public Client (String clientName, String address, String phoneNumber) {
		super(clientName, address, phoneNumber);
		this.clientId = "0"; //TODO: Generate unique ID -Randy
		this.balance = 0;
	}	
	/**
	 * Get client's ID
	 * @return clientID
	 */
	public String getClientId() {
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
	 * Set client's ID (must be unique)
	 * @param clientId Client's ID
	 */
	public void setclientId(String clientId) {
		this.clientId = clientId;
	}
	
	/**
	 * Set the client's balance
	 * @param balance Client's balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/**
	 * Returns the string form of the client object's information
	 */
	public String toString() {
		String string = "Client name: " + name + ", Address: " + address +
				", Phone number: " + phoneNumber + ", Client ID: " + clientId +
				", balance: " + balance;
		return string;
	}
	
}
