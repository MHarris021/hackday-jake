package com.sf.jake.model;

import java.math.BigDecimal;

public interface InsuranceProduct extends Product {

	
	BigDecimal getPremium();
	String getPolicyNumber();
	Coverable getCovered();
	
}
