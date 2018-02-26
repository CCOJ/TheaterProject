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
 * This class is the main controller or the application. The CL_Gui is the 
 * command line interface. It will get user input and make a call to this 
 * class for functionality.
 * 
 * @author Noah, Randy, Ricky
 */
public class Controller implements Application_API
{
	private CL_Gui cL_Gui; //The command-line gui
	private Theater theater;
	private static InputUtils inputUtils; // Functions to get user input
	private static boolean running; // If false, run() will stop executing and the program terminates

	public Controller()
	{
		inputUtils = new InputUtils();
		cL_Gui = new CL_Gui(this);
		theater = new Theater(Strings.CINEMA_NAME);
		running = true;
	}
	/**
	 * Runs the controller. When user selects 0 to exit the program run() will stop executing.
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

		while(running)	//Running is defaulted to true. False when user selects close program.
		{
			cL_Gui.displayMainMenu();
			commandSwitch(inputUtils.getIntInput());
		}
	}
	/**
	 * This function takes the user input selection from the gui and 
	 * makes the appropriate function call.
	 * 
	 * @param userSelection - User input from the GUI
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
	 * Prompts the user asking if they would like to retrieve data
	 */
	private boolean promptRetrieveData()
	{
		String input = null;
		/*
		 * This function should be done within inputUtils. Create getYesOrNo()
		 */
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
	 * to stop executing
	 */
	@Override
	public void exitApplication()
	{
		cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLOSING_APPLICATION);
		cL_Gui.displaySystemNotify(Strings.NOTIFICATION_SERIALIZING_DATA);
		
		if(storeData())
		{
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_SERIALIZE_SUCCESS);
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_SERIALIZE_FAILED);
		}
		
		cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLOSE_SUCCESS);
		running = false;
	}
	/***
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
		theater.addClient((Client) client);
		cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLIENT_ADDED_SUCCESS);
	}
	/**
	 * Removes the client from clientList. If a show is scheduled for current
	 * or future date for this client, the client cannot be removed.
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
		clientID = inputUtils.getLongInput();
		
		if(clientID > 0)
		{
			ShowList showList = theater.getShowsList();
			
			if(showList.isEveryShowListingInPast(clientID))
			{
				if(theater.removeClient(clientID))
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
				//return;
			}
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_LONG_INPUT);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLIENT_REMOVED_FAILED);
		}
	}
	/**
	 * 
	 */
	@Override
	public void listAllClients()
	{
		cL_Gui.displayAllClientsList(theater.getClientList());
	}
	/**
	 * 
	 */
	@Override
	public void addCustomer()
	{
		/*
		 * tomer. The system accepts the name, address, phone number, and the number and expiry 
		 * date of exactly one credit card. The system generates a unique id for the custome
		 */
		Customer customer;
		CreditCard creditCard;
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
		
		customer = new Customer(customerName, address, phoneNumber);
		creditCard = new CreditCard(customer.getUniqueID(), cardNumber, expirationDate);
                if(theater.getCustomerCreditCard(cardNumber) == null){
                    theater.addCustomer(customer);
                    theater.addCustomerCreditCard(creditCard);
                    cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CUSTOMER_SUCCESS);
                    cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_SUCCESS);
                }
                else{
                    cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CREDIT_CARD_EXISTS);
                }		
		//customer = new Customer(customerName, address, phoneNumber, cardNumber, expirationDate);
		//theater.addCustomer(customer);
	}
	/**
	 * RemoveCustomer 
	 */
	@Override
	public void removeCustomer()
	{
		//mer. Remove a customer with the given id. All credit cards related to the customer are also delete
		long customerID;
		
		cL_Gui.displayPageHeader(Strings.HEADER_REMOVE_CUSTOMER);
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CUSTOMER_ID);
		customerID = inputUtils.getLongInput();

		if(customerID > 0)
		{
			if(theater.removeCustomer(customerID)) //Customer found and removed
			{
				cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CUSTOMER_REMOVED_SUCCESS);
				
				if(theater.getCreditCardList().removeAllCustomerCards(customerID)) //Remove all associated credit cards
				{
					cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ALL_CREDIT_CARDS_REMOVED_SUCCESS);
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
		//theater.removeCustomer(customerID);
		//theater.getCreditCardList().removeAllCustomerCards(customerID);
	}
	/**
	 * 
	 */
	@Override
	public void addCreditCard()
	{
		CreditCard creditCard;
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

                if(theater.getCustomerCreditCard(cardNumber) == null){
                    creditCard = new CreditCard(customerID, cardNumber,
                            expirationDate);
                    theater.addCustomerCreditCard(creditCard);
                    cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CREDIT_CARD_SUCCESS);
                }
                else{
                    cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CREDIT_CARD_EXISTS);
                }
                    
		
		
		
		//creditCard = new CreditCard(cardNumber, expirationDate);
		//theater.addCustomerCreditCard(customerID, creditCard);
	}
	/**
	 * 
	 */
	@Override
	public void removeCreditCard()
	{
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

		if(!theater.getCreditCardList().isCustomersOnlyCreditCard(cardNumber))
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
	/**
	 * 
	 */
	@Override
	public void listAllCustomers()
	{
		cL_Gui.displayAllCustomerInformation(theater.getCustomerList(), theater.getCreditCardList());
	}
	/**
	 * 
	 */
	@Override
	public void addShowOrPlay()
	{
		String showName, dateInput;
		int[] inputBegDate, inputEndDate;
		long clientID;
		//Date begDate, endDate;

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
		//CHECK IF DATE HAS ANY OVERLAP FAILS IF TRUE
		//CHECK IF ID EXISTS
		
		//inputDate is in format -> [0] = Year, [1] = Month, [2] = Day
		Calendar begDate = new GregorianCalendar(inputBegDate[0], inputBegDate[1], inputBegDate[2], 0, 0, 0);
		Calendar endDate = new GregorianCalendar(inputEndDate[0], inputEndDate[1], inputEndDate[2], 23, 59, 59);

		//Show show = new Show(showName, clientID, begDate, endDate);
		//theater.addShow(showName, clientID, begDate, endDate); 
		if(!theater.getShowsList().isShowOverlappingOtherShows(begDate, endDate))
		{
			if(theater.addShow(showName, clientID, begDate, endDate)) //Need to check for overlap of show dates.
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

		//Add an error check for overlapping dates.
	}
	/**
	 * 
	 */
	@Override
	public void listAllShows()
	{
		cL_Gui.displayAllShowsList(theater.getShowsList());
	}
	/**
	 * @return 
	 * 
	 */
	@Override
	public boolean storeData()
	{
		Serializer serializer = new Serializer();
		return serializer.serializeTheater(theater); //Serialize success = true; else false
	}
	/**
	 * 
	 */
	@Override
	public void retrieveData()
	{
		/*
		 * This function overwrites any previously used Serialized Theater.ser file if user decides they 
		 * don't want to retrieve data.
		 *
		 * Retrieve all information related to the theater. 
		 * If stored data is found, the user has the option to use it. 
		 * The user may also invoke a command to load data, provided 
		 * he/she has not yet issued any data-related commands in 
		 * that session.
		 *
		 */
		Serializer serializer = new Serializer();
		Theater tempTheater = serializer.deserializeTheater(); 

		if(tempTheater != null)
		{
			theater = tempTheater;
		}

		//theater.getClientList();
	}
	/**
	 * 
	 */
	@Override
	public void help()
	{
		cL_Gui.displayHelp();
	}
}