package Theatre;

import java.io.Serializable;

import Abstract.Person;

/**
* Client holds information about name, address, and phone number.
* A unique id is generated and balance is set to 0. 
* Current iteration states the balance will remain 0 for now.
* 
* @author Ricky, Noah, Randy
*/
public class Client extends Person implements Serializable
{
	private int balance;
	
	/**
	 * A client object is created with given inputs, unique ID, and balance set to 0.
	 * 
	 * @param clientName Name of client
	 * @param address Client's address
	 * @param phoneNumber Client's phone number
	 */
    public Client(String name, String address, String phoneNumber)
    {
        super(name, address, phoneNumber);
        balance = 0;
    }
    
    /**
	 * Get client's ID
	 * @return uniqueID
	 */
	public int getID() {
		return uniqueID;
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
	 * @param uniqueID Client's ID
	 */
	public void setclientId(int uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	/**
	 * Set the client's balance
	 * @param balance Client's balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
    public String toString()
    {
		return "id:" + uniqueID + ", name:" + name + ", address:" + address + 
				", phoneNumber:" + phoneNumber + ", balance:" + balance;
    }
}
