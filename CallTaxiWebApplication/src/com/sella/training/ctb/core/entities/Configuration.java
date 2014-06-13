package com.sella.training.ctb.core.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CT_TR_CONFIG_TD_DRI")
@NamedQuery(name = "findTaxi", query = "select c from Configuration c where c.taxiLocation LIKE:location and c.taxiStatus LIKE:status")
public class Configuration implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CT_SQ_CON_CONFIG_ID")
	@Column(name = "CON_CONFIG_ID")
	private Long configId;
	@Column(name = "CON_TD_LOCATION")
	private String taxiLocation;
	@Column(name = "CON_TD_STATUS")
	private String taxiStatus;
	@OneToOne(targetEntity = Taxi.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "CON_TD_TAXI_ID", referencedColumnName = "TD_TAXI_ID")
	private Taxi taxiDetails;
	@OneToOne(targetEntity = Driver.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "CON_DRI_DRIVER_ID", referencedColumnName = "DRI_DRIVER_ID")
	private Driver driverDetails;
	private Set<CarBookingDetails> bookingDetails;

	public Long getConfigId() {
		return configId;
	}

	public void setConfigId(Long configId) {
		this.configId = configId;
	}

	public String getTaxiLocation() {
		return taxiLocation;
	}

	public void setTaxiLocation(String taxiLocation) {
		this.taxiLocation = taxiLocation;
	}

	public String getTaxiStatus() {
		return taxiStatus;
	}

	public void setTaxiStatus(String taxiStatus) {
		this.taxiStatus = taxiStatus;
	}

	public Taxi getTaxiDetails() {
		return taxiDetails;
	}

	public void setTaxiDetails(Taxi taxiDetails) {
		this.taxiDetails = taxiDetails;
	}

	public Driver getDriverDetails() {
		return driverDetails;
	}

	public void setDriverDetails(Driver driverDetails) {
		this.driverDetails = driverDetails;
	}

	@OneToMany(targetEntity = CarBookingDetails.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	public Set<CarBookingDetails> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(Set<CarBookingDetails> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Configuration [configId=");
		builder.append(configId);
		builder.append(", taxiLocation=");
		builder.append(taxiLocation);
		builder.append(", taxiStatus=");
		builder.append(taxiStatus);
		builder.append(", taxiDetails=");
		builder.append(taxiDetails);
		builder.append(", driverDetails=");
		builder.append(driverDetails);
		// builder.append(", bookingDetails=");
		// builder.append(bookingDetails);
		builder.append("]");
		return builder.toString();
	}
}
