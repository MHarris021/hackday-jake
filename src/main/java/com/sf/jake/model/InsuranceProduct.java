package com.sf.jake.model;

import java.math.BigDecimal;
import java.util.List;

public interface InsuranceProduct extends Product {

	
	BigDecimal getPremium();
	String getPolicyNumber();
	List<? extends Coverable> getCovered();
	
}
