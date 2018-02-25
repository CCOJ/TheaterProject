package GUI;

import java.util.ArrayList;

import Main.Controller;
import Theatre.Client;
import Theatre.ClientList;
import Theatre.CreditCard;
import Theatre.CreditCardList;
import Theatre.Customer;
import Theatre.CustomerList;
import Theatre.Show;
import Theatre.ShowList;
import Utils.InputUtils;
import Utils.Strings;
/**
 * CL_Gui - (Command Line GUI)
 * This class is the controller for the GUI portion of the
 * application.
 * 
 * @author Ricky
 *
 */
public class CL_Gui
{
	private final Controller controller;
	private final InputUtils inputUtils;
	/**
	 * When a command line gui is created it gets a reference to 
	 * it's controller. This is so the gui can make a call to the 
	 * appropriate function calls on the controller.
	 * 
	 * @param controller
	 */
	public CL_Gui(Controller controller)
	{
		this.controller = controller;
		inputUtils = new InputUtils();
	}
	/**
	 * 
	 * @param message
	 */
	public void displaySystemNotify(String message)
	{
		System.out.printf("%s\n", message);
	}
	/**
	 * 
	 * @param prompt
	 */
	public void displayPrompt(String prompt)
	{
		System.out.printf("%s\n", prompt);
	}
	/**
	 * 
	 * @param header
	 */
	public void displayPageHeader(String header)
	{
		System.out.printf("%s\n", header);
	}
	/**
	 * Display welcome message, list of options, and getting user input. 
	 * 
	 */
	public void displayMainMenu()
	{
		String[] commands = Strings.ALL_API_CALLS; //Controller API commands

		System.out.printf("\n\n%s, %s \n", Strings.MESSAGE_WELCOME, Strings.PROMPT_MENU_OPTION);

		for(int i = 0; i < commands.length; ++i)
		{
			System.out.printf(i + ". %s \n", commands[i]);
		}
	}
	/**
	 * 
	 * @param shows
	 */
	public void displayAllShowsList(ArrayList<Show> shows)
	{
		System.out.println("\n\n" + Strings.HEADER_LIST_ALL_SHOWS);

		for(int i = 0; i < shows.size(); ++i)
		{
			System.out.println(shows.get(i).toString());
		}
	}
	/**
	 * 
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
	 * 
	 * @param clients
	 */
	public void displayAllClientsList(ArrayList<Client> clients)
	{
		System.out.println("\n\n" + Strings.HEADER_LIST_ALL_CLIENTS);

		for(int i = 0; i < clients.size(); ++i)
		{
			System.out.println(clients.get(i).toString());
		}
	}
	/**
	 * 
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
	/**
	 * 
	 * @param customers
	 */
	public void displayAllCustomersList(ArrayList<Customer> customers)
	{
		System.out.println("\n\n" + Strings.HEADER_LIST_ALL_CUSTOMERS);

		for(int i = 0; i < customers.size(); ++i)
		{
			System.out.println(customers.get(i).toString());
		}
	}
	/**
	 * 
	 * @param customerList
	 */
	public void displayAllCustomersList(CustomerList customerList)
	{
		ArrayList<Customer> customers = customerList.getCustomerList();

		System.out.println("\n\n" + Strings.HEADER_LIST_ALL_CUSTOMERS);

		for(int i = 0; i < customers.size(); ++i)
		{
			System.out.println(customers.get(i).toString());
		}
	}
	/**
	 * 
	 */
	public void displayHelp()
	{

	}
	/**
	 * 
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
				if(cards.get(j).getCustomerID() == customers.get(i).getUniqueID())
				{
					str.append("{" + cards.get(j).toString() + "}, ");
				}
			}
			str.append("]");
			System.out.println(str.toString());
			str.delete(0, str.length());
		}
	}
}