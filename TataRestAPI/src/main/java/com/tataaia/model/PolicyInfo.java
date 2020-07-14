package com.tataaia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="policyinfo")
public class PolicyInfo {
	@Column
	private String policyNumber;
	@Column
	private String customerID;
	@Column
	private String customerName;
	@Column
	private String insuredName;
	@Column
	private Date dob;
	@Column
	private String emailAddress;
	@Column
	private String mobileNumber;
	@Column
	private String premiumMode;
	@Column
	private String policyStatus;
	@Column
	private String customerPanNo;
	@Column
	private Date policyIssuanceDate;
	@Column
	private String contactNumber;
	@Column
	private Date lastUpdated;
	@Column
	private String emailAddressLastUpdated;
	@Column
	private String bankAccountNumber;
	@Column
	private String whatsappOptInStatus;
	@Column
	private String productName;
	@Column
	private int productID;
	@Column
	private char reinvestApplicable;
	@Column
	private String outstandingPayout;
	@Column
	private String unclaimedAmount;
	@Column
	private String neftRegistered;
	@Column
	private String lastPremiumPaid;
}
