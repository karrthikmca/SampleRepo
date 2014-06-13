package com.sella.training.ctb.core.exceptions;


/**
 * This class is used to handle exception when no taxi is available
 * 
 * @author instage42
 * 
 */
@SuppressWarnings("serial")
public class NoTaxiAvailableException extends FastTrackException {

	public NoTaxiAvailableException(String message) {
		super(message);
	}

	public NoTaxiAvailableException(Throwable e, String message) {
		super(e, message);
	}

	public NoTaxiAvailableException(Throwable e) {
		super(e);
	}
}