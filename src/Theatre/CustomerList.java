package Theatre;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * CustomerList holds a list of all customer objects created.
 * This uses a linked list as the data structure.
 * 
 * Credits given to the textbook authors' (Brahma Dathan
 * and Sarnath Ramnath) class "MemberList" for suggestions.
 * 
 * This also uses the singleton pattern, as we only want a 
 * relationship of a one to many (CustomerList to Customer)
 * relationship. Hence, a singleton design is best for this.
 * 
 * @author Ricky, Noah, Randy
 * @param <E>
 *
 */
public class CustomerList implements Serializable
{
	private final ArrayList<Customer> customerList;
    
    /**
     * Private constructor, for singleton pattern
     */
    public CustomerList()
    {
        customerList = new ArrayList<Customer>();
    }
    
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
    public void removeCustomer(long customerID)
    {
    	for(int i = 0; i < customerList.size(); ++i)
    	{
    		if(customerList.get(i).getUniqueID() == customerID)
    		{
    			customerList.remove(i);
    		}
    	}
    }
}
