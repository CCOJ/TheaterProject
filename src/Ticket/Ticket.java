package Ticket;

import Utils.ID_Generator;
import Theatre.Client;
import Theatre.Customer;
import java.io.Serializable;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

/***
	Every ticket has a serial
	number, the date of the show, the type of ticket (regular, advance, student advance), and the
	ticket price;
 */

public abstract class Ticket implements Serializable
{

	private long serialNumber;
	private Calendar date;
	private String type;
	private double price;
        protected Customer customer;
        protected Client client;

	public Ticket(Calendar date, String type, double price)
	{
		serialNumber = ID_Generator.getUniqueGeneratedID();
		this.date = date;
		this.type = type;
		this.price = price;
	}

	/**
	 * Gets the serial number of the ticket
	 * @return serial number
	 */
	public long getSerialNumber()
	{
		return serialNumber;
	}

	/**
	 * Gets date of ticket
	 * @return date
	 */
	public Calendar getDate()
	{
		return date;
	}

	/**
	 * Return type of ticket
	 * @return ticket type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Return price of ticket
	 * @return price of ticket
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * Set serial number for ticket
	 * @param serialNumber new serial number
	 */
	public void setSerialNumber(long serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	/**
	 * Set date for ticket
	 * @param date new date
	 */
	public void setDate(Calendar date)
	{
		this.date = date;
	}

	/**
	 * Set type for ticket
	 * @param type new type
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * Set price for ticket
	 * @param price new price
	 */
	public void setPrice(double price)
	{
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