package Main;

import Main.Controller;
/**
 * This class is the starting point of the application and simply starts 
 * itself to start the controller. Keeps the controller less cluttered.
 * 
 * @author Noah, Randy, Ricky
 * 
 */
public class Runner
{
	public static void main(String[] args)
	{
		Controller.getInstanceOf().run();
	}
}