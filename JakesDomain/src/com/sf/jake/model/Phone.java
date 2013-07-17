package com.sf.jake.model;

public class Phone {
	private String value;
			
	public Phone(String value) {
		setValue(value);
	}
	
	private void setValue(String value) {
		this.value = value;
	}

	public String getValue(){
		return value;
	}
	
}
