package com.project1.Theatre;

/**
 * This abstract class will allow for specific kinds of people classes for the 
 * theater project to be created with this class being the first building block
 * 
 * @author Noah
 */
public abstract class Person {
    
    protected String name;
    protected String address;   
    protected String phoneNumber;

    public Person(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the value of phoneNumber
     *
     * @return the value of phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

}
