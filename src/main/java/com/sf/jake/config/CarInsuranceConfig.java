package com.sf.jake.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sf.jake.beans.BaseModels;
import com.sf.jake.beans.ReplacementCosts;
import com.sf.jake.model.BaseCoverageOption;
import com.sf.jake.model.CarInsurance;
import com.sf.jake.model.Vehicle;

@Configuration
public class CarInsuranceConfig {

	@Resource
	private List<Vehicle> initialModels;

	@Resource
	private BaseModels baseModels;

	@Resource
	private ReplacementCosts replacementCosts;

	@Resource
	private List<BaseCoverageOption> coverageOptions;

	@Bean
	public DateTime now() {
		return DateTime.now();
	}

	@Bean(name="carInsuranceList")
	public List<CarInsurance> carInsuranceList() {
		List<CarInsurance> carInsurances = new ArrayList<CarInsurance>();
		for (Vehicle vehicle : initialModels) {
			List<Vehicle> vehiclesToNow = generateVehiclesToNow(vehicle);

			BigDecimal replacementCost = replacementCosts
					.getBaseReplacementCost(vehicle);
			BigDecimal basePrice = replacementCost.multiply(BigDecimal
					.valueOf(0.10));
			for (Vehicle vehicle2 : vehiclesToNow) {
				int yearDifference = calcYearDifference(vehicle2, vehicle);
				BigDecimal yearIncrease = basePrice.multiply(BigDecimal
						.valueOf(Math.pow(1.05, yearDifference)));
				List<CarInsurance> carInsurances2 = createCarInsurances(vehicle2, yearIncrease);
				carInsurances.addAll(carInsurances2);
			}

		}

		return carInsurances;
	}

	private List<CarInsurance> createCarInsurances(Vehicle vehicle2,
			BigDecimal yearIncrease) {
		List<CarInsurance> carInsurances = new ArrayList<CarInsurance>();
		for(BaseCoverageOption coverageOption: coverageOptions){
			CarInsurance carInsurance = new CarInsurance(vehicle2, yearIncrease);
			carInsurance.setCoverageOption(coverageOption);
			carInsurances.add(carInsurance);
		}
		return carInsurances;
	}

	private int calcYearDifference(Vehicle vehicle2, Vehicle vehicle) {
		return vehicle2.getYear().getYear() - vehicle.getYear().getYear();
	}

	private List<Vehicle> generateVehiclesToNow(Vehicle vehicle) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		DateTime baseYear = baseModels.getBaseYear(vehicle);
		int yearDifference = now().year().get() - baseYear.year().get();
		for (int i = 0; i <= yearDifference; i++) {
			Vehicle vehicle2 = new Vehicle();
			vehicle2.copy(vehicle);
			vehicle2.setYear(baseYear.plusYears(i));
			vehicles.add(vehicle2);
		}
		return vehicles;
	}
}
