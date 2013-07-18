package com.sf.jake.model;

import java.math.BigInteger;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

public class Vehicle implements Coverable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigInteger id;
	private String make;
	private String model;
	private DateTime year;
	
	public Vehicle() {
	}
	
	public Vehicle(DateTime year, String make, String model) {
		setYear(year);
		setMake(make);
		setModel(model);
	}
	
	

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public DateTime getYear() {
		return year;
	}

	public void setYear(DateTime year) {
		this.year = year;
	}

	@Override
	public String getName() {
		StringBuffer buffer = new StringBuffer(StringUtils
				.join(Integer.toString(year.getYear()), " ", getMake(), " ", getModel()));
		return buffer.toString();
	}
	
	public void copy(Vehicle vehicle) {
		setYear(vehicle.getYear());
		setMake(vehicle.getMake());
		setModel(vehicle.getModel());
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Vehicle)) {
			return false;
		}
		Vehicle other = (Vehicle) obj;
		if (make == null) {
			if (other.make != null) {
				return false;
			}
		} else if (!make.equals(other.make)) {
			return false;
		}
		if (model == null) {
			if (other.model != null) {
				return false;
			}
		} else if (!model.equals(other.model)) {
			return false;
		}
		if (year == null) {
			if (other.year != null) {
				return false;
			}
		} else if (!year.equals(other.year)) {
			return false;
		}
		return true;
	}


}
