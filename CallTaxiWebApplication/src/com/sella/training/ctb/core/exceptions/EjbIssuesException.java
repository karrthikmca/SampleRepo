package com.sella.training.ctb.core.exceptions;

@SuppressWarnings("serial")
public class EjbIssuesException extends FastTrackException {

	public EjbIssuesException(String message) {
		super(message);

	}

	public EjbIssuesException(Throwable e, String message) {
		super(e, message);
	}

	public EjbIssuesException(Throwable e) {
		super(e);
	}

}
