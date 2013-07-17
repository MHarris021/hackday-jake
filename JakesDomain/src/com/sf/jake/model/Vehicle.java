package com.sf.jake.model;

import java.math.BigInteger;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

public class Vehicle implements Coverable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigInteger id;
	private String make;
	private String model;
	private DateTime year;
	private BigInteger mileage;

	public Vehicle() {
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public DateTime getYear() {
		return year;
	}

	public void setYear(DateTime year) {
		this.year = year;
	}

	@Override
	public String getName() {
		StringBuffer buffer = new StringBuffer(StringUtils
				.join(Integer.toString(year.getYear()), " ", getMake(), " ", getModel()));
		return buffer.toString();
	}

	public BigInteger getMileage() {
		return mileage;
	}

	public void setMileage(BigInteger mileage) {
		this.mileage = mileage;
	}

}
