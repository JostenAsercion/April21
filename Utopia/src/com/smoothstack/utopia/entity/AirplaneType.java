/**
 * 
 */
package com.smoothstack.utopia.entity;

/**
 * The airplane type entity
 * 
 * @author Joa
 *
 */
public class AirplaneType {

	// The type of the airplane
	private Integer type;

	// The maximum # seats the airplane can hold
	private Integer maxCapacity;

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param model the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the maxCapacity
	 */
	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	/**
	 * @param maxCapacity the maxCapacity to set
	 */
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

}
