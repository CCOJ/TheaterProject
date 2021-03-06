package Theatre;

import java.io.Serializable;
import Collections.ClientList;
import Collections.CreditCardList;
import Collections.CustomerList;
import Collections.ShowList;
import Collections.TicketList;
import Utils.Strings;

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
	private static Theater theater;
	private String name;
	private double balance;
	private int seatingCapacity = 3000;

	private CreditCardList creditCardList;
	private CustomerList customerList;
	private ShowList showsList;
	private ClientList clientList;
	private TicketList ticketList;

	/**
	 * 
	 * @param name
	 */
	private Theater()
	{
		this.name = Strings.CINEMA_NAME;
		this.balance = 0;
		creditCardList = CreditCardList.getInstanceOf();
		customerList = CustomerList.getInstanceOf();
		showsList = ShowList.getInstanceOf();
		clientList = ClientList.getInstanceOf();
		ticketList = TicketList.getInstanceOf();
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
	 * Get credit card list for theater
	 * @return creditCardList
	 */
	public CreditCardList getCreditCardList()
	{
		return creditCardList;
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
	 * 
	 */
	public static Theater getInstanceOf()
	{
		if(theater == null)
		{
			theater = new Theater();
		}
		return theater;
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
	 * Get seating capacity of theater
	 * @return seating capacity of theater
	 */
	public int getSeatingCapacity()
	{
		return seatingCapacity;
	}

	/**
	 * Get show list for theater
	 * @return showsList
	 */
	public ShowList getShowsList()
	{
		return showsList;
	}

	/**
	 * Get ticket list for theater
	 * @return ticketList
	 */
	public TicketList getTicketList()
	{
		return ticketList;
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
	 * Set seating capacity of theater
	 * @param seatingCapacity Seating capacity of theater
	 */
	public void setSeatingCapacity(int seatingCapacity)
	{
		this.seatingCapacity = seatingCapacity;
	}

	/**
	 * 
	 * @param amount
	 */
	public void addBalance(double amount)
	{
		balance += amount;
	}
}