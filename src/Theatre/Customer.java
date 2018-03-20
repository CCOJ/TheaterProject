package Theatre;

import java.io.Serializable;
import Abstract.Person;
import Ticket.Ticket;
import java.util.ArrayList;
/**
 * The customer class. It extends person, adding the credit card property. It
 * allows for multiple cards to be in the persons name.
 * 
 * @author Noah, Randy, Ricky
 */
@SuppressWarnings("serial")
public class Customer extends Person implements Serializable
{
    private ArrayList<Ticket> tickets = new ArrayList<>();
	/**
	 * Creates the customer object with the supplied name, address phone number
	 * credit card and credit card expiration.
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
        public void buyTicket(Ticket ticket){
            tickets.add(ticket);
        }
	@Override
	public String toString()
	{
		return "customerID: " + uniqueID + ", customerName: " +  name + 
				", address: " + address + ", phoneNumber: " + phoneNumber;
	}
}
