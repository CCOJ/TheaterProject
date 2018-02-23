package Utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ID_Generator implements Serializable
{
	public static Long getUniqueGeneratedID()
	{
		return convertTimeStampToID();
	}
	
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
}
