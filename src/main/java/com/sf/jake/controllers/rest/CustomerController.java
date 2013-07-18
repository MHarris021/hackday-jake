package com.sf.jake.controllers.rest;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sf.jake.model.Customer;
import com.sf.jake.services.CustomerService;

@Controller
@RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

	@Resource
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAll() {
		List<Customer> customers = customerService.getCustomers();
		ResponseEntity<List<Customer>> responseEntity = new ResponseEntity<List<Customer>>(
				customers, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "", method = RequestMethod.GET, params={"firstName", "lastName"})
	public ResponseEntity<Customer> getCustomerByName(
			@RequestParam String firstName, @RequestParam String lastName) {
		String name = StringUtils.join(firstName, " ", lastName);
		Customer customer = customerService.getCustomersByName(name).get(0);
				
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(
				customer, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{accountName}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerByAccount(
			@PathVariable String accountName) {
		Customer customer = customerService
				.getCustomerByAccountName(accountName);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(
				customer, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> createCustomer(
			@RequestBody Customer customer) {
		String accountName = StringUtils.join(customer.getLastName(), "_1");
		Customer customer2 = customerService.createCustomer(accountName);
		customer2.copy(customer);
		customer2 = customerService.updateCustomer(customer2);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(
				customer, HttpStatus.OK);
		return responseEntity;
	}
}
