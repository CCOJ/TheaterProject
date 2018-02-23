package Theatre;

import java.util.Calendar;
/**
 *
 * @author Noah, Randy, Ricky
 */
public class Show
{
	private String showName;
	private int clientID;
	private Calendar begDate;
	private Calendar endDate;

    public Show(String showName, int clientID, Calendar begDate, Calendar endDate)
    {
        this.showName = showName;
        this.clientID = clientID;
        this.begDate = begDate;
        this.endDate = endDate;
	}

	public String getShowName()
	{
		return showName;
	}

	public void setShowName(String showName)
	{
		this.showName = showName;
	}

	public int getClientID()
	{
		return clientID;
	}

	public void setClientID(int clientID)
	{
		this.clientID = clientID;
	}

	public Calendar getBegDate()
	{
		return begDate;
	}

	public void setBegDate(Calendar begDate)
	{
		this.begDate = begDate;
	}

	public Calendar getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Calendar endDate)
	{
		this.endDate = endDate;
	}

	public String toString()
    {
    	return "showName:" + showName + ", clientID:" + clientID + ", begDate:" + begDate.getTime() + ", endDate:" + endDate.getTime();
    }
}
