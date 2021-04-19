/**
 * 
 */
package com.smoothstack.utopia.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * Method for setting up the connection to the utopia database
 * 
 * @author Joa
 *
 */
public class ConnectionUtil {
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/utopia";
	private final String username = "root";
	private final String password = "root";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(Boolean.FALSE); // ensures no SQL statements are committed until the commit() method
		return conn;
	}
}
