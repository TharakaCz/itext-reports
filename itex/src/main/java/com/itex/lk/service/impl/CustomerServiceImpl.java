/**
 * Jun 14, 2019	
 * itex
 * com.itex.lk.service.impl
 */
package com.itex.lk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itex.lk.dao.CustomerDao;
import com.itex.lk.helper.CustomerDto;
import com.itex.lk.model.Customer;
import com.itex.lk.service.CustomerService;
import com.itex.lk.utill.AppConstant;

/**
 * @author Tharaka Chandralal
 */
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	/* (non-Javadoc)
	 * @see com.itex.lk.service.CustomerService#saveCustomer(com.itex.lk.helper.CustomerDto)
	 */
	@Override
	public String saveCustomer(CustomerDto customerDto) throws Exception {
		
		Customer customer = customerDao.findByCustomerNic(customerDto.getCustomerNic());
		
		if (customer == null) {
			
			Customer customerEntity = new Customer();
			
			customerEntity.setCustomerId(UUID.randomUUID().toString());
			customerEntity.setCustomerName(customerDto.getCustomerName());
			customerEntity.setAddress(customerDto.getAddress());
			customerEntity.setCustomerEmail(customerDto.getCustomerEmail());
			customerEntity.setCustomerNic(customerDto.getCustomerNic());
			customerEntity.setGender(customerDto.getGender());
			customerEntity.setMobileNumber(customerDto.getMobileNumber());
			customerEntity.setStatus(AppConstant.ACTIVE);
			customerDao.save(customerEntity);
			
			return "Customer Added Succsess . . !";
			
		}else {
			
			return "Customer All Ready Exist . . !";
		}
		
	}

	/* (non-Javadoc)
	 * @see com.itex.lk.service.CustomerService#updateCustomer(com.itex.lk.helper.CustomerDto)
	 */
	@Override
	public String updateCustomer(CustomerDto customerDto) throws Exception {
		
		Customer customer = customerDao.findByCustomerId(customerDto.getCustomerId());
		
		customer.setCustomerEmail(customerDto.getCustomerEmail());
		customer.setAddress(customerDto.getAddress());
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setCustomerNic(customerDto.getCustomerNic());
		customer.setGender(customerDto.getGender());
		customer.setMobileNumber(customerDto.getMobileNumber());
		
		customerDao.save(customer);
		
		return "Customer Update Succsess . . !";
	}

	/* (non-Javadoc)
	 * @see com.itex.lk.service.CustomerService#deleteCustomer(java.lang.String)
	 */
	@Override
	public String deleteCustomer(String customerId) throws Exception {
		
		Customer customer = customerDao.findByCustomerId(customerId);
		
		if (customer != null) {
			customer.setStatus(AppConstant.DEACTIVE);
			customerDao.save(customer);
			return "Customer Save Succsess . . !";
		}else {
			return "Customer Delete Faild Try Again . . !";
		}
		
	}

	/* (non-Javadoc)
	 * @see com.itex.lk.service.CustomerService#findCustomer(java.lang.String)
	 */
	@Override
	public CustomerDto findCustomer(String customerId) throws Exception {
		
		Customer customer = customerDao.findByCustomerId(customerId);
		CustomerDto customerDto = getCustomer(customer);
		
		return customerDto;
		
	}

	/* (non-Javadoc)
	 * @see com.itex.lk.service.CustomerService#getAllCustomer()
	 */
	@Override
	public List<CustomerDto> getAllCustomer() throws Exception {
		
		List<Customer> customers = customerDao.findByStatus(AppConstant.ACTIVE);
		
		ArrayList<CustomerDto>customerDtos = new ArrayList<>();
		
		customers.forEach(each ->{
			try {
				customerDtos.add(getCustomer(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return customerDtos;
	}

	private CustomerDto getCustomer(Customer customer)throws Exception{
		CustomerDto customerDto = new CustomerDto();
		
		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setCustomerEmail(customer.getCustomerEmail());
		customerDto.setCustomerName(customer.getCustomerName());
		customerDto.setCustomerNic(customer.getCustomerNic());
		customerDto.setGender(customer.getGender());
		customerDto.setMobileNumber(customer.getMobileNumber());
		customerDto.setAddress(customer.getAddress());
		
		return customerDto;
	}
}
