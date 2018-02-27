package Theatre;

import java.io.Serializable;
import java.util.Calendar;
import Abstract.Person;
/**
 * Theater has a name and set seating capacity.
 * It holds all four lists: credit cards, customers, shows, and clients.
 * This also maintains a variety of functions that has a relationship
 * to each four lists when derived from a command sent by the Controller.
 * @author Noah, Randy, Ricky
 */
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
		creditCardList = new CreditCardList();
		customerList = new CustomerList();
		showsList = new ShowList();
		clientList = new ClientList();
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

	/**
	 * Add a customer's credit card to credit card list
	 * @param creditCard credit card object
	 * @return true if added, false if not
	 */
	public boolean addCustomerCreditCard(CreditCard creditCard)
	{
		return creditCardList.addCreditCard(creditCard);
	}

	/**
	 * Gets customer's credit card using the credit card number
	 * @param creditCardNumber credit card number
	 * @return credit card object
	 */
	public CreditCard getCustomerCreditCard(String creditCardNumber)
	{
		return creditCardList.getCreditCard(creditCardNumber);
	}

	/**
	 * Finds customer via customerID. Once found, removes all credit cards
	 * then the customer itself from the lists.
	 * @param customerID Customer ID
	 * @return true if removed, false if not
	 */
	public boolean removeCustomer(long customerID)
	{
		Customer customer = customerList.getCustomer(customerID);
		
		if(customer != null)
		{
			creditCardList.removeAllCustomerCards(customerID);
			return customerList.removeCustomer(customerID);
		}
		return false;
	}

	/**
	 * Remove the customer credit card by credit card number
	 * @param creditCardNumber
	 * @return
	 */
	public boolean removeCustomerCard(String creditCardNumber)
	{
		return creditCardList.removeCreditCard(creditCardNumber);
	}

	/**
	 * Finds the client via clientID. Once found, removes the Client from the list.
	 * @param clientID the Client's ID
	 * @return true if removed, false if not
	 */
	public boolean removeClient(long clientID)
	{
		Client client = clientList.getClient(clientID);
		
		if(client != null)
		{
			return clientList.removeClient(client);
		}
		return false;
	}

	/**
	 * Add show to theater
	 * @param showName name of show
	 * @param clientID client ID
	 * @param begDate start date
	 * @param endDate end date
	 * @return true if added, false if not
	 */
	public boolean addShow(String showName, long clientID, Calendar begDate, Calendar endDate)
	{
		Show show = new Show(showName, clientID, begDate, endDate);
		return showsList.addShow(show);
	}

	/**
	 * Add client to theater
	 * @param client client object
	 * @return true if added, false if didn't
	 */
	public boolean addClient(Client client)
	{
		return clientList.addClient(client);
	}

	/**
	 * Add customer to theater
	 * @param customer customer object
	 */
	public void addCustomer(Customer customer)
	{
		customerList.addCustomer(customer);
	}
}
