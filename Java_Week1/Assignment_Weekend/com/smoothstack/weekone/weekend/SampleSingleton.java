package com.smoothstack.weekone.weekend;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Week 1 Weekend. Assignment 6. Fix the Singleton class.
 * 
 * @author Joa
 */

/*
 * CHANGES: Removed static modifier from class. Added instantiation via
 * getInstance() when there is no instance. Changed input to input.intValue().
 * Changed databaseQuery() to throw a SQLException.
 *
 */
public class SampleSingleton {
	private static Connection conn = null;
	private static SampleSingleton instance = null;

	public static SampleSingleton getInstance() {
		if (instance == null)
			return instance = new SampleSingleton();
		return instance;
	}

	public static void databaseQuery(BigDecimal input) throws SQLException {
		conn = DriverManager.getConnection("url of database"); // Establishes connection to database url
		Statement st = conn.createStatement(); // Creates statement from the connection to make queries
		ResultSet rs = st.executeQuery("select id from table"); // Table of IDs
		int x = 0;
		while (rs.next()) {
			x = rs.getInt(1) * input.intValue();
		}
	}
}