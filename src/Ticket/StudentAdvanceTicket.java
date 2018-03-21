package Ticket;

import Utils.Strings;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Student tickets that cost only 50% of regular tickets.
 * Requires student ID for purchase.
 */
public class StudentAdvanceTicket extends Ticket implements Serializable
{
	private static final double MODIFIER = .5;
	private String extraMessage;
	
	public StudentAdvanceTicket(Calendar date, double price)
	{
		super(date, "Advance", price*MODIFIER); //Student advance ticket price is 50% of regular tickets
		extraMessage = Strings.NOTIFICATION_EXTRA_MESSAGE;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ", extraMessage:" + extraMessage;
	}
}