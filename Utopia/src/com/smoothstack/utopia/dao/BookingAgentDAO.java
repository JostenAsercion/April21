/**
 * 
 */
package com.smoothstack.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.entity.BookingAgent;

/**
 * @author Joa
 *
 */
public class BookingAgentDAO extends BaseDAO<BookingAgent> {

	public BookingAgentDAO(Connection conn) {
		super(conn);
	}

	// Adds a bookingAgent to the bookingAgent table
	public Integer addBookingAgent(BookingAgent bookingAgent) throws ClassNotFoundException, SQLException {
		return saveWithPK("insert into booking_agent (booking_id, agent_id) VALUES(?, ?)",
				new Object[] { bookingAgent.getBookingId(), bookingAgent.getAgentId() });
	}

	// Updates an existing bookingAgent (via agent_id)
	public void updateBookingAgent(BookingAgent bookingAgent) throws ClassNotFoundException, SQLException {
		save("update bookingAgent set booking_id = ? where agent_id = ?",
				new Object[] { bookingAgent.getBookingId(), bookingAgent.getAgentId() });
	}

	// Removes a bookingAgent from the bookingAgent table
	public void deleteBookingAgent(BookingAgent bookingAgent) throws ClassNotFoundException, SQLException {
		save("delete from booking_agent where agent_id = ?", new Object[] { bookingAgent.getAgentId() });
	}

	// Returns a list of all bookingAgents
	public List<BookingAgent> getAllBookingAgents() throws ClassNotFoundException, SQLException {
		return read("select * from booking_agent", null);
	}

	// Returns a list from a result set
	@Override
	public List<BookingAgent> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingAgent> bookingAgentList = new ArrayList<>();
		while (rs.next()) {
			BookingAgent bookingAgent = new BookingAgent();
			bookingAgent.setAgentId(rs.getInt("agent_id"));
			bookingAgent.setBookingId(rs.getInt("booking_id"));
			bookingAgentList.add(bookingAgent);
		}

		return bookingAgentList;
	}

}
