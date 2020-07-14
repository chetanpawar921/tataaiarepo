package com.tataaia.service;

import java.util.List;

import com.tataaia.model.PolicyInfo;
import com.tataaia.model.Product;

public interface ProductService {
	public List<PolicyInfo> getPolicyData(String policyNumber);
	public int emailValidation(String email,String dob);
	public int mobileNoValidation(String mobileNumber,String dob);
	public int emailUpdation(String email,String policyNumber);
	public int mobileNoUpdation(String mobileNumber,String policyNumber);
	public int PanNoUpdation(String customerPanNo,String policyNumber);
	public String sentOtpOnMobile(String mobileNumber);
}
