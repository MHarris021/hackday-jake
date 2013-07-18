package com.sf.jake.model;


public class ContactInfo {
	private Address address;
	private Phone phone;
	private Email email;

	public ContactInfo(Address address, Phone phone, Email email) {
		setAddress(address);
		setPhone(phone);
		setEmail(email);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	
}