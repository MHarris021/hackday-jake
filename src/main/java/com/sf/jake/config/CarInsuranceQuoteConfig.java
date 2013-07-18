package com.sf.jake.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sf.jake.model.CarInsurance;
import com.sf.jake.model.CarInsuranceQuote;
import com.sf.jake.services.InsuranceQuoteService;

@Configuration
public class CarInsuranceQuoteConfig {

	@Resource
	private InsuranceQuoteService insuranceQuoteService;

	@Resource
	private List<CarInsurance> carInsuranceList;

	@Bean
	public List<CarInsuranceQuote> carInsuranceQuotes() {
		List<CarInsuranceQuote> carInsuranceQuotes = new ArrayList<CarInsuranceQuote>();
		for (CarInsurance carInsurance : carInsuranceList) {
			CarInsuranceQuote carInsuranceQuote = insuranceQuoteService
					.generateQuote(carInsurance);
			carInsuranceQuotes.add(carInsuranceQuote);
		}
		return carInsuranceQuotes;
	}
	
	@PostConstruct
	public void init() {
		List<CarInsuranceQuote> carInsuranceQuotes = carInsuranceQuotes();
	}
	

}
