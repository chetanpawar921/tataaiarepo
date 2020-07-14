package com.tataaia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tataaia.dao.ProductDaoImpl;
import com.tataaia.model.PolicyInfo;

@Repository
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDaoImpl dao;
	
	@Override
	public List<PolicyInfo> getPolicyData(String policyNumber) {
		return dao.getPolicyData(policyNumber);
	}

	@Override
	public int emailValidation(String email, String dob) {
		return dao.emailValidation(email, dob);
	}

	@Override
	public int mobileNoValidation(String mobileNumber, String dob) {
		return dao.mobileNoValidation(mobileNumber, dob);
	}

	@Override
	public int emailUpdation(String email, String policyNumber) {
		return dao.emailUpdation(email, policyNumber);
	}

	@Override
	public int mobileNoUpdation(String mobileNumber, String policyNumber) {
		return dao.mobileNoUpdation(mobileNumber, policyNumber);
	}

	@Override
	public int PanNoUpdation(String customerPanNo, String policyNumber) {
		return dao.PanNoUpdation(customerPanNo, policyNumber);
	}

	@Override
	public String sentOtpOnMobile(String mobileNumber) {
		return dao.sentOtpOnMobile(mobileNumber);
	}
}
