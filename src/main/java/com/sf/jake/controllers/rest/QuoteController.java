package com.sf.jake.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sf.jake.model.CarInsurance;
import com.sf.jake.model.CarInsuranceQuote;
import com.sf.jake.model.Vehicle;
import com.sf.jake.services.InsuranceQuoteService;

@Controller
@RequestMapping(value = "/quotes")
public class QuoteController {
	
	private InsuranceQuoteService insuranceQuoteService; 

	@RequestMapping(value="/auto")
	public ResponseEntity<CarInsuranceQuote> getAutoQuote(@RequestBody Vehicle vehicle) {
		CarInsuranceQuote insuranceQuote = insuranceQuoteService.getQuote(vehicle, CarInsurance.class);
		ResponseEntity<CarInsuranceQuote> responseEntity = new ResponseEntity<CarInsuranceQuote>(
				insuranceQuote, HttpStatus.OK);
		return responseEntity;
	}

}
