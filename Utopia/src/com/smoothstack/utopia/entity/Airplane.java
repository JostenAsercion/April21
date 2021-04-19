/**
 * 
 */
package com.smoothstack.utopia.entity;

/**
 * The airplane entity
 * 
 * @author Joa
 *
 */
public class Airplane {

	// The type of the airplane
	private AirplaneType airplaneType;

	// The ID of the plane
	private Integer id;

	/**
	 * @return the airplaneModel
	 */
	public AirplaneType getAirplaneType() {
		return airplaneType;
	}

	/**
	 * @param airplaneType the airplaneType to set
	 */
	public void setAirplaneType(AirplaneType airplaneType) {
		this.airplaneType = airplaneType;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
