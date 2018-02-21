/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Theatre;

import java.util.Date;

/**
 *
 * @author Noah
 */
public class Show
{
	private String showName;
	private int clientID;
	private Date begDate;
	private Date endDate;
	
    public Show(String showName, int clientID, Date begDate, Date endDate)
    {
        this.showName = showName;
        this.clientID = clientID;
    }
    
    public String toString()
    {
    	return "showName:" + showName + ", clientID:" + clientID + ", begDate:" + "FIXME" + ", endDate" + "FIXME";
    }
}
