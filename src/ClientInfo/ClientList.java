package ClientInfo;

import java.io.IOException;
import java.io.Serializable;
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
 * @param <E>
 *
 */
public class ClientList implements Serializable {
	private List clients = new LinkedList();
	private static ClientList clientList;
	
	/**
	 * Private constructor designed for the singleton pattern
	 */
	private ClientList() {
	}
	
	/**
	 * Singleton pattern allows us to return the only
	 * created clientList without creating anymore.
	 * This also creates one, if none were created.
	 * 
	 * @return clientList
	 */
	public static ClientList instance() {
		if (clientList == null) {
			return (clientList = new ClientList());
		} else {
			return clientList;
		}
	}
	
	/**
	 * Finds the client in clientList if they exist.
	 * This iterates through clientList until clientId
	 * has a match with a client, or to the end of the
	 * list.
	 * 
	 * @param clientID client's ID
	 * @return client object
	 */
	public Client findClient(String clientID) {
		for (Iterator iterator = clients.iterator(); iterator.hasNext(); ) {
			Client client = (Client) iterator.next();
			
			if (client.getClientId().equals(clientID)) {
				return client;
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
	public boolean addClient(Client client) {
		clients.add(client);
		return true;
	}
	
	/**
	 * Saves the clientList object to disk.
	 * If it is unable to, it returns an error
	 * stating it cannot save with the reason why.
	 * 
	 * @param output the stream for write
	 */
	private void writeObject(java.io.ObjectOutputStream output) {
		try {
			output.defaultWriteObject();
			output.writeObject(clientList);
		} catch (IOException ioe) {
			System.out.println("Could not save clientList to disk: ");
			ioe.printStackTrace();
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
			if (clientList != null) {
				return;
			} else {
				input.defaultReadObject();
				if (clientList == null) {
					clientList = (ClientList) input.readObject();
				} else {
					input.readObject();
				}
			}
		} catch (IOException ioe) {
			System.out.println("Could not load clientList from disk: ");
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			System.out.println("Could not find classL ");
			cnfe.printStackTrace();
		}
	}
	
	/**
	 * Returns a list of all the clients in clientList
	 */
	public String toString() {
		return clients.toString();
	}
}
