package com.sf.jake.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class BaseInsuranceQuote implements InsuranceQuote {

	private BigInteger id;
	private InsuranceProduct insuranceProduct;
	private BigDecimal premium;

	public BaseInsuranceQuote(InsuranceProduct insuranceProduct) {
		setInsuranceProduct(insuranceProduct);
		setPremium(calculatePremium());
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	protected void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	protected abstract BigDecimal calculatePremium();

	protected void setInsuranceProduct(InsuranceProduct insuranceProduct) {
		this.insuranceProduct = insuranceProduct;
	}

	@Override
	public InsuranceProduct getInsuranceProduct() {
		return insuranceProduct;
	}

	@Override
	public BigDecimal getPremium() {
		return premium;
	}

	@Override
	public BigDecimal getPremium(int periods) {
		BigDecimal periodicPremium = premium
				.divide(BigDecimal.valueOf(periods));
		periodicPremium = periodicPremium
				.add(calcPeriodicPremiumOverhead(periods));
		return periodicPremium;
	}

	protected abstract BigDecimal calcPeriodicPremiumOverhead(int periods);

}
