package com.sf.jake.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sf.jake.model.CarInsurance;
import com.sf.jake.model.CarInsuranceQuote;
import com.sf.jake.repositories.CarInsuranceRepository;

@Service
public class InsuranceQuoteService {

	@Resource
	private CarInsuranceRepository carInsuranceRepository;

	public CarInsuranceQuote generateQuote(CarInsurance carInsurance) {
		CarInsuranceQuote carInsuranceQuote = new CarInsuranceQuote(
				carInsurance);
		carInsuranceRepository.save(carInsurance);
		return carInsuranceQuote;
	}

	public CarInsurance getQuote(List<CarInsurance> carInsurances, int year,
			String coverageOption) {
		CarInsurance result = null;
		for (CarInsurance carInsurance : carInsurances) {
			if (carInsurance.getVehicle().getYear() == year) {
				if (carInsurance.getCoverageOption().getName()
						.equalsIgnoreCase(coverageOption));
					result = carInsurance;
				break;
			}
		}
		return result;
	}
}
