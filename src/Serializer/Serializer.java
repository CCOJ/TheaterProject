package Serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import Theatre.Theater;

public class Serializer implements Serializable
{

	public boolean serializeTheater(Theater theater)
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream("theater2.ser");
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

	public Theater deserializeTheater()
	{
		try
		{
			FileInputStream fileIn = new FileInputStream("theater2.ser");
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
