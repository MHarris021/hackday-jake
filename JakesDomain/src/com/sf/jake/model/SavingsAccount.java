package com.sf.jake.model;

public class SavingsAccount extends BankAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SavingsAccount() {
		setBankAccountType(BankAccountType.SAVINGS);
	}
}
