package com.sella.training.ctb.core.exceptions;


@SuppressWarnings("serial")
public class InvalidBookingDetailsException extends FastTrackException {

	public InvalidBookingDetailsException(String message) {
		super(message);

	}

	public InvalidBookingDetailsException(Throwable e, String message) {
		super(e, message);
	}

	public InvalidBookingDetailsException(Throwable e) {
		super(e);
	}
}
