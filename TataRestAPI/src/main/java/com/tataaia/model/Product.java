package com.tataaia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="productinfo")
public class Product{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int pId;
	
	@Column
	private String pName;
	@Column
	private String pDesc;
	
	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/mm/yyyy")
	private Date pLaunchDate;
	
	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/mm/yyyy")
	private Date pExpDate;
}
