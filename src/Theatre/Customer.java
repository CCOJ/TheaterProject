package Theatre;

import java.io.Serializable;
import Abstract.Person;
/**
 * The customer class. It extends person, adding the credit card property. It
 * allows for multiple cards to be in the persons name.
 * 
 * @author Noah
 */
public class Customer extends Person implements Serializable
{
	/**
	 * Creates the customer object with the supplied name, address phone number
	 * credit card and creadit card expiration.
	 * 
	 * @param name
	 * @param address
	 * @param phoneNumber
	 */
	public Customer(String name, String address, String phoneNumber)
	{
		super(name, address, phoneNumber);
	}
	/**
	 * Returns the string form of the client object's information
	 */
	@Override
	public String toString()
	{
		return "customerID: " + uniqueID + ", customerName: " +  name + ", address: " + address + ", phoneNumber: " + phoneNumber;
	}
}
