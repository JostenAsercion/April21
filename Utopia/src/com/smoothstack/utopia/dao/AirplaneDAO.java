package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.entity.Airplane;
import com.smoothstack.utopia.entity.AirplaneType;
import com.smoothstack.utopia.entity.Route;

public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(Connection conn) {
		super(conn);
	}

	// Adds an airplane to the airplane table
	public Integer addAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		return saveWithPK("insert into airplane (id, type_id) VALUES(?, ?)",
				new Object[] { airplane.getId(), airplane.getAirplaneType() });
	}

	// Updates an existing airplane (via id)
	public void updateAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("update airplane set type_id = ? where id = ?",
				new Object[] { airplane.getAirplaneType(), airplane.getId() });
	}

	// Removes an airplane from the airplane table
	public void deleteAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("delete from airplane where id = ?", new Object[] { airplane.getId() });
	}

	// Returns a list of all airplanes
	public List<Airplane> getAllAirplanes() throws ClassNotFoundException, SQLException {
		return read("select * from airplane", null);
	}

	public Airplane getAirplaneById(Integer id) throws ClassNotFoundException, SQLException {
		List<Airplane> airplanes = read("select * from airplane where id = ?", new Object[] { id });
		Airplane airplane = airplanes.get(0);
		return airplane;
	}

	// Returns a list from a result set
	@Override
	public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airplane> airplanes = new ArrayList<>();
		while (rs.next()) {
			Airplane airplane = new Airplane();
			airplane.setId(rs.getInt("id"));
			AirplaneType type = new AirplaneType();
			type.setType(rs.getInt("type_id"));
			airplane.setAirplaneType(type);

			airplanes.add(airplane);
		}

		return airplanes;
	}
}
