package com.sella.training.ctb.common.utility.stringutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This AmountUtility class is used to validate Amount
 * 
 * @author instage42
 * 
 */
public class AmountUtility {
	private  Pattern patNumber;
	private  Matcher numberMatcher;

	String numberPattern = "^([0-9]+.[0-9]+)$";

	public AmountUtility() {
		patNumber = Pattern.compile(numberPattern);
	}

	/**
	 * The Amount which is to be validated is passed as argument
	 * @param amount
	 * @return boolean
	 */
	public  boolean isValidAmount(String amount)
	{
		
		boolean isValid = false;
		if (amount != null && !(amount.equals(""))) 
		{
			numberMatcher = patNumber.matcher(amount);
			if (numberMatcher.matches() == true) {
				isValid = true;
			} else {
				isValid = false;
			}
		}
		return isValid;
	}	
		
}
