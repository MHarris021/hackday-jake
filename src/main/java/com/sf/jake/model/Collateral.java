package com.sf.jake.model;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Collateral extends Serializable {

	String getName();
	BigDecimal getValue();
	
}
