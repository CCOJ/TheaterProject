package Theatre;

import java.io.Serializable;

import Abstract.Person;

/**
 *
 * @author Noah
 */
public class Client extends Person implements Serializable
{
	private int balance;
	
    public Client(String name, String address, String phoneNumber)
    {
        super(name, address, phoneNumber);
        balance = 0;
    }
    
    public String toString()
    {
		return "id:" + uniqueID + ", name:" + name + ", address:" + address + 
				", phoneNumber:" + phoneNumber + ", balance:" + balance;
    }
}
