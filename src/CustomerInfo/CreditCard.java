package CustomerInfo;

/**
 * Credit card class so that credit card objects may be created for efficient
 * use and deletion.
 * 
 * @author Noah
 */
public class CreditCard {
    
    private String number;
    private String expirationDate;

    public CreditCard(String number, String expirationDate) {
        this.number = number;
        this.expirationDate = expirationDate;
    }
    
    /**
     * Get the value of number
     *
     * @return the value of number
     */
    public String getNumber() {
        return number;
    }


    /**
     * Get the value of expirationDate
     *
     * @return the value of expirationDate
     */
    public String getExpirationDate() {
        return expirationDate;
    }
	
	public String toString() {
		String string = "Number: " + number + ", expiry date" + expirationDate;
		return string;
	}

}
