package com.sf.jake.model;

import java.math.BigDecimal;

public class BaseCoverageOption implements CoverageOption {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private BigDecimal cost;
	
	public BaseCoverageOption(String name, BigDecimal cost) {
		setName(name);
		setCost(cost);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public BigDecimal getCost() {
		return cost;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	

}
