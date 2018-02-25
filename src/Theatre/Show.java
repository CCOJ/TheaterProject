package Theatre;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
/**
 * Show holds information of show name, client ID, and period (range of dates)
 * of the show playing.
 *
 * @author Ricky, Noah, Randy
 *
 */
public class Show implements Serializable
{
	private String showName;
	private long clientID;
	private Calendar begDate;
	private Calendar endDate;

	public Show(String showName, long clientID2, Calendar begDate, Calendar endDate)
	{
		this.showName = showName;
		this.clientID = clientID2;
		this.begDate = begDate;
		this.endDate = endDate;
	}
	/**
	 * Get the show's name
	 * @return showName
	 */
	public String getShowName()
	{
		return showName;
	}

	/**
	 * Get the show's client's ID
	 * @return clientID
	 */
	public long getClientID()
	{
		return clientID;
	}

	/**
	 * Gets the show's beginning date
	 * @return begDate
	 */
	public Calendar getBegDate()
	{
		return begDate;
	}

	/**
	 * Get the show's end date
	 * @return endDate
	 */
	public Calendar getEndDate()
	{
		return endDate;
	}

	/**
	 * Set the show's name
	 * @param showName Name of show
	 */
	public void setShowName(String showName)
	{
		this.showName = showName;
	}

	/**
	 * Set the client's ID
	 * @param clientID Client's ID
	 */
	public void setClientId(int clientID)
	{
		this.clientID = clientID;
	}

	/**
	 * Set the show's beginning date
	 * @param begDate
	 */
	public void setBegDate(Calendar begDate)
	{
		this.begDate = begDate;
	}

	/**
	 * Set the show's end date
	 * @param endDate
	 */
	public void setEndDate(Calendar endDate)
	{
		this.endDate = endDate;
	}

	/**
	 * Gets the date ranges for the show premiere
	 * @return The date range
	 */
	public String showingDatesToString()
	{
		StringBuilder strBuild = new StringBuilder();
		String startDate, endingDate;
		
		LocalDate localStartDate = begDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		strBuild.append(localStartDate.getYear() + "/" + localStartDate.getMonthValue() + "/"+ localStartDate.getDayOfMonth());
		startDate = strBuild.toString();
		
		strBuild.delete(0, strBuild.length());
		
		LocalDate localEndDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		strBuild.append(localEndDate.getYear() + "/" + localEndDate.getMonthValue() + "/"+ localEndDate.getDayOfMonth());
		endingDate = strBuild.toString();

		return startDate + " to " + endingDate;
	}

	/**
	 * Returns the string form of the show's name, client ID, and date range
	 * of the show
	 */
	public String toString()
	{
		return "showName:" + showName + ", clientID:" + clientID +
				", dates:" + showingDatesToString();
	}
}
