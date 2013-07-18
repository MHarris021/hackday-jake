package com.sf.jake.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sf.jake.model.BaseCoverageOption;

//@Configuration
public class CoverageOptionConfig {

	@Bean
	public BaseCoverageOption noOption() {
		BaseCoverageOption baseCoverageOption = new BaseCoverageOption(
				"No Option", BigDecimal.valueOf(0));
		return baseCoverageOption;

	}

	@Bean
	public BaseCoverageOption roadSideAssistance() {
		BaseCoverageOption baseCoverageOption = new BaseCoverageOption(
				"Road Side Assistance", BigDecimal.valueOf(72));
		return baseCoverageOption;

	}

	@Bean
	public BaseCoverageOption loanerVehicle() {
		BaseCoverageOption baseCoverageOption = new BaseCoverageOption(
				"Loaner Vehicle", BigDecimal.valueOf(150));
		return baseCoverageOption;
	}

	@Bean
	public BaseCoverageOption automaticResponse() {
		BaseCoverageOption baseCoverageOption = new BaseCoverageOption(
				"Automatic Assistance", BigDecimal.valueOf(500));
		return baseCoverageOption;
	}

	@Bean(name = "coverageOptions")
	public List<BaseCoverageOption> coverageOptions() {
		List<BaseCoverageOption> coverageOptions = new ArrayList<BaseCoverageOption>();
		coverageOptions.add(noOption());
		coverageOptions.add(roadSideAssistance());
		coverageOptions.add(loanerVehicle());
		coverageOptions.add(automaticResponse());
		return coverageOptions;
	}

}
