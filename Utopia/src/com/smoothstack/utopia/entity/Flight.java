/**
 * 
 */
package com.smoothstack.utopia.entity;

import java.sql.Timestamp;

/**
 * The flight entity
 * 
 * @author Joa
 *
 */
public class Flight {

	private Integer id;
	private Integer routeId;
	private Integer airplaneId;
	private Timestamp departureTime;
	private Integer reservedSeats;
	private Float seatPrice;

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
	 * @return the routeId
	 */
	public Integer getRouteId() {
		return routeId;
	}

	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	/**
	 * @return the airplaneId
	 */
	public Integer getAirplaneId() {
		return airplaneId;
	}

	/**
	 * @param airplaneId the airplaneId to set
	 */
	public void setAirplaneId(Integer airplaneId) {
		this.airplaneId = airplaneId;
	}

	/**
	 * @return the departureTime
	 */
	public Timestamp getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @return the reservedSeats
	 */
	public Integer getReservedSeats() {
		return reservedSeats;
	}

	/**
	 * @param reservedSeats the reservedSeats to set
	 */
	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	/**
	 * @return the seatPrice
	 */
	public Float getSeatPrice() {
		return seatPrice;
	}

	/**
	 * @param seatPrice the seatPrice to set
	 */
	public void setSeatPrice(Float seatPrice) {
		this.seatPrice = seatPrice;
	}

}
