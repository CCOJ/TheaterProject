package Utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * 
 * 
 * @author Noah, Randy, Ricky
 *
 */
public class DateUtils
{
	/**
	 * This function returns a Gregorian Calendar set at the 
	 * first hour, minute, and second of today's date
	 * @return
	 */
	public static Calendar getGregorianCalendarStartingTodayAtBeginningOfDay()
	{
		Calendar today = new GregorianCalendar();
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		return today;
	}
	/**
	 * This function returns a Gregorian Calendar set at the 
	 * last hour, minute, and second of today's date
	 * @return
	 */
	public static Calendar getGregorianCalendarStaringTodayAtEndOfDay()
	{
		Calendar today = new GregorianCalendar();
		today.set(Calendar.HOUR_OF_DAY, 23);
		today.set(Calendar.MINUTE, 59);
		today.set(Calendar.SECOND, 59);
		return today;
	}
	/**
	 * This function takes a Calendar day and sets the hours
	 * to 0, 0, 0. This is the first hour, minute, second, 
	 * of the day.
	 * @param day
	 * @return
	 */
	public static Calendar setGregorianCalendarToBeginningOfDay(Calendar day)
	{
		day.set(Calendar.HOUR_OF_DAY, 0);
		day.set(Calendar.MINUTE, 0);
		day.set(Calendar.SECOND, 0);
		return day;
	}
	/**
	 * This function takes a Calendar day and sets the hours 
	 * to 23, 59, 59. This is the last hour, minute, second, 
	 * of the day.
	 */
	public static Calendar setGregorianCalendarToEndOfDay(Calendar day)
	{
		day.set(Calendar.HOUR_OF_DAY, 23);
		day.set(Calendar.MINUTE, 59);
		day.set(Calendar.SECOND, 59);
		return day;
	}
}