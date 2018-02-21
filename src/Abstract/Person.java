package Abstract;

/**
 * This abstract class will allow for specific kinds of people classes for the 
 * theater project to be created with this class being the first building block
 * 
 * @author Noah
 */
public abstract class Person
{
    
    protected String name;
    protected String address;   
    protected String phoneNumber;
    protected static int generatedID = 0; //auto-increments for unique id's

    public Person(String name, String address, String phoneNumber)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        ++generatedID;
    }
  
    public int getGeneratedID()
    {
    	return generatedID;
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
