package com.sf.jake.model;

public class CheckingAccount extends BankAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CheckingAccount() {
		setBankAccountType(BankAccountType.CHECKING);
	}

}
