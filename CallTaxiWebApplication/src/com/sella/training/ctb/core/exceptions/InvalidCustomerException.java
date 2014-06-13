package com.sella.training.ctb.core.exceptions;


/**
 * This Exception class is used to handle all invalid Customer details
 * 
 * @author instage42
 * 
 */
@SuppressWarnings("serial")
public class InvalidCustomerException extends FastTrackException {

	/**
	 * @param message
	 */
	public InvalidCustomerException(String message) {
		super(message);

	}

	public InvalidCustomerException(Throwable e, String message) {
		super(e, message);
	}

	public InvalidCustomerException(Throwable e) {
		super(e);
	}
}
