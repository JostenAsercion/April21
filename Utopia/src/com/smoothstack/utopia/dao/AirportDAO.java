/**
 * 
 */
package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.entity.Airport;

/**
 * @author Joa
 *
 */
public class AirportDAO extends BaseDAO<Airport> {

	public AirportDAO(Connection conn) {
		super(conn);
	}

	// Adds an airport to the airport table
	public Integer addAirport(Airport airport) throws ClassNotFoundException, SQLException {
		return saveWithPK("insert into airport (iata_id, city) VALUES(?, ?)",
				new Object[] { airport.getAirportCode(), airport.getCityName() });
	}

	// Updates an existing airport (via iata_id)
	public void updateAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("update airport set city = ? where iata_id = ?",
				new Object[] { airport.getCityName(), airport.getAirportCode() });
	}

	// Removes an airport from the airport table
	public void deleteAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("delete from airport where iata_id = ?", new Object[] { airport.getAirportCode() });
	}

	// Returns a list of all airports
	public List<Airport> getAllAirports() throws ClassNotFoundException, SQLException {
		return read("select * from airport", null);
	}

	public Airport getAirportFromId(String id) throws ClassNotFoundException, SQLException {
		List<Airport> temp = read("select * from airport where iata_id = ?", new Object[] { id });
		return temp.get(0);
	}

	// Returns a list from a result set
	@Override
	public List<Airport> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airport> airports = new ArrayList<>();
		while (rs.next()) {
			Airport airport = new Airport();
			airport.setAirportCode(rs.getString("iata_id"));
			airport.setCityName(rs.getString("city"));
			airports.add(airport);
		}

		return airports;
	}
}
