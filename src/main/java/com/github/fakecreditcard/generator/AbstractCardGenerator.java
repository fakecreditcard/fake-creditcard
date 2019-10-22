package com.github.fakecreditcard.generator;

import java.util.stream.IntStream;

/**
 * Template for Generator a credit card number
 * 
 * @author Fernando
 *
 */
public abstract class AbstractCardGenerator implements CreditCardGenerator {

	/**
	 * Initial digits for a credit card
	 * 
	 * @return String initial digits
	 */
	protected abstract String getFillStarter();

	/**
	 * Sum of initial digits based on Luhn Algorithm
	 * 
	 * @return int sum of digitis
	 */
	protected abstract int getFillDigitSum();

	/**
	 * Number of digits for a credit card
	 * 
	 * @return int number of digits
	 */
	protected abstract int numberCardDigits();

	/**
	 * Verify if the multiply a digit is necessary for Luhn validation
	 * 
	 * @param index
	 * 
	 * @return true if the brand condition for multiply number is valid
	 */
	protected abstract boolean applyMultiplication(int index);

	/**
	 * Create a Builder for Cards
	 * 
	 * @return CardBuilder starter with data
	 */
	protected CardBuilder before() {
		return new CardBuilder(getFillStarter(), getFillDigitSum());
	}

	@Override
	public String generate() {
		CardBuilder builder = before();
		execute(builder);
		return builder.build();
	}

	/**
	 * Execute the loop for generate a digits
	 * 
	 * @param builder
	 * @return CardBuilder builder finalized after execution
	 */
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

	/**
	 * Generate a random digit
	 * 
	 * @return int random digit
	 */
	protected int getRandomDigit() {
		return (int) Math.floor(Math.random() * 10);
	}

	/**
	 * Apply the subtration when a digit is greater than 9
	 * 
	 * @param randomDigit
	 * d
	 * @return int random digit when is less than 9 or a random digit subtracted 9
	 */
	private int verifyLunhFactor(int randomDigit) {
		if (randomDigit > 9) {
			return randomDigit -= 9;
		}
		return randomDigit;
	}

}
