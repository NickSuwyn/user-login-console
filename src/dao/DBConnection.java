package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	//path to find the database with login credentials
	private final static String URL = "jdbc:mysql://localhost:3306/user_info";
	
	//this log in and password need to be the same for all DB users 
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";
	private static Connection connection;
	private static DBConnection instance;
	
	private DBConnection(Connection connection) {
		this.connection = connection;
	}
	
	public static Connection getConnection() {
		if (instance == null) {
			try {
				// this gets the connection to the database
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBConnection(connection);
				System.out.println("Connection successful.");
			} catch (SQLException e) {
				
			}
			
		}
		return DBConnection.connection;
	}
}
