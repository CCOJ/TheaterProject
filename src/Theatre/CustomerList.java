package Theatre;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * CustomerList holds a list of all client objects created.
 * This uses a linked list as the data structure.
 * 
 * Credits given to the textbook authors' (Brahma Dathan
 * and Sarnath Ramnath) class "MemberList" for suggestions.
 * 
 * This also uses the singleton pattern, as we only want a 
 * relationship of a one to many (ClientList to Client)
 * relationship. Hence, a singleton design is best for this.
 * 
 * @author Ricky, Noah, Randy
 * @param <E>
 *
 */
@SuppressWarnings("serial")
public class CustomerList implements Serializable{
    private List customers = new LinkedList();
    private static CustomerList customerList;
    
    /**
     * Private constructor, for singleton pattern
     */
    private CustomerList(){
        
    }
    
    /**
     * With the singleton pattern, we create one available instance of
     * customerList at a time. It creates one if necessary 
     */
    public static CustomerList instance(){
        if(customerList == null){
            return (customerList = new CustomerList());
        }
        else{
            return customerList;
        }
    }
    
    /**
     * Finds the customer in the customerList by iterating through the lsit
     * with customerID
     * @param customerID
     * @return 
     */
    public Customer findCustomer(String customerID){
        for(Iterator iterator = customers.iterator(); iterator.hasNext();){
            Customer customer = (Customer)iterator.next();
            
            if(customer.getCustomerID().equals(customerID)){
                return customer;
            }
        }
        return null;
    }
    /**
     * Adds the specified customer to the list
     * @param customer
     * @return 
     */
    public boolean addCustomer(Customer customer){
        customers.add(customer);
        return true;
    }
    /**
     * Removes the specified customer from the list
     * @param customer
     * @return 
     */
    public boolean removeCustomer(Customer customer){
        customers.remove(customer);
        return true;
    }
    /**
     * Saves the customerList to the disk
     * Returns an error if it cannot, with the reason why
     * @param output 
     */
    private void writeObject(java.io.ObjectOutputStream output){
        try{
            output.defaultWriteObject();
            output.writeObject(customerList);
            
        }
        catch(IOException io){
            System.out.println("Could not save customerList to disk: ");
            io.printStackTrace();
        }
    }
    
	/**
	 * Loads clientList object from disk.
	 * Otherwise, it prints out errors with
	 * reasons why.
	 * @param input the stream for input
	 */
	private void readObject(java.io.ObjectInputStream input) {
		try {
			if (customerList != null) {
				return;
			} else {
				input.defaultReadObject();
				if (customerList == null) {
					customerList = (CustomerList) input.readObject();
				} else {
					input.readObject();
				}
			}
		} catch (IOException ioe) {
			System.out.println("Could not load clientList from disk: ");
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			System.out.println("Could not find class: ");
			cnfe.printStackTrace();
		}
	}
	
	/**
	 * Returns a list of all the clients in clientList
	 */
	public String toString() {
		return customers.toString();
	}
}
