package com.tataaia.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tataaia.service.ProductServiceImpl;
import com.tataaia.model.PolicyInfo;

@RestController
@RequestMapping("/rest/")
public class PRestController {
	
	@Autowired
	private ProductServiceImpl service;
	
	@GetMapping("/getPolicyInfo")
	public ResponseEntity<Object> getPolicyProd(@RequestParam("policyNumber") String policyNumber) {
		List<PolicyInfo> pList = service.getPolicyData(policyNumber);
		if(pList.size()>0) {
			return new ResponseEntity<PolicyInfo>(HttpStatus.OK).status(1006).body("");	
		}else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/emailValidate")
	public ResponseEntity<String> emailValidation(@RequestParam("email") String email,@RequestParam("dob") String dob) {
		int i=service.emailValidation(email,dob);
		ResponseEntity.status(1006).body("");
		if(i>0) {
			return new ResponseEntity<String>(HttpStatus.OK).status(1005).body("Success");
		}else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/mobileValidate")
	public ResponseEntity<String> mobileNoValidation(@RequestParam("mobileNo") String mobileNo,@RequestParam("dob") String dob) {
		int i=service.emailValidation(mobileNo,dob);
		if(i>0) {
			return new ResponseEntity<String>(HttpStatus.OK).status(1005).body("Success");
		}else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/emailValidate")
	public ResponseEntity<String> emailUpdation(@RequestParam("email") String email,@RequestParam("policyNumber") String policyNumber) {
		int i=service.emailValidation(email,policyNumber);
		if(i>0) {
			return new ResponseEntity<String>(HttpStatus.OK).status(1004).body("Service Request for Mobile Number Updation Generated");
		}else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/mobileUpdate")
	public ResponseEntity<String> mobileNoUpdation(@RequestParam("mobileNo") String mobileNo,@RequestParam("policyNumber") String policyNumber) {
		int i=service.emailValidation(mobileNo,policyNumber);
		if(i>0) {
			return new ResponseEntity<String>(HttpStatus.OK).status(1004).body("Service Request for Email address Updation Generated");
		}else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/panNoUpdate")
	public ResponseEntity<String> panNoUpdation(@RequestParam("customerPanNo") String customerPanNo,@RequestParam("policyNumber") String policyNumber) {
		int i= service.PanNoUpdation(customerPanNo,policyNumber);
		if(i>0) {
			return new ResponseEntity<String>(HttpStatus.OK).status(1004).body("Service Request for Pan number Updation Generated");
		}else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
