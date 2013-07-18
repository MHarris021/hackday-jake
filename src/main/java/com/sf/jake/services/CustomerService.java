package com.sf.jake.services;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sf.jake.model.Customer;
import com.sf.jake.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Resource
	private CustomerRepository customerRepository;
	
	public List<Customer> getCustomers(){
		return (List<Customer>) customerRepository.findAll();
	}
	
	public List<Customer> getCustomersByFirstName(String firstName) {
		return customerRepository.findByFirstName(firstName);
	}
	
	public List<Customer> getCustomersByLastName(String lastName) {
		return customerRepository.findByLastName(lastName);
	}
	
	public List<Customer> getCustomersByName(String name) {
		return customerRepository.findByFirstAndLastName(name);
	}
	
	public  Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public  Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	
	public Customer getCustomer(BigInteger id) {
		return customerRepository.findOne(id);
	}
	
	public Customer getCustomerByAccountName(String accountName) {
		return customerRepository.findUniqueByAccountName(accountName);
	}
	
	public Customer createCustomer(String accountName) {
		Customer customer = new Customer(accountName);
		customer = customerRepository.save(customer);
		return customer;
	}
}
