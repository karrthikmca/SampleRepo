package com.sella.training.ctb.core.exceptions;


@SuppressWarnings("serial")
public class InvalidTimeFormatException extends FastTrackException {

	public InvalidTimeFormatException(String message) {
		super(message);

	}

	public InvalidTimeFormatException(Throwable e, String message) {
		super(e, message);
	}

	public InvalidTimeFormatException(Throwable e) {
		super(e);
	}

}
