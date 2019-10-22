package com.github.fakecreditcard.generator;

/**
 * Specification of a Credit Card generator
 * 
 * @author Fernando
 *
 */
public interface CreditCardGenerator {

	/**
	 * Generate card number
	 * 
	 * @return String card number
	 */
	String generate();

}
