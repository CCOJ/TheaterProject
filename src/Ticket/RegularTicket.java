package Ticket;


import java.util.Calendar;

/**
 * Regular priced tickets purchased on day of showing
 */
public class RegularTicket extends Ticket
{
	public RegularTicket(Calendar date, double price)
	{
		super(date, "Regular", price);
	}
}