package Theatre;

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

    private String customerID;
    
    /**
     * Creates the customer object with the supplied name, address phone number
     * credit card and creadit card expiration.
     * 
     * @param name
     * @param address
     * @param phoneNumber
     * @param creditCardNumber
     * @param expirationDate 
     */
    public Customer(String name, String address, String phoneNumber,
            String creditCardNumber, String expirationDate) {
        
        super(name, address, phoneNumber);
        
        CreditCardList ccl = new CreditCardList();
        ccl.addCreditCard(new CreditCard(creditCardNumber,  expirationDate, customerID));
    }

        

    /**
     * Get the value of customerID
     *
     * @return the value of customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * Set the value of customerID
     *
     * @param customerID new value of customerID
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
	/**
	 * Returns the string form of the client object's information
	 */
    @Override
    public String toString() {
		String string = "Customer name: " +  name + ", Address: " 
                        + address + ", Phone number: " + phoneNumber + 
                        ", Customer ID: " + customerID;
		return string;
    }
}
