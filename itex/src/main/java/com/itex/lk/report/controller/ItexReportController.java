/**
 * Jun 24, 2019	
 * itex
 * com.itex.lk.report.controller
 */
package com.itex.lk.report.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itex.lk.model.Customer;
import com.itex.lk.reports.service.ItexReportsService;
import com.itex.lk.utill.GenerateItexPdfReports;

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
	public ResponseEntity<InputStreamResource>reportItex(){
		
		try {
			List<Customer>customers = itexReportsService.createCustomerReports();
			ByteArrayInputStream bis = GenerateItexPdfReports.customerReports(customers);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=customer.pdf");
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
		return new ResponseEntity<InputStreamResource>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
