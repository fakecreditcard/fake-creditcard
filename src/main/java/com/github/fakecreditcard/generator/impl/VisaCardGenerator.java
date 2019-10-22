package com.github.fakecreditcard.generator.impl;

import com.github.fakecreditcard.generator.AbstractCardGenerator;

public class VisaCardGenerator extends AbstractCardGenerator {

	@Override
	protected String getFillStarter() {
		return "4";
	}

	@Override
	protected int getFillDigitSum() {
		return 8;
	}

	@Override
	protected int numberCardDigits() {
		return 14;
	}

	@Override
	protected boolean applyMultiplication(int index) {
		return index % 2 == 1;
	}

}
