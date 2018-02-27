package Theatre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Utils.DateUtils;
/**
 * ShowList holds show objects and checks for any overlaps.
 * @author Ricky, Noah, Randy
 * 
 */
public class ShowList implements Serializable{

	private ArrayList<Show> showsList;
	
	public ShowList()
	{
		showsList = new ArrayList<Show>();
	}

	/**
	 * Get shows list
	 * @return showsList
	 */
	public ArrayList<Show> getShowsList()
	{
		return showsList;
	}

	/**
	 * Add show to shows list
	 * @param show show object
	 * @return true when added, false when not
	 */
	public boolean addShow(Show show)
	{
		showsList.add(show);
		return true;
	}

	/**
	 * Checks if every show is in the past
	 * @param clientID client ID
	 * @return true if they are, false if not
	 */
	public boolean isEveryShowListingInPast(long clientID)
	{
		for(int i = 0; i < showsList.size(); ++i)
		{
			if(showsList.get(i).getClientID() == clientID)
			{
				Calendar today = DateUtils.getGregorianCalendarStartingTodayAtBeginningOfDay();
		
				if(showsList.get(i).getEndDate().getTimeInMillis() >= today.getTimeInMillis()) //if end date of the show is later in the future than right now, then client can't be removed
				{
					return false;
				}
			}
		} 
		return true;
	}

	/**
	 * Checks if the show overlaps other shows
	 * @param begDate start date
	 * @param endDate end date
	 * @return true if overlap, false if no overlap
	 */
	public boolean isShowOverlappingOtherShows(Calendar begDate, Calendar endDate) //returns true if show overlaps other shows
	{
		for(int i = 0; i < showsList.size(); ++i)
		{
			if(begDate.getTimeInMillis() > showsList.get(i).getBegDate().getTimeInMillis())
			{
				if(begDate.getTimeInMillis() < showsList.get(i).getEndDate().getTimeInMillis())
				{
					return true;
				}
			}
			if(begDate.getTimeInMillis() < showsList.get(i).getBegDate().getTimeInMillis())
			{
				if(endDate.getTimeInMillis() > showsList.get(i).getBegDate().getTimeInMillis())
				{
					return true;
				}
			}
			if(begDate.getTimeInMillis() == showsList.get(i).getBegDate().getTimeInMillis())
			{
				return true;
			}
		}
		return false;
	}
}
