/**
 * 
 */
package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.entity.UserRole;

/**
 * @author Joa
 *
 */
public class UserRoleDAO extends BaseDAO<UserRole> {

	public UserRoleDAO(Connection conn) {
		super(conn);
	}

	// Adds a userRole to the userRole table
	public Integer addUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		return saveWithPK("insert into user_role (id, name) VALUES(?, ?)",
				new Object[] { userRole.getId(), userRole.getName() });
	}

	// Updates an existing userRole (via id)
	public void updateUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		save("update user_role set name = ? where id = ?", new Object[] { userRole.getName(), userRole.getId() });
	}

	// Removes a userRole from the userRole table
	public void deleteUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		save("delete from user_role where id = ?", new Object[] { userRole.getId() });
	}

	// Returns a list of all userRoles
	public List<UserRole> getAllUserRoles() throws ClassNotFoundException, SQLException {
		return read("select * from user_role", null);
	}

	// Returns a list from a result set
	@Override
	public List<UserRole> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<UserRole> userRoleList = new ArrayList<>();
		while (rs.next()) {
			UserRole userRole = new UserRole();
			userRole.setId(rs.getInt("id"));
			userRole.setName(rs.getString("name"));
			userRoleList.add(userRole);
		}

		return userRoleList;
	}

}
