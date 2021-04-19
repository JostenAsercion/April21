/**
 * 
 */
package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.entity.AirplaneType;

/**
 * @author Joa
 *
 */
public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {

	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}

	// Adds an airplaneType to the airplane_type table
	public Integer addAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		return saveWithPK("insert into airplane_type (id, max_capacity) VALUES(?, ?)",
				new Object[] { airplaneType.getType(), airplaneType.getMaxCapacity() });
	}

	// Updates an existing airplaneType
	public void updateAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		save("update airplane_type set max_capacity = ? where id = ?",
				new Object[] { airplaneType.getMaxCapacity(), airplaneType.getType() });
	}

	// Removes an airplaneType from the airplane_type table
	public void deleteAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		save("delete from airplane_type where id = ?", new Object[] { airplaneType.getType() });
	}

	// Returns a list of all airplaneTypes
	public List<AirplaneType> getAllAirplaneTypes() throws ClassNotFoundException, SQLException {
		return read("select * from airplane_type", null);
	}

	// Returns a list from a result set
	@Override
	public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<AirplaneType> airplaneTypes = new ArrayList<>();
		while (rs.next()) {
			AirplaneType airplaneType = new AirplaneType();
			airplaneType.setType(rs.getInt("id"));
			airplaneType.setMaxCapacity(rs.getInt("max_capacity"));
			airplaneTypes.add(airplaneType);
		}

		return airplaneTypes;
	}
}
