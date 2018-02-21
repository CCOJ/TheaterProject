package Theatre;

import java.util.Date;

/**
 * Credit card class so that credit card objects may be created for efficient
 * use and deletion.
 * 
 * @author Noah
 */
public class CreditCard
{

	private String cardNumber;
	private String expirationDate;
	private Date expireDate;


	public CreditCard(String number, String expirationDate)
	{
		this.cardNumber = number;
		this.expirationDate = expirationDate;
	}
	
	/**
	 * Get the value of number
	 *
	 * @return the value of number
	 */
	public String getCardNumber()
	{
		return cardNumber;
	}
	
	public void setCardNumber(String cardNumber)
	{
		this.cardNumber = cardNumber; 
	}

	public Date getExpireDate()
	{
		return expireDate;
	}

	public void setExpireDate(Date expireDate)
	{
		this.expireDate = expireDate;
	}

	/**
	 * Get the value of expirationDate
	 *
	 * @return the value of expirationDate
	 */
	public String getExpirationDate()
	{
		return expirationDate;
	}

	public String toString()
	{
		return "{cardNumber: " + cardNumber + ", expirationDate:" + expirationDate + "}";
	}
	/*
	public Object getCardNumber()
	{
		// TODO Auto-generated method stub
		return null;
	}
	*/
}
