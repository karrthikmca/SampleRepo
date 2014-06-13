package com.sella.training.ctb.common.utility.calendarutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class is used for Date Validation purpose.
 * @author instage42
 *
 */
public class DateParserUtility {

	/**
	 * The Date Which is to be validated and the desired date format is entered by the user
	 * @param dateToValidate
	 * @param dateFormat
	 * @return
	 */
	public  boolean validateDate(String dateToValidate, String dateFormat)
	{
		boolean isValidDate=false;
	
	Date date, today = new java.util.Date();
	SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	sdf.setLenient(false);
	
	try {
	// if not valid Date, it will throw ParseException
	date = sdf.parse(dateToValidate);
	if (dateToValidate.equalsIgnoreCase("")||date.before(today))
	{
		isValidDate=false;
	}
	else
	{
	isValidDate=true;
	}
	}
	catch (ParseException e) 
	{
	isValidDate=false;
	}
	return isValidDate;

	}

}
