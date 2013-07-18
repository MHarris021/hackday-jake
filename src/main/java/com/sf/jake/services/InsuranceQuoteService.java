package com.sf.jake.services;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.sf.jake.model.CarInsurance;
import com.sf.jake.model.CarInsuranceQuote;
import com.sf.jake.model.Vehicle;
import com.sf.jake.repositories.CarInsuranceRepository;

@Service
public class InsuranceQuoteService {

	@Resource
	private CarInsuranceRepository carInsuranceRepository;

	public CarInsuranceQuote getQuote(Vehicle vehicle, DateTime baseYear) {
		CarInsurance carInsurance = carInsuranceRepository
				.findByVehicle(vehicle);
		CarInsuranceQuote quote = new CarInsuranceQuote(carInsurance, baseYear);
		return quote;
	}

	public CarInsuranceQuote generateQuote(CarInsurance carInsurance) {
		CarInsuranceQuote carInsuranceQuote = new CarInsuranceQuote(carInsurance);
		carInsuranceRepository.save(carInsurance);
		return carInsuranceQuote;
	}
}
