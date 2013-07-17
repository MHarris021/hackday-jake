package com.sf.jake.model;

import java.math.BigDecimal;

public interface InsuranceQuote {
	
	InsuranceProduct getInsuranceProduct();
	BigDecimal getPremium();
	BigDecimal getPremium(int periods);
}
