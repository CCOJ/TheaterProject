package Theatre;

public class CreditCard {
    
    private String creditCardNumber;
    private String expirationDate;
    private String customerID;   

    public CreditCard(String creditCardNumber, String expirationDate, String customerID) {
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = expirationDate;
        this.customerID = customerID;
    }
    

    /**
     * Get the value of creditCardNumber
     *
     * @return the value of creditCardNumber
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Set the value of creditCardNumber
     *
     * @param creditCardNumber new value of creditCardNumber
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * Get the value of expirationDate
     *
     * @return the value of expirationDate
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Set the value of expirationDate
     *
     * @param expirationDate new value of expirationDate
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
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

}
