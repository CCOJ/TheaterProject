package Theatre;

import java.util.ArrayList;
import java.util.Date;
import Abstract.Person;
/**
 *
 * @author Noah, Randy, Ricky
 */
public class Theater
{

	private String name;
	private int seatingCapacity;
	private ArrayList<Customer> customers;
	private ArrayList<Client> clients;
	private ArrayList<Show> shows;

	public Theater(String name)
	{
		this.name = name;
		seatingCapacity = 3000;
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

	public void addShow(String showName, int clientID, Date begDate, Date endDate)
	{
		Show show = new Show(showName, clientID, begDate, endDate);
		shows.add(show);
	}
	/**
	 * Check to see if the credit card is already on file. If it is, return true
	 * 
	 * @param number
	 * @return 
	 */
	public boolean creditCardExists(String number){
		for(int i = 0; i < customers.size(); i++){
			for(int j = 0; j < customers.get(i).getCreditCards().size(); j ++){
				if(number.equals(customers.get(i).getCreditCards().get(j)
						.getNumber())){
					return true;
				}
			}
		}
		return false;
	}
}
