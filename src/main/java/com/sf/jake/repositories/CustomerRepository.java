package com.sf.jake.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sf.jake.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, BigInteger> {

	@Query
	List<Customer> findByFirstName(String firstName);
	
	@Query
	List<Customer> findByLastName(String lastName);
	
	@Query
	List<Customer> findByFirstAndLastName(String name);
	
	@Query
	Customer findUniqueByAccountName(String accountName);
}
