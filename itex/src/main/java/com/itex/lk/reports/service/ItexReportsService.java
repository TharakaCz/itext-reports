/**
 * Jun 24, 2019	
 * itex
 * com.itex.lk.reports
 */
package com.itex.lk.reports.service;

import java.io.ByteArrayInputStream;

/**
 * @author Tharaka Chandralal
 */
public interface ItexReportsService {

	ByteArrayInputStream createCustomerReports()throws Exception;
}
