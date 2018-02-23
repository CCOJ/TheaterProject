package CustomerInfo;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * CreditCardList holds a list of all creditCard objects created.
 * This uses a linked list as the data structure.
 * 
 * Credits given to the textbook authors' (Brahma Dathan
 * and Sarnath Ramnath) class "MemberList" for suggestions.
 * 
 * This also uses the singleton pattern, as we only want a 
 * relationship of a one to many (CreditCardList to CreditCard)
 * relationship. Hence, a singleton design is best for this.
 * 
 * @author Ricky, Noah, Randy
 * @param <E>
 *
 */
public class CreditCardList implements Serializable{
    private List creditCards = new LinkedList();
    private static CreditCardList creditCardList;
    
    /**
     * Private constructor, for singleton pattern
     */
    private CreditCardList(){
        
    }
    
    /**
     * With the singleton pattern, we create one available instance of
        creditCardList at a time. It creates one if necessary 
     */
    public static CreditCardList instance(){
        if(creditCardList == null){
            return (creditCardList = new CreditCardList());
        }
        else{
            return creditCardList;
        }
    }
    
    /**
     * Finds the creditCard in the creditCardList by iterating through the lsit
        with creditCardNumber
     * @param creditCardNumber
     * @return 
     */
    public CreditCard findCreditCard(String creditCardNumber){
        for(Iterator iterator = creditCards.iterator(); iterator.hasNext();){
            CreditCard creditCard = (CreditCard)iterator.next();
            
            if(creditCard.getCreditCardNumber().equals(creditCardNumber)){
                return creditCard;
            }
        }
        return null;
    }
    /**
     * Adds the specified creditCard to the list
     * @param creditCard
     * @return 
     */
    public boolean addCreditCard(CreditCard creditCard){
        creditCards.add(creditCard);
        return true;
    }
    /**
     * Removes the specified creditCard from the list
     * @param creditCard
     * @return 
     */
    public boolean removeCreditCard(CreditCard creditCard){
        creditCards.remove(creditCard);
        return true;
    }
    /**
     * Saves the creditCardList to the disk
        Returns an error if it cannot, with the reason why
     * @param output 
     */
    private void writeObject(java.io.ObjectOutputStream output){
        try{
            output.defaultWriteObject();
            output.writeObject(creditCardList);
            
        }
        catch(IOException io){
            System.out.println("Could not save creditCardList to disk: ");
            io.printStackTrace();
        }
    }
    
	/**
	 * Loads creditCardList object from disk.
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
					creditCardList = (CreditCardList) 
                                                input.readObject();
				} else {
					input.readObject();
				}
			}
		} catch (IOException ioe) {
			System.out.println("Could not load creditCardList from "
                                + "disk: ");
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			System.out.println("Could not find class: ");
			cnfe.printStackTrace();
		}
	}
	
	/**
	 * Returns a list of all the creditCards in creditCardList
	 */
	public String toString() {
		return creditCards.toString();
	}
}
