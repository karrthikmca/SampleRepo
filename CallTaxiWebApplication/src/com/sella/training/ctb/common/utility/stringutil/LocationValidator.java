package com.sella.training.ctb.common.utility.stringutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This class is used to validate the from Place and Destination place
 * @author instage42
 *
 */
public class LocationValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String USERNAME_PATTERN = "^[a-zA-Z]+$";

	public LocationValidator() {
		pattern = Pattern.compile(USERNAME_PATTERN);
	}

	public boolean validate(final String username)
	{
		
		boolean isValid = false;
		if (username != null && !(username.equals(""))) 
		{
			matcher = pattern.matcher(username);
			if (matcher.matches() == true) {
				isValid = true;
			} else {
				isValid = false;
			}
		}
		return isValid;

		
	}

}
