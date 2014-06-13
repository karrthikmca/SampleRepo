package com.sella.training.ctb.common.utility;

import com.sella.training.ctb.common.utility.calendarutil.DateParserUtility;
import com.sella.training.ctb.common.utility.calendarutil.TimeUtility;
import com.sella.training.ctb.common.utility.numberutil.NumberFormatUtility;
import com.sella.training.ctb.common.utility.numberutil.NumberUtility;
import com.sella.training.ctb.common.utility.stringutil.AmountUtility;
import com.sella.training.ctb.common.utility.stringutil.LocationValidator;
import com.sella.training.ctb.common.utility.stringutil.NameValidator;
import com.sella.training.ctb.core.exceptions.InvalidAmountException;
import com.sella.training.ctb.core.exceptions.InvalidDateException;
import com.sella.training.ctb.core.exceptions.InvalidLocationException;
import com.sella.training.ctb.core.exceptions.InvalidNameException;
import com.sella.training.ctb.core.exceptions.InvalidNumberException;
import com.sella.training.ctb.core.exceptions.InvalidNumberFormatException;
import com.sella.training.ctb.core.exceptions.InvalidTimeFormatException;
import com.sella.training.ctb.core.properties.ErrorMessages;

/**
 * This Validator Manager contains various validations and returns corresponding boolean values.
 * @author instage42
 *
 */

public class ValidatorManager implements IValidatorManager
{

	public boolean isNameValid(String name) throws InvalidNameException {
		if(new NameValidator().validate(name)==true)
		{
			return true;
		}
		else
		{	
			throw new InvalidNameException(ErrorMessages.INVALID_NAME.getError());
		}
	}

	public boolean isValidContactNumber(String number)throws InvalidNumberException {
		if(new NumberUtility().validateNumber(number)==true)
		{
			return true;
		}
		else
		{
			throw new InvalidNumberException(ErrorMessages.INVALID_NUMBER_FORMAT.getError());
		}
	}

	public boolean isValidTime(String time) throws InvalidTimeFormatException {
		if(new TimeUtility().validateTime(time)==true)
		{
			return true;
		}
		else
		{
			throw new InvalidTimeFormatException(ErrorMessages.INVALID_TIME.getError());
		}
	}

	public boolean isValidAmount(String amount) throws InvalidAmountException 
	{
		if(new AmountUtility().isValidAmount(amount)==true)
		{
			return true;
		}
		else
		{
			throw new InvalidAmountException(ErrorMessages.INVALID_AMOUNT.getError());
		}
	}
	
	public boolean isValidDate(String date) throws InvalidDateException
	{
		if(new DateParserUtility().validateDate(date, "dd-MMM-yyyy"))
		{
			return true;
		}
		else
		{
			throw new InvalidDateException(ErrorMessages.INVALID_DATE_FORMAT.getError());
		}
	}
	public boolean isValidLocation(String location) throws InvalidLocationException
	{
		if(new LocationValidator().validate(location)==true)
		{
			return true;
		}
		else
		{
		throw new InvalidLocationException(ErrorMessages.INVALID_LOCATION.getError());
		}
	}
	public boolean isValidNumberFormat(String number) throws InvalidNumberFormatException
	{
		if(new NumberFormatUtility().validateNumber(number)==true)
				{
			return true;
				}
		else
			throw new InvalidNumberFormatException(ErrorMessages.INVALID_NUMBER.getError());
	}

}
