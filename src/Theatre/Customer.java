package Theatre;

import java.util.ArrayList;
import Abstract.Person;
/**
 * The customer class. It extends person, adding the credit card property. It
 * allows for multiple cards to be in the persons name.
 * 
 * @author Noah
 */
public class Customer extends Person
{
	private ArrayList<CreditCard> creditCards = new ArrayList<>();
	private int uniqueID;

	public Customer(String name, String address, String phoneNumber, String creditCardNumber, String expirationDate)
	{
		super(name, address, phoneNumber);
		creditCards.add(new CreditCard(creditCardNumber,  expirationDate));
		uniqueID = getGeneratedID(); //GeneratedID is in the parent class. Static auto-increments for ID
	}

	public Customer(String name, String address, String phoneNumber, CreditCard card)
	{
		super(name, address, phoneNumber);
		creditCards.add(card);
		uniqueID = getGeneratedID(); //GeneratedID is in the parent class. Static auto-increments for ID
	}
	/**
	 * Get the value of creditCards
	 *
	 * @return the value of creditCards
	 */
	public ArrayList<CreditCard> getCreditCards()
	{
		return creditCards;
	}

	public int getUniqueID()
	{
		return uniqueID;
	}

	public void setUniqueID(int uniqueID)
	{
		this.uniqueID = uniqueID;
	}

	public void setCreditCards(ArrayList<CreditCard> creditCards)
	{
		this.creditCards = creditCards;
	}

	public void addCreditCard(CreditCard card)
	{
		creditCards.add(card);
	}
	/**
	 * Adds a credit card to the customers file
	 * 
	 * @param number
	 * @param expirationDate 
	 */
	public void addCreditCard(String number, String expirationDate)
	{     
		creditCards.add(new CreditCard(number,  expirationDate));
	}
	/**
	 * Removes a credit card with the given credit card number
	 * 
	 * @param number
	 * @return 
	 */
	public boolean removeCreditCard(String number)
	{ 
		for(CreditCard card : creditCards)
		{
			if(card.getCardNumber().equals(number))
			{
				if(creditCards.size() > 1)
				{
					creditCards.remove(card);
					System.out.println("Credit Card " + card.getCardNumber() + " has been removed " + "successfully.");
					return true;
				}
				else
				{
					System.out.println("Credit Card " + card.getCardNumber() + " could not be " + "removed because this is the only card " + this.name + " has on file.");       
					return false;
				}
			}
		}
		return false;
		//return "Credit Card " + number + " could not be found.";
	}

	public void removeAllCreditCards()
	{
		creditCards.removeAll(creditCards);
	}
	
	public void removeCustomer()
	{
		
	}
	
	public String creditCardsToString()
	{
		StringBuilder strCards = new StringBuilder();

		for(int i = 0; i < creditCards.size(); ++i)
		{
			strCards.append(creditCards.get(i).toString() + ", ");
		}

		return strCards.toString();
	}

	public String toString()
	{
		return "uniqueID:" + uniqueID + ", name:" + name + ", address:" + address + ", phoneNumber:" + phoneNumber + ", creditCards[" + creditCardsToString() + "]";
	}
}
