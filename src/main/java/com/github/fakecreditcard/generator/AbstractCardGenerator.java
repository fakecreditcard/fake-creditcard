package com.github.fakecreditcard.generator;

import java.util.Random;
import java.util.stream.IntStream;

public abstract class AbstractCardGenerator implements CreditCardGenerator {

	protected abstract String getFillStarter();

	protected abstract int getFillDigitSum();

	protected abstract int numberCardDigits();

	protected abstract boolean applyMultiplication(int index);

	protected CardBuilder before() {
		return new CardBuilder(getFillStarter(), getFillDigitSum());
	}

	@Override
	public String generate() {
		CardBuilder builder = before();
		execute(builder);
		return builder.toCardNumber();
	}

	private CardBuilder execute(CardBuilder builder) {
		IntStream.range(0, numberCardDigits()).forEach(index -> {
			int randomDigit = getRandomDigit();
			builder.add(randomDigit);
			if (applyMultiplication(index)) {
				randomDigit *= 2;
				randomDigit = verifyLunhFactor(randomDigit);
			}
			builder.sum(randomDigit);
		});
		return builder;
	}

	protected int getRandomDigit() {
		return (int) Math.floor(Math.random() * 10);
	}

	private int verifyLunhFactor(int randomDigit) {
		if (randomDigit > 9) {
			return randomDigit -= 9;
		}
		return randomDigit;
	}

}
