package com.sf.jake.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "autoinsurances")
@CompoundIndex(dropDups=true, def="{'vehicle':1, 'componentOption' : 1}" )
public class CarInsurance implements InsuranceProduct {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger id;

	private String name = "Auto Insurance";
	private BigDecimal basePrice;
	private BigDecimal premium;
	private String policyNumber;
	
	@Indexed
	private Vehicle vehicle;

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Indexed
	private CoverageOption coverageOption;

	public CarInsurance(Vehicle vehicle, BigDecimal basePrice) {
		setVehicle(vehicle);
		setBasePrice(basePrice);
	}
	
	public CarInsurance() {
	}

	@Override
	public Vehicle getCovered() {
		return vehicle;
	}

	@Override
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal price) {
		this.basePrice = price;
	}

	@Override
	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	@Override
	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public CoverageOption getCoverageOption() {
		return coverageOption;
	}

	public void setCoverageOption(CoverageOption coverageOption) {
		this.coverageOption = coverageOption;
	}

}
