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
			System.out.println("** Welcome to " + hotelSystem.getHotelName() + " **");
			System.out.println("Currently logged in as:\t" + loggedInUser.getFullName());
			System.out.println("Type of Account:\t" + (loggedInUser.getAccountType() > 0 ? (loggedInUser.getAccountType() > 1 ? "Admin" : "Staff") : "Customer"));

			// Show this because admin supposed to create a reservation using the user's account.
			if(loggedInUser.getAccountType() >= 1)
			{
				System.out.println("You are an staff/admin, please enter the username of the user you want to use:");
				do {
				currentUser = hotelSystem.lookUser(keyboard.nextLine());
				if (currentUser == null)
					System.out.println("Cannot find user. Try again.");
				} while (currentUser == null);
				
			} else {
				currentUser = loggedInUser;
			}

			if (loggedInUser.getAccountType() > 0)
				System.out.println("You are currently modifying customer:\t" + currentUser.getFullName());
			System.out.println();
			PrintMenu();
			System.out.println();
		}
	}

	private static void PrintMenu() {
		System.out.println("Select one of the following(Enter the number):");

		// Standard Users Menu
		System.out.println("\t1: Create Reservation");
		System.out.println("\t2: Look for Reservation");
		System.out.println("\t3: Login Different Account");
		// Staffs and Admins Menu
		if(loggedInUser.getAccountType() >= 1)	
		{
			System.out.println("\t4: Create New Customer");
			System.out.println("\t5: Look for User");
			System.out.println("\t6: View Room Info");
		}
		// Admins Only Menu
		if(loggedInUser.getAccountType() >= 2)
		{
			System.out.println("\t7: Create New Staff");
			System.out.println("\t8: Create New Admin");
			System.out.println("\t9: Create New Room");

		}
		switch(keyboard.nextLine())
		{
		case "1":
			makeReservation(currentUser);
			break;

		case "2":
			System.out.println("======\nLook for Reservation of the User: " + currentUser.getUsername() + "\n======");
			hotelSystem.lookReservation(currentUser);
			System.out.println("Would you like to modify this user or delete it? (m or d)");
			// Menu for modify or delete user here
			break;

		case "3":	// Login a Different User
			System.out.println("======\nLogin Window\n======");
			System.out.println("Enter the username:");
			String loginUser = keyboard.nextLine();
			System.out.println("Enter the user's password");
			String loginPass = keyboard.nextLine();
			// Look for the User and check if password matches.
			// If yes, return the user.
			User tmp = hotelSystem.loginUser(loginUser, loginPass);
			if (tmp != null)
			{
				System.out.println("Success. You are now logged in as: " + tmp.getFullName());
				loggedInUser = tmp;
			}
			// Else, return a message saying incorrect;
			else
				System.out.println("Your username or password is incorrect. Please try again.");
			break;

		case "4":	// Create Customer
			if (!checkPriviledge(1))
				break;

			System.out.println("======\nCreate New Customer\n======");
			System.out.println("Enter username: ");
			String createUser = keyboard.nextLine();
			System.out.println("Enter password: ");
			String createPass = keyboard.nextLine();
			System.out.println("Enter full name of user: ");
			String fullName = keyboard.nextLine();
			if (hotelSystem.createUser(createUser, createPass, fullName, 0) != null)
				System.out.println("Successfully added a new customer");
			else
				System.out.println("A username " + createUser + " is already in the system. Please look for that user or use a different username");
			break;

		case "5":	// Look for User
			if (!checkPriviledge(1))
				break;

			System.out.println("======\nLook For User\n======");

			currentUser = hotelSystem.lookUser(keyboard.nextLine());
			if (currentUser == null)
				System.out.println("Cannot find user with that username.");
			else
			{
				System.out.println("Found user " + currentUser.getFullName());
				System.out.println("== Account Details ==");
				System.out.println("User ID: " + currentUser.getUserID());
				System.out.println("Username: " + currentUser.getUsername());
				System.out.println("Password: " + currentUser.getPassword());
				System.out.println("Full Name: " + currentUser.getFullName());
				System.out.println("Account Type: " + currentUser.getAccountType());
				System.out.println("=====================");
			}
			
			// Menu for modify or delete user here
			System.out.println("Would you like to (m)odify or (d)elete this user?");
			switch(keyboard.nextLine())
			{
			case "m":
			case "modify":
				// Modify
				break;
			case "d":
			case "delete":
				// Delete
			}
			break;

		default:
			System.out.println("Menu not found. Try again.");
			break;
		}

	}

	// Minimum rank to check for priviledge
	private static boolean checkPriviledge(int i) {
		if (loggedInUser.getAccountType() >= i)
			System.out.println("Checking permission... Access Granted");
		else
			System.out.println("Checking permission... Access Denied");
		return (loggedInUser.getAccountType() >= i);
	}

	public static Reservation makeReservation(User user)
	{
		// Should create a room first before making a reservation
		if (hotelSystem.getListOfRooms().size() == 0)
		{
			System.out.println("Room is empty. Cannot create a reservation. Admins, create a room first.");
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
}
