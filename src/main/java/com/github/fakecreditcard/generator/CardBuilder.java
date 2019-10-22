package com.github.fakecreditcard.generator;

import java.util.concurrent.atomic.AtomicInteger;

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

	public String toCardNumber() {
		int lastDigit = this.getLastDigit();
		this.add(lastDigit);
		return acumulator.toString();
	}
	
	private int getLastDigit() {
		int lastDigit = 10 - (digitSum.get() % 10);
		if (digitSum.get() % 10 == 0) {
			return 0;
		}
		return lastDigit;
	}

}
