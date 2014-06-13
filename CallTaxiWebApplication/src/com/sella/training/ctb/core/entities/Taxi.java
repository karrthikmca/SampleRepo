package com.sella.training.ctb.core.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CT_MA_TAXI_DETAILS")
public class Taxi implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CT_SQ_TD_TAXI_ID")
	@Column(name = "TD_TAXI_ID")
	private Long taxiId;
	@Column(name = "TD_TAXI_NAME")
	private String taxiName;
	@Column(name = "TD_TYPE")
	private String taxiType;
	@Column(name = "TD_MIN_AMOUNT")
	private Double minimumAmount;
	@Column(name = "TD_AMT_PER_KM")
	private Double amountPerKm;
	@Column(name = "TD_CONTACT_NUMBER")
	private Long contactNumber;
	@OneToOne(mappedBy = "taxiDetails", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Configuration configurationDetails;

	public Long getTaxiId() {
		return taxiId;
	}

	public void setTaxiId(Long taxiId) {
		this.taxiId = taxiId;
	}

	public String getTaxiName() {
		return taxiName;
	}

	public void setTaxiName(String taxiName) {
		this.taxiName = taxiName;
	}

	public String getTaxiType() {
		return taxiType;
	}

	public void setTaxiType(String taxiType) {
		this.taxiType = taxiType;
	}

	public Double getMinimumAmount() {
		return minimumAmount;
	}

	public void setMinimumAmount(Double minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	public Double getAmountPerKm() {
		return amountPerKm;
	}

	public void setAmountPerKm(Double amountPerKm) {
		this.amountPerKm = amountPerKm;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Configuration getConfigurationDetails() {
		return configurationDetails;
	}

	public void setConfigurationDetails(Configuration configurationDetails) {
		this.configurationDetails = configurationDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Taxi [taxiId=");
		builder.append(taxiId);
		builder.append(", taxiName=");
		builder.append(taxiName);
		builder.append(", taxiType=");
		builder.append(taxiType);
		builder.append(", minimumAmount=");
		builder.append(minimumAmount);
		builder.append(", amountPerKm=");
		builder.append(amountPerKm);
		builder.append(", contactNumber=");
		builder.append(contactNumber);
		builder.append("]");
		return builder.toString();
	}

}
