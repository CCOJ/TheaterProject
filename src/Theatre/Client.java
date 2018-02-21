package Theatre;

import Abstract.Person;

/**
 *
 * @author Noah
 */
public class Client extends Person
{
	private int uniqueID;
	private int balance;
	
    public Client(String name, String address, String phoneNumber)
    {
        super(name, address, phoneNumber);
        uniqueID = getGeneratedID(); //GeneratedID is in the parent class. Static auto-increments for ID
        balance = 0;
    }
    
    public String toString()
    {
		return "id:" + uniqueID + ", name:" + name + ", address:" + address + 
				", phoneNumber:" + phoneNumber + ", balance:" + balance;
    }
}
