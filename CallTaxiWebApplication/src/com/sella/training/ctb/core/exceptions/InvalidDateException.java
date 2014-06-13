package com.sella.training.ctb.core.exceptions;



@SuppressWarnings("serial")
public class InvalidDateException extends FastTrackException {

	public InvalidDateException(String message) {
		super(message);

	}

	public InvalidDateException(Throwable e, String message) {
		super(e, message);
	}

	public InvalidDateException(Throwable e) {
		super(e);
	}

}
