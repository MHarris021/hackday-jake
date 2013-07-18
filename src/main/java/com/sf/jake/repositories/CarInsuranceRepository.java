package com.sf.jake.repositories;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sf.jake.model.CarInsurance;

@Repository
public interface CarInsuranceRepository extends
		CrudRepository<CarInsurance, BigInteger> {

	

}
