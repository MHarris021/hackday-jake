package com.sf.jake.model;

import java.io.Serializable;

public class Email implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String value;

	public Email(String value) {
		setValue(value);
	}

	private void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
