package Theatre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

	public boolean addShow(Show show)
	{
		
		//Check to make sure that dates do not overlap
		showsList.add(show);
		return true;
	}
	
	public boolean isEveryShowListingInPast(long clientID)
	{
		for(int i = 0; i < showsList.size(); ++i)
		{
			if(showsList.get(i).getClientID() == clientID)
			{
				//BUGGED if same day is entered as todays date, will still delete object
				Calendar today = new GregorianCalendar(); //gets the current time and date
				today.set(Calendar.HOUR_OF_DAY, 0);
				today.set(Calendar.MINUTE, 0);
				today.set(Calendar.SECOND, 0);
		
				if(showsList.get(i).getEndDate().getTimeInMillis() >= today.getTimeInMillis()) //if end date of the show is later in the future than right now, then client can't be removed
				{
					System.out.println(showsList.get(i).getEndDate().getTime() + " " + today.getTime());
					System.out.println(showsList.get(i).getEndDate().getTimeInMillis() + " " + today.getTimeInMillis());

					return false;
				}
			}
		} 
		return true;
	}
}
