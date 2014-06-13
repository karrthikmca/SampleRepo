package com.sella.training.ctb.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CT_MA_DRIVER")
public class Driver implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CT_SQ_DRI_DRIVER_ID")
	@Column(name="DRI_DRIVER_ID")
	private Long driverId;
	@Column(name = "DRI_DRIVER_NAME")
	private String driverName;
	@Column(name = "DRI_DRIVER_ADDRESS")
	private String driverAddress;
	@Column(name = "DRI_DRIVER_CONTACT")
	private Long driverContact;
	@Column(name = "DRI_REG_NO")
	private String driverRegistrationNumber;

	// @OneToOne(mappedBy="driverDetails",cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	// private Configuration configDetails;

	public Long getDriverId() {
		return driverId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Driver [driverId=");
		builder.append(driverId);
		builder.append(", driverName=");
		builder.append(driverName);
		builder.append(", driverAddress=");
		builder.append(driverAddress);
		builder.append(", driverContact=");
		builder.append(driverContact);
		builder.append(", driverRegistrationNumber=");
		builder.append(driverRegistrationNumber);
		// builder.append(", configDetails=");
		// builder.append(configDetails);
		builder.append("]");
		return builder.toString();
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverAddress() {
		return driverAddress;
	}

	public void setDriverAddress(String driverAddress) {
		this.driverAddress = driverAddress;
	}

	public Long getDriverContact() {
		return driverContact;
	}

	public void setDriverContact(Long driverContact) {
		this.driverContact = driverContact;
	}

	public String getDriverRegistrationNumber() {
		return driverRegistrationNumber;
	}

	public void setDriverRegistrationNumber(String driverRegistrationNumber) {
		this.driverRegistrationNumber = driverRegistrationNumber;
	}
	// public Configuration getConfigDetails() {
	// return configDetails;
	// }
	// public void setConfigDetails(Configuration configDetails) {
	// this.configDetails = configDetails;
	// }

}
