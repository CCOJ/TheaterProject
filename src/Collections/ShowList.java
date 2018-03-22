package Collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Theatre.Show;
import Utils.DateUtils;

/**
 * ShowList holds show objects and checks for any overlaps.
 * @author Noah, Randy, Ricky
 * 
 */
@SuppressWarnings("serial")
public class ShowList implements Serializable{

	private static ShowList instance;
	private ArrayList<Show> showsList;
	
	/**
	 * 
	 */
	private ShowList()
	{
		showsList = new ArrayList<Show>();
	}
	
	/**
	 * 
	 * @return
	 */
	public static ShowList getInstanceOf()
	{
		if(instance == null)
		{
			instance = new ShowList();
		}
		return instance;
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
	public boolean isEveryShowListingInClientsPast(long clientID)
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
	
	/**
	 * Advance Tickets must be sold at least a day in advance. This function checks if today 
	 * starting at YYYY/MM/DD/00:00:00 is at least one day before the start Date of the show.
	 */
	public boolean isTicketPurchasedInAdvance(Show show)
	{
		Calendar today = new GregorianCalendar();
	
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		//today.set(Calendar.MILLISECOND, 0);
		
		show.getBegDate().set(Calendar.HOUR_OF_DAY, 0);
		show.getBegDate().set(Calendar.MINUTE, 0);
		show.getBegDate().set(Calendar.SECOND, 0);
		
		if(today.getTimeInMillis() < show.getBegDate().getTimeInMillis())
		{
			return true;
		}
		
		/*
		for(int i = 0; i < showsList.size(); ++i)
		{
			Calendar date = showsList.get(i).getBegDate();
			//date.set(Calendar.DAY_OF_MONTH, -1);
			date.set(Calendar.HOUR_OF_DAY, 0);
			date.set(Calendar.MINUTE, 0);
			date.set(Calendar.SECOND, 0);

			System.out.println(today.getTimeInMillis() + " > " + date.getTimeInMillis());
			
			if(today.getTimeInMillis() < date.getTimeInMillis())
			{
				return true;
			}
		}
		*/
		
		return false;
	}

	/**
	 * Finds show with the given date
	 * @param date
	 * 		show date
	 * @return the Show object
	 */
	public Show getShow(Calendar date)
	{
		for (int i = 0; i < showsList.size(); i++)
		{
			if (date.getTimeInMillis() >= showsList.get(i).getBegDate().getTimeInMillis() &&
					date.getTimeInMillis() <= showsList.get(i).getEndDate().getTimeInMillis())
			{
				return showsList.get(i);
			}
		}
		return null;
	}
}
