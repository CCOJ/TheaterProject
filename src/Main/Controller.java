package Main;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import API.Application_API;
import GUI.CL_Gui;
import Theatre.CreditCard;
import Theatre.Customer;
import Theatre.Theater;
import Utils.InputUtils;
import Utils.Strings;
/**
 * This class is the main controller or the application. The CL_Gui is the 
 * command line interface. It will get user input and make a call to this 
 * class for functionality.
 * 
 * @author Ricky
 */
public class Controller implements Application_API
{
	private CL_Gui cL_Gui; //The command-line gui
	private Theater theater;
	private static InputUtils inputUtils; // Functions to get user input
	private static boolean running; // If false, run() will stop executing and the program terminates
	/**
	 * Gets a user input class for error checking and returning proper input
	 * Gui so user can select commands
	 * Variable to keep the program running until the user determines to close
	 */
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
		//Need to finish so user can decide to load file.
		/*
		if(promptRetrieveData())
		{
			retrieveData();
		}
		*/
		// Running is defaulted to true. False when user selects close program.
		while(running)
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
		/*
		 * enterToContinue() may be able to be removed at a later time. If it 
		 * removed, after running a command, the GUI commands pop up so 
		 * programmer must scroll up to see command output.
		 */
		String message = Strings.CONTINUE_ON_ENTER;
		
