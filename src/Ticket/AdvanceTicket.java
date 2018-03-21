package Ticket;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Advanced tickets are purchased at least one day of the showing.
 * It costs 70% of regular ticket pricing.
 */
public class AdvanceTicket extends Ticket implements Serializable
{
	private static final double MODIFIER = .7;

	public AdvanceTicket(Calendar date, double price)
	{
		super(date, "Advance", price*MODIFIER); //Advanced ticket price is 70% of regular tickets
	}
}