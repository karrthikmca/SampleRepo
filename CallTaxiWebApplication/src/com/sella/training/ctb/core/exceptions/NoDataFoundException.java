package com.sella.training.ctb.core.exceptions;


@SuppressWarnings("serial")
public class NoDataFoundException extends FastTrackException {

	public NoDataFoundException(String message) {
		super(message);

	}

	public NoDataFoundException(Throwable e, String message) {
		super(e, message);
	}

	public NoDataFoundException(Throwable e) {
		super(e);
	}

}
