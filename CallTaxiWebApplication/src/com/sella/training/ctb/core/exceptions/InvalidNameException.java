package com.sella.training.ctb.core.exceptions;


@SuppressWarnings("serial")
public class InvalidNameException extends FastTrackException {

	public InvalidNameException(String message) {
		super(message);

	}

	public InvalidNameException(Throwable e, String message) {
		super(e, message);
	}

	public InvalidNameException(Throwable e) {
		super(e);
	}

}
