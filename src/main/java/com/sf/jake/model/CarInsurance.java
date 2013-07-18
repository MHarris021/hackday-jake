package com.sf.jake.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="autoinsurances")
public class CarInsurance implements InsuranceProduct {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private BigInteger id;
	
	private String name;
	private BigDecimal basePrice;
	private BigDecimal premium;
	private String policyNumber;
	private List<Vehicle> vehicles;
	private CoverageOption coverageOption;
	
	public CarInsurance() {
	}
	
	@Override
	public List<Vehicle> getCovered() {
		return vehicles;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		BigDecimal totalPrice = basePrice;
		totalPrice.add(coverageOption.getCost());
		return totalPrice;
	}

	public void setBasePrice(BigDecimal price) {
		this.basePrice = price;
	}

	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public CoverageOption getCoverageOption() {
		return coverageOption;
	}

	public void setCoverageOption(CoverageOption coverageOption) {
		this.coverageOption = coverageOption;
	}

	

}
