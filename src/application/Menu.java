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
		
		
		do {
			printLoginWelcome();
			
			System.out.print(">> ");
			option = scanner.next();
			
			if (option.equals("1")) {
				login();
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
		
		System.out.println("Welcome online.");
		
		
		do {
			
			printSuccessdulMenuOptions();
			System.out.print(">> ");
			option = scanner.next();
			
			if (option.equals("1")) {
				//displayUsers();
			} else if (option.equals("2")) {
				playGame();
			} else if(option.equals("3")) {
				//deleteUser();
			}
			
			else {
				System.out.println("Please give a valid response.\n");
				printSuccessdulMenuOptions();
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
	private void login() {
		// test the login given
		
		
		// if correct, call userLoginSuccessful();
		System.out.println("--------------------------------------------");
		userLoginSuccessful();
		
	}
	
	// adds a new user to the database
	private void createNewUser() {
		
	}
	
	
	// creates a list of all of the users in the database
	private void displayUsers() {
		
	}
	
	// lets the user play a game
	private void playGame() {
		System.out.println("Sorry, no games yet. Try again later!");
	}
	
	// deletes a user from the database
	private void deleteUser() {
		
	}
	
	
	
}
