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
import Theatre.Show;
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
			//inputUtils.enterToContinue(message);
			break;
		case 2:
			removeClient();
			//inputUtils.enterToContinue(message);
			break;
		case 3:
			listAllClients();
			//inputUtils.enterToContinue(message);
			break;
		case 4: 
			addCustomer();
			//inputUtils.enterToContinue(message);
			break;
		case 5: 
			removeCustomer();
			//inputUtils.enterToContinue(message);
			break;
		case 6: 
			addCreditCard();
			//inputUtils.enterToContinue(message);
			break;
		case 7: 
			removeCreditCard();
			//inputUtils.enterToContinue(message);
			break;
		case 8: 
			listAllCustomers();
			//inputUtils.enterToContinue(message);
			break;
		case 9: 
			addShowOrPlay();
			//inputUtils.enterToContinue(message);
			break;
		case 10: 
			listAllShows();
			//inputUtils.enterToContinue(message);
			break;
		case 11: 
			storeData();
			//inputUtils.enterToContinue(message);
			break;
		case 12: 
			retrieveData();
			//inputUtils.enterToContinue(message);
			break;
		case 13:
			help();
			//inputUtils.enterToContinue(message);
			break;
		default: 
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_INPUT_YES_NO);
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
			//input = inputUtils.getStringInput();//
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
				cL_Gui.displaySystemNotify(Strings.ERROR_BAD_INPUT);
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
		storeData();
		cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLOSING_APPLICATION);
		cL_Gui.displaySystemNotify(Strings.NOTIFICATION_SERIALIZING_DATA);
		running = false;
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
		phoneNumber = inputUtils.getPhoneNumberInput();

		//verify that information is entered correctly
		if (phoneNumber == null) { //Invalid phone number
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_PHONE_NUMBER);
		} else {
			Person client = new Client(name, address, phoneNumber);
			theater.addClient((Client) client);
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLIENT_ADDED);
		}
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

		if (theater.removeClient(clientID)) {
			cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLIENT_REMOVED);
		} else {
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

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_ADDRESS);
		address = inputUtils.getStringInput();

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_PHONE_NUMBER);
		phoneNumber = inputUtils.getPhoneNumberInput();

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CREDIT_CARD_NUMBER);
		cardNumber = inputUtils.getStringInput();

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CARD_EXPIRATION);
		expirationDate = inputUtils.getStringInput();

		if (phoneNumber == null) { //Invalid phone number
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_PHONE_NUMBER);
		} else {
			customer = new Customer(customerName, address, phoneNumber);
			creditCard = new CreditCard(customer.getUniqueID(), cardNumber, expirationDate);
			theater.addCustomer(customer);
			theater.addCustomerCreditCard(creditCard);
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

		theater.removeCustomer(customerID);
		theater.getCreditCardList().removeAllCustomerCards(customerID);
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

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CREDIT_CARD_NUMBER);
		cardNumber = inputUtils.getStringInput();

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CARD_EXPIRATION);
		expirationDate = inputUtils.getStringInput();


		creditCard = new CreditCard(customerID, cardNumber, expirationDate);
		theater.addCustomerCreditCard(creditCard);

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

		theater.removeCustomerCard(cardNumber);
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
	@SuppressWarnings("deprecation")
	@Override
	public void addShowOrPlay()
	{
		String showName;
		int begYear, begMonth, begDay, endYear, endMonth, endDay;
		long clientID;
		//Date begDate, endDate;

		cL_Gui.displayPageHeader(Strings.HEADER_ADD_SHOW);

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_SHOW_NAME);
		showName = inputUtils.getStringInput();

		cL_Gui.displayPrompt(Strings.PROMPT_FOR_CLIENT_ID);
		clientID = inputUtils.getLongInput();

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

		Show show = new Show(showName, clientID, begDate, endDate);
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
		cL_Gui.displayAllShowsList(theater.getShowsList());
	}
	/**
	 * 
	 */
	@Override
	public void storeData()
	{
		Serializer serializer = new Serializer();
		serializer.serializeTheater(theater);
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

		theater.getClientList();
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