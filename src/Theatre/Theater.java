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
	private ArrayList<Customer> customers;
	private ArrayList<Client> clients;
	private ArrayList<Show> shows;

	public Theater(String name)
	{
		this.name = name;
		customers = new ArrayList<>();
		clients = new ArrayList<>();
		shows = new ArrayList<>();
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

	public ArrayList<Customer> getCustomerList()
	{
		return customers;
	}

	public void setCustomerList(ArrayList<Customer> customers)
	{
		this.customers = customers;
	}

	public ArrayList<Client> getClientList()
	{
		return clients;
	}

	public void setClientList(ArrayList<Client> clients)
	{
		this.clients = clients;
	}

	public ArrayList<Show> getShowList()
	{
		return shows;
	}

	public void setShowList(ArrayList<Show> shows)
	{
		this.shows = shows;
	}

	public void addClient(String name, String address, String phoneNumber)
	{
		Person client = new Client(name, address, phoneNumber);
		clients.add((Client) client);
	}   

	public void addCustomer(String name, String address, String phoneNumber, String creditCardNumber, String expirationDate)
	{
		customers.add(new Customer(name, address, phoneNumber, creditCardNumber, expirationDate));
	}
	
	public void addCustomer(Customer customer)
	{
		customers.add(customer);
	}
	
	public void addShow(String showName, int clientID, Calendar begDate, Calendar endDate)
	{
		//Need to check if date overlaps any other events.
		Show show = new Show(showName, clientID, begDate, endDate);
		shows.add(show);
	}
	
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
	
	public void removeCustomer(int customerID)
	{
		for(int i = 0; i < customers.size(); ++i)
		{
			if(customers.get(i).getUniqueID() == customerID)
			{
				customers.get(i).removeAllCreditCards();
				customers.remove(i);
				return;
			}
		}
	}
	
	public void removeCustomerCard(int customerID, String cardNumber)
	{
		for(int i = 0; i < customers.size(); ++i)
		{
			if(customers.get(i).getUniqueID() == customerID)
			{
				customers.get(i).removeCreditCard(cardNumber);
				return;
			}
		}	
	}
	
	public void removeClient(int clientID)
	{
		for(int i = 0; i < shows.size(); ++i)
		{
			if(shows.get(i).getClientID() == clientID)
			{
				Calendar now = new GregorianCalendar(); //gets the current time and date
				
				if(shows.get(i).getEndDate().compareTo((Calendar) now) > 0) //if end date of the show is later in the future than right now, then client can't be removed
				{
					System.out.println("Client not removed");
					return;
				}
			}
		}
		System.out.println("Client Removed");
		clients.remove(clientID);
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
