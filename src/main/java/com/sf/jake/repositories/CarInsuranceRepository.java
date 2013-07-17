package com.sf.jake.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sf.jake.model.CarInsurance;
import com.sf.jake.model.Vehicle;

@Repository
public interface CarInsuranceRepository extends
		CrudRepository<CarInsurance, BigInteger> {

	@Query
	CarInsurance findByVehicle(Vehicle vehicle);

}
