/**
 * 
 */
package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 
 * The Base DAO for for each DAO
 * 
 * @author Joa
 *
 */
public abstract class BaseDAO<T> {

	public static Connection conn = null;

	public BaseDAO(Connection conn) {
		this.conn = conn;
	}

	// Executes the indicated query with the arguments in the vals array
	public void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		pstmt.executeUpdate();
	}

	// To ensure thread safety with database additions
	public Integer saveWithPK(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		pstmt.executeUpdate();
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			return rs.getInt(1);
		}
		return null;
	}

	// Used with return statements to return data from result tables
	public List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
	}

	// Returns a list from a result set
	public abstract List<T> extractData(ResultSet rs) throws ClassNotFoundException, SQLException;

}
