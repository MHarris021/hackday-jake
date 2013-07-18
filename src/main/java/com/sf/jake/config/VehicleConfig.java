package com.sf.jake.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sf.jake.model.Vehicle;

@Configuration
public class VehicleConfig {

	@Bean
	public DateTime defaultYear() {
		return new DateTime(2000, 1, 1, 0, 0, 0, 0);
	}
	
	@Bean
	public Vehicle fordFiesta() {
		Vehicle vehicle = new Vehicle(defaultYear(), "Ford", "Fiesta");
		return vehicle;
	}
	
	@Bean
	public Vehicle fordExplorer() {
		Vehicle vehicle = new Vehicle(defaultYear(), "Ford", "Explorer");
		return vehicle;
	}
	
	@Bean
	public Vehicle dodgeRam() {
		Vehicle vehicle = new Vehicle(defaultYear(), "Dodge", "Ram");
		return vehicle;
	}
	
	@Bean
	public Vehicle hondaCivic() {
		Vehicle vehicle = new Vehicle(defaultYear(), "Honda", "Civic");
		return vehicle;
	}
	
	@Bean
	public Vehicle nissanAltima() {
		Vehicle vehicle = new Vehicle(defaultYear(), "Nissan", "Altima");
		return vehicle;
	}
	
	@Bean
	public Vehicle toyotaCamry() {
		Vehicle vehicle = new Vehicle(defaultYear(), "Toyota", "Camry");
		return vehicle;
	}
	
	@Bean(name="initialModels")
	public List<Vehicle> initialModels() {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(fordFiesta());
		vehicles.add(fordExplorer());
		vehicles.add(nissanAltima());
		vehicles.add(toyotaCamry());
		vehicles.add(dodgeRam());
		vehicles.add(hondaCivic());
		return vehicles;
	}
	
	@Bean(name="baseModelsMap")
	public Map<Vehicle, DateTime> baseModelsMap() {
		Map<Vehicle, DateTime> map = new HashMap<Vehicle, DateTime>();
		for(Vehicle vehicle : initialModels()){
			map.put(vehicle, vehicle.getYear());
		}
		return map;
	}
	
	@Bean(name="replacementCostMap")
	public Map<Vehicle, BigDecimal> replacementCostMap() {
		Map<Vehicle, BigDecimal> map = new HashMap<Vehicle, BigDecimal>();
		map.put(fordFiesta(), BigDecimal.valueOf(5000));
		map.put(fordExplorer(), BigDecimal.valueOf(14000));
		map.put(dodgeRam(), BigDecimal.valueOf(12000));
		map.put(hondaCivic(), BigDecimal.valueOf(8000));
		map.put(nissanAltima(), BigDecimal.valueOf(11500));
		map.put(toyotaCamry(), BigDecimal.valueOf(6000));
		return map;
	}
	
}
