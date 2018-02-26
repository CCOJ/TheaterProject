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
	public boolean removeClient(long clientID)
	{
		//Check if all shows have played. If one's end date is not past todays date, don't remove.

		for(int i = 0; i < clientList.size(); ++i)
		{
			if(clientList.get(i).getID() == clientID)
			{
				clientList.remove(i);
				return true;
			}
		}
		return false;
	}



	/**
	 * Finds the Client object via clientID
	 * @param clientID the Client's ID
	 * @return the object if found, or null if not found
	 */
	public Client getClient(long clientID)
	{
		for(int i = 0; i < clientList.size(); ++i)
		{
			if(clientList.get(i).getID() == clientID)
			{
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

	public boolean clientExists(long clientID)
	{
		for(int i = 0; i < clientList.size(); ++i)
		{
			if(clientList.get(i).getID() == clientID)
			{
				return true;
			}
		}
		return false;
	}

}
