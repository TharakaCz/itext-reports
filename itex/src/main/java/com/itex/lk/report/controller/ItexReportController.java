/**
 * Jun 24, 2019	
 * itex
 * com.itex.lk.report.controller
 */
package com.itex.lk.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itex.lk.reports.service.ItexReportsService;

/**
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value="/itex/reports")
public class ItexReportController {

	@Autowired
	private ItexReportsService itexReportsService;
	
	@GetMapping(value="/customerReport",produces=MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<Object>reportItex(){
		try {
			return new ResponseEntity<Object>(itexReportsService.createCustomerReports(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
