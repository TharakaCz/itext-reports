/**
 * Jun 14, 2019	
 * itex
 * com.itext.lk.dao
 */
package com.itex.lk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itex.lk.model.Customer;

/**
 * @author Tharaka Chandralal
 */
public interface CustomerDao extends JpaRepository<Customer, String>{

	Customer findByCustomerNic(String customerNic);
	
	Customer findByCustomerId(String customerId);
	
	List<Customer> findByStatus(String status);
	
	List<Customer> findAllByStatus(String status);
}
