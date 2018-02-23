package Theatre;

import java.io.Serializable;
import java.util.ArrayList;

public class CreditCardList implements Serializable
{
	private final ArrayList<CreditCard> creditCards;

	/**
	 * Private constructor designed for singleton pattern
	 */
	public CreditCardList()
	{
		creditCards = new ArrayList<>();
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

}
