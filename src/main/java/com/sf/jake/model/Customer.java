package com.sf.jake.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection="customers")
public class Customer implements Coverable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private BigInteger id;
	
	@Indexed
	private String firstName;
	
	@Indexed
	private String lastName;
	
	@Indexed(unique=true)
	private String accountName;
	
	@DateTimeFormat(pattern="MM-DD-YYYY")
	private Date dateOfBirth;
	private Gender gender;
	private ContactInfo contactInfo;

	private List<Product> products;
	
	public Customer(String accountName) {
		this.accountName = accountName;
	}
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getAccountName() {
		return accountName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String getName() {
		return StringUtils.join(getFirstName(), " ", getLastName());
	}

	public void copy(Customer customer) {
		setFirstName(customer.getFirstName());
		setLastName(customer.getLastName());
		setContactInfo(customer.getContactInfo());
		setDateOfBirth(customer.getDateOfBirth());
		setGender(customer.getGender());
	}
	
}
