package com.sf.jake.controllers.rest;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sf.jake.beans.BaseModels;
import com.sf.jake.model.AutoQuoteRequest;
import com.sf.jake.model.BaseCoverageOption;
import com.sf.jake.model.CarInsurance;
import com.sf.jake.model.Vehicle;
import com.sf.jake.repositories.CarInsuranceRepository;

@Controller
@RequestMapping(value = "/quotes")
public class QuoteController {

	@Resource
	private CarInsuranceRepository carInsuranceRepository;

	@Resource
	private BaseModels baseModels;

	@RequestMapping(value = "/auto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarInsurance> getAutoQuotes(
			@RequestBody AutoQuoteRequest autoQouteRequest) {
		Vehicle vehicle = autoQouteRequest.getVehicle();
		BaseCoverageOption baseCoverageOption = autoQouteRequest
				.getBaseCoverageOption();
		CarInsurance carInsurance = carInsuranceRepository
				.findUniqueByVehicleYearAndVehicleMakeAndVehicleModelAndCoverageOption(
						vehicle.getYear(), vehicle.getMake(),
						vehicle.getModel(), baseCoverageOption);

		ResponseEntity<CarInsurance> responseEntity = new ResponseEntity<CarInsurance>(
				carInsurance, HttpStatus.OK);
		return responseEntity;
	}

}
