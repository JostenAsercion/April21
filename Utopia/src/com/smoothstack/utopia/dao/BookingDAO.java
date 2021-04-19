/**
 * 
 */
package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.entity.Booking;

/**
 * @author Joa
 *
 */
public class BookingDAO extends BaseDAO<Booking> {

	public BookingDAO(Connection conn) {
		super(conn);
	}

	// Adds an booking to the booking table
	public Integer addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		return saveWithPK("insert into booking (id, is_active, confirmation_code) VALUES(?, ?, ?)",
				new Object[] { booking.getId(), booking.getIsActive(), booking.getConfirmationCode() });
	}

	// Updates an existing booking (via id)
	public void updateBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("update booking set is_active = ?, confirmation_code = ? where id = ?",
				new Object[] { booking.getIsActive(), booking.getConfirmationCode(), booking.getId() });
	}

	// Removes an booking from the booking table
	public void deleteBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("delete from booking where id = ?", new Object[] { booking.getId() });
	}

	// Returns a list of all bookings
	public List<Booking> getAllBookings() throws ClassNotFoundException, SQLException {
		return read("select * from booking", null);
	}

	// Returns a list from a result set
	@Override
	public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Booking> bookingList = new ArrayList<>();
		while (rs.next()) {
			Booking booking = new Booking();
			booking.setId(rs.getInt("id"));
			booking.setIsActive(rs.getByte("is_active"));
			booking.setConfirmationCode(rs.getString("confirmation_code"));
			bookingList.add(booking);
		}

		return bookingList;
	}

}
