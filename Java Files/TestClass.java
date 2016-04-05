import java.util.Scanner;

public class TestClass {

	// Import scanner
	private static Scanner keyboard = new Scanner(System.in);

	// Create an instance of the hotel
	private static HotelSystem hotelSystem = new HotelSystem();

	/*
	 *  Logged-in user to the system.
	 *  Admins can do everything.
	 *  Staff can print report, create reservation,
	 *  Users can only create reservation and update their reservations. Also, view all the reservations
	 *  under that user.
	 */
	private static Users loggedInUser;
	private static Users user;

	// Sample main class
	public static void main(String[] args)
	{	
		// Name your hotel
		System.out.println("Name your hotel");
		hotelSystem.setHotelName(keyboard.nextLine());
		// Add an admin to manage the hotelSystem
		// ASK USER TO CREATE RESERVATION
		while(true) {
			PrintMenu();
		}
	}

	private static void PrintMenu() {
		System.out.println("Select one of the following:");
		while (user == null)
			hotelSystem.loginWindow();

		// Standard Users Menu
		System.out.println("\tcr: Create Reservation");
		System.out.println("\tlr: Look for Reservation");

		if(loggedInUser.getAccountType() >= 1)	// Staffs and Admins
		{
			System.out.println("\tcu: Create New Customer");
			System.out.println("\tlu: Look for Customer");
		}
		if(loggedInUser.getAccountType() >= 2)	// Admins
		{
			System.out.println("\tcs: Create New Staff");
			System.out.println("\tls: Look for Staff");
			System.out.println("\tcrm: Create New Room");
			System.out.println("\tvrm: View Room Info");
		}
		switch(keyboard.nextLine())
		{
		case "cr":
			hotelSystem.makeReservation(user);
			break;
		case "lr":
			hotelSystem.lookReservation(user);
			System.out.println("Would you like to modify this user or delete it? (m or d)");
			// Menu for modify or delete user here
			break;
		case "cc":
			hotelSystem.createUser();
			break;
		case "lc":
			hotelSystem.lookUser();
			// Menu for modify or delete user here
			break;
		case "lu":
			hotelSystem.loginWindow();
		default:
			System.out.println("Menu not found. Try again.");
			break;
		}
	}


}
