package Theatre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Abstract.Person;
/**
 *
 * @author Noah, Randy, Ricky
 */
public class Theater implements Serializable
{

	private String name;
	private int seatingCapacity = 3000;
	//private ArrayList<Customer> customers;
	//private ArrayList<Client> clients;
	//private ArrayList<Show> shows;
	private CreditCardList creditCardList;
	private CustomerList customerList;
	private ShowList showsList;
	private ClientList clientList;

	public Theater(String name)
	{
		this.name = name;
		//customers = new ArrayList<>();
		//clients = new ArrayList<>();
		//shows = new ArrayList<>();
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
	

	/*
	public ArrayList<Customer> getCustomerList()
	{
		return customers;
	}

	public void setCustomerList(ArrayList<Customer> customers)
	{
		this.customers = customers;
	}
	*/

	/*
	public ArrayList<Client> getClientList()
	{
		return clients;
	}

	public void setClientList(ArrayList<Client> clients)
	{
		this.clients = clients;
	}
	*/

	/*
	public ArrayList<Show> getShowList()
	{
		return shows;
	}

	public void setShowList(ArrayList<Show> shows)
	{
		this.shows = shows;
	}
	*/

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
	
	
	/*
	public void addCustomer(Customer customer)
	{
		customers.add(customer);
	}
	*/
	
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
	/*
	public void addCustomerCreditCard(int customerID, CreditCard card)
	{
		for(int i = 0; i < customers.size(); ++i)
		{
			if(customers.get(i).getUniqueID() == customerID)
			{
				customers.get(i).addCreditCard(card);
				return;
			}
		}
	}
	*/
	
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
	
	public void removeClient(long clientID)
	{
		clientList.removeClient(clientID);
	}

	public void addCustomer(String customerName, String address, String phoneNumber, CreditCard creditCard)
	{
		
		
	}
	/**
	 * Check to see if the credit card is already on file. If it is, return true
	 * 
	 * @param number
	 * @return 
	 */
	/*
	public boolean creditCardExists(String number){
		for(int i = 0; i < customers.size(); i++){
			for(int j = 0; j < customers.get(i).getCreditCards().size(); j ++){
				if(number.equals(customers.get(i).getCreditCards().get(j)
						.getCardNumber())){
					return true;
				}
			}
		}
		return false;
	}
	*/












}
