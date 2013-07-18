package com.sf.jake.beans;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sf.jake.model.Vehicle;

//@Component
public class ReplacementCosts {

	@Resource
	private Map<Vehicle, BigDecimal> replacementCostMap;
	
	
	public ReplacementCosts() {
	}
	
	public BigDecimal getBaseReplacementCost(Vehicle vehicle) {
		return replacementCostMap.get(vehicle);
	}
	
}
