package Ticket;


import java.io.Serializable;
import java.util.Calendar;

/**
 * Regular priced tickets purchased on day of showing
 */
public class RegularTicket extends Ticket implements Serializable
{
	public RegularTicket(Calendar date, double price)
	{
		super(date, "Regular", price);
	}
}