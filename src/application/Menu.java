package application;

import java.util.Scanner;

public class Menu {
	
	//place private objects here
	private Scanner scanner = new Scanner(System.in);
	
	
	// opens the application to the login screen and leads the user
	// to the other menus based of their login info
	// this loop will run while the user is logged out and they quit
	public void loginScreen() {
		String option = "";
		
		System.out.println("Welcome to the UserInfo application.");
		printLoginWelcome();
		
		do {
			
			System.out.print(">> ");
			option = scanner.next();
			
			if (option.equals("1")) {
				login();
				System.out.println("login");
			} else if (option.equals("2")) {
				createNewUser();
				System.out.println("New User");
			} else if (option.equals("0")){
				
			}else {
				System.out.println("Please give a valid response.\n");
				printLoginWelcome();
			}
			
		} while (!option.equals("0"));
		
		
	}

	
	// if the user login is correct, they can view this in the application (the users)
	private void userLoginSuccessful() {
		String option = "";
		
		System.out.println("What would you like to do?");
		
		do {
			
			if (option.equals("1")) {
				// do something
			} else if (option.equals("2")) {
				// do something
			}

		} while (!option.equals("0"));
	}
	
	//prints the login welcome
	public static void printLoginWelcome() {
		System.out.println("Do you want to make a new account or sign in?");
		System.out.println("1: Log in\n2: Sign up\n0: Quit");
	}
	
	// logs the user into the database
	private void login() {
		// test to see if the login info is correct. If it is, call the
		// userLoginSuccessful method 
	}
	
	// adds a new user to the database
	private void createNewUser() {
		
	}
	
	
	// creates a list of all of the users in the database
	private void displayUsers() {
		
	}
	
	private void deleteUser() {
		
	}
	
}
