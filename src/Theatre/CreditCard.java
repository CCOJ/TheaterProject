package Theatre;

public class CreditCard {
    
    private String creditCardNumber;
    private String expirationDate;
    private long customerID;   

    public CreditCard(long customerID, String creditCardNumber, String expirationDate)
    {
        this.customerID = customerID;
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = expirationDate;
    }
    

    /**
     * Get the value of creditCardNumber
     *
     * @return the value of creditCardNumber
     */
    public String getCreditCardNumber()
    {
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
    public long getCustomerID()
    {
        return customerID;
    }

    /**
     * Set the value of customerID
     *
     * @param customerID new value of customerID
     */
    public void setCustomerID(long customerID)
    {
        this.customerID = customerID;
    }
    
    public String toString()
    {
        //customerID   return "customerID:" + customerID + ", cardNumber:" + creditCardNumber + ", expirationDate:" + expirationDate;
		return "cardNumber:" + creditCardNumber + ", expirationDate:" + expirationDate;
    }

}
