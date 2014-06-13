package com.sella.training.ctb.core.properties;

/**
 * This enum has been created to contain different status messages of the taxi
 * such as Available,cancelled,Booked
 * 
 * @author instage42
 * 
 */
public enum Status {

	AVAILABLE("available"), BOOKED("Booked"), CANCELLED("cancelled");

	private String status;

	private Status(String statusString) {
		this.status = statusString;
	}

	public String getStatus() {
		return status;
	}

}
