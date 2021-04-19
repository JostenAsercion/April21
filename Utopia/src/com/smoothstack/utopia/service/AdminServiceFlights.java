/**
 * 
 */
package com.smoothstack.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.smoothstack.utopia.dao.AirplaneDAO;
import com.smoothstack.utopia.dao.AirportDAO;
import com.smoothstack.utopia.dao.FlightDAO;
import com.smoothstack.utopia.dao.RouteDAO;
import com.smoothstack.utopia.entity.Flight;
import com.smoothstack.utopia.entity.Route;

public class AdminServiceFlights {

	ConnectionUtil connUtil = new ConnectionUtil();

	// Adds a new flight
	public void addNewFlight() throws SQLException {
		Scanner input = new Scanner(System.in);
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			// call needed DAOs here
			FlightDAO fdao = new FlightDAO(conn);
			RouteDAO rdao = new RouteDAO(conn);
			AirportDAO apodao = new AirportDAO(conn);
			AirplaneDAO apldao = new AirplaneDAO(conn);

			Flight flight = new Flight();

			// Sets new flight's route
			// Displays all existing routes
			rdao.getAllRoutes().forEach(route -> System.out.println(route.getId() + ". "
					+ route.getOriAirport().getAirportCode() + " -> " + route.getDesAirport().getAirportCode()));

			// Sets flight route
			System.out.println("Enter the Route # for the new flight");
			flight.setRouteId(input.nextInt());

			// Sets airplane used
			apldao.getAllAirplanes().forEach(
					airplane -> System.out.println(airplane.getId() + ". " + airplane.getAirplaneType().getType()));
			System.out.println("Enter the Airplane ID that you wish to use for this flight");
			flight.setAirplaneId(input.nextInt());

			// Sets flight departure to a default date/time
			LocalDateTime dateTime = LocalDateTime.now();
			flight.setDepartureTime(dateTime);

			// Sets flight reserved seats
			System.out.println("Enter the # of reserved seats for this flight");
			flight.setReservedSeats(input.nextInt());

			// Sets flight seat price
			System.out.println("Enter the seat price for this flight");
			flight.setSeatPrice(input.nextFloat());

			// Sets flight id to next available
			flight.setId(fdao.nextAvailableId());

			// Adds flight to flight table
			fdao.addFlight(flight);

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			input.close();
			conn.close();
		}
	}

	// Creates new route
	public void addRoute() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Scanner input = new Scanner(System.in);

			// call needed DAOs here
			RouteDAO rdao = new RouteDAO(conn);
			AirportDAO apodao = new AirportDAO(conn);

			// Displays all available airports
			apodao.getAllAirports().forEach(
					airport -> System.out.println(airport.getAirportCode() + " (" + airport.getCityName() + ")"));

			System.out.println("\nPlease enter the route's origin airport code");
			String ori = input.nextLine();
			System.out.println("\nPlease enter the route's destination airport code");
			String des = input.nextLine();

			// Creates route as long as it is unique
			if (rdao.getRouteIdFromAirports(ori, des) == 0) {
				Route route = new Route();
				route.setId(rdao.nextAvailableId());
				route.setOriAirport(apodao.getAirportFromId(ori));
				route.setDesAirport(apodao.getAirportFromId(des));
				rdao.addRoute(route);
			} else
				System.out.println("Route already exists.");

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// Updates a flight
	public void updateFlight() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Scanner input = new Scanner(System.in);
			// call needed DAOs here
			FlightDAO fdao = new FlightDAO(conn);
			RouteDAO rdao = new RouteDAO(conn);
			AirplaneDAO apldao = new AirplaneDAO(conn);

			// Print all flights
			fdao.getAllFlights().forEach(flight -> {
				try {
					System.out.println(flight.getId() + ". "
							+ rdao.getRouteById(flight.getRouteId()).getOriAirport().getAirportCode() + " -> "
							+ rdao.getRouteById(flight.getRouteId()).getDesAirport().getAirportCode() + " at "
							+ flight.getDepartureTime());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			Flight f = new Flight();
			System.out.println("Enter ID of flight you wish to update.");
			// f=.setId(input.nextInt());
			f = fdao.getFlightById(input.nextInt());

			// Displays all existing routes
			rdao.getAllRoutes().forEach(route -> System.out.println(route.getId() + ". "
					+ route.getOriAirport().getAirportCode() + " -> " + route.getDesAirport().getAirportCode()));
			System.out.println("Enter new route ID from existing route list");
			f.setRouteId(input.nextInt());

			// Sets airplane used
			apldao.getAllAirplanes().forEach(
					airplane -> System.out.println(airplane.getId() + ". " + airplane.getAirplaneType().getType()));
			System.out.println("Enter the new Airplane ID that you wish to use for this flight");
			f.setAirplaneId(input.nextInt());

			// Sets flight departure to a default date/time
			LocalDateTime dateTime = LocalDateTime.now();
			f.setDepartureTime(dateTime);

			// Sets flight reserved seats
			// System.out.println("Enter the # of reserved seats for this flight");
			// f.setReservedSeats(input.nextInt());

			// Sets flight seat price
			// System.out.println("Enter the seat price for this flight");
			// f.setSeatPrice(input.nextFloat());

			fdao.updateFlight(f);

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// Deletes a flight
	public void deleteFlight(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			// call needed DAOs here
			FlightDAO fdao = new FlightDAO(conn);
			fdao.deleteFlight(fdao.getFlightById(id));
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// Displays all flights
	public void readFlights() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			RouteDAO rdao = new RouteDAO(conn);
			// call needed DAOs here
			fdao.getAllFlights().forEach(flight -> {
				try {
					System.out.println(flight.getId() + ". "
							+ rdao.getRouteById(flight.getRouteId()).getOriAirport().getAirportCode() + " -> "
							+ rdao.getRouteById(flight.getRouteId()).getDesAirport().getAirportCode() + " at "
							+ flight.getDepartureTime());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
}
