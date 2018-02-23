package Theatre;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Ricky, Noah, Randy
 *
 */
public class ClientList implements Serializable
{
	private ArrayList<Client> clientList;

	public ClientList()
	{
		clientList = new ArrayList<Client>();
	}

	/**
	 * Gets the list of clients
	 * @return clientList
	 */
	public ArrayList<Client> getClientList()
	{
		return clientList;
	}

	/**
	 * Remove client via clientID if known without using findClient()
	 * @param clientID the Client's ID
	 */
	public void removeClient(long clientID)
	{
		//Check if all shows have played. If one's end date is not past todays date, don't remove.
		/*
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
		 */
		for(int i = 0; i < clientList.size(); ++i)
		{
			if(clientList.get(i).getID() == clientID)
			{
				clientList.remove(i);
			}
		}

	}

	/**
	 * Finds the Client object via clientID
	 * @param clientID the Client's ID
	 * @return the object if found, or null if not found
	 */
	public Client findClient(long clientID) {
		for(int i = 0; i < clientList.size(); ++i) {
			if(clientList.get(i).getID() == clientID) {
				return clientList.get(i);
			}
		}
		return null;
	}
	/**
	 * Add client to list of clients
	 * 
	 * @param client the client to be added to the list
	 * @return true when added
	 */
	public boolean addClient(Client client)
	{
		return clientList.add(client);
	}

	/**
	 * Remove client from list
	 * @param client the client to be removed from the list
	 * @return true when removed
	 */
	public boolean removeClient(Client client)
	{
		return clientList.remove(client);
	}
}
