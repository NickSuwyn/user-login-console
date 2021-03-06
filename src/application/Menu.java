package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.UserLoginDAO;
import entity.UserLogin;

public class Menu {
	
	//place private objects here
	private Scanner scanner = new Scanner(System.in);
	private UserLoginDAO userLoginDAO = new UserLoginDAO();
	
	
	// opens the application to the login screen and leads the user
	// to the other menus based of their login info
	// this loop will run while the user is logged out and they quit
	public void loginScreen() {
		String option = "";
		
		System.out.println("Welcome to the UserInfo application.");
		
		do {
			printLoginWelcome();
			
			System.out.print(">> ");
			option = scanner.next();
			
			try {
				if (option.equals("1")) {
					login();
				} else if (option.equals("2")) {
					createNewUser();
				} else if (option.equals("0")){
					
				}else {
					System.out.println("Please give a valid response.\n");
					printLoginWelcome();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} while (!option.equals("0"));
		
		
	}

	
	// if the user login is correct, they can view this in the application (the users)
	private void userLoginSuccessful() {
		String option = "";
		
		System.out.println("Welcome online.");
		
		
		do {
			
			printSuccessdulMenuOptions();
			System.out.print(">> ");
			option = scanner.next();
			
			try {
				
				if (option.equals("1")) {
					displayUsers();
				} else if (option.equals("2")) {
					playGame();
				} else if(option.equals("3")) {
					deleteUser();
				}else {
					System.out.println("Please give a valid response.\n");
					printSuccessdulMenuOptions();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("");
			scanner.nextLine();
			
		} while (!option.equals("0"));

	}
	
	//prints the login welcome
	public static void printLoginWelcome() {
		System.out.println("Do you want to make a new account or sign in?");
		System.out.println("1: Log in\n2: Sign up\n0: Quit");
	}
	
	//print the loginSuccessfulMenu options
	public static void printSuccessdulMenuOptions() {
		System.out.println("What would you like to do today?");
		System.out.println("1: Display users\n2: Play a game\n3: Delete user"
				+ "\n0: Log out");
	}
	// checks to see if login is correct. If it is, logs the
	// user into the application 
	private void login() throws SQLException {
		// test the login given
		System.out.println("Please enter a username and password.");
		
		System.out.print("Username>> ");
		String testUsername = scanner.next();
		
		System.out.print("Password>> ");
		String testPassword = scanner.next();
		
		List<UserLogin> users = userLoginDAO.getUsers();
		
		for (UserLogin user: users) {
			if (testUsername.equals(user.getUsername())) {
				if (testPassword.equals(user.getPassword())) {
					// if correct, call userLoginSuccessful();
					System.out.println("Login successful.");
					System.out.println("--------------------------------------------");
					userLoginSuccessful();
					break;
				}				
			}
		}
		System.out.println(">>>>>>>ERROR<<<<<<<\n"
				+ "Username or password inccorect.");
		System.out.println(">>>>>>>ERROR<<<<<<<\n");	
	}
	
	public void checkStrInput(String str) {
		if (str.isEmpty()) {
			System.out.println("Invalid input. Try again human.");
		}
	}
	
	// adds a new user to the database
	private void createNewUser() throws SQLException {
		System.out.print("Enter Username: ");
		String userName = scanner.next();
		System.out.print("Enter password: ");
		String password = scanner.next();
		userLoginDAO.createNewUser(userName, password);
		System.out.println(userName + "Added to Database");	
	}
	
	// creates a list of all of the users in the database
	private void displayUsers() throws SQLException {
		System.out.println("Current Users: ");
		List<UserLogin> users = userLoginDAO.getUsers(); 
		for (UserLogin user: users) {
			System.out.println("\t" + user.getId() + ": " + user.getUsername());
		}
		
	}
	
	// lets the user play a game
	private void playGame() {
		System.out.println("Sorry, no games yet. Try again later!");
	}
	
	// deletes a user from the database
	private void deleteUser() throws SQLException {
		System.out.print("Enter ID of user to delete: ");
		int userID = Integer.parseInt(scanner.next());
		userLoginDAO.deleteUser(userID);
		System.out.println("User was deleted.");
	}
	
	
	
}
