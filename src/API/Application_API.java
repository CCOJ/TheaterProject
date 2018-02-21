package theaterProject.API;
/**
 * This interface contains the basic functionality of 
 * the application
 * 
 * @author Ricky
 *
 */
public interface Application_API
{
	public void exitApplication();
	public void addClient();
	public void removeClient();
	public void listAllClients();
	public void addCustomer();
	public void removeCustomer();
	public void addCreditCard();
	public void removeCreditCard();
	public void listAllCustomers();
	public void addShowOrPlay();
	public void listAllShows();
	public void storeData();
	public void retrieveData();
	public void help();
}
