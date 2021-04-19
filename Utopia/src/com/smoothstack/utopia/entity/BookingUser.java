/**
 * 
 */
package com.smoothstack.utopia.entity;

/**
 * Booking User entity
 * 
 * @author Joa
 *
 */
public class BookingUser {
	private Integer bookingId;
	private Integer userId;

	/**
	 * @return the bookingId
	 */
	public Integer getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
