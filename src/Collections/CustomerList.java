package Collections;


import java.io.Serializable;
import java.util.ArrayList;

import Theatre.Customer;
/**
 * 
 * @author Noah, Randy, Ricky
 *
 */
@SuppressWarnings("serial")
public class CustomerList implements Serializable
{
	private static CustomerList instance;
	private ArrayList<Customer> customerList;

	/**
	 * Private constructor, for singleton pattern
	 */
	private CustomerList()
	{
		customerList = new ArrayList<Customer>();
	}
	/**
	 * 
	 * @return
	 */
	public static CustomerList getInstanceOf()
	{
		if(instance == null)
		{
			instance = new CustomerList();
		}
		return instance;
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
			if(customerList.get(i).getID() == customerID)
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
	 * @param customerID customer ID
	 * @return true when removed, false if not
	 */
	public boolean removeCustomer(long customerID)
	{
		for(int i = 0; i < customerList.size(); ++i)
		{
			if(customerList.get(i).getID() == customerID)
			{
				customerList.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if customer exists
	 * @param customerID customer ID
	 * @return true if exists, false if not
	 */
	public boolean customerExists(long customerID)
	{
		for(int i = 0; i < customerList.size(); ++i)
		{
			if(customerList.get(i).getID() == customerID)
			{
				return true;
			}
		}
		return false;
	}
}
