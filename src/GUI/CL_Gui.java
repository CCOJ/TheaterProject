package GUI;

import java.util.ArrayList;

import Main.Controller;
import Theatre.Client;
import Theatre.Customer;
import Theatre.Show;
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
	
	public void displaySystemNotify(String message)
	{
		System.out.printf("%s\n", message);
	}
	
	public void displayPrompt(String prompt)
	{
		System.out.printf("%s\n", prompt);
	}
	
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
		
		System.out.printf("%s, %s \n", Strings.MESSAGE_WELCOME, Strings.PROMPT_MENU_OPTION);
		
		for(int i = 0; i < commands.length; ++i)
		{
			System.out.printf(i + ". %s \n", commands[i]);
		}
	}
	
	public void displayAllShowsList(ArrayList<Show> shows)
	{
		System.out.println(Strings.HEADER_LIST_ALL_SHOWS);
		
		for(int i = 0; i < shows.size(); ++i)
		{
			System.out.println(shows.get(i).toString());
		}
	}
	
	public void displayAllClientsList(ArrayList<Client> clients)
	{
		System.out.println(Strings.HEADER_LIST_ALL_CLIENTS);
		
		for(int i = 0; i < clients.size(); ++i)
		{
			System.out.println(clients.get(i).toString());
		}
	}
	
	public void displayAllCustomersList(ArrayList<Customer> customers)
	{
		System.out.println(Strings.HEADER_LIST_ALL_CUSTOMERS);
		
		for(int i = 0; i < customers.size(); ++i)
		{
			System.out.println(customers.get(i).toString());
		}
	}
	
	public void displayHelp()
	{
		
	}


}