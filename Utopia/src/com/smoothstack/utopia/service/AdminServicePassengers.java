/**
 * 
 */
package com.smoothstack.utopia.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.smoothstack.utopia.dao.AirplaneDAO;
import com.smoothstack.utopia.dao.AirportDAO;
import com.smoothstack.utopia.dao.FlightDAO;
import com.smoothstack.utopia.dao.PassengerDAO;
import com.smoothstack.utopia.dao.RouteDAO;
import com.smoothstack.utopia.entity.Flight;
import com.smoothstack.utopia.entity.Passenger;
import com.smoothstack.utopia.entity.Route;

public class AdminServicePassengers {

	ConnectionUtil connUtil = new ConnectionUtil();

	// Adds a new flight
	public void addNewPassenger() throws SQLException {
		Scanner input = new Scanner(System.in);
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			// call needed DAOs here
			PassengerDAO pdao = new PassengerDAO(conn);
			FlightDAO fdao = new FlightDAO(conn);
			RouteDAO rdao = new RouteDAO(conn);
			AirportDAO apodao = new AirportDAO(conn);
			AirplaneDAO apldao = new AirplaneDAO(conn);

			Passenger passenger = new Passenger();
			passenger.setId(pdao.nextAvailableId());
			passenger.setBookingId(1);

			// Sets passenger name
			System.out.println("Enter the passenger given name");
			passenger.setGivenName(input.nextLine());
			System.out.println("Enter the passenger family name");
			passenger.setFamilyName(input.nextLine());

			// Sets birthday
			System.out.println("Enter DOB (yyyy-mm-dd)");
			Date date = Date.valueOf(input.nextLine());
			passenger.setDob(date);

			// Sets gender
			System.out.println("Enter gender (male/female/other)");
			passenger.setGender(input.nextLine());

			// Sets address
			System.out.println("Enter the address of the passenger");
			passenger.setAddress(input.nextLine());

			// Adds passenger to passenger table
			pdao.addPassenger(passenger);

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// Updates a passenger
	public void updatePassenger() throws SQLException {
		Connection conn = null;
		Scanner input = new Scanner(System.in);
		try {
			conn = connUtil.getConnection();
			// call needed DAOs here
			FlightDAO fdao = new FlightDAO(conn);
			RouteDAO rdao = new RouteDAO(conn);
			AirplaneDAO apldao = new AirplaneDAO(conn);
			PassengerDAO pdao = new PassengerDAO(conn);

			// Print all passengers
			pdao.getAllPassengers().forEach(passenger -> {
				System.out
						.println(passenger.getId() + ". " + passenger.getGivenName() + " " + passenger.getFamilyName());
			});

			Passenger p = new Passenger();
			System.out.println("Enter ID of passenger you wish to update.");

			int temp = input.nextInt();
			p = pdao.getPassengerById(temp);

			// Sets address
			System.out.println("Enter the new address of the passenger");
			p.setAddress(input.nextLine());

			pdao.updatePassenger(p);

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// Deletes a passenger
	public void deletePassenger(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			// call needed DAOs here
			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.deletePassenger(pdao.getPassengerById(id));
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// Displays passengers
	public void readPassengers() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			// call needed DAOs here
			// Print all passengers
			pdao.getAllPassengers().forEach(passenger -> {
				System.out
						.println(passenger.getId() + ". " + passenger.getGivenName() + " " + passenger.getFamilyName());
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
