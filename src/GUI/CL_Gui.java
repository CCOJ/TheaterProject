package GUI;

import java.util.*;

import Collections.ClientList;
import Collections.CreditCardList;
import Collections.CustomerList;
import Collections.ShowList;
import Theatre.Client;
import Theatre.CreditCard;
import Theatre.Customer;
import Theatre.Show;
import Utils.InputUtils;
import Utils.Strings;
/**
 * CL_Gui - (Command Line GUI)
 * This class is the controller for the GUI portion of the
 * application.
 * 
 * @author Noah, Randy, Ricky
 *
 */
public class CL_Gui
{
	private final InputUtils inputUtils;
	/**
	 * When a command line gui is created it gets a reference to 
	 * it's controller. This is so the gui can make a call to the 
	 * appropriate function calls on the controller.
	 * 
	 * @param controller
	 */
	public CL_Gui()
	{
		inputUtils = new InputUtils();
	}

	/**
	 * Prompts the user asking if they would like to retrieve data. User must 
	 * select some form of yes or no to continue. (y, Y, yes, YES)
	 * 
	 */
	public boolean promptRetrieveData()
	{
		String input = null;
		
		displayPrompt(Strings.PROMPT_RETRIEVE_DATA);
	
		while(input == null)
		{
			input = inputUtils.getYesOrNo();
	
			if(input == "YES")
			{
				return true;
			}
			else if(input == "NO")
			{
				return false;
			}
			else
			{
				displaySystemNotify(Strings.ERROR_BAD_INPUT_YES_NO);
			}
		}
		return false;
	}

	public void exitApplication()
	{
		displaySystemNotify(Strings.NOTIFICATION_CLOSING_APPLICATION);
	}

	public boolean displaySerialization(boolean isSerialized)
	{
		displaySystemNotify(Strings.NOTIFICATION_SERIALIZING_DATA);
		
		if(isSerialized) //True value means data was able to be stored
		{
			displaySystemNotify(Strings.NOTIFICATION_SERIALIZE_SUCCESS);
			return true;
		}
		else
		{
			displaySystemNotify(Strings.NOTIFICATION_CLOSED_FAILED_TO_SERIALIZE);
			return false;
		}
	}

	public Map<String, Object> addClient()
	{
		Map<String, Object> userInput = new HashMap<String, Object>();
		String name, address, phoneNumber;
		displayPageHeader(Strings.HEADER_ADD_CLIENT);
	
		displayPrompt(Strings.PROMPT_FOR_NAME);
		name = inputUtils.getStringInput();
		if(name == null)
		{
			displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			displaySystemNotify(Strings.NOTIFICATION_ADD_CLIENT_FAILED);
			return null;
		}
		else
		{
			userInput.put("name", name);
		}
	
		displayPrompt(Strings.PROMPT_FOR_ADDRESS);
		address = inputUtils.getStringInput();
		if(address == null)
		{
			displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			displaySystemNotify(Strings.NOTIFICATION_ADD_CLIENT_FAILED);
			return null;
		}
		else
		{
			userInput.put("address", address);
		}
	
		displayPrompt(Strings.PROMPT_FOR_PHONE_NUMBER);
		phoneNumber = inputUtils.getPhoneNumberInput();
		if (phoneNumber == null)
		{
			displaySystemNotify(Strings.ERROR_BAD_PHONE_NUMBER);
			displaySystemNotify(Strings.NOTIFICATION_ADD_CLIENT_FAILED);
			return null;
		}
		else
		{
			userInput.put("phoneNumber", phoneNumber);
		}
		
		return userInput;
	}

	public long removeClient()
	{
		long clientID;
		
		displayPageHeader(Strings.HEADER_REMOVE_CLIENT);
		displayPrompt(Strings.PROMPT_FOR_CLIENT_ID);
		clientID = inputUtils.getLongInput(); //Returns -1 if input is not a long integer
		
		if(clientID > 0) //clientID cannot be negative
		{
			return clientID;
		}
		else
		{
			displaySystemNotify(Strings.ERROR_BAD_LONG_INPUT);
			return clientID; //-1
		}
	}

	/**
	 * Displays all clients
	 * @param clientList
	 */
	public void displayAllClientsList(ClientList clientList)
	{
		ArrayList<Client> clients = clientList.getClientList();
	
		System.out.println("\n\n" + Strings.HEADER_LIST_ALL_CLIENTS);
	
		for(int i = 0; i < clients.size(); ++i)
		{
			System.out.println(clients.get(i).toString());
		}
	}

