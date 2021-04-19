/**
 * 
 */
package com.smoothstack.utopia.entity;

/**
 * The booking payment entity
 * 
 * @author Joa
 *
 */
public class BookingPayment {
private Integer bookingId;
private String stripeId;
private byte refunded;

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
 * @return the stripeId
 */
public String getStripeId() {
	return stripeId;
}

/**
 * @param stripeId the stripeId to set
 */
public void setStripeId(String stripeId) {
	this.stripeId = stripeId;
}

/**
 * @return the refunded
 */
public byte getRefunded() {
	return refunded;
}

/**
 * @param refunded the refunded to set
 */
public void setRefunded(byte refunded) {
	this.refunded = refunded;
}
}
