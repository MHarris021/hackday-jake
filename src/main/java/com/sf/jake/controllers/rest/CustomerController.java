package com.sf.jake.controllers.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sf.jake.model.Customer;
import com.sf.jake.services.CustomerService;

@Controller
@RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

	@Resource
	private CustomerService customerService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAll() {
		List<Customer> customers = customerService.getCustomers();
		ResponseEntity<List<Customer>> responseEntity = new ResponseEntity<List<Customer>>(
				customers, HttpStatus.OK);
		return responseEntity;
	}
}
