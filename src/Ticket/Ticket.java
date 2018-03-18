package Ticket;

import Utils.ID_Generator;

import java.util.Calendar;

/***
	Every ticket has a serial
	number, the date of the show, the type of ticket (regular, advance, student advance), and the
	ticket price;
 */

public abstract class Ticket
{

	private long serialNumber;
	private Calendar date;
	private String type;
	private double price;

	public Ticket(Calendar date, String type, double price)
	{
		serialNumber = ID_Generator.getUniqueGeneratedID();
		this.date = date;
		this.type = type;
		this.price = price;
	}
}