package com.sf.jake.controllers.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sf.jake.beans.BaseModels;
import com.sf.jake.model.AutoQuoteRequest;
import com.sf.jake.model.BaseCoverageOption;
import com.sf.jake.model.CarInsurance;
import com.sf.jake.model.Vehicle;
import com.sf.jake.repositories.CarInsuranceRepository;
import com.sf.jake.services.InsuranceQuoteService;

@Controller
@RequestMapping(value = "/quotes")
public class QuoteController {

	@Resource
	private CarInsuranceRepository carInsuranceRepository;

	@Resource
	private BaseModels baseModels;

	@Resource
	private InsuranceQuoteService insuranceQuoteService;

	@RequestMapping(value = "/auto", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params = {
			"make", "model" })
	public ResponseEntity<List<CarInsurance>> getAllAuto(
			@RequestParam String make, @RequestParam String model) {
		List<CarInsurance> carInsurances = carInsuranceRepository
				.findByVehicleMakeAndVehicleModel(make, model);
		ResponseEntity<List<CarInsurance>> responseEntity = new ResponseEntity<List<CarInsurance>>(
				carInsurances, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/auto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarInsurance> getAutoQuotes(
			@RequestBody AutoQuoteRequest autoQouteRequest) {
		Vehicle vehicle = autoQouteRequest.getVehicle();
		BaseCoverageOption baseCoverageOption = autoQouteRequest
				.getBaseCoverageOption();
		List<CarInsurance> carInsurances = carInsuranceRepository
				.findByVehicleMakeAndVehicleModel(vehicle.getMake(),
						vehicle.getModel());

		CarInsurance carInsurance = insuranceQuoteService.getQuote(
				carInsurances, vehicle.getYear(), baseCoverageOption);

		ResponseEntity<CarInsurance> responseEntity = new ResponseEntity<CarInsurance>(
				carInsurance, HttpStatus.OK);
		return responseEntity;
	}

}
