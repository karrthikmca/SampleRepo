package com.sella.training.ctb.common.utility;

import com.sella.training.ctb.core.exceptions.InvalidAmountException;
import com.sella.training.ctb.core.exceptions.InvalidDateException;
import com.sella.training.ctb.core.exceptions.InvalidLocationException;
import com.sella.training.ctb.core.exceptions.InvalidNameException;
import com.sella.training.ctb.core.exceptions.InvalidNumberException;
import com.sella.training.ctb.core.exceptions.InvalidNumberFormatException;
import com.sella.training.ctb.core.exceptions.InvalidTimeFormatException;

public interface IValidatorManager {

	public abstract boolean isNameValid(String name)
			throws InvalidNameException;

	public abstract boolean isValidContactNumber(String number)
			throws InvalidNumberException;

	public abstract boolean isValidTime(String time)
			throws InvalidTimeFormatException;

	public abstract boolean isValidAmount(String amount)
			throws InvalidAmountException;
	
	public abstract boolean isValidDate(String date)
			throws InvalidDateException;
	
	public abstract boolean isValidLocation(String location)
			throws InvalidLocationException;
	
	public abstract boolean isValidNumberFormat(String number)
			throws InvalidNumberFormatException;


}