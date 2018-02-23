package Theatre;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author Ricky, Noah, Randy
 * 
 */
public class ShowList implements Serializable{

	private ArrayList<Show> showsList;

	public ShowList()
	{
		showsList = new ArrayList<Show>();
	}

	public ArrayList<Show> getShowsList()
	{
		return showsList;
	}

	public void addShow(Show show)
	{
		//Check to make sure that dates do not overlap
		showsList.add(show);
	}
}
