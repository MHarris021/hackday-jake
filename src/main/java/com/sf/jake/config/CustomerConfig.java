package com.sf.jake.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sf.jake.model.Address;
import com.sf.jake.model.BaseCoverageOption;
import com.sf.jake.model.CarInsurance;
import com.sf.jake.model.ContactInfo;
import com.sf.jake.model.Customer;
import com.sf.jake.model.Email;
import com.sf.jake.model.Gender;
import com.sf.jake.model.Phone;
import com.sf.jake.model.Product;
import com.sf.jake.model.Vehicle;
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
		customer.setContactInfo(contactInfo());
		customer.setProducts(products());
		return customer;
	}

	@Bean
	public List<Product> products() {
		List<Product> products = new ArrayList<Product>();
		products.add(carInsurance());
		return products;
	}

	@Bean
	public Product carInsurance() {
		CarInsurance carInsurance = new CarInsurance(vehicle(), BigDecimal.valueOf(500));
		carInsurance.setCoverageOption(new BaseCoverageOption("No Option", BigDecimal.ZERO));
		carInsurance.setPremium(BigDecimal.valueOf(500));
		return carInsurance;
	}

	private Vehicle vehicle() {
		Vehicle vehicle = new Vehicle(2013, "Ford", "Explorer");
		return vehicle;
	}

	@Bean
	public ContactInfo contactInfo() {
		ContactInfo contactInfo = new ContactInfo(address(), phone(), email());
		return contactInfo;
	}

	@Bean
	public Email email() {
		return new Email("john.doe@boring.com");
	}

	private Phone phone() {
		return new Phone("309-265-4123");
	}

	private Address address() {
		Address address = new Address();
		List<String> lines = new ArrayList<String>();
		lines.add("123 Fake St");
		lines.add("# 42");
		address.setLines(lines);
		address.setCity("Bloomington");
		address.setState("IL");
		address.setZipcode("61761");
		return address; 
	}

	@PostConstruct
	public void init() {
		customerService.addCustomer(johnDoe());
	}
}