	public Map<String, Object> addCustomer()
	{
		Map<String, Object> userInput = new HashMap<String, Object>();
		String customerName, address, phoneNumber, cardNumber, expirationDate;
		
		displayPageHeader(Strings.HEADER_ADD_CUSTOMER);
	
		displayPrompt(Strings.PROMPT_FOR_NAME);
		customerName = inputUtils.getStringInput();
		if(customerName == null)
		{
			displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			displaySystemNotify(Strings.NOTIFICATION_ADD_CUSTOMER_FAILED);
			return null;
		}
		else
		{
			userInput.put("customerName", customerName);
		}
		
		displayPrompt(Strings.PROMPT_FOR_ADDRESS);
		address = inputUtils.getStringInput();
		if(address == null)
		{
			displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			displaySystemNotify(Strings.NOTIFICATION_ADD_CUSTOMER_FAILED);
			return null;
		}
		else
		{
			 userInput.put("address", address);
		}
	
		displayPrompt(Strings.PROMPT_FOR_PHONE_NUMBER);
		phoneNumber = inputUtils.getPhoneNumberInput();
		if(phoneNumber == null)
		{
			displaySystemNotify(Strings.ERROR_BAD_PHONE_NUMBER);
			displaySystemNotify(Strings.NOTIFICATION_ADD_CUSTOMER_FAILED);
			return null;
		}
		else
		{
			userInput.put("phoneNumber", phoneNumber);
		}
		
		displayPrompt(Strings.PROMPT_FOR_CREDIT_CARD_NUMBER);
		cardNumber = inputUtils.getStringInput();
		if(cardNumber == null)
		{
			displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			displaySystemNotify(Strings.NOTIFICATION_ADD_CUSTOMER_FAILED);
			return null;
		}
		else
		{
			userInput.put("cardNumber", cardNumber);
		}
	
		displayPrompt(Strings.PROMPT_FOR_CARD_EXPIRATION);
		expirationDate = inputUtils.getStringInput();
		if(expirationDate == null)
		{
			displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			displaySystemNotify(Strings.NOTIFICATION_ADD_CUSTOMER_FAILED);
			return null;	
		}
		else
		{
			userInput.put("expirationDate", expirationDate);
		}
		
		return userInput; 
	}

	public long removeCustomer()
	{
		long customerID;
		
		displayPageHeader(Strings.HEADER_REMOVE_CUSTOMER);
		displayPrompt(Strings.PROMPT_FOR_CUSTOMER_ID);
		customerID = inputUtils.getLongInput(); //Returns -1 if input is not a long integer
		
		if(customerID > 0) //clientID cannot be negative
		{
			return customerID;
		}
		else
		{
			displaySystemNotify(Strings.ERROR_BAD_LONG_INPUT);
			return customerID; //-1
		}
	}

	public Map<String, Object> addCreditCard()
	{
		Map<String, Object> userInput = new HashMap<String, Object>();
		
		long customerID;
		String cardNumber;
		String expirationDate;
		
		displayPageHeader(Strings.HEADER_ADD_CREDIT_CARD);
	
		displayPrompt(Strings.PROMPT_FOR_CUSTOMER_ID);
		customerID = inputUtils.getLongInput();
		if(customerID < 0)
		{
			displaySystemNotify(Strings.ERROR_BAD_LONG_INPUT);
			displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_FAILED);
			return null;	
		}
		else
		{
			userInput.put("customerID", customerID);
		}
	
