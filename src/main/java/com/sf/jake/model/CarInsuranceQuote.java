package com.sf.jake.model;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

public class CarInsuranceQuote extends BaseInsuranceQuote {

	
	private List<BigDecimal> periodicOverheads;

	private DateTime baseYear;
	
	@Autowired
	public CarInsuranceQuote(CarInsurance carInsurance) {
		this(carInsurance, null);
	}

	public CarInsuranceQuote(CarInsurance carInsurance, DateTime baseYear) {
		super(carInsurance);
		setBaseYear(baseYear);
	}

	
	@Override
	protected BigDecimal calculatePremium() {
		CarInsurance carInsurance = (CarInsurance) getInsuranceProduct();
		BigDecimal premium = carInsurance.getBasePrice();
		premium = premium.add(carInsurance.getCoverageOption().getCost());
		carInsurance.setPremium(premium);
		return premium;
	}

	@Override
	protected BigDecimal calcPeriodicPremiumOverhead(int periods) {
		BigDecimal overhead = BigDecimal.ZERO;
		switch (periods) {
		case 2:
			overhead = periodicOverheads.get(0);
			break;
		case 4:
			overhead = periodicOverheads.get(1);
			break;
		case 12:
			overhead = periodicOverheads.get(2);
			break;
		default:
			throw new InvalidParameterException("A period value of: " + periods
					+ " is not supported");
		}
		return overhead;
	}

	public DateTime getBaseYear() {
		return baseYear;
	}

	public void setBaseYear(DateTime baseYear) {
		this.baseYear = baseYear;
	}

}
