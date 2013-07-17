package com.sf.jake.model;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.List;

public class CarInsuranceQuote extends BaseInsuranceQuote {

	private List<BigDecimal> periodicOverheads;

	public CarInsuranceQuote(CarInsurance carInsurance) {
		super(carInsurance);
	}

	@Override
	protected BigDecimal calculatePremium() {
		CarInsurance carInsurance = (CarInsurance) getInsuranceProduct();
		BigDecimal premium = carInsurance.getPrice();
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

}
