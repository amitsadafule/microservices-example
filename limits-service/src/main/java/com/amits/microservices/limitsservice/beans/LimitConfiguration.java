package com.amits.microservices.limitsservice.beans;

/**
 * @author Amit Sadafule
 *
 * 10-Nov-2018
 */
public class LimitConfiguration {

	private int maximum;
	private int minimum;
	
	private LimitConfiguration() {
		super();
	}
	
	/**
	 * @param maximum
	 * @param minimum
	 */
	public LimitConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
	
}
