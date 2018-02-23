package Theatre;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * ClientList holds a list of all client objects created.
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
 *
 */
public class ClientList implements Serializable
{
	private ArrayList<Client> clientList;
	
	/**
	 * Private constructor designed for the singleton pattern
	 */
	public ClientList()
	{
		clientList = new ArrayList<Client>();
	}
	
	public ArrayList<Client> getClientList()
	{
		return clientList;
	}
	
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
	 * Add client to list of clients
	 * 
	 * @param client the client to be added to the list
	 * @return true when added
	 */
	public void addClient(Client client)
	{
		clientList.add(client);
	}
	
	/**
	 * Remove client from list
	 * @param client the client to be removed from the list
	 * @return true when removed
	 */
	public void removeClient(Client client)
	{
		clientList.remove(client);
	}


	
	
}