		switch(userSelection)
		{
			case 0:
					exitApplication(); 
					break;
			case 1:
					addClient();
					inputUtils.enterToContinue(message);
					break;
			case 2:
					removeClient();
					inputUtils.enterToContinue(message);
					break;
			case 3:
					listAllClients();
					inputUtils.enterToContinue(message);
					break;
			case 4: 
					addCustomer();
					inputUtils.enterToContinue(message);
					break;
			case 5: 
					removeCustomer();
					inputUtils.enterToContinue(message);
					break;
			case 6: 
					addCreditCard();
					inputUtils.enterToContinue(message);
					break;
			case 7: 
					removeCreditCard();
					inputUtils.enterToContinue(message);
					break;
			case 8: 
					listAllCustomers();
					inputUtils.enterToContinue(message);
					break;
			case 9: 
					addShowOrPlay();
					inputUtils.enterToContinue(message);
					break;
			case 10: 
					listAllShows();
					inputUtils.enterToContinue(message);
					break;
			case 11: 
					storeData();
					inputUtils.enterToContinue(message);
					break;
			case 12: 
					retrieveData();
					inputUtils.enterToContinue(message);
					break;
			case 13:
					help();
					inputUtils.enterToContinue(message);
					break;
			default: 
					cL_Gui.displaySystemNotify(Strings.ERROR_SELECTION_NOT_IN_RANGE);
					break;
		}
	}
	/**
	 * Prompts the user asking if they would like to retrieve data
	 */
	private boolean promptRetrieveData()
	{
		String input;
		boolean badInput = true;
		boolean loadData = true;
		/*
		 * This function should be done within inputUtils. Create getYesOrNo()
		 */
		while(badInput)
		{
			cL_Gui.displayPrompt(Strings.PROMPT_RETRIEVE_DATA);
			input = inputUtils.getStringInput();
			
			if(input == "y" || input == "Y")
			{
				badInput = false;
				loadData = true;
			}
			else if(input == "n" || input == "N")
			{
				badInput = false;
				loadData = false;
			}
			else
			{
				cL_Gui.displaySystemNotify(Strings.ERROR_BAD_INPUT);
			}
		}
		return loadData;
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

		// TO-DO serialize all data to disk
		running = false;
		storeData();
	}
	/***
	 * 
	 */
	@Override
	public void addClient()
	{
		String name, address, phoneNumber;
		//cL_Gui.displayAddClient();
		cL_Gui.displayPageHeader(Strings.HEADER_ADD_CLIENT);
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_NAME);
		name = inputUtils.getStringInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_ADDRESS);
		//cL_Gui.displayAskAddress();
		address = inputUtils.getStringInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_PHONE_NUMBER);
		//cL_Gui.displayAskPhoneNumber();
		phoneNumber = inputUtils.getStringInput();
		
		//verify that information is entered correctly
		
		theater.addClient(name, address, phoneNumber);
		cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLIENT_ADDED);
	}
	/**
	 * 
	 */
	@Override
	public void removeClient()
	{
		//Remove a client with the given id. If a show is scheduled for the current or a future date for this client, the client cannot be remove
		int clientID;
		cL_Gui.displayPageHeader(Strings.HEADER_REMOVE_CLIENT);
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CLIENT_ID);
		clientID = inputUtils.getIntInput();
		
		theater.removeClient(clientID);
	
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
		String customerName, address, phoneNumber, cardNumber, expirationDate;
		cL_Gui.displayPageHeader(Strings.HEADER_ADD_CUSTOMER);
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_NAME);
		customerName = inputUtils.getStringInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_ADDRESS);
		address = inputUtils.getStringInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_PHONE_NUMBER);
		phoneNumber = inputUtils.getStringInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CREDIT_CARD_NUMBER);
		cardNumber = inputUtils.getStringInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CARD_EXPIRATION);
		expirationDate = inputUtils.getStringInput();
		
		customer = new Customer(customerName, address, phoneNumber, cardNumber, expirationDate);
		theater.addCustomer(customer);
	}
	/**
	 * 
	 */
	@Override
	public void removeCustomer()
	{
		//mer. Remove a customer with the given id. All credit cards related to the customer are also delete
		int customerID;
		
		cL_Gui.displayPageHeader(Strings.HEADER_REMOVE_CUSTOMER);
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CUSTOMER_ID);
		customerID = inputUtils.getIntInput();
		
		theater.removeCustomer(customerID);
	}
	/**
	 * 
	 */
	@Override
	public void addCreditCard()
	{
		CreditCard creditCard;
		int customerID;
		String cardNumber, expirationDate;
		
		cL_Gui.displayPageHeader(Strings.HEADER_ADD_CREDIT_CARD);
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CUSTOMER_ID);
		customerID = inputUtils.getIntInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CREDIT_CARD_NUMBER);
		cardNumber = inputUtils.getStringInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CARD_EXPIRATION);
		expirationDate = inputUtils.getStringInput();
		
		creditCard = new CreditCard(cardNumber, expirationDate);
		theater.addCustomerCreditCard(customerID, creditCard);
	}
	/**
	 * 
	 */
	@Override
	public void removeCreditCard()
	{
		int customerID;
		String cardNumber;
		
		cL_Gui.displayPageHeader(Strings.HEADER_REMOVE_CREDIT_CARD);
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CUSTOMER_ID);
		customerID = inputUtils.getIntInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CREDIT_CARD_NUMBER);
		cardNumber = inputUtils.getStringInput();
		
		theater.removeCustomerCard(customerID, cardNumber);
	}
	/**
	 * 
	 */
	@Override
	public void listAllCustomers()
	{
		cL_Gui.displayAllCustomersList(theater.getCustomerList());
	}
	/**
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void addShowOrPlay()
	{
		String showName;
		int clientID, begYear, begMonth, begDay, endYear, endMonth, endDay;
		//Date begDate, endDate;
		
		cL_Gui.displayPageHeader(Strings.HEADER_ADD_SHOW);
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_SHOW_NAME);
		showName = inputUtils.getStringInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CLIENT_ID);
		clientID = inputUtils.getIntInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_BEGIN_YEAR);
		begYear = inputUtils.getIntInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_BEGIN_MONTH);
		begMonth = inputUtils.getIntInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_BEGIN_DAY);
		begDay = inputUtils.getIntInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_END_YEAR);
		endYear = inputUtils.getIntInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_END_MONTH);
		endMonth = inputUtils.getIntInput();
		
		cL_Gui.displayPrompt(Strings.PROMPT_FOR_END_DAY);
		endDay = inputUtils.getIntInput();
		
		//CHECK IF DATE HAS ANY OVERLAP FAILS IF TRUE
		//CHECK IF ID EXISTS
		
		Calendar begDate = new GregorianCalendar(begYear, begMonth, begDay);
		Calendar endDate = new GregorianCalendar(endYear, endMonth, endDay);
		//begDate = new Date(begYear, begMonth, begDay);
		//endDate = new Date(endYear, endMonth, endDay);

		theater.addShow(showName, clientID, begDate, endDate);
		//Add an error check for overlapping dates.
		cL_Gui.displaySystemNotify(Strings.NOTIFICATION_SHOW_ADDED);
		
	}
	/**
	 * 
	 */
	@Override
	public void listAllShows()
	{
		cL_Gui.displayAllShowsList(theater.getShowList());
	}
	/**
	 * 
	 */
	@Override
	public void storeData()
	{
		
	}
	/**
	 * 
	 */
	@Override
	public void retrieveData()
	{
		/*
		 * Retrieve all information related to the theater. 
		 * If stored data is found, the user has the option to use it. 
		 * The user may also invoke a command to load data, provided 
		 * he/she has not yet issued any data-related commands in 
		 * that session.
		 */
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