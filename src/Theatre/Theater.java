package Theatre;

import java.util.ArrayList;

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

}
