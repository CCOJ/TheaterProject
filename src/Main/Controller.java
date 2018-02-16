package theaterProject.Main;

import theaterProject.API.Application_API;
import theaterProject.GUI.CL_Gui;
import theaterProject.Utils.InputUtils;
import theaterProject.Utils.Strings;
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
		running = true;
	}
	/**
	 * Runs the controller. When user selects 0 to exit the program run() will stop executing.
	 * 
	 */
	public void run()
	{
		promptRetrieveData();
		// Running is defaulted to true. False when user selects close program.
		while(running)
		{
			cL_Gui.displayMainMenu();
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
					System.out.println(Strings.SELECTION_NOT_IN_RANGE);
					break;
		}
	}
	/**
	 * Prompts the user asking if they would like to retrieve data
	 */
	private void promptRetrieveData()
	{
		/*
		 * If yes call retrieveData() else return
		 */
	}
	/**
	 * Stores the program data and sets running to false causing the program 
	 * to stop executing
	 */
	@Override
	public void exitApplication()
	{
		System.out.println(Strings.CLOSING_APPLICATION);
		System.out.println(Strings.SERIALIZING_DATA);
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
		
	}
	/**
	 * 
	 */
	@Override
	public void removeClient()
	{
		
	}
	/**
	 * 
	 */
	@Override
	public void listAllClients()
	{
		
	}
	/**
	 * 
	 */
	@Override
	public void addCustomer()
	{
		
	}
	/**
	 * 
	 */
	@Override
	public void removeCustomer()
	{
		
	}
	/**
	 * 
	 */
	@Override
	public void addCreditCard()
	{
		
	}
	/**
	 * 
	 */
	@Override
	public void removeCreditCard()
	{
		
	}
	/**
	 * 
	 */
	@Override
	public void listAllCustomers()
	{
		
	}
	/**
	 * 
	 */
	@Override
	public void addShowOrPlay()
	{
		
	}
	/**
	 * 
	 */
	@Override
	public void listAllShows()
	{

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