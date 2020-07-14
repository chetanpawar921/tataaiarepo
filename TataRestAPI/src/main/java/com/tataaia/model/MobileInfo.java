package com.tataaia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="customermobileinfo")
public class MobileInfo {
	@Column
	private String mobileNumber;
	
	@Column
	private int otp;
	
	@Column
	private String expiryTime;
	
	@Column
	private Date createdTime;

}
