package com.sella.training.ctb.core.view.bookingview;

import com.sella.training.ctb.core.view.bookingview.interfaces.ICustomerInsertionView;

public class CustomerInsertionView implements ICustomerInsertionView {

	private String fromPlace;
	private String travellingDate;

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getTravellingDate() {
		return travellingDate;
	}

	public void setTravellingDate(String travellingDate) {
		this.travellingDate = travellingDate;
	}

	public CustomerInsertionView() {

		this.fromPlace = "";
		this.travellingDate = "";
	}

}