		displayPrompt(Strings.PROMPT_FOR_CREDIT_CARD_NUMBER);
		cardNumber = inputUtils.getStringInput();
		if(cardNumber == null)
		{
			displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_FAILED);
			return null;
		}
		else
		{
			userInput.put("cardNumber", cardNumber);
		}
	
		displayPrompt(Strings.PROMPT_FOR_CARD_EXPIRATION);
		expirationDate = inputUtils.getStringInput();
		if(expirationDate == null)
		{
			displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_FAILED);
			return null;
		}
		else
		{
			userInput.put("expirationDate", expirationDate);
		}
		
		return userInput;
	}

	public String removeCreditCard()
	{
		String cardNumber;
		
		displayPageHeader(Strings.HEADER_REMOVE_CREDIT_CARD);
		displayPrompt(Strings.PROMPT_FOR_CREDIT_CARD_NUMBER);
		cardNumber = inputUtils.getStringInput(); //Returns -1 if input is not a long integer
		
		if(cardNumber == null) //clientID cannot be negative
		{
			displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			displaySystemNotify(Strings.NOTIFICATION_REMOVE_CREDIT_CARD_FAILED);
			return null;
		}
		else
		{
			return cardNumber; 
		}
	}

	/**
	 * Displays all customers with their credit card info
	 * @param customerList
	 * @param creditCardList
	 */
	public void displayAllCustomerInformation(CustomerList customerList, CreditCardList creditCardList)
	{
		ArrayList<Customer> customers = customerList.getCustomerList();
		ArrayList<CreditCard> cards = creditCardList.getCreditCardList();
	
		StringBuilder str = new StringBuilder();
	
		for(int i = 0; i < customers.size(); ++i)
		{
			str.append(customers.get(i).toString());
			str.append(", creditCards:[");
			for(int j = 0; j < cards.size(); ++j)
			{
				if(cards.get(j).getCustomerID() == customers.get(i).getID())
				{
					str.append("{" + cards.get(j).toString() + "}, ");
				}
			}
			str.append("]");
			System.out.println(str.toString());
			str.delete(0, str.length());
		}
	}

	/**
	 * Adds a show or play with given inputs of
	 * showName, beginning date, end date, client ID, and price
	 * @return Hashmap of inputs for show or play
	 */
	public Map<String, Object> addShowOrPlay()
	{
		Map<String, Object> userInput = new HashMap<String, Object>();
		
		String showName;
		int[] inputBegDate, inputEndDate;
		long clientID;
		double price;
	
		displayPageHeader(Strings.HEADER_ADD_SHOW);

		//Show name
		displayPrompt(Strings.PROMPT_FOR_SHOW_NAME);
		showName = inputUtils.getStringInput();
		if(showName == null)
		{
			displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			displaySystemNotify(Strings.NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED);
			return null;
		}
		else
		{
			userInput.put("showName", showName);
		}

		//Client ID
		displayPrompt(Strings.PROMPT_FOR_CLIENT_ID);
		clientID = inputUtils.getLongInput();
		if(clientID < 0)
		{
			displaySystemNotify(Strings.ERROR_BAD_LONG_INPUT);
			displaySystemNotify(Strings.NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED);
			return null;
		}
		else
		{
			userInput.put("clientID", clientID);
		}

		//Beginning date
		displayPrompt(Strings.PROMPT_FOR_WHOLE_BEGIN_DATE);
		inputBegDate = inputUtils.getDateInput(inputUtils.getStringInput());
		if(inputBegDate == null)
		{
			displaySystemNotify(Strings.ERROR_BAD_INPUT);
			displaySystemNotify(Strings.NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED);
			return null;
		}
		else
		{
			userInput.put("inputBegDate", inputBegDate);
		}

		//End date
		displayPrompt(Strings.PROMPT_FOR_WHOLE_END_DATE);
		inputEndDate = inputUtils.getDateInput(inputUtils.getStringInput());
		if(inputEndDate == null)
		{
			displaySystemNotify(Strings.ERROR_BAD_INPUT);
			displaySystemNotify(Strings.NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED);
			return null;
		}
		else
		{
			userInput.put("inputEndDate", inputEndDate);
		}

		//Price
		displayPrompt(Strings.PROMPT_FOR_PRICE);
		price = inputUtils.getPriceInput(inputUtils.getDoubleInput());
		if (price < 0)
		{
			displaySystemNotify(Strings.ERROR_BAD_INPUT);
			displaySystemNotify(Strings.NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED);
			return null;
		}
		else
		{
			userInput.put("price", price);
		}

		return userInput;
	}

	/**
	 * Displays all show listings
	 * @param showsList
	 */
	public void displayAllShowsList(ShowList showsList)
	{
		ArrayList<Show> shows = showsList.getShowsList();
	
		System.out.println("\n\n" + Strings.HEADER_LIST_ALL_SHOWS);
	
		for(int i = 0; i < shows.size(); ++i)
		{
			System.out.println(shows.get(i).toString());
		}
	}

	/**
	 * Sells tickets and prompts for quantity, customer ID, card number, and date
	 * Works for all three tickets: regular, advance, and student advance
	 * @return
	 */
	public Map<String, Object> sellTickets() {
		Map<String, Object> userInput = new HashMap<String, Object>();

		int quantity;
		long customerID;
		String cardNumber;
		int[] dateInput;
		Calendar date;

		//Quantity prompt
		displayPrompt(Strings.PROMPT_FOR_TICKET_QUANTITY);
		quantity = inputUtils.getIntInput();
		if (quantity < 0) {
			displaySystemNotify(Strings.ERROR_BAD_INT_INPUT);
			return null;
		} else
		{
			userInput.put("quantity", quantity);
		}

		//Client ID prompt
		displayPrompt(Strings.PROMPT_FOR_CUSTOMER_ID);
		customerID = inputUtils.getLongInput();
		if (customerID < 0)
		{
			displaySystemNotify(Strings.ERROR_BAD_LONG_INPUT);
			return null;
		} else
		{
			userInput.put("customerID", customerID);
		}

		//cardNumber prompt
		displayPrompt(Strings.PROMPT_FOR_CREDIT_CARD_NUMBER);
		cardNumber = inputUtils.getStringInput();
		if (cardNumber == null)
		{
			displaySystemNotify(Strings.ERROR_BAD_INPUT);
			return null;
		} else
		{
			userInput.put("cardNumber", cardNumber);
		}

		//date prompt and converts input to Calendar type
		displayPrompt(Strings.PROMPT_FOR_DATE);
		dateInput = inputUtils.getDateInput(inputUtils.getStringInput());
		if (dateInput == null)
		{
			displaySystemNotify(Strings.ERROR_BAD_DATE_INPUT);
			return null;
		} else
		{
			date = new GregorianCalendar(dateInput[0], dateInput[1], dateInput[2], 0, 0, 0);
			userInput.put("date", date);
		}

		//returns userInput to Controller
		return userInput;
	}

	/**
	 * Asks for clientID and passes to controller
	 * @return clientID
	 */
	public long payClient()
	{
		displayPageHeader(Strings.HEADER_PAY_CLIENT);

		displayPrompt(Strings.PROMPT_FOR_CLIENT_ID);

		long clientID = inputUtils.getLongInput();
		if (clientID < 0)
		{
			displaySystemNotify(Strings.ERROR_BAD_LONG_INPUT);
		}

		return clientID;
	}

	/**
	 * Asks for pay amount for client and passes to controller
	 * @return pay
	 */
	public double pay()
	{
		displayPrompt(Strings.PROMPT_FOR_PAY);
		double pay = inputUtils.getPriceInput(inputUtils.getDoubleInput());

		if(pay < 0)
		{
			displaySystemNotify(Strings.ERROR_BAD_PRICE);
		}

		return pay;
	}

	/**
	 * Display welcome message, list of options, and getting user input. 
	 * 
	 */
	public int mainMenu()
	{
		String[] commands = Strings.ALL_API_CALLS; //Controller API commands
	
		System.out.printf("\n\n%s, %s \n", Strings.MESSAGE_WELCOME, Strings.PROMPT_MENU_OPTION);
	
		for(int i = 0; i < commands.length; ++i)
		{
			System.out.printf(i + ". %s \n", commands[i]);
		}
		
		return inputUtils.getIntInput(); //-1 if error
	}
	/**
	 * Displays help info of all commands
	 */
	public void displayHelp()
	{
		String[] commands = Strings.HELP_MENU; //Controller API commands
	
		System.out.printf("\n\n%s\n", Strings.PROMPT_MENU_OPTION);
	
		for(int i = 0; i < commands.length; ++i)
		{
			System.out.printf("%s \n", commands[i]);
		}
	}

	/**
	 * Display system notifications
	 * @param message
	 */
	public void displaySystemNotify(String message)
	{
		System.out.printf("%s\n", message);
	}

	/**
	 * Display system prompt for user
	 * @param prompt
	 */
	public void displayPrompt(String prompt)
	{
		System.out.printf("%s\n", prompt);
	}
	
	/**
	 * Display header of selected category
	 * @param header
	 */
	public void displayPageHeader(String header)
	{
		System.out.printf("%s\n", header);
	}
}