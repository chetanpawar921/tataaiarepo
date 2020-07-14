package com.tataaia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name="customermobileinfo")
public class MobileInfo {
	@Column
	private String optinId;	
	
	@Column
	private String mobileNumber;
	
	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/mm/yyyy")
	private Date optinDate;
	
}
