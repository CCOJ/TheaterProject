

import java.util.ArrayList;

import CustomerInfo.Customer;
import ClientInfo.Client;
import Theatre.Show;

/**
 *
 * @author Noah
 */
public class Theater {
    
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Show> shows = new ArrayList<>();
    
    public Theater(String name){
        this.name = name;
    	customers = new ArrayList<>();
    	clients = new ArrayList<>();
    	shows = new ArrayList<>();
    }


    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Check to see if the credit card is already on file. If it is, return true
     * 
     * @param number
     * @return 
     */
    public boolean creditCardExists(String number){
        for(int i = 0; i < customers.size(); i++){
            for(int j = 0; j < customers.get(i).getCreditCards().size(); j ++){
                if(number.equals(customers.get(i).getCreditCards().get(j)
                        .getNumber())){
                    return true;
                }
            }
        }
        return false;
    }
    public void addCustomer(String name, String address, String phoneNumber,
            String creditCardNumber, String expirationDate){
        
        customers.add(new Customer(name, address, phoneNumber, creditCardNumber,
                expirationDate));
    }
	/* Credit card check if customer has more than one or if it's the only one
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
	*/

}
