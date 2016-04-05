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
	private static User user;

	// Sample main class
	public static void main(String[] args)
	{	
		// Set the hotel name;
		hotelSystem.setHotelName(hotelName);
		// Add an initial admin to manage the hotelSystem and loggedIn to that User
		loggedInUser = hotelSystem.createUser(username, password, "Admin", 2);

		// Show the menu to the appropriate user.
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
		// Staffs and Admins Menu
		if(loggedInUser.getAccountType() >= 1)	
		{
			System.out.println("\tcu: Create New Customer");
			System.out.println("\tlu: Look for Customer");
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
	public Reservation makeReservation(User userID)
	{
		System.out.println("======\nMake Reservation:\n======");
		System.out.println("Select a Room:");
		// Reservation
		Reservation rsvp = null;
		// View the list of available rooms to users
		Iterator<Room> itr = listOfRooms.iterator();
		Room rm;
		while(itr.hasNext())
		{
			rm = itr.next();
			System.out.println("Room Number: " + rm.getRoomNumber());
			System.out.println("Price: " + rm.getPrice());
			System.out.println("- Would you like to use this room? Y or N");
			if (keyboard.nextLine().toLowerCase() == "y")
				break;
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
		keyboard.nextLine();
		Calendar date = calendar.checkDate(rm,month,day,year);
		if (date == null)
		{
			rsvp = Reservation(userID, rm, occupants, date, rm.getPrice(), rm.getPrice());
			listOfReservations.add(rsvp);
			System.out.println("You have successfully added a reservation under " + userID.getFullName() + "'s account");
		}
		else
			System.out.println("Unfortunately, this date and room is already taken. Please try a different room or date.");
		return rsvp;
	}
	public User loginWindow()
	{
		Iterator<User> users = hotelSystem.getListOfUsers().iterator();
		System.out.println("======\nLogin Window\n======");
		System.out.println("Enter the username:");
		String user = keyboard.nextLine();
		System.out.println("Enter the user's password");
		String pass = keyboard.nextLine();
		// Look for the User and check if password matches.
		// If yes, return the user.
		User tmp;
		while (users.hasNext())
		{
			tmp = users.next();
			if (tmp.getUsername().equals(user) && tmp.getPassword().equals(pass))
			{
				System.out.println("Success. You are now logged in as: " + tmp.getUsername());
				return tmp;
			}
		}
		// Else, return null;
		System.out.println("Your username or password is incorrect. Please try again.");
		return null;
	}
}
