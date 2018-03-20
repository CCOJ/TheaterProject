package Ticket;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Advanced tickets are purchased at least one day of the showing.
 * It costs 70% of regular ticket pricing.
 */
public class AdvanceTicket extends Ticket implements Serializable
{
	public AdvanceTicket(Calendar date, double price)
	{
		super(date, "Advance", price*.7); //Advanced ticket price is 70% of regular tickets
	}
}