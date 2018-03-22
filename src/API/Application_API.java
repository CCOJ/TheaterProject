package API;

/**
 * This interface contains the basic functionality of 
 * the application
 * 
 * @author Noah, Randy, Ricky
 *
 */
public interface Application_API
{
	/**
	 * Exit application
	 * @return 
	 */
	public boolean exitApplication();

	/**
	 * Add client to client list
	 * @return 
	 */
	public void addClient();

	/**
	 * Remove client from client list
	 * @return 
	 */
	public void removeClient();

	/**
	 * List all clients from client list
	 */
	public void listAllClients();

	/**
	 * Add customer to customer list
	 */
	public void addCustomer();

	/**
	 * Remove customer from customer list
	 */
	public void removeCustomer();

	/**
	 * Add credit card to credit card list
	 */
	public void addCreditCard();

	/**
	 * Remove credit card from credit card list
	 */
	public void removeCreditCard();

	/**
	 * List all customers from customer list
	 */
	public void listAllCustomers();

	/**
	 * Add show to show list
	 */
	public void addShowOrPlay();

	/**
	 * List all shows from show list
	 */
	public void listAllShows();

	/**
	 * Serialize data
	 * @return true if saved, false if not
	 */
	public void storeData();

	/**
	 * Deserialize data
	 */
	public void retrieveData();

	/**
	 * Returns information for help information
	 * @return 
	 */
	public void help();
	
	/**
	 * 
	 */
	public void sellRegularTickets();
	
	/**
	 * 
	 */
	public void sellAdvanceTickets();
	
	/**
	 * 
	 */
	public void sellStudentAdvanceTickets();
	
	/**
	 * 
	 */
	public void payClient();
	
	/**
	 * 
	 */
	public void printAllTicketsForGivenDay();
}
