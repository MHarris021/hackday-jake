package com.sf.jake.model;

import java.io.Serializable;

public class AutoQuoteRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Vehicle vehicle;
	private BaseCoverageOption baseCoverageOption;
	
	public AutoQuoteRequest(Vehicle vehicle, BaseCoverageOption baseCoverageOption) {
		setVehicle(vehicle);
		setBaseCoverageOption(baseCoverageOption);
	}

	public BaseCoverageOption getBaseCoverageOption() {
		return baseCoverageOption;
	}

	public void setBaseCoverageOption(BaseCoverageOption baseCoverageOption) {
		this.baseCoverageOption = baseCoverageOption;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
