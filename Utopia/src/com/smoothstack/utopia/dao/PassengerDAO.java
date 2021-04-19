/**
 * 
 */
package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.entity.Airplane;
import com.smoothstack.utopia.entity.Passenger;

/**
 * @author Joa
 *
 */
public class PassengerDAO extends BaseDAO<Passenger> {

	public PassengerDAO(Connection conn) {
		super(conn);
	}

	// Adds an passenger to the passengers table
	public Integer addPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		return saveWithPK(
				"insert into passenger (id, booking_id, given_name, family_name, dob, gender, address) VALUES(?, ?, ?, ?, ?, ?, ?)",
				new Object[] { passenger.getId(), passenger.getBookingId(), passenger.getGivenName(),
						passenger.getFamilyName(), passenger.getDob(), passenger.getGender(), passenger.getAddress() });
	}

	// Updates an existing passenger (via id)
	public void updatePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("update passenger booking_id = ?, given_name = ?, family_name = ?, dob = ?, gender = ?, address = ? where id = ?",
				new Object[] { passenger.getBookingId(), passenger.getGivenName(), passenger.getFamilyName(),
						passenger.getDob(), passenger.getGender(), passenger.getAddress(), passenger.getId() });
	}

	// Removes an passenger from the passenger table
	public void deletePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("delete from passenger where id = ?", new Object[] { passenger.getId() });
	}

	// Returns a list of all flights
	public List<Passenger> getAllPassengers() throws ClassNotFoundException, SQLException {
		return read("select * from passenger", null);
	}

	// Returns next available passenger id
	public Integer nextAvailableId() throws ClassNotFoundException, SQLException {
		return getAllPassengers().size() + 1;
	}

	public Passenger getPassengerById(Integer id) throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = read("select * from passenger where id = ?", new Object[] { id });
		Passenger passenger = passengers.get(0);
		return passenger;
	}

	// Returns a list from a result set
	@Override
	public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Passenger> passengerList = new ArrayList<>();
		while (rs.next()) {
			Passenger passenger = new Passenger();
			passenger.setId(rs.getInt("id"));
			passenger.setBookingId(rs.getInt("booking_id"));
			passenger.setGivenName(rs.getString("given_name"));
			passenger.setFamilyName(rs.getString("family_name"));
			passenger.setDob(rs.getDate("dob"));
			passenger.setGender(rs.getString("gender"));
			passenger.setAddress(rs.getString("address"));
			passengerList.add(passenger);
		}

		return passengerList;
	}

}
