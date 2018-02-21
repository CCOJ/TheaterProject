package Main;

import Main.Controller;
import Utils.Strings;

/**
 * This class is the starting point of the application and simply starts 
 * itself to start the controller. Keeps the controller less cluttered.
 * 
 */
public class Runner
{
	/**
	 * Instantiates self
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args)
	{
		Runner runner = new Runner();
		runner.run();
	}
	/**
	 * Instantiates an instance of the controller and prints a message upon 
	 * successful application termination
	 * 
	 */
	private void run()
	{
		Controller controller = new Controller();
		controller.run();
		System.out.println(Strings.APPLICATION_CLOSE_SUCCESS);
	}
}