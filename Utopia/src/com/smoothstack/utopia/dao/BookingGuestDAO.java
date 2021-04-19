/**
 * 
 */
package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.entity.BookingGuest;

/**
 * @author Joa
 *
 */
public class BookingGuestDAO extends BaseDAO<BookingGuest> {

	public BookingGuestDAO(Connection conn) {
		super(conn);
	}

	// Adds a bookingGuest to the bookingGuest table
	public Integer addBookingGuest(BookingGuest bookingGuest) throws ClassNotFoundException, SQLException {
		return saveWithPK("insert into booking_guest (booking_id, contact_email, contact_phone) VALUES(?, ?, ?)",
				new Object[] { bookingGuest.getBookingId(), bookingGuest.getEmail(), bookingGuest.getPhone() });
	}

	// Updates an existing bookingGuest (via contact_email)
	public void updateBookingGuest(BookingGuest bookingGuest) throws ClassNotFoundException, SQLException {
		save("update booking_guest set booking_id = ?, contact_phone = ? where contact_email = ?",
				new Object[] { bookingGuest.getBookingId(), bookingGuest.getPhone(), bookingGuest.getEmail() });
	}

	// Removes a bookingGuest from the bookingGuest table
	public void deleteBookingGuest(BookingGuest bookingGuest) throws ClassNotFoundException, SQLException {
		save("delete from booking_guest where booking_id = ?", new Object[] { bookingGuest.getBookingId() });
	}

	// Returns a list of all bookingGuests
	public List<BookingGuest> getAllBookingGuests() throws ClassNotFoundException, SQLException {
		return read("select * from booking_guest", null);
	}

	// Returns a list from a result set
	@Override
	public List<BookingGuest> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingGuest> bookingGuestList = new ArrayList<>();
		while (rs.next()) {
			BookingGuest bookingGuest = new BookingGuest();
			bookingGuest.setBookingId(rs.getInt("booking_id"));
			bookingGuest.setEmail(rs.getString("contact_email"));
			bookingGuest.setPhone(rs.getString("contact_phone"));
			bookingGuestList.add(bookingGuest);
		}

		return bookingGuestList;
	}

}
