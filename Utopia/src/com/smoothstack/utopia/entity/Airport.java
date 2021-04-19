/**
 * 
 */
package com.smoothstack.utopia.entity;

/**
 * The airport entity
 * 
 * @author Joa
 *
 */
public class Airport {

	// The IATA ID of the airport
	private String airportCode;

	// The name of the city the airport is in
	private String cityName;

	/**
	 * @return the airportCode
	 */
	public String getAirportCode() {
		return airportCode;
	}

	/**
	 * @param airportCode the airportCode to set
	 */
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
