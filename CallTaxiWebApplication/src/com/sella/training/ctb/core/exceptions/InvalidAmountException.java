package com.sella.training.ctb.core.exceptions;



@SuppressWarnings("serial")
public class InvalidAmountException extends FastTrackException {

	public InvalidAmountException(String message) {
		super(message);

	}

	public InvalidAmountException(Throwable e, String message) {
		super(e, message);
	}

	public InvalidAmountException(Throwable e) {
		super(e);
	}

}
