package com.sf.jake.repositories;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sf.jake.model.BaseCoverageOption;
import com.sf.jake.model.CarInsurance;

@Repository
public interface CarInsuranceRepository extends
		CrudRepository<CarInsurance, BigInteger> {

	@Query
	List<CarInsurance> findByVehicleMakeAndVehicleModel(String make, String model);

	@Query
	CarInsurance findUniqueByVehicleYearAndVehicleMakeAndVehicleModelAndCoverageOption(
			Date year, String make, String model,
			BaseCoverageOption coverageOption);

	

}
