package Main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import API.Application_API;
import Abstract.Person;
import GUI.CL_Gui;
import Serializer.Serializer;
import Theatre.Client;
import Theatre.CreditCard;
import Theatre.Customer;
import Theatre.Show;
import Theatre.Theater;
import Ticket.AdvanceTicket;
import Ticket.RegularTicket;
import Ticket.StudentAdvanceTicket;
import Ticket.Ticket;
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
	private static boolean running; // If false, run() will stop executing and the program terminates

	public Controller()
	{
		cL_Gui = new CL_Gui();
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
			if(cL_Gui.promptRetrieveData()) //If previous available, prom
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
			commandSwitch(cL_Gui.mainMenu());
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
	private void commandSwitch(int userSelection)
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
			case 13:	sellRegularTickets();
						break;
			case 14:	sellAdvanceTickets();
						break;
			case 15:	sellStudentAdvanceTickets();
						break;
			case 16:	payClient();
						break;
			case 17:	printAllTicketsForGivenDay();
						break;
			case 18:	help();
						break;
			default:	cL_Gui.displaySystemNotify(Strings.ERROR_SELECTION_NOT_IN_RANGE);
		}
	}
	/**
	 * Stores the program data and sets running to false causing the program 
	 * to stop executing.
	 * @return 
	 * @return 
	 * 
	 */
	@Override
	public boolean exitApplication()
	{
		cL_Gui.exitApplication();
		storeData();
		cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLOSE_SUCCESS);
		running = false;
		return true;
	}
	/**
	 * Typical process is to prompt the user, get input, check that the input is 
	 * a correct format, inform user of incorrect input reason, and then stop 
	 * executing the action if the format is incorrect returning to the main menu. 
	 * 
	 * If no input errors then a Client is made with a name, address, and phoneNumber
	 * 
	 */
	public void addClient()
	{
		Map<String, Object> userInput = cL_Gui.addClient();

		if(userInput != null)
		{
			String name = (String) userInput.get("name");
			String address = (String) userInput.get("address");
			String phoneNumber = (String) userInput.get("phoneNumber");
		
			Person client = new Client(name, address, phoneNumber);
			
			if(theater.getClientList().addClient((Client) client)) //If client was successfully added inform user
			{
				cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLIENT_ADDED_SUCCESS);
			}
			else
			{
				cL_Gui.displaySystemNotify(Strings.NOTIFICATION_ADD_CLIENT_FAILED);
			}
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
		long clientID = cL_Gui.removeClient();

		if(theater.getClientList().clientExists(clientID))
		{
			if(theater.getShowsList().isEveryShowListingInClientsPast(clientID)) //Also true when clientID doesn't exist 
			{
				if(theater.getClientList().removeClient(clientID)) //Removes client if the clientID exists returns true if Client was removed
				{
					cL_Gui.displaySystemNotify(Strings.NOTIFICATION_CLIENT_REMOVED_SUCCESS);
				}
				else
				{
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
			cL_Gui.displaySystemNotify(Strings.ERROR_CLIENT_ID_NOT_FOUND);
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
		Map<String, Object> userInput = cL_Gui.addCustomer();
		
		String customerName = (String) userInput.get("customerName");
		String address = (String) userInput.get("address");
		String phoneNumber = (String) userInput.get("phoneNumber");
		String cardNumber = (String) userInput.get("cardNumber");
		String expirationDate = (String) userInput.get("expirationDate");
		
		Customer customer = new Customer(customerName, address, phoneNumber);
		CreditCard creditCard = new CreditCard(customer.getID(), cardNumber, expirationDate);
		
		if(!theater.getCreditCardList().creditCardExists(cardNumber)) //if card is not in system then add it to the list
		{
			theater.getCustomerList().addCustomer(customer);
			theater.getCreditCardList().addCreditCard(creditCard);
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
		long customerID = cL_Gui.removeCustomer();
		
		if(theater.getCustomerList().customerExists(customerID))
		{
			if(theater.getCustomerList().removeCustomer(customerID)) //RemoveCustomer() is true if customerID is valid. Customer is removed at same time
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
		Map<String, Object> userInput = cL_Gui.addCreditCard();
		
		if(userInput != null)
		{
			long customerID = (long) userInput.get("customerID");
			String cardNumber = (String) userInput.get("cardNumber");
			String expirationDate = (String) userInput.get("expirationDate");
			
			if(theater.getCustomerList().customerExists(customerID))
			{
				if(!theater.getCreditCardList().creditCardExists(cardNumber)) //Null returned if Card Number does not exist
				{
					CreditCard creditCard = new CreditCard(customerID, cardNumber,	expirationDate);
					
					if(theater.getCreditCardList().addCreditCard(creditCard))
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
		else
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_INPUT);
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
		String cardNumber = cL_Gui.removeCreditCard();

		if(cardNumber != null)
		{
			if(theater.getCreditCardList().creditCardExists(cardNumber))
			{
				if(!theater.getCreditCardList().isCustomersOnlyCreditCard(cardNumber)) //If customer has more than one credit card on file
				{
					if(theater.getCreditCardList().removeCreditCard(cardNumber)) //If customer Credit Card removed successfully
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
		Map<String, Object> userInput = cL_Gui.addShowOrPlay();
		
		if(userInput != null)
		{
			String showName = (String) userInput.get("showName");
			int[] inputBegDate = (int[]) userInput.get("inputBegDate");
			int[] inputEndDate = (int[]) userInput.get("inputEndDate");
			long clientID = (long) userInput.get("clientID");
			double price = (double) userInput.get("price");

			if(theater.getClientList().clientExists(clientID)) //Checking that the clientID exists in the system
			{
				//Constructor is in format [0] = Year, [1] = Month, [2] = Day (n-1)
				Calendar begDate = new GregorianCalendar(inputBegDate[0], inputBegDate[1], inputBegDate[2], 0, 0, 0); //Start of time period. Day starts at midnight.
				Calendar endDate = new GregorianCalendar(inputEndDate[0], inputEndDate[1], inputEndDate[2], 23, 59, 59); //End of the time period. Day ends 1-Second to Midnight.

				if(!theater.getShowsList().isShowOverlappingOtherShows(begDate, endDate)) //Check for overlapping day. 1/1/2018 00:00:00 - 1/4/2018 23:59:59
				{
					Show show = new Show(showName, clientID, begDate, endDate, price);
					if(theater.getShowsList().addShow(show))
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
		else
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_INPUT);
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
	public void storeData()
	{
		Serializer serializer = new Serializer();
		cL_Gui.displaySerialization(serializer.serializeTheater(theater));
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
	 * This will sell regular Tickets. It also checks to make sure there is a valid
	 * customer ID, credit card number, and show date.
	 *
	 * This updates customer that attaches tickets to its customer object.
	 *
	 * This updates client that updates balance to its customer object.
	 * 
	 * Sells regular priced tickets
	 */
	public void sellRegularTickets()
	{
		Map<String, Object> userInput = cL_Gui.sellTickets(Strings.HEADER_SELL_REGULAR_TICKET);

		int quantity = (int) userInput.get("quantity");
		long customerID = (long) userInput.get("customerID");
		String cardNumber = (String) userInput.get("cardNumber");
		Calendar date = (Calendar) userInput.get("date");

		if(theater.getCustomerList().customerExists(customerID))
		{
			if(theater.getCreditCardList().creditCardExists(cardNumber))
			{
				if(theater.getShowsList().getShow(date) != null)
				{
					Show show = theater.getShowsList().getShow(date);
					Client client = theater.getClientList().getClient(show.getClientID());

					for(int i = 0; i < quantity; ++i)
					{
						RegularTicket ticket = new RegularTicket(date, show.getPrice()); //Create ticket
		                theater.getTicketList().addTicket(ticket);
		                theater.getCustomerList().getCustomer(customerID).buyTicket(ticket);
						theater.addBalance(ticket.getPrice() / 2.0);
						client.addBalance(ticket.getPrice() / 2.0); 	 //Add revenue to client
					}
				}
				else
				{
					cL_Gui.displaySystemNotify(Strings.ERROR_SHOW_NOT_FOUND);
				}
			}
			else
			{
				cL_Gui.displaySystemNotify(Strings.ERROR_CREDIT_CARD_NOT_FOUND);
			}
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_CUSTOMER_ID_NOT_FOUND);
		}
	}

	/**
	 * Sells advanced tickets 70% of regular tickets
	 */
	public void sellAdvanceTickets()
	{
		Map<String, Object> userInput = cL_Gui.sellTickets(Strings.HEADER_SELL_ADVANCE_TICKET);

		int quantity = (int) userInput.get("quantity");
		long customerID = (long) userInput.get("customerID");
		String cardNumber = (String) userInput.get("cardNumber");
		Calendar date = (Calendar) userInput.get("date");

		if(theater.getCustomerList().customerExists(customerID))
		{
			if(theater.getCreditCardList().creditCardExists(cardNumber))
			{
				if(theater.getShowsList().getShow(date) != null)
				{
					Show show = theater.getShowsList().getShow(date);
					Client client = theater.getClientList().getClient(show.getClientID());

					for(int i = 0; i < quantity; ++i)
					{
						AdvanceTicket ticket = new AdvanceTicket(date, show.getPrice()); //Create ticket
		                theater.getTicketList().addTicket(ticket);
		                theater.getCustomerList().getCustomer(customerID).buyTicket(ticket);
						theater.addBalance(ticket.getPrice() / 2.0);
						client.addBalance(ticket.getPrice() / 2.0); 	 //Add revenue to client
					}
				}
				else
				{
					cL_Gui.displaySystemNotify(Strings.ERROR_SHOW_NOT_FOUND);
				}
			}
			else
			{
				cL_Gui.displaySystemNotify(Strings.ERROR_CREDIT_CARD_NOT_FOUND);
			}
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_CUSTOMER_ID_NOT_FOUND);
		}
	}

	/**
	 * Sells student advance tickets 50% of regular tickets
	 */
	public void sellStudentAdvanceTickets()
	{
		Map<String, Object> userInput = cL_Gui.sellTickets(Strings.HEADER_SELL_STUDENT_ADVANCE_TICKET);

		int quantity = (int) userInput.get("quantity");
		long customerID = (long) userInput.get("customerID");
		String cardNumber = (String) userInput.get("cardNumber");
		Calendar date = (Calendar) userInput.get("date");

		//Sells tickets if valid
		if(theater.getCustomerList().customerExists(customerID))
		{
			if(theater.getCreditCardList().creditCardExists(cardNumber))
			{
				if(theater.getShowsList().getShow(date) != null)
				{
					Show show = theater.getShowsList().getShow(date);
					Client client = theater.getClientList().getClient(show.getClientID());

					for(int i = 0; i < quantity; ++i)
					{
						StudentAdvanceTicket ticket = new StudentAdvanceTicket(date, show.getPrice()); //Create ticket
		                theater.getTicketList().addTicket(ticket);
		                theater.getCustomerList().getCustomer(customerID).buyTicket(ticket);
						theater.addBalance(ticket.getPrice() / 2.0);
						client.addBalance(ticket.getPrice() / 2.0); 	 //Add revenue to client
					}
				}
				else
				{
					cL_Gui.displaySystemNotify(Strings.ERROR_SHOW_NOT_FOUND);
				}
			}
			else
			{
				cL_Gui.displaySystemNotify(Strings.ERROR_CREDIT_CARD_NOT_FOUND);
			}
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_CUSTOMER_ID_NOT_FOUND);
		}
	}

	/**
	 * Gets passed clientID from CL_GUI
	 * If existing client exists, it displays the balance
	 * Then prompts to pay client no more than existing balance
	 */
	public void payClient()
	{
		long clientID = cL_Gui.promptClientID();
		double pay;

		if(clientID > 0)
		{
			if(theater.getClientList().hasClient(clientID))
			{
				Client client = theater.getClientList().getClient(clientID);
				pay = cL_Gui.promptPaymentAmount(client.getBalance());
				
				if(pay <= client.getBalance() && pay > 0)
				{
					client.payClient(pay);
					cL_Gui.displaySystemNotify(Strings.NOTIFICATION_PAY_CLIENT_SUCCESS);
				}
				else
				{
					cL_Gui.displaySystemNotify(Strings.ERROR_ABOVE_BALANCE);
					cL_Gui.displaySystemNotify(Strings.NOTIFICATIOM_PAY_CLIENT_FAILED);
				}
			}
			else
			{
				cL_Gui.displaySystemNotify(Strings.ERROR_CLIENT_ID_NOT_FOUND);
				cL_Gui.displaySystemNotify(Strings.NOTIFICATIOM_PAY_CLIENT_FAILED);
			}
		}
		else
		{
			cL_Gui.displaySystemNotify(Strings.ERROR_BAD_INPUT);	
			cL_Gui.displaySystemNotify(Strings.NOTIFICATIOM_PAY_CLIENT_FAILED);
		}
	}

	@Override
	public void printAllTicketsForGivenDay()
	{
		Calendar date = cL_Gui.promptDate();
		
		cL_Gui.displayAllTicketList(theater.getTicketList(), date);
	}

	/**
	 * Displays main menu options, gets the input, then checks the command switch for instruction
	 *
	 */
	public void help()
	{
		cL_Gui.displayHelp();
	}
}