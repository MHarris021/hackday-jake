package com.sf.jake.model;

public class LoanAccount extends BankAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Collateral collateral;
	
	public LoanAccount() {
		setBankAccountType(BankAccountType.LOAN);
	}

	public Collateral getCollateral() {
		return collateral;
	}

	public void setCollateral(Collateral collateral) {
		this.collateral = collateral;
	}

}
