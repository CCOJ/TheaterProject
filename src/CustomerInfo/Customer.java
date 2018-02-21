package CustomerInfo;

import Theatre.CreditCard;

import java.io.Serializable;
import java.util.ArrayList;

import Abstract.Person;

/**
 * The customer class. It extends person, adding the credit card property. It
 * allows for multiple cards to be in the persons name.
 * 
 * @author Noah
 */
public class Customer extends Person implements Serializable{

    private ArrayList<CreditCard> creditCards = new ArrayList<>();
    
    public Customer(String name, String address, String phoneNumber,
            String creditCardNumber, String expirationDate) {
        
        super(name, address, phoneNumber);
        creditCards.add(new CreditCard(creditCardNumber,  expirationDate));
    }

    /**
     * Get the value of creditCards
     *
     * @return the value of creditCards
     */
    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }
    /**
     * Adds a credit card to the customers file
     * 
     * @param number
     * @param expirationDate 
     */
    public void addCreditCard(String number, String expirationDate){     
        
        creditCards.add(new CreditCard(number,  expirationDate));
    }
    /**
     * Removes a credit card with the given credit card number
     * 
     * @param number
     * @return 
     */
    public String removeCreditCard(String number){ 
        
        for(CreditCard card : creditCards) {
            if(card.getNumber().equals(number)) {
                
                if(creditCards.size() > 1){
                    
                    creditCards.remove(card);
                    return "Credit Card " + card.getNumber() + " has been removed "
                            + "successfully.";
                }
                else{
                    
                    return "Credit Card " + card.getNumber() + " could not be "
                            + "removed because this is the only card "
                            + this.name + " has on file.";   
                }
            }
            
        }
        return "Credit Card " + number + " could not be found.";
    }

	public Object getCustomerID()
	{
		// TODO Auto-generated method stub
		return null;
	}
    
}
