/**
 * Jun 24, 2019	
 * itex
 * com.itex.lk.reports
 */
package com.itex.lk.reports.service;

import java.util.List;

import com.itex.lk.model.Customer;

/**
 * @author Tharaka Chandralal
 */
public interface ItexReportsService {

	List<Customer> createCustomerReports()throws Exception;
}
