package com.github.fakecreditcard.generator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Responsible for encapsulate the card during of algorithm is running
 * 
 * @author Fernando
 *
 */
public class CardBuilder {

	private StringBuilder acumulator;

	private AtomicInteger digitSum;

	public CardBuilder(String firstDigits, int sumDigits) {
		acumulator = new StringBuilder(firstDigits);
		digitSum = new AtomicInteger(sumDigits);
	}

	public void add(Integer digit) {
		acumulator.append(digit);
	}

	protected void sum(Integer digit) {
		digitSum.addAndGet(digit);
	}

	public void addAndSum(int digit) {
		this.add(digit);
		this.sum(digit);
	}

	/**
	 * Build the card number
	 * 
	 * @return String card number
	 */
	public String build() {
		int lastDigit = this.getLastDigit();
		this.add(lastDigit);
		return acumulator.toString();
	}

	/**
	 * Include the last card digit
	 * 
	 * @return int last card digit
	 */
	private int getLastDigit() {
		int lastDigit = 10 - (digitSum.get() % 10);
		if (digitSum.get() % 10 == 0) {
			return 0;
		}
		return lastDigit;
	}

}
