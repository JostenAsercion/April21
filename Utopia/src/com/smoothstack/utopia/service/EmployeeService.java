package com.smoothstack.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.smoothstack.utopia.dao.RouteDAO;

public class EmployeeService {

	ConnectionUtil connUtil = new ConnectionUtil();

	public void addNewFlight() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void addNewUser() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
}
