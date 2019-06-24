/**
 * Jun 14, 2019	
 * itex
 * com.itex.lk.model
 */
package com.itex.lk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tharaka Chandralal
 */
@Entity
@Table(name="CUSTOMER")
public class Customer {

	private String customerId;
	private String customerName;
	private String customerEmail;
	private String customerNic;
	private String gender;
	private String mobileNumber;
	private String address;
	private String status;
	
	public Customer() {
		
	}

	@Id
	@Column(name="CUSTOMER_ID",nullable=false,length=100)
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Column(name="CUSTOMER_NAME",nullable=false,length=255)
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name="EMAIL",nullable=true,length=100)
	public String getCustomerEmail() {
		return customerEmail;
	}

	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Column(name="NIC",nullable=false,length=100)
	public String getCustomerNic() {
		return customerNic;
	}

	public void setCustomerNic(String customerNic) {
		this.customerNic = customerNic;
	}

	@Column(name="GENDER",length=50,nullable=false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	@Column(name="MOBILE_NUMBER",length=10,nullable=true)
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column(name="ADDRESS",length=255,nullable=false)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="STATUS",length=10,nullable=false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
