package com.sf.jake.services;

import javax.annotation.Resource;

import com.sf.jake.model.CarInsurance;
import com.sf.jake.model.CarInsuranceQuote;
import com.sf.jake.model.Vehicle;
import com.sf.jake.repositories.CarInsuranceRepository;

public class InsuranceQuoteService {

	@Resource
	private CarInsuranceRepository carInsuranceRepository;
	
	public CarInsuranceQuote getQuote(Vehicle vehicle,
			Class<CarInsurance> clazz) {
		CarInsurance carInsurance = carInsuranceRepository.findByVehicle(vehicle);
		CarInsuranceQuote quote = new CarInsuranceQuote(carInsurance);
		return quote;
	}

}
