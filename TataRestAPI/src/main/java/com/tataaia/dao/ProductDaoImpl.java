package com.tataaia.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tataaia.model.PolicyInfo;
import com.tataaia.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory factory;
	
	public Session getSession() {
		Session ses=factory.getCurrentSession();
		if(ses==null) {
			ses=factory.openSession();
		}
		return ses;
	}
	
	public List<PolicyInfo> getPolicyData(String policyNumber){
		Query q=getSession().createQuery("from PolicyInfo where policyNumber=:policyNumber");
		q.setParameter("policyNumber",policyNumber);
		return q.getResultList();
	}
	public int emailValidation(String email,String dob) {
		Query q=getSession().createQuery("From PolicyInfo where emailAddress=:emailAddress,dob=:dob");
		q.setParameter("emailAddress", email);
		q.setParameter("dob", dob);
		List<PolicyInfo> pList=q.getResultList();
		
		return pList.size();
	}
	public int mobileNoValidation(String mobileNumber,String dob) {
		Query q=getSession().createQuery("From PolicyInfo where mobileNumber=:mobileNumber,dob=:dob");
		q.setParameter("mobileNumber", mobileNumber);
		q.setParameter("dob", dob);
		List<PolicyInfo> pList=q.getResultList();
		
		return pList.size();
	}
	
	public int emailUpdation(String email,String policyNumber) {
		Query q=getSession().createQuery("Update PolicyInfo set emailAddress=:emailAddress where policyNumber=:policyNumber");
		q.setParameter("emailAddress", email);
		q.setParameter("policyNumber",policyNumber);
				
		return q.executeUpdate();
	}
	
	public int mobileNoUpdation(String mobileNumber,String policyNumber) {
		Query q=getSession().createQuery("Update PolicyInfo set mobileNumber=:mobileNumber where policyNumber=:policyNumber");
		q.setParameter("mobileNumber", mobileNumber);
		q.setParameter("policyNumber",policyNumber);
		
		return q.executeUpdate();
	}
	
	public int PanNoUpdation(String customerPanNo,String policyNumber) {
		Query q=getSession().createQuery("Update PolicyInfo set customerPanNo=:customerPanNo where policyNumber=:policyNumber");
		q.setParameter("customerPanNo", customerPanNo);
		q.setParameter("policyNumber",policyNumber);
		
		return q.executeUpdate();
	}
	
	public int sentOtpOnMobile(String mobileNumber) {
		Query q=getSession().createQuery("From MobileInfo where mobileNumber=:mobileNumber");
		q.setParameter("mobileNumber", mobileNumber);
		List<PolicyInfo> pList=q.getResultList();
		return pList.size();
	}
}
