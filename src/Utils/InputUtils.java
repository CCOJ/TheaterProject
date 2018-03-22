package Utils;

import java.util.Scanner;

/**
 * This class is called for user input. It will do error checks on the data 
 * to make sure proper input is used. (EG - Asking for int and receiving a 
 * character instead)
 * 
 * @author Noah, Randy, Ricky
 *
 */
public class InputUtils
{
	private static InputUtils inputUtils;
	private final Scanner scanner;
	
	/**
	 * 
	 */
	private InputUtils()
	{
		scanner = new Scanner(System.in);
	}
	
	/**
	 * 
	 */
	public static InputUtils getInstanceOf()
	{
		if(inputUtils == null)
		{
			inputUtils = new InputUtils();
		}
		return inputUtils;
	}
	
	/**
	 * Returns the user input as an int
	 * @return user int selection if no exceptions, -1 if there is bad input
	 */
	public int getIntInput()
	{
		try
		{
			String input = scanner.nextLine();
			return Integer.parseInt(input);
		}
		catch(NumberFormatException nfe)
		{
			//System.out.println(nfe);
			return -1;
		}
	}

	/**
	 * Returns user input as double
	 * @return user double selection if no exceptions, -1.0 if there is bad input
	 */
	public double getDoubleInput()
	{
		try
		{
			String input = scanner.nextLine();
			return Double.parseDouble(input);
		}
		catch(NumberFormatException nfe)
		{
			return -1.0;
		}
	}

	/**
	 * Return price in format $x.xx
	 * @param price double input
	 * @return price in format $x.xx
	 */
	public double getPriceInput(Double price)
	{
		return Math.round(price*100.0)/100.0;
	}

	/**
	 * Retrieves a String and converts to a Date if possible
	 * @param strDate String format of date
	 * @return the date as int[]
	 */
	public int[] getDateInput(String strDate)
	{
		int[] date = new int[3];
		String[] parsedDate = strDate.split("/");

		if(parsedDate.length == 3)
		{
			date[0] = Integer.parseInt(parsedDate[0]);
			date[1] = Integer.parseInt(parsedDate[1]) - 1; //-1 for month-1
			date[2] = Integer.parseInt(parsedDate[2]);
		}
		else
		{
			return null;
		}
		
		return date;
	}

	/**
	 * Retrieves long input from user
	 * @return long input, or -1 if there is an exception
	 */
	public long getLongInput()
	{
		try
		{
			String input = scanner.nextLine();
			return Long.parseLong(input);
		}
		catch(NumberFormatException nfe)
		{
			//System.out.println(nfe);
			return -1;
		}
	}

	/**
	 * Retrieves yes or no input
	 * @return YES if yes, NO if no, and null if invalid input
	 */
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

	/**
	 * Retrives string input and ensures there is a valid input
	 * @return the string input
	 */
	public String getStringInput()
	{
		String input = scanner.nextLine();

		if (input.length() == 0) {
			return null;
		}
		return input;
	}

	/**
	 * Ensures phone number input is 10 digits long and numbers only.
	 * Removes any dashes if added.
	 * @return input if valid or null if not
	 */
	public String getPhoneNumberInput()
	{
		String input = scanner.nextLine();
		
		input = input.replace("-", ""); //Remove -
		input = input.replaceAll("\\s+",""); //Remove whitespace
		//System.out.println("Input: " + input);
		
		if(input.length() == 10 && input.matches("[0-9]+"))
		{
			return input;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Prompts user to press enter to continue
	 */
	public void enterToContinue()
	{
		scanner.nextLine();
	}

	/**
	 * Prompts user to press enter to continue, with passed in message
	 * @param message
	 */
	public void enterToContinue(String message)
	{
		System.out.println(message);
		scanner.nextLine();
	}
}