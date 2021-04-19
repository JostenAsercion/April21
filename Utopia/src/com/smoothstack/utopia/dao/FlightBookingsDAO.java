/**
 * 
 */
package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.entity.FlightBookings;

/**
 * @author Joa
 *
 */
public class FlightBookingsDAO extends BaseDAO<FlightBookings> {

	public FlightBookingsDAO(Connection conn) {
		super(conn);
	}

	// Adds an flightBooking to the flight_bookings table
	public Integer addFlightBooking(FlightBookings flightBooking) throws ClassNotFoundException, SQLException {
		return saveWithPK("insert into flight_bookings (flight_id, booking_id) VALUES(?, ?)",
				new Object[] { flightBooking.getFlightId(), flightBooking.getBookingId() });
	}

	// Updates an existing flightBooking (via booking_id)
	public void updateFlightBooking(FlightBookings flightBooking) throws ClassNotFoundException, SQLException {
		save("update flight_bookings set flight_id = ? where booking_id = ?",
				new Object[] { flightBooking.getFlightId(), flightBooking.getBookingId() });
	}

	// Removes an flightBooking from the flight_booking table
	public void deleteFlightBooking(FlightBookings flightBooking) throws ClassNotFoundException, SQLException {
		save("delete from flight_bookings where booking_id = ?", new Object[] { flightBooking.getBookingId() });
	}

	// Returns a list of all flights
	public List<FlightBookings> getAllFlightBookings() throws ClassNotFoundException, SQLException {
		return read("select * from flight_bookings", null);
	}

	// Returns a list from a result set
	@Override
	public List<FlightBookings> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<FlightBookings> flightBookingList = new ArrayList<>();
		while (rs.next()) {
			FlightBookings flightBooking = new FlightBookings();
			flightBooking.setFlightId(rs.getInt("flight_id"));
			flightBooking.setBookingId(rs.getInt("booking_id"));
			flightBookingList.add(flightBooking);
		}

		return flightBookingList;
	}

}
