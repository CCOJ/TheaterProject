package CustomerInfo;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CreditCardList implements Serializable {
	private List creditCards = new LinkedList<>();
	private static CreditCardList creditCardList;
	
	/**
	 * Private constructor designed for singleton pattern
	 */
	private CreditCardlist() {
	}
	
	/**
	 * Singleton pattern allows us to return the only
	 * created list without creating anymore.
	 * This also creates one, if none were created.
	 * 
	 * @return creditCardList
	 */
	public static CreditCardList instance() {
		if (creditCardList == null) {
			return (creditCardList = new CreditCardList());
		} else {
			return creditCardList;
		}
	}
	/**
	 * Finds the credit card in creditCardList if they exist.
	 * Iterates through creditCardList until the number matches or not.
	 *
	 * @param number Credit card number
	 * @return creditCard object
	 */
	public CreditCard findCreditCard(String number) {
		for (Iterator iterator = creditCards.iterator(); iterator.hasNext(); ) {
			CreditCard creditCard = (CreditCard) iterator.next();
			
			if (creditCard.getNumber().equals(number)) {
				return creditCard;
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
    public boolean addCreditCard(CreditCard creditCard){     
        creditCards.add(creditCard);
		return true;
    }
	
    /**
     * Removes a credit card with the given credit card number
     * 
     * @param creditCard the credit card object
     * @return true when removed
     */
    public String removeCreditCard(CreditCard creditCard){ 
        creditCards.remove(creditCard);
		return true;
        
    }
	
	/**
	 * Saves the CreditCardList object to disk.
	 * If it is unable to, it returns an error
	 * stating it cannot save with the reason why.
	 * 
	 * @param output the stream for write
	 */
	private void writeObject(java.io.ObjectOutputStream output) {
		try {
			output.defaultWriteObject();
			output.writeObject(creditCardList);
		} catch (IOException ioe) {
			System.out.println("Could not save creditCardList to disk: ");
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Loads CreditCardList object from disk.
	 * Otherwise, it prints out errors with
	 * reasons why.
	 * @param input the stream for input
	 */
	private void readObject(java.io.ObjectInputStream input) {
		try {
			if (creditCardList != null) {
				return;
			} else {
				input.defaultReadObject();
				if (creditCardList == null) {
					creditCardList = (CreditCardList) input.readObject();
				} else {
					input.readObject();
				}
			}
		} catch (IOException ioe) {
			System.out.println("Could not load creditCardList from disk: ");
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			System.out.println("Could not find class: ");
			cnfe.printStackTrace();
		}
	}
	
	/**
	 * Returns a list of all the clients in clientList
	 */
	public String toString() {
		return creditCards.toString();
	}
}
