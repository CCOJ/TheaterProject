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

	public void addCustomerCreditCard(CreditCard creditCard)
	{
		creditCardList.addCreditCard(creditCard);
	}

	public void removeCustomer(long customerID)
	{
		customerList.removeCustomer(customerID);
	}

	public void removeCustomerCard(String cardNumber)
	{
		creditCardList.removeCreditCard(cardNumber);
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

	public void addShow(String showName, long clientID, Calendar begDate, Calendar endDate)
	{
		//Need to check if date overlaps any other events.
		Show show = new Show(showName, clientID, begDate, endDate);
		showsList.addShow(show);
	}

	public void addShow(Show show)
	{
		showsList.addShow(show);
	}

	public void addClient(Person client)
	{
		clientList.addClient((Client) client);
	}

	public void addClient(Client client)
	{
		clientList.addClient(client);
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
