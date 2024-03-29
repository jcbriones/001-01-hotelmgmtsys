import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TestClass {

	// Instantiation of HotelSystem
	private static HotelSystem hs = new HotelSystem();

	// RENAME THIS MAIN CLASS TO main2 IF YOU WANT TO USE THE OTHER ONE. THIS IS THE SYSTEM GENERATED TEST CLASS
	public static void main(String[] args) {
		try {
			Date date1 = new Date(3, 12, 2016);
			Date date2 = new Date(3, 13, 2016);

			print("=========================================================================");
			print(" Add the following info");
			print("=========================================================================");
			print(hs.addRoom(101, false, 100.50));
			print(hs.addRoom(102, false, 213.20));
			print(hs.addRoom(103, true, 163.50));
			print(hs.addUser("user1", "pass", "Full Name User 1", 0,"","","","",12345));
			print(hs.addUser("user2", "pass", "Full Name User 2", 0,"","","","",12345));
			print(hs.addReservation(hs.getDB().getListOfUsers().get(0), hs.getDB().getListOfRooms().get(0), 2, true, 3, 13, 2016, 3));
			print(hs.addReservation(hs.getDB().getListOfUsers().get(0), hs.getDB().getListOfRooms().get(2), 2, false, 3, 13, 2016, 3));
			print(hs.addReservation(hs.getDB().getListOfUsers().get(1), hs.getDB().getListOfRooms().get(0), 2, true, 3, 17, 2016, 3));
			print(hs.addReservation(hs.getDB().getListOfUsers().get(1), hs.getDB().getListOfRooms().get(1), 2, false, 3, 17, 2016, 3));

			User usr = hs.getUser("user1");
			Reservation rsvp = hs.getReservationByID(0);
			print("=========================================================================");
			print(" Set Current User: " + usr.getFullName() + " and reservationID: " + rsvp.getRsvpID());
			print("=========================================================================");
			
			print("=========================================================================");
			print(" Add Credit Card");
			print("=========================================================================");
			print(hs.addCreditCard(usr, usr.getFullName(), "Visa", "12341234123412", 123, 10, 2016, "4400 University Dr", "", "Fairfax", "VA", 22030));
			print("=========================================================================");
			print(" Charge the User's Credit Card");
			print("=========================================================================");
			print(hs.chargeUser(rsvp));
			print("=========================================================================");
			print(" Check-In");
			print("=========================================================================");
			print(hs.checkInReservation(rsvp,rsvp.getDates().get(0)));
			print("=========================================================================");
			print(" View the current reservation");
			print("=========================================================================");
			print(rsvp);
			print("=========================================================================");
			print(" View the current room under that reservation that is being checked-in");
			print("=========================================================================");
			print(rsvp.getRoom());
			print("=========================================================================");
			print(" Check-Out");
			print("=========================================================================");
			print(hs.checkOutReservation(rsvp,rsvp.getDates().get(rsvp.getDates().size()-1)));
			print("=========================================================================");
			print(" View the Reservation again and the Room that is being checked-out");
			print("=========================================================================");
			print(rsvp.toString());
			print(rsvp.getRoom());

			print("=========================================================================");
			print(" Generate Reports (Revenue is only calculated for completed reservations)");
			print("=========================================================================");
			print(hs.generateReportAll());
			print(hs.generateReportByRange(date1, date2).toString(date1,date2));
		}
		catch(Exception e)
		{
			print("You have something that is returned a null because it's either the item you are adding is already in the system.");
			print("Please check the following:");
			print("- Users cannot have the same username");
			print("- Reservation dates should not conflict to the dates that are already in the database.");
			print("- Rooms can't have the same room number");
			print("- Check your dates");
		}
	}

	// NOTE: RENAME THE MAIN CLASS BELOW IF YOU WANT TO USE THE MANUAL ADDITION
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
		hs.setHotelName(hotelName);

		// Add an initial admin user to manage the hs and customer 
		loggedInUser = hs.addUser(username, password, "MyName IsAdmin", 2,"","","","",12345);
		currentUser = hs.addUser(cusername, cpassword, "Customer Name", 0,"","","","",12345);


		// Show the menu to the appropriate user.
		while(true) {
			print("** Welcome to " + hs.getHotelName() + " **");
			print("Currently logged in as\t:\t" + loggedInUser.getFullName());
			print("Type of Account\t\t:\t" + (loggedInUser.getAccountType() > 0 ? (loggedInUser.getAccountType() > 1 ? "Admin" : "Staff") : "Customer"));

			// Show this because admin supposed to create a reservation using the user's account.
			if(loggedInUser.getAccountType() >= 1)
			{
				print("You are a(n) staff/admin, please enter the username of the customer you are helping:");
				do {
					currentUser = hs.getUser(keyboard.nextLine());
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
			if (!hs.checkPrivilege(loggedInUser, 1))
				break;
			createUser(0);
			break;

		case "5":	// Look for User
			if (!hs.checkPrivilege(loggedInUser, 1))
				break;
			lookUser();
			break;

		case "6":	// View Room Info
			if (!hs.checkPrivilege(loggedInUser, 1))
				break;
			lookRoom();
			break;

		case "7":	// Check-in the currentUser
			if (!hs.checkPrivilege(loggedInUser, 1))
				break;
			checkIn();
			break;

		case "8":	// Check-out the currentUser
			if (!hs.checkPrivilege(loggedInUser, 1))
				break;
			checkOut();
			break;

		case "9":	// Create Staff
			if (!hs.checkPrivilege(loggedInUser, 2))
				break;
			createUser(1);
			break;

		case "10":	// Create Admin
			if (!hs.checkPrivilege(loggedInUser, 2))
				break;
			createUser(2);
			break;

		case "11":	// Create Room
			if (!hs.checkPrivilege(loggedInUser, 2))
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

		if (hs.addRoom(rmNumber, isDouble, price) != null)
			print("Successfully added a new room");
		else
			print("Room " + rmNumber + " is already in the system. Please look for that room or use a different room number.");
	}

	private static void lookRoom() {
		print("======\nLook for Room\n======");
		for (int i = 0; i < hs.getDB().getListOfRooms().size(); i++)
		{

			print("Room Number:\t" + hs.getDB().getListOfRooms().get(i).getRoomNumber());
			print(hs.getDB().getListOfRooms().get(i).isDouble() ? "Type:\t\tDouble" : "Type:\t\tSingle");
			print("Price:\t\t" + hs.getDB().getListOfRooms().get(i).getPrice());
		}
	}

	private static void lookReservation() {
		print("======\nLook for Reservations of the User: " + currentUser.getUsername() + "\n======");
		ArrayList<Reservation> list = hs.getReservations(currentUser);
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
			print(rsvp.toString());
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
		User tmp = hs.loginUser(loginUser, loginPass);
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

		if (hs.addUser(user, pass, fullName, rank,"","","","",12345) != null)
			print("Successfully added a new user");
		else
			print("A username " + user + " is already in the system. Please look for that user or use a different username");
	}

	private static void lookUser() {
		print("======\nLook For User\n======");

		print("Enter the username of user:");
		User usr = hs.getUser(keyboard.nextLine());
		if (usr == null)
			print("Cannot find user with that username.");
		else
			print(usr.toString());

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
		if (hs.getDB().getListOfRooms().size() == 0)
		{
			print("Room is empty. Cannot create a reservation. Admins, create a room first.");
			return;
		}

		print("======\nMake Reservation:\n======");
		print("Select a Room:");
		// View the list of available rooms to users
		Iterator<Room> itr = hs.getDB().getListOfRooms().iterator();
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
				itr = hs.getDB().getListOfRooms().iterator();
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
		if (hs.addReservation(user, rm, occupants, false, month, day, year, numberOfNights) != null)
			print("You have successfully added a reservation under " + user.getFullName() + "'s account");
		else
			print("Unfortunately, this date and room is already taken. Please try a different room or date.");
	}

	public static void print(Object o)
	{
		System.out.println(o);
	}
}
