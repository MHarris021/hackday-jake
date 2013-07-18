package com.sf.jake.services;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sf.jake.model.BaseCoverageOption;
import com.sf.jake.model.CarInsurance;
import com.sf.jake.model.CarInsuranceQuote;
import com.sf.jake.repositories.CarInsuranceRepository;

@Service
public class InsuranceQuoteService {

	@Resource
	private CarInsuranceRepository carInsuranceRepository;

	
	public CarInsuranceQuote generateQuote(CarInsurance carInsurance) {
		CarInsuranceQuote carInsuranceQuote = new CarInsuranceQuote(carInsurance);
		carInsuranceRepository.save(carInsurance);
		return carInsuranceQuote;
	}


	public CarInsurance getQuote(List<CarInsurance> carInsurances, Date year,
			BaseCoverageOption baseCoverageOption) {
		CarInsurance result = null;
		for(CarInsurance carInsurance: carInsurances){
			if(carInsurance.getVehicle().getYear().equals(year)){
				if(carInsurance.getCoverageOption().getName().equals(baseCoverageOption.getName()))
					result = carInsurance;
				break;
			}
		}
		return result;
	}
}
