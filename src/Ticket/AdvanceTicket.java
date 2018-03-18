package Ticket;

/**
 * Advanced tickets are purchased at least one day of the showing.
 * It costs 70% of regular ticket pricing.
 */
public class AdvanceTicket extends Ticket
{
	public AdvanceTicket(String date, double price)
	{
		super(date, "Advance", price*.7); //Advanced ticket price is 70% of regular tickets
	}
}