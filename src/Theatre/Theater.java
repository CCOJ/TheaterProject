package Theatre;

import java.io.Serializable;

import Collections.ClientList;
import Collections.CreditCardList;
import Collections.CustomerList;
import Collections.ShowList;
/**
 * Theater has a name and set seating capacity.
 * It holds all four lists: credit cards, customers, shows, and clients.
 * This also maintains a variety of functions that has a relationship
 * to each four lists when derived from a command sent by the Controller.
 * @author Noah, Randy, Ricky
 * 
 */
@SuppressWarnings("serial")
public class Theater implements Serializable
{
	private String name;
	private int seatingCapacity = 3000;

	private CreditCardList creditCardList;
	private CustomerList customerList;
	private ShowList showsList;
	private ClientList clientList;

	public Theater(String name)
	{
		this.name = name;
		creditCardList = CreditCardList.getInstanceOf();
		customerList = CustomerList.getInstanceOf();
		showsList = ShowList.getInstanceOf();
		clientList = ClientList.getInstanceOf();
	}
	/**
	 * Get name of theater
	 * @return name of theater
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Set name of theater
	 * @param name name of theater
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Get seating capacity of theater
	 * @return seating capacity of theater
	 */
	public int getSeatingCapacity()
	{
		return seatingCapacity;
	}

	/**
	 * Set seating capacity of theater
	 * @param seatingCapacity Seating capacity of theater
	 */
	public void setSeatingCapacity(int seatingCapacity)
	{
		this.seatingCapacity = seatingCapacity;
	}

	/**
	 * Get customer list for theater
	 * @return customerList
	 */
	public CustomerList getCustomerList()
	{
		return customerList;
	}

	/**
	 * Get credit card list for theater
	 * @return creditCardList
	 */
	public CreditCardList getCreditCardList()
	{
		return creditCardList;
	}

	/**
	 * Get client list for theater
	 * @return clientList
	 */
	public ClientList getClientList()
	{
		return clientList;
	}

	/**
	 * Get show list for theater
	 * @return showsList
	 */
	public ShowList getShowsList()
	{
		return showsList;
	}
}
