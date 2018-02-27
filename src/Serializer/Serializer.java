package Serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import Theatre.Theater;

/**
 * This class saves and loads theater data upon running the program.
 * It also checks for any previous saved data and reloads it.
 */
public class Serializer implements Serializable
{

	/**
	 * Saves the theater to theater.ser
	 * @param theater theater object
	 * @return true if saved, false if not
	 */
	public boolean serializeTheater(Theater theater)
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream("theater.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(theater);
			out.close();
			fileOut.close();
			return true;
		}
		catch (IOException i)
		{
			i.printStackTrace();
			return false;
		}
	}

	/**
	 * Loads the theater from theater.ser
	 * @return true if loaded, false if not
	 */
	public Theater deserializeTheater()
	{
		try
		{
			FileInputStream fileIn = new FileInputStream("theater.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Theater theater = (Theater) in.readObject();
			return theater;
		}
		catch (IOException i)
		{
			//i.printStackTrace();
			return null;
		}
		catch (ClassNotFoundException c)
		{
			System.out.println("Employee class not found");
			//c.printStackTrace();
			return null;
		}
	}

	/**
	 * Loads any previous saved data from theater.ser
	 * @return true if there is previous data, false if not
	 */
	public static boolean isPreviousTheaterDataAvailable()
	{
		try
		{
			FileInputStream fileIn = new FileInputStream("theater.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			//Theater theater = (Theater) in.readObject();
			return true;
		}
		catch (IOException i)
		{
			//i.printStackTrace();
			return false;
		}
	}
}
