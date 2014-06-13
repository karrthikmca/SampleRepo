package com.sella.training.ctb.core.exceptions;


@SuppressWarnings("serial")
public class InvalidNumberException extends FastTrackException {

	public InvalidNumberException(String message) {
		super(message);

	}

	public InvalidNumberException(Throwable e, String message) {
		super(e, message);
	}

	public InvalidNumberException(Throwable e) {
		super(e);
	}

}
