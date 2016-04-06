import java.util.Iterator;
import java.util.Scanner;

public class TestClass {
	/*
	 * SETTINGS:
	 * Change the following info below for the variables that the hotel system will be using.
	 */
	// Initial Admin User
	protected static String username = "admin";
	protected static String password = "cs321";
	protected static String hotelName = "NotYourOrdinary Hotel";

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
	private static User loggedInUser;
	private static User currentUser;

	// Sample main class
	public static void main(String[] args)
	{	
		// Set the hotel name;
		hotelSystem.setHotelName(hotelName);
		// Add an initial admin to manage the hotelSystem and loggedIn to that User
		loggedInUser = hotelSystem.createUser(username, password, "Admin", 2);

		// Show the menu to the appropriate user.
		while(true) {
			System.out.println(hotelSystem.getHotelName());
			PrintMenu();
		}
	}

	private static void PrintMenu() {
		System.out.println("Select one of the following:");

		// Standard Users Menu
		System.out.println("\tcr: Create Reservation");
		System.out.println("\tlr: Look for Reservation");
		System.out.println("\tlu: Login Different Account");
		// Staffs and Admins Menu
		if(loggedInUser.getAccountType() >= 1)	
		{
			System.out.println("\tcc: Create New Customer");
			System.out.println("\tlc: Look for Customer");
		}
		// Admins Only Menu
		if(loggedInUser.getAccountType() >= 2)
		{
			System.out.println("\tcs: Create New Staff");
			System.out.println("\tls: Look for Staff");
			System.out.println("\tcrm: Create New Room");
			System.out.println("\tvrm: View Room Info");
		}
		switch(keyboard.nextLine())
		{
		case "cr":
			// Show this because admin supposed to create a reservation using the user's account.
			if(loggedInUser.getAccountType() >= 1)
			{
				System.out.println("You are an admin, please enter the username of the customer you want to add the reservation to:");
				do {
					currentUser = hotelSystem.lookUser(keyboard.nextLine());
					if (currentUser == null)
						System.out.println("Cannot find user. Enter the username again:");
				} while(currentUser == null);
			} else {
				currentUser = loggedInUser;
			}
			makeReservation(currentUser);
			break;
		case "lr":
			hotelSystem.lookReservation(currentUser);
			System.out.println("Would you like to modify this user or delete it? (m or d)");
			// Menu for modify or delete user here
			break;
		case "cc":	// Create User
			System.out.println("Enter username: ");
			String user = keyboard.nextLine();
			System.out.println("Enter password: ");
			String pass = keyboard.nextLine();
			System.out.println("Enter full name of user: ");
			String fullName = keyboard.nextLine();
			hotelSystem.createUser(user, pass, fullName, 0);
			break;
		case "lc":	// Look for User
			if(loggedInUser.getAccountType() >= 1)
			{
				currentUser = hotelSystem.lookUser(keyboard.nextLine());
				if (currentUser == null)
					System.out.println("Cannot find user with that username.");
				else
					System.out.println("Found user " + currentUser.getFullName() + " and has been set as currentUser user");
			}
			// TODO: Menu for modify or delete user here
			break;
		case "lu":	// Login a Different User
			loginWindow();
			break;
		default:
			System.out.println("Menu not found. Try again.");
			break;
		}
	}
	public static Reservation makeReservation(User user)
	{
		// Should create a room first before making a reservation
		if (hotelSystem.getListOfRooms().size() == 0)
		{
			System.out.print("Room is empty. Cannot create a reservation. Admins, create a room first.");
			return null;
		}
		System.out.println("======\nMake Reservation:\n======");
		System.out.println("Select a Room:");
		// Reservation
		Reservation rsvp = null;
		// View the list of available rooms to users
		Iterator<Room> itr = hotelSystem.getListOfRooms().iterator();
		Room rm = null;
		while(itr.hasNext())
		{
			rm = itr.next();
			System.out.println("Room Number: " + rm.getRoomNumber());
			System.out.println("Price: " + rm.getPrice());
			System.out.println("- Would you like to use this room? Y or N");
			if (keyboard.nextLine().toLowerCase() == "y")
				break;

			if (!itr.hasNext())
				itr = hotelSystem.getListOfRooms().iterator();
		}
		System.out.println("How many are you in a room?:");
		int occupants = keyboard.nextInt();
		System.out.println("When are you using this room?");
		System.out.println("Month (1-12): ");
		int month = keyboard.nextInt();
		System.out.println("Day (DD): ");
		int day = keyboard.nextInt();
		System.out.println("Year (YYYY): ");
		int year = keyboard.nextInt();
		System.out.println("How many days?: ");
		int numberOfDays = keyboard.nextInt();
		keyboard.nextLine();
		// Create reservation
		rsvp = hotelSystem.makeReservation(user.getUserID(), rm, occupants, month, day, year, numberOfDays);
		if (rsvp != null)
			System.out.println("You have successfully added a reservation under " + user.getFullName() + "'s account");
		else
			System.out.println("Unfortunately, this date and room is already taken. Please try a different room or date.");
		return rsvp;
	}

	public static User loginWindow()
	{
		System.out.println("======\nLogin Window\n======");
		System.out.println("Enter the username:");
		String user = keyboard.nextLine();
		System.out.println("Enter the user's password");
		String pass = keyboard.nextLine();
		// Look for the User and check if password matches.
		// If yes, return the user.
		User tmp = hotelSystem.loginUser(user, pass);
		if (tmp != null)
		{
			System.out.println("Success. You are now logged in as: " + tmp.getUsername());
			return tmp;
		}
		// Else, return null;
		System.out.println("Your username or password is incorrect. Please try again.");
		return null;
	}
}
