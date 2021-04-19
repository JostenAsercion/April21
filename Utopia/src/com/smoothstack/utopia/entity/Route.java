/**
 * 
 */
package com.smoothstack.utopia.entity;

/**
 * @author Joa
 *
 */
public class Route {

	private Integer id;
	private Airport oriAirport;
	private Airport desAirport;

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

	/**
	 * @return the oriAirport
	 */
	public Airport getOriAirport() {
		return oriAirport;
	}

	/**
	 * @param oriAirport the oriAirport to set
	 */
	public void setOriAirport(Airport oriAirport) {
		this.oriAirport = oriAirport;
	}

	/**
	 * @return the desAirport
	 */
	public Airport getDesAirport() {
		return desAirport;
	}

	/**
	 * @param desAirport the desAirport to set
	 */
	public void setDesAirport(Airport desAirport) {
		this.desAirport = desAirport;
	}

}
