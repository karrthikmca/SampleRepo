package com.sella.training.ctb.common.utility.calendarutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used to validate Time
 * @author instage42
 *
 */
public class TimeUtility {

	private Pattern pattern;
	private  Matcher matcher;

	private static final String TIME_PATTERN = "(0?[1-9]|[1][0-2]):(0?[0-9]|[1][0-9]|[2][0-9]|[3][0-9]|[4][0-9]|[5][0-9]|[6][0]):(0?[0-9]|[1][0-9]|[2][0-9]|[3][0-9]|[4][0-9]|[5][0-9]|[6][0])";

	public TimeUtility() {

		pattern = Pattern.compile(TIME_PATTERN);

	}

	/**
	 * The time which is to be validated is entered by user
	 * If the entered time,matches with the pattern described true value is returned
	 * @param time
	 * @return
	 */
	public boolean validateTime(final String time)
	{
		matcher = pattern.matcher(time);
		boolean isValid=false;
		if (time == null || time.equalsIgnoreCase("")) 
		{
			isValid=false;
		}
		if(matcher.matches()==true)
		{
			isValid=true;
		}
		return isValid;
		
	}
}