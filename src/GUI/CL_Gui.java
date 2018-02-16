package theaterProject.GUI;

import theaterProject.Main.Controller;
import theaterProject.Utils.InputUtils;
import theaterProject.Utils.Strings;
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
	 * Display welcome message, list of options, and getting user input. 
	 * 
	 */
	public void displayMainMenu()
	{
		String[] commands = Strings.API_CALLS; //Controller API commands
		
		System.out.printf("%s, %s \n", Strings.WELCOME_MSG, Strings.PLEASE_INPUT_OPTION);
		
		for(int i = 0; i < commands.length; ++i)
		{
			System.out.printf(i + ". %s \n", commands[i]);
		}
		
		controller.commandSwitch(inputUtils.getIntInput());
	}
	/**
	 * 
	 */
	public void displayHelp()
	{
		
	}
}