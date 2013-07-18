package com.sf.jake.config;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sf.jake.model.Customer;
import com.sf.jake.model.Gender;
import com.sf.jake.services.CustomerService;

@Configuration
public class CustomerConfig {
	
	@Resource
	private CustomerService customerService;

	@Bean
	public Customer johnDoe() {
		Customer customer = new Customer("Doe-1");
		customer.setFirstName("John");
		customer.setLastName("Doe");
		customer.setGender(Gender.Male);
		Date dateOfBirth = Calendar.getInstance().getTime();

		customer.setDateOfBirth(dateOfBirth);
		return customer;
	}
	
	@PostConstruct
	public void init() {
		customerService.addCustomer(johnDoe());
	}
}
