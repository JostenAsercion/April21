/**
 * 
 */
package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.entity.Flight;
import com.smoothstack.utopia.entity.Route;

/**
 * @author Joa
 *
 */
public class FlightDAO extends BaseDAO<Flight> {

	public FlightDAO(Connection conn) {
		super(conn);
	}

	// Adds an flight to the flight table
	public Integer addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		return saveWithPK(
				"insert into flight (id, route_id, airplane_id, departure_time, reserved_seats, seat_price) VALUES(?, ?, ?, ?, ?, ?)",
				new Object[] { flight.getId(), flight.getRouteId(), flight.getAirplaneId(), flight.getDepartureTime(),
						flight.getReservedSeats(), flight.getSeatPrice() });
	}

	// Updates an existing flight (via id)
	public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("update flight set route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? where id = ?",
				new Object[] { flight.getRouteId(), flight.getAirplaneId(), flight.getDepartureTime(),
						flight.getReservedSeats(), flight.getSeatPrice(), flight.getId() });
	}

	// Removes an flight from the flight table
	public void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("delete from flight where id = ?", new Object[] { flight.getId() });
	}

	// Returns a list of all flights
	public List<Flight> getAllFlights() throws ClassNotFoundException, SQLException {
		return read("select * from flight", null);
	}

	// Returns route with the specified id
	public Flight getFlightById(Integer id) throws ClassNotFoundException, SQLException {
		List<Flight> flights = read("select * from flight where id = ?", new Object[] { id });
		Flight flight = flights.get(0);
		return flight;
	}

	// Returns next available flight id
	public Integer nextAvailableId() throws ClassNotFoundException, SQLException {
		return getAllFlights().size() + 1;
	}

	// Returns a list from a result set
	@Override
	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<>();
		while (rs.next()) {
			Flight flight = new Flight();
			flight.setId(rs.getInt("id"));
			flight.setRouteId(rs.getInt("route_id"));
			flight.setAirplaneId(rs.getInt("airplane_id"));
			flight.setDepartureTime((LocalDateTime) rs.getObject("departure_time"));
			flight.setReservedSeats(rs.getInt("reserved_seats"));
			flight.setSeatPrice(rs.getFloat("seat_price"));
			flights.add(flight);
		}

		return flights;
	}

}
