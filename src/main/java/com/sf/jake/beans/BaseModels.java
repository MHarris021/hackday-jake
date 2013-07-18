package com.sf.jake.beans;

import java.util.Map;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.sf.jake.model.Vehicle;

//@Component
public class BaseModels {
	
	@Resource
	private Map<Vehicle, DateTime> baseModelsMap;
	
	public BaseModels() {
	}
	
	public DateTime getBaseYear(Vehicle vehicle) {
		return baseModelsMap.get(vehicle);
	}
}
