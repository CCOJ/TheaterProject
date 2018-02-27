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

	/**
	 * Creates a person object using name, address, and phone number then generates a uniqueID
	 * @param name
	 * @param address
	 * @param phoneNumber
	 */
	public Person(String name, String address, String phoneNumber)
	{
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		uniqueID = ID_Generator.getUniqueGeneratedID();
	}

	/**
	 * Gets unique ID for person
	 * @return uniqueID
	 */
	public long getUniqueID()
	{
		return uniqueID;
	}

	/**
	 * Set unique ID for person
	 * @param uniqueID unique ID for person
	 */
	public void setUniqueID(long uniqueID)
	{
		this.uniqueID = uniqueID;
	}

	/**
	 * Get name for person
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Set name for person
	 * @param name name of person
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Get address for person
	 * @return address
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * Set address of person
	 * @param address address of person
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * Get phone number of person
	 * @return phoneNumber
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * Set phone number of person
	 * @param phoneNumber phone number of person
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
}
