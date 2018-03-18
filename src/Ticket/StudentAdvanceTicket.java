package Ticket;

import Utils.Strings;
import java.util.Calendar;

/**
 * Student tickets that cost only 50% of regular tickets.
 * Requires student ID for purchase.
 */
public class StudentAdvanceTicket extends Ticket
{
	private String extraMessage;
	
	public StudentAdvanceTicket(Calendar date, double price)
	{
		super(date, "Advance", price*.5); //Student advance ticket price is 50% of regular tickets
		extraMessage = Strings.NOTIFICATION_EXTRA_MESSAGE;
		
	}
}