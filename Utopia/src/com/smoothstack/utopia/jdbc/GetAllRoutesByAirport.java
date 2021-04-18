/**
 * 
 */
package com.smoothstack.utopia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Joa
 *
 */
public class GetAllRoutesByAirport {

	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/utopia";
	private static final String username = "root";
	private static final String password = "root";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Register driver
		Class.forName(driver);
		// Create connection
		Connection conn = DriverManager.getConnection(url, username, password);
		// Create statement
		PreparedStatement pstmt = conn
				.prepareStatement("select * from route where origin_id = ? OR destination_id = ?");

		Scanner input = new Scanner(System.in);
		System.out.println("Enter airport code to search");
		String airportCode = input.nextLine();
		pstmt.setString(1, airportCode);
		pstmt.setString(2, airportCode);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println("Airport Routes: " + rs.getInt("id") + " " + rs.getString("origin_id") + " -> "
					+ rs.getString("destination_id"));
		}
		input.close();
	}
}
