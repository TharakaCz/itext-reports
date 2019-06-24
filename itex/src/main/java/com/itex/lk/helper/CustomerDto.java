/**
 * Jun 14, 2019	
 * itex
 * com.itex.lk.helper
 */
package com.itex.lk.helper;

/**
 * @author Tharaka Chandralal
 */
public class CustomerDto {

	private String customerId;
	private String customerName;
	private String customerEmail;
	private String customerNic;
	private String gender;
	private String mobileNumber;
	private String address;
	
	
	public CustomerDto() {
	
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerNic() {
		return customerNic;
	}
	public void setCustomerNic(String customerNic) {
		this.customerNic = customerNic;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
