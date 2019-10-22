package com.github.fakecreditcard.generator;

import com.github.fakecreditcard.generator.impl.MasterCardGenerator;
import com.github.fakecreditcard.generator.impl.VisaCardGenerator;

/**
 * 
 * @author Fernando
 *
 */
public enum Brand {

	VISA(new VisaCardGenerator()),
	MASTER(new MasterCardGenerator());

	private CreditCardGenerator generator;

	private Brand(CreditCardGenerator creditCardGenerator) {
		this.generator = creditCardGenerator;
	}

	public String generate() {
		return this.generator.generate();
	}
}
