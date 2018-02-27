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
	 * @param cardNumber Credit card number
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
	public boolean addCreditCard(CreditCard creditCard)
	{
		return creditCards.add(creditCard);
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
	 * Checks if this is the customer's only credit card
	 * @param cardNumber credit card number
	 * @return true if only card, false if not
	 */
	public boolean isCustomersOnlyCreditCard(String cardNumber)
	{
		int totalCards = 0;
		long customerID = -1;
		
		for(int i = 0; i < creditCards.size(); ++i)
		{
			if(creditCards.get(i).getCreditCardNumber().equals(cardNumber))
			{
				customerID = creditCards.get(i).getCustomerID();
				break;
			}
		}
		
		for(int i = 0; i < creditCards.size(); ++i)
		{
			if(creditCards.get(i).getCustomerID() == customerID)
			{
				++totalCards;
				
				if(totalCards > 1)
				{
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Removes all customer cards, used only when customer is removed
	 * @param customerID customer ID
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

	/**
	 * Checks if the credit card exists
	 * @param cardNumber credit card number
	 * @return true if exists, false if not
	 */
	public boolean creditCardExists(String cardNumber)
	{
		for(int i = 0; i < creditCards.size(); ++i)
		{
			if(creditCards.get(i).getCreditCardNumber().equals(cardNumber))
			{
				return true;
			}
		}
		return false;
	}
}
