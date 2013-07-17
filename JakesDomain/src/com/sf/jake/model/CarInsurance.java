package com.sf.jake.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class CarInsurance implements InsuranceProduct {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigInteger id;
	private BigInteger productId;
	private String name;
	private BigDecimal basePrice;
	private BigDecimal premium;
	private String policyNumber;
	private List<Vehicle> vehicles;
	private List<CoverageOption> coverageOptions;
	
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

	public BigInteger getProductId() {
		return productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		BigDecimal totalPrice = basePrice;
		for(CoverageOption coverageOption: coverageOptions){
			totalPrice.add(coverageOption.getCost());
		}
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

	public List<CoverageOption> getCoverageOptions() {
		return coverageOptions;
	}

	public void setCoverageOptions(List<CoverageOption> coverageOptions) {
		this.coverageOptions = coverageOptions;
	}

	

}
