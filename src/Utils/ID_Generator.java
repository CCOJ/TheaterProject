package Utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 
 * @author Noah, Randy, Ricky
 * 
 */
@SuppressWarnings("serial")
public class ID_Generator implements Serializable
{
	/**
	 * 
	 * @return
	 */
	public static Long getUniqueGeneratedID()
	{
		return convertTimeStampToID();
	}
	
	public static Long getUniqueGeneratedTicketID()
	{
		return convertTimeStampToTicketID();
	}
	
	/**
	 * 
	 * @return
	 */
	private static long convertTimeStampToID()
	{
		String uniqueID = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		StringBuilder strBuild = new StringBuilder();
		String[] str = uniqueID.split("\\.");
		
		for(int i = 0; i < str.length; ++i)
		{
			strBuild.append(str[i]);
		}
		return Long.parseLong(strBuild.substring(2, strBuild.length()));
	}
	
	/**
	 * 
	 * @return
	 */
	private static long convertTimeStampToTicketID()
	{
		StringBuilder strBuild = new StringBuilder();
		
		try        
		{
			Thread.sleep(2);
			//
			String uniqueID = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss:SSS").format(new Date());

			String[] str = uniqueID.split("\\:");
			
			for(int i = 0; i < str.length; ++i)
			{
				strBuild.append(str[i]);
			}
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
		
		return Long.parseLong(strBuild.substring(2, strBuild.length()));
	}
}
