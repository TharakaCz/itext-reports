/**
 * Jun 24, 2019	
 * itex
 * com.itex.lk.reports.service.impl
 */
package com.itex.lk.reports.service.impl;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itex.lk.dao.CustomerDao;
import com.itex.lk.model.Customer;
import com.itex.lk.reports.service.ItexReportsService;
import com.itex.lk.utill.AppConstant;
import com.itex.lk.utill.GenerateItexPdfReports;

/**
 * @author Tharaka Chandralal
 */
@Service
public class ItexReportsServiceImpl implements ItexReportsService{

	@Autowired
	private CustomerDao customerDao;
	
	/* (non-Javadoc)
	 * @see com.itex.lk.reports.service.ItexReportsService#createCustomerReports(java.lang.String)
	 */
	@Override
	public List<Customer> createCustomerReports() throws Exception {
		
		List<Customer> customers = customerDao.findAllByStatus(AppConstant.ACTIVE);
		
		return customers;
	}

}
