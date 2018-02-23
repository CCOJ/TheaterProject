package Utils;

import java.util.Scanner;
/**
 * This class is called for user input. It will do error checks on the data 
 * to make sure proper input is used. (EG - Asking for int and receiving a 
 * character instead)
 * 
 * @author Ricky
 *
 */
public class InputUtils
{
	private final Scanner scanner = new Scanner(System.in);
	/**
	 * Returns the user input as an int
	 * @return user int selection if no exceptions, -1 if there is bad input
	 */
	public int getIntInput() throws NumberFormatException
	{
		try
		{
			String input = scanner.nextLine();
			return Integer.parseInt(input);
		}
		catch(NumberFormatException nfe)
		{
			System.out.println(nfe);
			return -1;
		}
	}
	
	public long getLongInput()
	{
		try
		{
			String input = scanner.nextLine();
			return Long.parseLong(input);
		}
		catch(NumberFormatException nfe)
		{
			System.out.println(nfe);
			return -1;
		}
	}
	
	public String getYesOrNo()
	{
		String input = scanner.nextLine();
		
		switch(input)
		{
			case "y":	return "YES";
			case "Y":	return "YES";
			case "yes":	return "YES";
			case "YES":	return "YES";
			case "n":	return "NO";
			case "N":	return "NO";
			case "no":	return "NO";
			case "NO":	return "NO";
			default:	return null;
		}
	}
	
	public String getStringInput()
	{
		return scanner.nextLine();
	}
	
	public void enterToContinue()
	{
		scanner.nextLine();
	}
	
	public void enterToContinue(String message)
	{
		System.out.println(message);
		scanner.nextLine();
	}
}