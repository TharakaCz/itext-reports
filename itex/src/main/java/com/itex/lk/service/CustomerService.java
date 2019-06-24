/**
 * Jun 14, 2019	
 * itex
 * com.itex.lk.service
 */
package com.itex.lk.service;

import java.util.List;

import com.itex.lk.helper.CustomerDto;

/**
 * @author Tharaka Chandralal
 */
public interface CustomerService {

	public String saveCustomer(CustomerDto customerDto)throws Exception;
	
	public String updateCustomer(CustomerDto customerDto)throws Exception;
	
	public String deleteCustomer(String customerId)throws Exception;
	
	public CustomerDto findCustomer(String customerId)throws Exception;
	
	List<CustomerDto> getAllCustomer()throws Exception;
	
}
