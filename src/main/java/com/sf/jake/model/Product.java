package com.sf.jake.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public interface Product extends Serializable {
	
	BigInteger getId();
	BigInteger getProductId();
	String getName();
	BigDecimal getPrice();

}
