package com.sf.jake.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public class Address implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigInteger id;
	
	private List<String> lines;
	private String city;
	private String state;
	private String zipcode;
	
	public Address() {
	}
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public List<String> getLines() {
		return lines;
	}
	
	public void setLines(List<String> lines) {
		this.lines = lines;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}
