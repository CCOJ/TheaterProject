package MiscellaneousUnused;

import java.io.Serializable;

/**
 * Show holds information of show name, client ID, and period (range of dates)
 * of the show playing.
 * 
 * @author Ricky, Noah, Randy
 *
 */
public class Show implements Serializable{
	private String showName, clientId, period;
	//TODO: period can be changed, it's a String for now as a placeholder
	//Maybe we can use the Calendar object?
	
	//TODO: We need to be able to verify that the clientID does exist in clientList
	//first before the show can be added. Maybe we'll do verification in the theater class?
	
	/**
	 * Creates the show object with a name, client ID, and period it shows
	 * @param showName Name of the show
	 * @param clientId Client's ID
	 * @param start Starting period
	 * @param end Ending period
	 */
	public Show (String showName, String clientId, String start, String end) {
		this.showName = showName;
		this.clientId = clientId;
		period = start + " to " + end; //TODO: period can be changed, temporary for now
	}
	
	/**
	 * Get the show's name
	 * @return showName
	 */
	public String getShowName() {
		return showName;
	}
	
	/**
	 * Get the show's client's ID
	 * @return clientID
	 */
	public String getClientId() {
		return clientId;
	}
	
	/**
	 * Get the show's range of dates for showing
	 * @return period
	 */
	public String getPeriod() {
		return period; //TODO: Temporary for now
	}
	
	/**
	 * Set the show's name
	 * @param showName Name of show
	 */
	public void setShowName(String showName) {
		this.showName = showName;
	}
	
	/**
	 * Set the client's ID
	 * @param clientId Client's ID
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	/**
	 * TEMPORARY: Set's the show's period
	 * @param start Start of period
	 * @param end End of period
	 */
	public void setPeriod(String start, String end) {
		period = start + " to " + end; //TODO: We'll change this
	}
	
	/**
	 * Returns the string form of the show's name, client ID, and range of dates
	 * of the show
	 */
	public String toString() {
		String string = "Show name: " + showName + ", Client ID: " + clientId +
				"Show period: " + period;
		return string;
	}
}
