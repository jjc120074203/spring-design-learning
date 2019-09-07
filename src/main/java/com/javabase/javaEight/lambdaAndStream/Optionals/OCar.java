package com.javabase.javaEight.lambdaAndStream.Optionals;

import java.util.Optional;

public class OCar {
	private Optional<OInsurance> insurance;

	public Optional<OInsurance> getInsurance() {
		return insurance;
	}
	public void setInsurance(Optional<OInsurance> insurance) {
		this.insurance = insurance;
	}	
}