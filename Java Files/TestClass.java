import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TestClass {

	// RENAME THIS MAIN CLASS TO main2 IF YOU WANT TO USE THE OTHER ONE
	public static void main(String[] args) {
		Date date1 = new Date(3, 12, 2016);
		Date date2 = new Date(3, 13, 2016);

		HotelSystem hs = new HotelSystem();
		print(hs.addRoom(101, false, 100.50).toString());
		print(hs.addRoom(102, false, 213.20).toString());
		print(hs.addRoom(103, true, 163.50).toString());
		print(hs.addUser("user1", "pass", "Full Name User 1", 0).toString());
		print(hs.addUser("user2", "pass", "Full Name User 2", 0).toString());
		print(hs.addReservation(HotelSystem.getDB().getListOfUsers().get(0), HotelSystem.getDB().getListOfRooms().get(0), 2, 3, 13, 2016, 3).toString());
		print(hs.addReservation(HotelSystem.getDB().getListOfUsers().get(0), HotelSystem.getDB().getListOfRooms().get(2), 2, 3, 13, 2016, 3).toString());
		print(hs.addReservation(HotelSystem.getDB().getListOfUsers().get(1), HotelSystem.getDB().getListOfRooms().get(0), 2, 3, 17, 2016, 3).toString());
		print(hs.addReservation(HotelSystem.getDB().getListOfUsers().get(1), HotelSystem.getDB().getListOfRooms().get(1), 2, 3, 17, 2016, 3).toString());

		print(hs.generateReportAll().toString());
		print(hs.generateReportRange(date1, date2).toString());
	}

	// NOTE: RENAME MAIN CLASS BELOW IF YOU WANT TO USE THE MANUAL ADDITION
	/* ===========================================
	 * SETTINGS:
	 * Change the following info below for the
	 * variables that the hotel system will be
	 * using.
	 * ============ Begin of Settings ============
	 */

	// Hotel Name
	protected static String hotelName = "NotYourOrdinary Hotel";

	// Initial Admin User
	protected static String username = "admin";
	protected static String password = "cs321";

	// Initial Customer User
	protected static String cusername = "user";
	protected static String cpassword = "pass";

	/*
	 * ============ End of Settings ============
	 */

	// For keyboard inputs.
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
	public static void main2(String[] args)
	{	
		// Set the hotel name;
		hotelSystem.setHotelName(hotelName);

		// Add an initial admin user to manage the hotelSystem and customer 
		loggedInUser = hotelSystem.addUser(username, password, "MyName IsAdmin", 2);
		currentUser = hotelSystem.addUser(cusername, cpassword, "Customer Name", 0);


		// Show the menu to the appropriate user.
		while(true) {
			print("** Welcome to " + hotelSystem.getHotelName() + " **");
			print("Currently logged in as\t:\t" + loggedInUser.getFullName());
			print("Type of Account\t\t:\t" + (loggedInUser.getAccountType() > 0 ? (loggedInUser.getAccountType() > 1 ? "Admin" : "Staff") : "Customer"));

			// Show this because admin supposed to create a reservation using the user's account.
			if(loggedInUser.getAccountType() >= 1)
			{
				print("You are a(n) staff/admin, please enter the username of the customer you are helping:");
				do {
					currentUser = hotelSystem.getUser(keyboard.nextLine());
					if (currentUser == null)
						print("Cannot find user. Try again.");
				} while (currentUser == null);

			} else {
				currentUser = loggedInUser;
			}

			if (loggedInUser.getAccountType() > 0)
				print("You are currently helping customer:\t" + currentUser.getFullName());
			print("");
			PrintMenu();
			print("");
		}
	}

	private static void PrintMenu() {
		print("Select one of the following(Enter the number):");

		// Standard Users Menu
		print("\t1: Create Reservation");
		print("\t2: Look for Reservation");
		print("\t3: Login Different Account");
		// Staffs and Admins Menu
		if(loggedInUser.getAccountType() >= 1)	
		{
			print("\t4: Create New Customer");
			print("\t5: Look for User");
			print("\t6: View Room Info");
			print("\t7: Check-In Customer");
			print("\t8: Check-Out Customer");
		}
		// Admins Only Menu
		if(loggedInUser.getAccountType() >= 2)
		{
			print("\t9: Create New Staff");
			print("\t10: Create New Admin");
			print("\t11: Create New Room");

		}

		// Selections
		switch(keyboard.nextLine())
		{
		case "1":
			makeReservation(currentUser);
			break;

		case "2":
			lookReservation();
			break;

		case "3":	// Login a Different User
			loginUser();
			break;

		case "4":	// Create Customer
			if (!hotelSystem.checkPriviledge(loggedInUser, 1))
				break;
			createUser(0);
			break;

		case "5":	// Look for User
			if (!hotelSystem.checkPriviledge(loggedInUser, 1))
				break;
			lookUser();
			break;

		case "6":	// View Room Info
			if (!hotelSystem.checkPriviledge(loggedInUser, 1))
				break;
			lookRoom();
			break;

		case "7":	// Check-in the currentUser
			if (!hotelSystem.checkPriviledge(loggedInUser, 1))
				break;
			checkIn();
			break;

		case "8":	// Check-out the currentUser
			if (!hotelSystem.checkPriviledge(loggedInUser, 1))
				break;
			checkOut();
			break;

		case "9":	// Create Staff
			if (!hotelSystem.checkPriviledge(loggedInUser, 2))
				break;
			createUser(1);
			break;

		case "10":	// Create Admin
			if (!hotelSystem.checkPriviledge(loggedInUser, 2))
				break;
			createUser(2);
			break;

		case "11":	// Create Room
			if (!hotelSystem.checkPriviledge(loggedInUser, 2))
				break;
			createRoom();
			break;

		default:
			print("Menu not found. Try again.");
			break;
		}

	}

	private static void checkOut() {
		print("======\nCheck-In\n======");
		// Show the list of reservations first then select the given reservation
		// then shows a menu about checking-in

	}

	private static void checkIn() {
		print("======\nCheck-Out\n======");

	}

	private static void createRoom() {
		print("======\nCreate Room\n======");
		print("Enter the Room Number:");
		int rmNumber = keyboard.nextInt();
		print("Is it Double? (y or n):");
		boolean isDouble = ("y".equals(keyboard.next().toLowerCase()) ? true : false);
		print("How much does the Room cost?:");
		double price = keyboard.nextDouble();
		keyboard.nextLine();

		if (hotelSystem.addRoom(rmNumber, isDouble, price) != null)
			print("Successfully added a new room");
		else
			print("Room " + rmNumber + " is already in the system. Please look for that room or use a different room number.");
	}

	private static void lookRoom() {
		print("======\nLook for Room\n======");
		for (int i = 0; i < HotelSystem.getDB().getListOfRooms().size(); i++)
		{

			print("Room Number:\t" + HotelSystem.getDB().getListOfRooms().get(i).getRoomNumber());
			print(HotelSystem.getDB().getListOfRooms().get(i).isDouble() ? "Type:\t\tDouble" : "Type:\t\tSingle");
			print("Price:\t\t" + HotelSystem.getDB().getListOfRooms().get(i).getPrice());
		}
	}

	private static void lookReservation() {
		print("======\nLook for Reservations of the User: " + currentUser.getUsername() + "\n======");
		ArrayList<Reservation> list = hotelSystem.getReservations(currentUser);
		Iterator<Reservation> itr = list.iterator();
		Reservation rsvp;

		if (list.isEmpty())
		{
			print("There are no reservations under this account");
			return;
		}
		while(itr.hasNext())
		{
			rsvp = itr.next();
			print("Reservation ID:\t\t" + rsvp.getRsvpID());
			print("Reserved to:\t\t" + rsvp.getReservedTo().getFullName());
			print("Room:\t\t\t" + rsvp.getRoom().getRoomNumber());
			print("Number of Occupants:\t" + rsvp.getNumberOfOccupants());
			print("Booked on the following dates:");
			for (int i = 0; i < rsvp.getDates().size(); i++)
				print("\t" + rsvp.getDates().get(i).toString());
			print("# of Nights of Stay:\t" + rsvp.getNumberOfNights());
			print("Balance:\t\t" + rsvp.getBalance());
			print("Room Cost Per Night:\t" + rsvp.getRoomCost());
			print("Total Room Cost:\t" + rsvp.getRoomCost()*rsvp.getNumberOfNights());
			print("");
		}
		print("Select the Reservation ID of the following reservations you would like to modify or delete? (m or d)");
		// Menu for modify or delete user here
	}

	private static void loginUser() {
		print("======\nLogin Window\n======");
		print("Enter the username:");
		String loginUser = keyboard.nextLine();
		print("Enter the user's password");
		String loginPass = keyboard.nextLine();
		// Look for the User and check if password matches.
		// If yes, return the user.
		User tmp = hotelSystem.loginUser(loginUser, loginPass);
		if (tmp != null)
		{
			print("Success. You are now logged in as: " + tmp.getFullName());
			loggedInUser = tmp;
		}
		// Else, return a message saying incorrect;
		else
			print("Your username or password is incorrect. Please try again.");
	}

	private static void createUser(int rank) {
		print("======\nCreate New Customer\n======");
		print("Enter username: ");
		String user = keyboard.nextLine();
		print("Enter password: ");
		String pass = keyboard.nextLine();
		print("Enter full name of user: ");
		String fullName = keyboard.nextLine();

		if (hotelSystem.addUser(user, pass, fullName, rank) != null)
			print("Successfully added a new user");
		else
			print("A username " + user + " is already in the system. Please look for that user or use a different username");
	}

	private static void lookUser() {
		print("======\nLook For User\n======");

		print("Enter the username of user:");
		User usr = hotelSystem.getUser(keyboard.nextLine());
		if (usr == null)
			print("Cannot find user with that username.");
		else
		{
			print("Found user " + usr.getFullName());
			print("== Account Details ==");
			print("User ID: " + usr.getUserID());
			print("Username: " + usr.getUsername());
			print("Password: " + usr.getPassword());
			print("Full Name: " + usr.getFullName());
			print("Account Type: " + usr.getAccountType());
			print("=====================");
		}

		// Menu for modify or delete user here
		print("Select one of the following you would like to do with this user?");
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
	}

	private static void makeReservation(User user)
	{
		// Should create a room first before making a reservation
		if (HotelSystem.getDB().getListOfRooms().size() == 0)
		{
			print("Room is empty. Cannot create a reservation. Admins, create a room first.");
			return;
		}

		print("======\nMake Reservation:\n======");
		print("Select a Room:");
		// View the list of available rooms to users
		Iterator<Room> itr = HotelSystem.getDB().getListOfRooms().iterator();
		Room rm = null;
		while(itr.hasNext() && rm == null)
		{
			rm = itr.next();
			print("\nRoom Number: " + rm.getRoomNumber());
			print(rm.isDouble() ? "Type: Double" : "Type: Single");
			print("Price: " + rm.getPrice());
			print("- Would you like to use this room? Y or N");
			if (keyboard.nextLine().toLowerCase() == "y")
				break;

			if (!itr.hasNext())
				itr = HotelSystem.getDB().getListOfRooms().iterator();
		}
		print("How many are you in a room?:");
		int occupants = keyboard.nextInt();
		print("When are you using this room?");
		print("Month (1-12):");
		int month = keyboard.nextInt();
		print("Day (DD):");
		int day = keyboard.nextInt();
		print("Year (YYYY):");
		int year = keyboard.nextInt();
		print("How many nights?:");
		int numberOfNights = keyboard.nextInt();
		keyboard.nextLine();
		if (hotelSystem.addReservation(user, rm, occupants, month, day, year, numberOfNights) != null)
			print("You have successfully added a reservation under " + user.getFullName() + "'s account");
		else
			print("Unfortunately, this date and room is already taken. Please try a different room or date.");
	}

	public static void print(Object o)
	{
		System.out.println(o);
	}
}
