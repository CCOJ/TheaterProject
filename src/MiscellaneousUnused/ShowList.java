package MiscellaneousUnused;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * This holds a list of all the shows created.
 * This uses a linked list data structure.
 * 
 * Most of the code was reused based on the authors' code.
 * 
 * This also uses a singleton pattern, as there is
 * a one to many relationship (showList to show).
 * 
 * @author Ricky, Noah, Randy
 *
 */
public class ShowList implements Serializable{

	private List shows = new LinkedList();
	private static ShowList showList;
	
	/**
	 * Private constructor to support the singleton pattern
	 */
	private ShowList() {
	}
	
	/**
	 * Only one show list can exist via the singleton pattern.
	 * If a showList was not created, one will be made.
	 * Otherwise, it returns the showList.
	 * @return showList
	 */
	public static ShowList instance() {
		if (showList == null) {
			return (showList = new ShowList());
		} else {
			return showList;
		}
	}
	
	/**
	 * Finds if a show is in the list using showName
	 * @param showName Name of show
	 * @return show object
	 */
	public Show findShow(String showName) {
		for (Iterator iterator = shows.iterator(); iterator.hasNext();) {
			Show show = (Show) iterator.next();
			
			if (show.getShowName().equals(showName)) {
				return show;
			}
		}
		return null;
	}
	
	/**
	 * Adds a show to list of shows
	 * @param show The show to be added
	 * @return true once added to the list
	 */
	public boolean addShow(Show show) {
		shows.add(show);
		return true;
	}
	
	/**
	 * Saves the showList object to disk.
	 * If it is unable to, it returns an error
	 * stating it cannot save with the reason why.
	 * 
	 * @param output the stream for write
	 */
	private void writeObject(java.io.ObjectOutputStream output) {
		try {
			output.defaultWriteObject();
			output.writeObject(showList);
		} catch (IOException ioe) {
			System.out.println("Could not save showList to disk: ");
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Loads showList object from disk.
	 * Otherwise, it prints out errors with
	 * reasons why.
	 * @param input the stream for input
	 */
	private void readObject(java.io.ObjectInputStream input) {
		try {
			if (showList != null) {
				return;
			} else {
				input.defaultReadObject();
				if (showList == null) {
					showList = (ShowList) input.readObject();
				} else {
					input.readObject();
				}
			}
		} catch (IOException ioe) {
			System.out.println("Could not load showList from disk: ");
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			System.out.println("Could not find class: ");
			cnfe.printStackTrace();
		}
	}
	
	/**
	 * Returns the list of shows
	 */
	public String toString() {
		return shows.toString();
	}
}
