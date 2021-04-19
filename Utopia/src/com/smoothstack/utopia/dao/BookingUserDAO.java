/**
 * 
 */
package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.entity.BookingUser;

/**
 * @author Joa
 *
 */
public class BookingUserDAO extends BaseDAO<BookingUser> {

	public BookingUserDAO(Connection conn) {
		super(conn);
	}

	// Adds a bookingUser to the bookingUser table
	public Integer addBookingUser(BookingUser bookingUser) throws ClassNotFoundException, SQLException {
		return saveWithPK("insert into booking_user (booking_id, user_id) VALUES(?, ?)",
				new Object[] { bookingUser.getBookingId(), bookingUser.getUserId() });
	}

	// Updates an existing bookingUser (via user_id)
	public void updateBookingUser(BookingUser bookingUser) throws ClassNotFoundException, SQLException {
		save("update booking_user set booking_id = ? where user_id = ?",
				new Object[] { bookingUser.getBookingId(), bookingUser.getUserId() });
	}

	// Removes a bookingUser from the bookingUser table
	public void deleteBookingUser(BookingUser bookingUser) throws ClassNotFoundException, SQLException {
		save("delete from booking_user where user_id = ?", new Object[] { bookingUser.getUserId() });
	}

	// Returns a list of all bookingUsers
	public List<BookingUser> getAllBookingUsers() throws ClassNotFoundException, SQLException {
		return read("select * from booking_user", null);
	}

	// Returns a list from a result set
	@Override
	public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingUser> bookingUserList = new ArrayList<>();
		while (rs.next()) {
			BookingUser bookingUser = new BookingUser();
			bookingUser.setUserId(rs.getInt("user_id"));
			bookingUser.setBookingId(rs.getInt("booking_id"));
			bookingUserList.add(bookingUser);
		}

		return bookingUserList;
	}

}
