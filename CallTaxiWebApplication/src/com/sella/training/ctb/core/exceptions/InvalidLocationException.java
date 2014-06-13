package com.sella.training.ctb.core.exceptions;


@SuppressWarnings("serial")
public class InvalidLocationException extends FastTrackException {

	public InvalidLocationException(String message) {
		super(message);

	}

	public InvalidLocationException(Throwable e, String message) {
		super(e, message);
	}

	public InvalidLocationException(Throwable e) {
		super(e);
	}

}
