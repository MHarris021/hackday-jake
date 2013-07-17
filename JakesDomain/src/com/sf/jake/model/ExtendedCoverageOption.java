package com.sf.jake.model;

import java.math.BigDecimal;
import java.util.List;

public class ExtendedCoverageOption extends BaseCoverageOption {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Tier> tiers;
	private Tier currentTier;
	
	public ExtendedCoverageOption(String name, BigDecimal multiplier) {
		super(name, multiplier);
	}

	public List<Tier> getTiers() {
		return tiers;
	}

	public void setTiers(List<Tier> tiers) {
		this.tiers = tiers;
	}

	public Tier getCurrentTier() {
		return currentTier;
	}

	public void setCurrentTier(Tier currentTier) {
		this.currentTier = currentTier;
	}
	
	@Override
	public BigDecimal getCost() {
		BigDecimal multiplier = super.getCost();
		multiplier = multiplier.multiply(currentTier.getMultiplier());
		return multiplier;
	}

}
