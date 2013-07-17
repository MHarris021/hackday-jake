package com.sf.jake.model;

import java.io.Serializable;
import java.math.BigDecimal;

public interface CoverageOption extends Serializable {
	
	String getName();
	BigDecimal getCost();
	

}
