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
import com.smoothstack.utopia.entity.Route;

/**
 * @author Joa
 *
 */
public class RouteDAO extends BaseDAO<Route> {

	public RouteDAO(Connection conn) {
		super(conn);
	}

	// Adds a route to the Route table
	public Integer addRoute(Route route) throws ClassNotFoundException, SQLException {
		return saveWithPK("insert into route (origin_id, destination_id) VALUES(?, ?)",
				new Object[] { route.getOriAirport().getAirportCode(), route.getDesAirport().getAirportCode() });
	}

	// Updates an existing route (via id)
	public void updateRoute(Route route) throws ClassNotFoundException, SQLException {
		save("update route set origin_id = ?, destination_id = ? where id = ?", new Object[] {
				route.getOriAirport().getAirportCode(), route.getDesAirport().getAirportCode(), route.getId() });
	}

	// Removes a route from the Route table
	public void deleteRoute(Route route) throws ClassNotFoundException, SQLException {
		save("delete from route where id = ?", new Object[] { route.getId() });
	}

	// Returns a list of all routes
	public List<Route> getAllRoutes() throws ClassNotFoundException, SQLException {
		return read("select * from route", null);
	}

	// Returns a list of all routes (by airport)
	public List<Route> getAllRoutesByAirport(String airportCode) throws ClassNotFoundException, SQLException {
		return read("select * from route where origin_id = ? OR destination_id = ?",
				new Object[] { airportCode, airportCode });
	}

	// Returns route with the specified id
	public Route getRouteById(Integer id) throws ClassNotFoundException, SQLException {
		List<Route> routes = read("select * from route where id = ?", new Object[] { id });
		Route route = routes.get(0);
		return route;
	}

	// Returns the ID of a route in a database given the airports (0 if DNE)
	public int getRouteIdFromAirports(String oriAirportCode, String desAirportCode)
			throws ClassNotFoundException, SQLException {
		List<Route> temp = read("select * from route where origin_id = ? AND destination_id = ?",
				new Object[] { oriAirportCode, desAirportCode });
		if (temp.isEmpty())
			return 0;
		else
			return temp.get(0).getId();
	}

	// Returns next available route id
	public Integer nextAvailableId() throws ClassNotFoundException, SQLException {
		return getAllRoutes().size() + 1;
	}

	// Returns a list from a result set
	@Override
	public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();
		while (rs.next()) {
			Route route = new Route();
			route.setId(rs.getInt("id"));
			// route.getOriAirport().setAirportCode(rs.getString("origin_id"));
			Airport ori = new Airport();
			Airport des = new Airport();
			ori.setAirportCode(rs.getString("origin_id"));
			des.setAirportCode(rs.getString("destination_id"));
			route.setOriAirport(ori);
			route.setDesAirport(des);
			// route.getDesAirport().setAirportCode(rs.getString("destination_id"));
			routes.add(route);
		}

		return routes;
	}
}
