package com.sella.training.ctb.core.properties;

/**
 * This enum has been created to hold the different error messages that has to
 * be shown during various instances
 * 
 * @author instage42
 * 
 */
public enum ErrorMessages {

	NO_TAXI_AVAILABLE("Sorry,No Taxi is available in specified location..!!"),
	DB_EXCEPTION("Sorry,Problem in DataBase Connectivity..Try Later!!"), 
	INVALID_CUSTOMER_EXCEPTION("Sorry,Invalid Customer Details..!!"),
	INVALID_DATE_FORMAT("Sorry,the date you entered is invalid..Please enter Correct date in dd-MMM-yyyy Format!!!!"),
	INVALID_NUMBER_FORMAT("Sorry,The number you entered is not valid..!!!"),
	INVALID_DATE("Do Not Enter a Date From Past"),
	INVALID_LOCATION("The Location You Entered is Invalid..!!!"),
	INVALID_TIME("The Time Format You entered is Invalid..!!!"),
	INVALID_AMOUNT(	"The Amount You Have Entered is Invalid"),
	INVALID_BOOKING_DETAILS("The Booking Details you entered are invalid"),
	BLANK_DATE("Date Field Should not be blank"),
	NO_DATA_FOUND("No Records Were Found for the given Data..!!!"),
	TECHNICAL_PROBLEM("Sorry..Technical Difficulties!!! Try Later"),
	INVALID_NUMBER("Sorry,the number you entered is not valid..!!! "),
	INVALID_NAME("Please enter a valid Name Only..Numerics not allowed");
	private String error;

	private ErrorMessages(String errorString) {
		this.error = errorString;
	}

	public String getError() {
		return error;
	}

}
