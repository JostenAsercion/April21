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

public class AdminServiceSeats {

	ConnectionUtil connUtil = new ConnectionUtil();

	// Adds a new flight
	public void changeSeats() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Scanner input = new Scanner(System.in);
			// call needed DAOs here
			FlightDAO fdao = new FlightDAO(conn);
			RouteDAO rdao = new RouteDAO(conn);

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
			System.out.println("Enter ID of flight to update seats.");
			// f=.setId(input.nextInt());
			f = fdao.getFlightById(input.nextInt());

			// Sets flight reserved seats
			System.out.println("Enter the # of reserved seats for this flight");
			f.setReservedSeats(input.nextInt());

			// Sets flight seat price
			System.out.println("Enter the seat price for this flight");
			f.setSeatPrice(input.nextFloat());

			fdao.updateFlight(f);

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// Displays all flights
	public void readSeats() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			RouteDAO rdao = new RouteDAO(conn);
			AirplaneDAO apldao = new AirplaneDAO(conn);
			// call needed DAOs here
			fdao.getAllFlights().forEach(flight -> {
				try {
					System.out.println(flight.getId() + ". "
							+ rdao.getRouteById(flight.getRouteId()).getOriAirport().getAirportCode() + " -> "
							+ rdao.getRouteById(flight.getRouteId()).getDesAirport().getAirportCode() + " at "
							+ flight.getDepartureTime() + " Reserved: " + flight.getReservedSeats());
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
