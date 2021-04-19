/**
 * 
 */
package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.entity.BookingPayment;

/**
 * @author Joa
 *
 */
public class BookingPaymentDAO extends BaseDAO<BookingPayment> {

	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}

	// Adds an bookingPayment to the flight_bookingPayments table
	public Integer addBookingPayment(BookingPayment bookingPayment) throws ClassNotFoundException, SQLException {
		return saveWithPK("insert into booking_payment (booking_id, stripe_id, refunded) VALUES(?, ?, ?)",
				new Object[] { bookingPayment.getBookingId(), bookingPayment.getStripeId(),
						bookingPayment.getRefunded() });
	}

	// Updates an existing bookingPayment (via id)
	public void updateBookingPayment(BookingPayment bookingPayment) throws ClassNotFoundException, SQLException {
		save("update booking_payment set stripe_id = ?, refunded = ? where booking_id = ?", new Object[] {
				bookingPayment.getStripeId(), bookingPayment.getRefunded(), bookingPayment.getBookingId() });
	}

	// Removes an bookingPayment from the flight_bookingPayment table
	public void deleteBookingPayment(BookingPayment bookingPayment) throws ClassNotFoundException, SQLException {
		save("delete from booking_payment where booking_id = ?", new Object[] { bookingPayment.getBookingId() });
	}

	// Returns a list of all flights
	public List<BookingPayment> getAllBookingPayments() throws ClassNotFoundException, SQLException {
		return read("select * from booking_payment", null);
	}

	// Returns a list from a result set
	@Override
	public List<BookingPayment> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingPayment> bookingPaymentList = new ArrayList<>();
		while (rs.next()) {
			BookingPayment bookingPayment = new BookingPayment();
			bookingPayment.setBookingId(rs.getInt("booking_id"));
			bookingPayment.setStripeId(rs.getString("is_active"));
			bookingPayment.setRefunded(rs.getByte("refunded"));
			bookingPaymentList.add(bookingPayment);
		}

		return bookingPaymentList;
	}

}
