package Collections;

import java.io.Serializable;
import java.util.ArrayList;

import Ticket.Ticket;

/**
 * TicketList holds ticket objects and checks for any overlaps.
 * 
 * @author Noah, Randy, Ricky
 * 
 */
@SuppressWarnings("serial")
public class TicketList implements Serializable{

	private static TicketList instance;
	private ArrayList<Ticket> ticketList;
	
	private TicketList()
	{
		ticketList = new ArrayList<Ticket>();
	}
	
	public static TicketList getInstanceOf()
	{
		if(instance == null)
		{
			instance = new TicketList();
		}
		return instance;
	}

	/**
	 * Get ticket list
	 * @return ticketList
	 */
	public ArrayList<Ticket> getTicketList()
	{
		return ticketList;
	}

	/**
	 * Add ticket to ticket list
	 * @param ticket ticket object
	 * @return true when added, false when not
	 */
	public boolean addTicket(Ticket ticket)
	{              
		ticketList.add(ticket);
		return true;
	}

}
