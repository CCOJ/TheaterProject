package Theatre;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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

	private final ArrayList<Show> showsList;
	
	/**
	 * Private constructor to support the singleton pattern
	 */
	public ShowList()
	{
		showsList = new ArrayList<Show>();
	}
	
	public ArrayList<Show> getShowsList()
	{
		return showsList;
	}

	public Show getShow()
	{/*
		for(int i = 0; i < showsList.size(); ++i)
		{
			if(showsList.get(i))
			{
				
			}
		}*/
		return null;
	}
	
	public void addShow(Show show)
	{
		//Check to make sure that dates do not overlap
		showsList.add(show);
	}

}
