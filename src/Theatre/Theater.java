package Theatre;

import java.io.Serializable;
import java.util.Calendar;
import Abstract.Person;
/**
 *
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getSeatingCapacity()
	{
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity)
	{
		this.seatingCapacity = seatingCapacity;
	}

	public CustomerList getCustomerList()
	{
		return customerList;
	}

	public CreditCardList getCreditCardList()
	{
		return creditCardList;
	}	

	public ClientList getClientList()
	{
		return clientList;
	}

	public ShowList getShowsList()
	{
		return showsList;
	}

	public boolean addCustomerCreditCard(CreditCard creditCard)
	{
		return creditCardList.addCreditCard(creditCard);
	}

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

	public boolean removeCustomerCard(String cardNumber)
	{
		return creditCardList.removeCreditCard(cardNumber);
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

	public boolean addShow(String showName, long clientID, Calendar begDate, Calendar endDate)
	{
		//Need to check if date overlaps any other events.
		Show show = new Show(showName, clientID, begDate, endDate);
		return showsList.addShow(show);
	}

	public boolean addShow(Show show)
	{
		return showsList.addShow(show);
	}

	public void addClient(Person client)
	{
		clientList.addClient((Client) client);
	}

	public boolean addClient(Client client)
	{
		return clientList.addClient(client);
	}

	public void addClient(String name, String address, String phoneNumber)
	{
		Person client = new Client(name, address, phoneNumber);
		clientList.addClient((Client) client);
	}

	public void addCustomer(Customer customer)
	{
		customerList.addCustomer(customer);
	}
}
