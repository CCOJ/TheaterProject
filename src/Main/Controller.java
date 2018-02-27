package Main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import API.Application_API;
import Abstract.Person;
import GUI.CL_Gui;
import Serializer.Serializer;
import Theatre.Client;
import Theatre.CreditCard;
import Theatre.Customer;
import Theatre.ShowList;
import Theatre.Theater;
import Utils.InputUtils;
import Utils.Strings;
/**
 * This class is the main controller or the application. It will call on the 
 * command-line gui for display. It gets the input from the user, runs test cases 
 * against the input, and calls on the appropriate actions to take upon the theater 
 * and other related classes.
 * 
 * @author Noah, Randy, Ricky
 */
public class Controller implements Application_API
{
	private CL_Gui cL_Gui; //The command-line UI
	private Theater theater;
	private static InputUtils inputUtils; // Functions to get and check user input
	private static boolean running; // If false, run() will stop executing and the program terminates

	public Controller()
	{
		inputUtils = new InputUtils();
		cL_Gui = new CL_Gui(this);
		theater = new Theater(Strings.CINEMA_NAME);
		running = true;
	}
	/**
	 * Runs the controller. When user selects 0 to exit, the boolean running becomes false 
	 * causing the program to stop running run() will stop executing.
	 * 
	 */
	public void run()
	{	
		if(Serializer.isPreviousTheaterDataAvailable())
		{
			if(promptRetrieveData())
			{
				retrieveData();
			}
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_NO_PREVIOUS_DATA_FOUND);
		}

