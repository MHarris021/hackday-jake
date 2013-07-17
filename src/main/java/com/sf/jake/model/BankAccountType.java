package com.sf.jake.model;

import java.io.Serializable;

import org.apache.commons.lang3.text.WordUtils;

public enum BankAccountType implements Serializable {

	CHECKING, SAVINGS, CD, LOAN, MUTUAL_FUND, IRA, MORTGAGE;
	public String toString() {
		StringBuffer buffer = new StringBuffer(WordUtils.capitalizeFully(this.name()));
		return buffer.toString();
	};
}
