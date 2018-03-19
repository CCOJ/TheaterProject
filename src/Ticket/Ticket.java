package Ticket;

import Utils.ID_Generator;

import java.time.LocalDate;
import java.time.ZoneId;
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

	/**
	 * Converts the date to string
	 * @return string format of the ticket's date for showing
	 */
	public String DateToString()
	{
		StringBuilder strBuild = new StringBuilder();
		String dateString;

		LocalDate localStartDate = this.date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		strBuild.append(localStartDate.getYear() + "/" + localStartDate.getMonthValue() + "/"+ localStartDate.getDayOfMonth());
		dateString = strBuild.toString();

		return dateString;
	}

	/**
	 * Converts the ticket object to a string format
	 * @return ticket information
	 */
	public String toString() {
		return type + " ticket; $" + price + "; date sold " + DateToString();
	}
}