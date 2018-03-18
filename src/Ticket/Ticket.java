package Ticket;

import Utils.ID_Generator;

public abstract class Ticket
{
	/*
	Every ticket has a serial
	number, the date of the show, the type of ticket (regular, advance, student advance), and the
	ticket price;
	*/
	private long serialNumber;
	private String date;
	private String type;
	private double price;

	public Ticket(String date, String type, double price)
	{
		serialNumber = ID_Generator.getUniqueGeneratedID();
		this.date = date;
		this.type = type;
		this.price = price;
	}
}