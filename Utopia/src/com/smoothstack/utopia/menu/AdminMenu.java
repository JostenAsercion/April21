/**
 * 
 */
package com.smoothstack.utopia.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.smoothstack.utopia.service.AdminServiceFlights;
import com.smoothstack.utopia.service.AdminServicePassengers;
import com.smoothstack.utopia.service.AdminServiceSeats;

/**
 * Utopia Administrator menu
 * 
 * @author Joa
 *
 */
public class AdminMenu {

	/**
	 * @param args
	 * @throws SQLException
	 */
	static Scanner input = new Scanner(System.in);

	public static void displayMenu() throws SQLException {
		// TODO Auto-generated method stub
		int option;

		System.out.println("\nWelcome, ADMINISTRATOR." + "\nPlease select an option below."
				+ "\n1) Add/Update/Delete/Read Flights" + "\n2) Add/Update/Delete/Read Seats"
				+ "\n3) Add/Update/Delete/Read Tickets and Passengers" + "\n4) Add/Update/Delete/Read Airports"
				+ "\n5) Add/Update/Delete/Read Travelers" + "\n6) Add/Update/Delete/Read Employees"
				+ "\n7) Override Trip Cancellation for a ticket" + "\n8) Back");
		option = input.nextInt();

		switch (option) {
		case 1:
			manageFlights();
			break;
		case 2:
			manageSeats();
			break;
		case 3:
			managePassengers();
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			input.close();
		}
	}

	public static void manageFlights() throws SQLException {
		AdminServiceFlights asf = new AdminServiceFlights();
		int option;

		System.out.println("\n1) Add Flights" + "\n2) Update Flights" + "\n3) Delete Flights" + "\n4) Read Flights"
				+ "\n5) Add New Route" + "\n6) Back");
		option = input.nextInt();

		switch (option) {
		case 1:
			asf.addNewFlight();
			break;
		case 2:
			asf.updateFlight();
			break;
		case 3:
			System.out.println("\nEnter the ID of the Flight you would like to delete");
			option = input.nextInt();
			asf.deleteFlight(option);
			break;
		case 4:
			asf.readFlights();
			break;
		case 5:
			asf.addRoute();
			break;
		case 6:
			break;

		}
		displayMenu();
	}

	public static void manageSeats() throws SQLException {
		AdminServiceSeats ass = new AdminServiceSeats();
		int option;

		System.out.println("\n1) Change Seats" + "\n2) Read remaining seats" + "\n3) Back");
		option = input.nextInt();

		switch (option) {
		case 1:
			ass.changeSeats();
			break;
		case 2:
			ass.readSeats();
			break;
		case 3:

			break;

		}
		displayMenu();
	}

	public static void managePassengers() throws SQLException {
		AdminServicePassengers asp = new AdminServicePassengers();
		int option;

		System.out.println("\n1) Add Passenger" + "\n2) Update Passenger" + "\n3) View Passengers" + "\4) Back");
		option = input.nextInt();

		switch (option) {
		case 1:
			asp.addNewPassenger();
			break;
		case 2:
			asp.updatePassenger();
			break;
		case 3:
			asp.readPassengers();
			break;

		}
		displayMenu();
	}
}
