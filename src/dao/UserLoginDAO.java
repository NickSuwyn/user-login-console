package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.UserLogin;

public class UserLoginDAO {
	
	private Connection connection;
	private final String GET_USERS_QUERY = "SELECT * FROM user_info";
	private final String CREATE_NEW_CHILD_QUERY = "INSERT INTO user_info(username, password)"
			+ "VALUES(?, ?)";
	private final String DELETE_USER_BY_ID = "DELETE FROM user_info WHERE id = ?";
	
	
	public UserLoginDAO() {
		connection = DBConnection.getConnection();
	}
	
	// makes a list of users from the database
	public List<UserLogin> getUsers() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_USERS_QUERY).executeQuery();
		List<UserLogin> users = new ArrayList<UserLogin>();
		
		 while (rs.next()) {
			 users.add(populateUsers(rs.getInt(1), rs.getString(2), rs.getString(3)));
		 }
		 return users;
	}
	
	// used to create a new user
	public void createNewUser(String username, String password) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CHILD_QUERY);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.executeUpdate();
	}
	
	// used to delete user
	public void deleteUser(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_USER_BY_ID);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	//used to get user info from the database and create instances in the program
	private UserLogin populateUsers(int id, String username, String password) {
		return new UserLogin(id, username, password);
	}
}	
