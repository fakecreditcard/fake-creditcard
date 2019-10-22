package com.github.fakecreditcard.generator.impl;

import com.github.fakecreditcard.generator.AbstractCardGenerator;
import com.github.fakecreditcard.generator.CardBuilder;

public class MasterCardGenerator extends AbstractCardGenerator {

	@Override
	protected String getFillStarter() {
		return "5";
	}

	@Override
	protected int getFillDigitSum() {
		return 1;
	}

	@Override
	protected int numberCardDigits() {
		return 13;
	}

	@Override
	protected boolean applyMultiplication(int index) {
		return index % 2 == 0;
	}

	@Override
	protected CardBuilder before() {
		CardBuilder builder = super.before();
		int digit = getRandomDigit();
		builder.addAndSum(digit);
		return builder;
	}

}
