package com.sella.training.ctb.core.exceptions;

/**
 * This class is the Root for all exception that occurs
 * 
 * @author instage42
 * 
 */
@SuppressWarnings("serial")
public class FastTrackException extends Exception

{
	private String message;

	/**
	 * @param message
	 */
	public FastTrackException(String message) 
	{
		this.message = message;
	}

	/**
	 * @param e
	 * @param message
	 */
	public FastTrackException(Throwable e, String message)
	{
		super(e);
		this.message = message;
	}

	/**
	 * @param e
	 */
	public FastTrackException(Throwable e)
	{
		super(e);
	}

	@Override
	public String getMessage() {
		return message;
	}

}
