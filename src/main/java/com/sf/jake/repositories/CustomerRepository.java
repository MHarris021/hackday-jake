package com.sf.jake.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sf.jake.model.Customer;

@Repository(value="customerRepository")
public interface CustomerRepository extends CrudRepository<Customer, BigInteger> {

	@Query
	List<Customer> findByFirstName(String firstName);
	
	@Query
	List<Customer> findByLastName(String lastName);
	
	@Query
	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
	
	@Query
	Customer findUniqueByAccountName(String accountName);
}
