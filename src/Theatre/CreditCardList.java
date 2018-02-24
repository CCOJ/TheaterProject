package Theatre;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author Noah, Randy, Ricky
 *
 */
public class CreditCardList implements Serializable
{
	private ArrayList<CreditCard> creditCards;

	/**
	 * Private constructor designed for singleton pattern
	 */
	public CreditCardList()
	{
		creditCards = new ArrayList<>();
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<CreditCard> getCreditCardList()
	{
		return creditCards;
	}
	/**
	 * Finds the credit card in creditCardList if they exist.
	 * Iterates through creditCardList until the number matches or not.
	 *
	 * @param number Credit card number
	 * @return creditCard object
	 */
	public CreditCard getCreditCard(String cardNumber)
	{
		for(int i = 0; i < creditCards.size(); ++i)
		{
			if (creditCards.get(i).getCreditCardNumber().equals(cardNumber))
			{
				return creditCards.get(i);
			}
		}
		return null;
	}
	/**
	 * Adds a credit card to the list
	 * 
	 * @param creditCard the credit card object
	 * @return true when added
	 */
	public void addCreditCard(CreditCard creditCard)
	{     
		creditCards.add(creditCard);
	}

	/**
	 * Removes a credit card with the given credit card number
	 * 
	 * @param creditCard the credit card object
	 * @return true when removed
	 */
	public void removeCreditCard(CreditCard creditCard)
	{ 
		creditCards.remove(creditCard);
	}
	/**
	 * 
	 * @param cardNumber
	 * @return
	 */
	public boolean removeCreditCard(String cardNumber)
	{
		for(int i = 0; i < creditCards.size(); ++i)
		{
			if(creditCards.get(i).getCreditCardNumber().equals(cardNumber))
			{
				creditCards.remove(i);
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param customerID
	 */
	public boolean removeAllCustomerCards(long customerID)
	{
		boolean cardRemoved = false;
		
		for(int i = 0; i < creditCards.size(); ++i)
		{
			if(creditCards.get(i).getCustomerID() == customerID)
			{
				creditCards.remove(i);
				cardRemoved = true;
			}
		}
		
		if(cardRemoved)
		{
			return true;
		}
		else
		{
			return false;
		}

	}
}
