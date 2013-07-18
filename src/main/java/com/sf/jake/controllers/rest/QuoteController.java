package com.sf.jake.controllers.rest;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sf.jake.beans.BaseModels;
import com.sf.jake.services.InsuranceQuoteService;

@Controller
@RequestMapping(value = "/quotes")
public class QuoteController {
	
	@Resource
	private InsuranceQuoteService insuranceQuoteService;
	
	@Resource
	private BaseModels baseModels;
	
//	@RequestMapping(value="/auto")
//	public ResponseEntity<CarInsuranceQuote> getAutoQuote(@RequestBody Vehicle vehicle) {
//		DateTime baseYear = baseModels.getBaseYear(vehicle);
//		CarInsuranceQuote insuranceQuote = insuranceQuoteService.getQuote(vehicle, baseYear);
//		ResponseEntity<CarInsuranceQuote> responseEntity = new ResponseEntity<CarInsuranceQuote>(
//				insuranceQuote, HttpStatus.OK);
//		return responseEntity;
//	}

}
