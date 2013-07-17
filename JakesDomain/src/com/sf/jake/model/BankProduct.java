package com.sf.jake.model;

import java.math.BigDecimal;

public interface BankProduct extends Product {

	String getAccountId();
	BigDecimal getRate();
	BigDecimal getBalance();
	BankAccountType getBankAccountType();
	
}
