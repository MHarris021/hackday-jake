package com.sf.jake.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class BankAccount implements BankProduct{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private BigInteger id;
	private BigInteger productId;
	private BigDecimal price;
	private BankAccountType bankAccountType;
	private String accountId;
	private String name;
	private BigDecimal balance;
	private BigDecimal rate;
	
	
	public BankAccount() {
	}


	public BigInteger getId() {
		return id;
	}


	public void setId(BigInteger id) {
		this.id = id;
	}


	public BigInteger getProductId() {
		return productId;
	}


	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public BankAccountType getBankAccountType() {
		return bankAccountType;
	}


	public void setBankAccountType(BankAccountType bankAccountType) {
		this.bankAccountType = bankAccountType;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getBalance() {
		return balance;
	}


	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	public BigDecimal getRate() {
		return rate;
	}


	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
}
