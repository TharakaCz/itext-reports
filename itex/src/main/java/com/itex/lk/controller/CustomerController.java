/**
 * Jun 14, 2019	
 * itex
 * com.itext.lk.controller
 */
package com.itex.lk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itex.lk.helper.CustomerDto;
import com.itex.lk.service.CustomerService;

/**
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value="/itex/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value="/saveCustomer")
	public ResponseEntity<Object>saveCustomer(@RequestBody CustomerDto customerDto){
		try {
			return new ResponseEntity<Object>(customerService.saveCustomer(customerDto),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/updateCustomer")
	public ResponseEntity<Object>updateCustomer(@RequestBody CustomerDto customerDto){
		try {
			return new ResponseEntity<Object>(customerService.updateCustomer(customerDto),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/deleteCustomer/{customerId}")
	public ResponseEntity<Object>deleteCustomer(@PathVariable("customerId") String customerId){
		try {
			return new  ResponseEntity<Object>(customerService.deleteCustomer(customerId),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new  ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/findCustomer/{customerId}")
	public ResponseEntity<Object>findCustomer(@PathVariable("customerId") String customerId){
		try {
			return new ResponseEntity<Object>(customerService.findCustomer(customerId),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllCustomer")
	public ResponseEntity<Object>getAllCustomers(){
		try {
			return new ResponseEntity<Object>(customerService.getAllCustomer(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/getAllCustomerUsingNic/{customerNic}")
	public ResponseEntity<Object>getAllCustomersUsingNic(@PathVariable("customerNic")String customerNic){
		try {
			return new ResponseEntity<Object>(customerService.findCustomerUsingNic(customerNic),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