		while(running)	//Running is defaulted to true. False when user selects close program.
		{
			help(); //Displays main menu options, gets the input, checks the Command Switch
		}
	}
	/**
	 * This function takes the user input selection and checks for the proper API 
	 * function call. Default is to inform user that the option selected is not 
	 * within range.
	 * 
	 * @param userSelection - User menu selection
	 * 
	 */
	public void commandSwitch(int userSelection)
	{
		switch(userSelection)
		{
		case 0:		exitApplication(); 
					break;
		case 1:		addClient();
					break;
		case 2:		removeClient();
					break;
		case 3:		listAllClients();
					break;
		case 4:		addCustomer();
					break;
		case 5:		removeCustomer();
					break;
		case 6:		addCreditCard();
					break;
		case 7:		removeCreditCard();
					break;
		case 8:		listAllCustomers();
					break;
		case 9:		addShowOrPlay();
					break;
		case 10:	listAllShows();
					break;
		case 11:	storeData();
					break;
		case 12:	retrieveData();
					break;
		case 13:	help();
					break;
		default:	cL_Gui.displaySystemNotify(Strings.ERROR_SELECTION_NOT_IN_RANGE);
					break;
		}
	}
	/**
	 * Prompts the user asking if they would like to retrieve data. User must 
	 * select some form of yes or no to continue. (y, Y, yes, YES)
	 * 
	 */
	private boolean promptRetrieveData()
	{
		String input = null;

		while(input == null)
		{
			cL_Gui.displayPrompt(Strings.PROMPT_RETRIEVE_DATA);
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
				cL_Gui.displaySystemNotify(Strings.ERROR_BAD_INPUT_YES_NO);
			}
		}
		return false;
	}
	/**
	 * Stores the program data and sets running to false causing the program 
	 * to stop executing.
	 * 
	 */
	@Override
	public void exitApplication()
	{
		cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLOSING_APPLICATION);
		cL_Gui.displaySystemNotify(Strings.NOTIFICATION_SERIALIZING_DATA);
		
		if(storeData()) //True value means data was able to be stored
		{
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_SERIALIZE_SUCCESS);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLOSE_SUCCESS);
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_SERIALIZE_FAILED);
		}
		
		running = false;
	}
	/**
	 * Typical process is to prompt the user, get input, check that the input is 
	 * a correct format, inform user of incorrect input reason, and then stop 
	 * executing the action if the format is incorrect returning to the main menu. 
	 * 
	 * If no input errors then a Client is made with a name, address, and phoneNumber
	 * 
	 */
	@Override
	public void addClient()
	{
		String name, address, phoneNumber;
		cL_Gui.displayPageHeader(Strings.HEADER_ADD_CLIENT);

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_NAME);
		name = inputUtils.getStringInput();
		if(name == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CLIENT_FAILED);
			return;
		}

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_ADDRESS);
		address = inputUtils.getStringInput();
		if(address == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CLIENT_FAILED);
			return;
		}

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_PHONE_NUMBER);
		phoneNumber = inputUtils.getPhoneNumberInput();
		if (phoneNumber == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_PHONE_NUMBER);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CLIENT_FAILED);
			return;
		}

		Person client = new Client(name, address, phoneNumber);
		
		if(theater.addClient((Client) client)) //If client was successfully added inform user
		{
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLIENT_ADDED_SUCCESS);
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CLIENT_FAILED);
		}
	}
	/**
	 * Removes the client from the theater's ClientList. If the Client has a show 
	 * scheduled for the current or a future date, the Client will not be removed 
	 * and the user will be returned to the main menu.
	 * 
	 * Prints a success or failed message upon clientID input.
	 */
	@Override
	public void removeClient()
	{
		//Remove a client with the given id. If a show is scheduled for the current or a future date for this client, the client cannot be remove
		long clientID;
		
		cL_Gui.displayPageHeader(Strings.HEADER_REMOVE_CLIENT);
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CLIENT_ID);
		clientID = inputUtils.getLongInput(); //Returns -1 if input is not a long integer
		
		if(clientID > 0) //clientID cannot be negative
		{
			ShowList showList = theater.getShowsList();
			
			if(showList.isEveryShowListingInPast(clientID)) //Also true when clientID doesn't exist 
			{
				if(theater.removeClient(clientID)) //Removes client if the clientID exists returns true if Client was removed
				{
					cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLIENT_REMOVED_SUCCESS);
				}
				else
				{
					cL_Gui.displaySystemNotify(Strings.ERROR_CLIENT_ID_NOT_FOUND);
					cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLIENT_REMOVED_FAILED);
				}	
			}
			else
			{
				cL_Gui.displaySystemNotify(Strings.NOTIFICATION_SHOW_STILL_ONGOING);
				cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLIENT_REMOVED_FAILED);
			}
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_LONG_INPUT);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLIENT_REMOVED_FAILED);
		}
	}
	/**
	 * Passes the UI the theater's list of clients for printing.
	 * 
	 */
	public void listAllClients()
	{
		cL_Gui.displayAllClientsList(theater.getClientList());
	}
	/**
	 * Adds a new customer and exactly one associated credit card to the Theater Customer 
	 * and Credit Card lists.
	 * 
	 * Typical process is to prompt the user, get input, check that the input is 
	 * a correct format, inform user of incorrect input reason, and then stop 
	 * executing the action if the format is incorrect returning to the main menu. 
	 * 
	 * If there are no input errors then a Client is made with a name, address, 
	 * and phoneNumber. A Credit Card is made next and it's number is checked to 
	 * ensure no duplicates are in the system. If there are no duplicates the Customer 
	 * and Credit Card are added to their respective Theater lists.
	 * 
	 */
	@Override
	public void addCustomer()
	{
		String customerName, address, phoneNumber, cardNumber, expirationDate;
		cL_Gui.displayPageHeader(Strings.HEADER_ADD_CUSTOMER);

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_NAME);
		customerName = inputUtils.getStringInput();
		if(customerName == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CUSTOMER_FAILED);
			return;
		}
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_ADDRESS);
		address = inputUtils.getStringInput();
		if(address == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CUSTOMER_FAILED);
			return;
		}

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_PHONE_NUMBER);
		phoneNumber = inputUtils.getPhoneNumberInput();
		if(phoneNumber == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_PHONE_NUMBER);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CUSTOMER_FAILED);
			return;
		}
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CREDIT_CARD_NUMBER);
		cardNumber = inputUtils.getStringInput();
		if(cardNumber == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CUSTOMER_FAILED);
			return;	
		}

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CARD_EXPIRATION);
		expirationDate = inputUtils.getStringInput();
		if(expirationDate == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CUSTOMER_FAILED);
			return;	
		}

		Customer customer = new Customer(customerName, address, phoneNumber);
		CreditCard creditCard = new CreditCard(customer.getUniqueID(), cardNumber, expirationDate);
		
		
		if(theater.getCustomerCreditCard(cardNumber) == null) //Null if card is not in system
		{
			theater.addCustomer(customer);
			theater.addCustomerCreditCard(creditCard);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CUSTOMER_SUCCESS);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_SUCCESS);
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CREDIT_CARD_EXISTS);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_FAILED);
		}
	}
	/**
	 * Removes a customer from a Theater Customer list. After the Customer is removed all of 
	 * that customer's associated Credit Cards are removed from the Theater Credit Card list.
	 * 
	 * 
	 */
	@Override
	public void removeCustomer()
	{
		long customerID;
		
		cL_Gui.displayPageHeader(Strings.HEADER_REMOVE_CUSTOMER);
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CUSTOMER_ID);
		customerID = inputUtils.getLongInput();

		if(customerID > 0)
		{
			if(theater.removeCustomer(customerID)) //RemoveCustomer() is true if customerID is valid. Customer is removed at same time
			{
				cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CUSTOMER_REMOVED_SUCCESS);
				
				if(theater.getCreditCardList().removeAllCustomerCards(customerID)) //Remove all associated credit cards
				{
					cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ALL_CREDIT_CARDS_REMOVED_SUCCESS);
				}
				else
				{
					cL_Gui.displaySystemNotify(Strings.NOTIFICATION_NO_CREDIT_CARDS_REMOVED);
				}
			}
			else
			{
				cL_Gui.displaySystemNotify(Strings.ERROR_CUSTOMER_ID_NOT_FOUND);
				cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CUSTOMER_REMOVED_FAILED);
			}
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_LONG_INPUT);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CUSTOMER_REMOVED_FAILED);
		}
	}
	/**
	 * Typical process is to prompt the user, get input, check that the input is 
	 * a correct format, inform user of incorrect input reason, and then stop 
	 * executing the action if the format is incorrect returning to the main menu. 
	 * 
	 * If no input errors then a check is performed to ensure the card is not already 
	 * in the Theater Credit Card List. If card is not already in system a new Credit 
	 * Card is made and stored in the Theater Credit Card list.
	 * 
	 */
	@Override
	public void addCreditCard()
	{
		/*
		 * May eventually want to add an expiration date format check in
		 * InputUtils. MM/YYYY
		 */
		long customerID;
		String cardNumber, expirationDate;

		cL_Gui.displayPageHeader(Strings.HEADER_ADD_CREDIT_CARD);

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CUSTOMER_ID);
		customerID = inputUtils.getLongInput();
		if(customerID < 0)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_LONG_INPUT);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_FAILED);
			return;	
		}

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CREDIT_CARD_NUMBER);
		cardNumber = inputUtils.getStringInput();
		if(cardNumber == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_FAILED);
			return;
		}

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CARD_EXPIRATION);
		expirationDate = inputUtils.getStringInput();
		if(expirationDate == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_FAILED);
			return;
		}
		
		if(theater.getCustomerList().customerExists(customerID))
		{
			if(theater.getCustomerCreditCard(cardNumber) == null) //Null returned if Card Number does not exist
			{
				CreditCard creditCard = new CreditCard(customerID, cardNumber,	expirationDate);
				
				if(theater.addCustomerCreditCard(creditCard))
				{
					cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_SUCCESS);
				}
				else
				{
					cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_FAILED);
				}
			}
			else
			{
				cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CREDIT_CARD_EXISTS);
				cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_FAILED);
			}			
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_CUSTOMER_ID_NOT_FOUND);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_FAILED);
		}
	}
	/**
	 * Typical process is to prompt the user, get input, check that the input is 
	 * a correct format, inform user of incorrect input reason, and then stop 
	 * executing the action if the format is incorrect returning to the main menu. 
	 * 
	 * If no input errors then the card is checked to ensure there is more than 1 card on file 
	 * for the Customer.If more than one card then the Credit Card is removed.
	 * 
	 */
	@Override
	public void removeCreditCard()
	{
		/*
		 * Eventually add an InputUtils function to ensure a credit card is 16 digits in length 
		 * and in correct format. xxxx xxxx xxxx xxxx
		 */
		String cardNumber;

		cL_Gui.displayPageHeader(Strings.HEADER_REMOVE_CREDIT_CARD);
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CREDIT_CARD_NUMBER);
		cardNumber = inputUtils.getStringInput();
		if(cardNumber == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_REMOVE_CREDIT_CARD_FAILED);
			return;
		}

		if(theater.getCreditCardList().creditCardExists(cardNumber))
		{
			if(!theater.getCreditCardList().isCustomersOnlyCreditCard(cardNumber)) //If customer has more than one credit card on file
			{
				if(theater.removeCustomerCard(cardNumber)) //If customer Credit Card removed successfully
				{
					cL_Gui.displaySystemNotify(Strings.NOTIFICATION_REMOVE_CREDIT_CARD_SUCCESS);
				}
				else
				{
					cL_Gui.displaySystemNotify(Strings.NOTIFICATION_REMOVE_CREDIT_CARD_FAILED);
				}	
			}
			else
			{
				cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CUSTOMER_HAS_ONLY_ONE_CARD);
				cL_Gui.displaySystemNotify(Strings.NOTIFICATION_REMOVE_CREDIT_CARD_FAILED);
			}	
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CREDIT_CARD_DNE);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_REMOVE_CREDIT_CARD_FAILED);
		}

	}
	/**
	 * Passes the UI the theater's list of Credit Cards for printing.
	 * 
	 */
	@Override
	public void listAllCustomers()
	{
		cL_Gui.displayAllCustomerInformation(theater.getCustomerList(), theater.getCreditCardList());
	}
	/**
	 * Typical process is to prompt the user, get input, check that the input is 
	 * a correct format, inform user of incorrect input reason, and then stop 
	 * executing the action if the format is incorrect returning to the main menu. 
	 * 
	 * If no input errors then a check is made to ensure clientID does exist. If it 
	 * does exist then both a beginning and ending showing day are created. These 
	 * days are checked for overlap with other existing shows in the Theater Show 
	 * list. If no other shows overlap then the show is added to the Theater Show 
	 * list.
	 * 
	 * Showing time period includes the following: 
	 * 2/2/2018 00:00:00 - 2/3/2018 23:59:59
	 * Midnight = start of a day
	 * 1-Second to Midnight = end of a day
	 * 
	 */
	@Override
	public void addShowOrPlay()
	{
		String showName;
		int[] inputBegDate, inputEndDate;
		long clientID;

		cL_Gui.displayPageHeader(Strings.HEADER_ADD_SHOW);

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_SHOW_NAME);
		showName = inputUtils.getStringInput();
		if(showName == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_INPUT_CANNOT_BE_BLANK);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED);
			return;
		}

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CLIENT_ID);
		clientID = inputUtils.getLongInput();
		if(clientID < 0)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_LONG_INPUT);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED);
			return;
		}
		else if (!theater.getClientList().hasClient(clientID))
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_CLIENT_ID_NOT_FOUND);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED);
			return;
		}
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_WHOLE_BEGIN_DATE);
		inputBegDate = inputUtils.getDateInput(inputUtils.getStringInput());
		if(inputBegDate == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_INPUT);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED);
			return;
		}
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_WHOLE_END_DATE);
		inputEndDate = inputUtils.getDateInput(inputUtils.getStringInput());
		if(inputEndDate == null)
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_INPUT);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED);
			return;
		}
		
		if(theater.getClientList().clientExists(clientID)) //Checking that the clientID exists in the system
		{
			//Constructor is in format [0] = Year, [1] = Month, [2] = Day (n-1)
			Calendar begDate = new GregorianCalendar(inputBegDate[0], inputBegDate[1], inputBegDate[2], 0, 0, 0); //Start of time period. Day starts at midnight.
			Calendar endDate = new GregorianCalendar(inputEndDate[0], inputEndDate[1], inputEndDate[2], 23, 59, 59); //End of the time period. Day ends 1-Second to Midnight.

			if(!theater.getShowsList().isShowOverlappingOtherShows(begDate, endDate)) //Check for overlapping day. 1/1/2018 00:00:00 - 1/4/2018 23:59:59
			{
				if(theater.addShow(showName, clientID, begDate, endDate))
				{
					cL_Gui.displaySystemNotify(Strings.NOTIFICATION_SHOW_ADDED_SUCCESS);
				}
				else
				{
					cL_Gui.displaySystemNotify(Strings.NOTIFICATION_SHOW_ADDED_FAILED);
				}
			}
			else
			{
				cL_Gui.displaySystemNotify(Strings.NOTIFICATION_SHOW_OVERLAP);
				cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED);
			}
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLIENT_DNE);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_SHOW_OR_PLAY_FAILED);
		}
	}
	/**
	 * Passes the UI the theater's list of shows for printing.
	 * 
	 */
	@Override
	public void listAllShows()
	{
		cL_Gui.displayAllShowsList(theater.getShowsList());
	}
	/**
	 * Stores a Theater Object and all of it's contents in a Theater.ser file
	 * 
	 * @return isSerializeSuccessful
	 * 
	 */
	@Override
	public boolean storeData()
	{
		Serializer serializer = new Serializer();
		return serializer.serializeTheater(theater); //Serialize success = true; else false
	}
	/**
	 * This function overwrites any previously used Serialized Theater.ser file if user decides they 
	 * don't want to retrieve data.
	 *
	 * Retrieve all information related to a Theater from a theater.ser file. An attempt is made to 
	 * load Theater. If the object can't be deserialized the object will be null and the system will 
	 * use the already initialized version. (Initialized through constructor)
	 * 
	 */
	@Override
	public void retrieveData()
	{
		Serializer serializer = new Serializer();
		Theater tempTheater = serializer.deserializeTheater(); //Null if can't deserialize

		if(tempTheater != null)
		{
			theater = tempTheater;
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_DESERIALIZING_DATA);
		}
	}
	/**
	 * Displays main menu options, gets the input, then checks the command switch for instruction
	 * 
	 */
	@Override
	public void help()
	{
		cL_Gui.displayHelp();
		cL_Gui.displayMainMenu();
		commandSwitch(inputUtils.getIntInput());
	}
}