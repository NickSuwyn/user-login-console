package dao;

import java.sql.Connection;

public class userLoginDAO {
	
	private Connection connection;
	
	public UserLoginDAO() {
		connection = DBConnection.getConnection();
	}
}
