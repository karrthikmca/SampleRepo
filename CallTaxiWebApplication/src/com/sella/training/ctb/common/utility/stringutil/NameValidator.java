package com.sella.training.ctb.common.utility.stringutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sella.training.ctb.core.exceptions.InvalidNameException;

/**
 * This class is used to validate any Name which is intended to contain only String literals
 * @author instage42
 *
 */
public class NameValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String USERNAME_PATTERN = "^[a-zA-Z]+$";

	public NameValidator() {
		pattern = Pattern.compile(USERNAME_PATTERN);
	}

	
	public boolean validate(final String username) throws InvalidNameException {
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
