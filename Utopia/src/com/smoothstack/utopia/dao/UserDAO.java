/**
 * 
 */
package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.entity.User;

/**
 * @author Joa
 *
 */
public class UserDAO extends BaseDAO<User> {

	public UserDAO(Connection conn) {
		super(conn);
	}

	// Adds an user to the users table
	public Integer addUser(User user) throws ClassNotFoundException, SQLException {
		return saveWithPK(
				"insert into user (id, role_id, given_name, family_name, username, email, password, phone) VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { user.getId(), user.getRoleId(), user.getGivenName(), user.getFamilyName(),
						user.getUsername(), user.getEmail(), user.getPassword(), user.getPhone() });
	}

	// Updates an existing user (via id)
	public void updateUser(User user) throws ClassNotFoundException, SQLException {
		save("update user role_id = ?, given_name = ?, family_name = ?, username = ?, email = ?, password = ?, phone = ? where id = ?",
				new Object[] { user.getRoleId(), user.getGivenName(), user.getFamilyName(), user.getUsername(),
						user.getEmail(), user.getPassword(), user.getPhone(), user.getId() });
	}

	// Removes an user from the user table
	public void deleteUser(User user) throws ClassNotFoundException, SQLException {
		save("delete from user where id = ?", new Object[] { user.getId() });
	}

	// Returns a list of all flights
	public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
		return read("select * from user", null);
	}

	// Returns a list from a result set
	@Override
	public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<User> userList = new ArrayList<>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setRoleId(rs.getInt("role_id"));
			user.setGivenName(rs.getString("given_name"));
			user.setFamilyName(rs.getString("family_name"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			userList.add(user);
		}
		return userList;
	}

}
