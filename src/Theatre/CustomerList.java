package Theatre;


import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author Ricky, Noah, Randy
 *
 */
public class CustomerList implements Serializable
{
	private ArrayList<Customer> customerList;

	/**
	 * Private constructor, for singleton pattern
	 */
	public CustomerList()
	{
		customerList = new ArrayList<Customer>();
	}
	/*
	 * 
	 */
	public ArrayList<Customer> getCustomerList()
	{
		return customerList;
	}
	/**
	 * Finds the customer in the customerList by iterating through the lsit
	 * with customerID
	 * @param customerID
	 * @return 
	 */
	public Customer getCustomer(long customerID)
	{
		for(int i = 0; i < customerList.size(); ++i)
		{
			if(customerList.get(i).getUniqueID() == customerID)
			{
				return customerList.get(i);
			}
		}
		return null;
	}
	/**
	 * Adds the specified customer to the list
	 * @param customer
	 * @return 
	 */
	public void addCustomer(Customer customer)
	{
		customerList.add(customer);
	}
	/**
	 * Removes the specified customer from the list
	 * @param customer
	 * @return 
	 */
	public void removeCustomer(Customer customer)
	{
		for(int i = 0; i < customerList.size(); ++i)
		{
			if(customerList.get(i).equals(customer))
			{
				customerList.remove(i);
				
			}
		}
	}
	/**
	 * Removes the specified customer from the list
	 * @param customer
	 * @return 
	 */
	public boolean removeCustomer(long customerID)
	{
		for(int i = 0; i < customerList.size(); ++i)
		{
			if(customerList.get(i).getUniqueID() == customerID)
			{
				customerList.remove(i);
				return true;
			}
		}
		return false;
	}
}
