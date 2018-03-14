package Ticket;

import Utils.Strings;

public class StudentAdvanceTicket extends Ticket
{
	private String extraMessage;
	
	public StudentAdvanceTicket()
	{
		super();
		extraMessage = Strings.NOTIFICATION_EXTRA_MESSAGE;
		
	}
}