package com.sella.training.ctb.core.exceptions;


@SuppressWarnings("serial")
public class InvalidNumberFormatException extends FastTrackException {

	public InvalidNumberFormatException(String message) {
		super(message);

	}

	public InvalidNumberFormatException(Throwable e, String message) {
		super(e, message);
	}

	public InvalidNumberFormatException(Throwable e) {
		super(e);
	}

}
