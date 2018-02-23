package Abstract;

import java.io.Serializable;
import Utils.ID_Generator;
/**
 * This abstract class will allow for specific kinds of people classes for the 
 * theater project to be created with this class being the first building block
 * 
 * @author Noah
 */
public abstract class Person implements Serializable
{
    protected long uniqueID;
    protected String name;
    protected String address;   
    protected String phoneNumber;
    
    public Person(String name, String address, String phoneNumber)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        uniqueID = ID_Generator.getUniqueGeneratedID();
    }
    
    public long getUniqueID()
    {
    	return uniqueID;
    }
    
    public void setUniqueID(long uniqueID)
    {
    	this.uniqueID = uniqueID;
    }
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
    	this.name = name;
    }

    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
    	this.address = address;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
    	this.phoneNumber = phoneNumber;
    }
}
