package com.sella.training.ctb.core.view.cancellationview;

import com.sella.training.ctb.core.view.cancellationview.interfaces.ICancellationView;

public class CancellationView implements ICancellationView {

	private String bookingId;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sella.training.ctb.view.ICancellationView#getBookingId()
	 */
	public String getBookingId() {
		return bookingId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sella.training.ctb.view.ICancellationView#setBookingId(java.lang.
	 * Long)
	 */
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public CancellationView() {
		this.bookingId ="";
	}

}
