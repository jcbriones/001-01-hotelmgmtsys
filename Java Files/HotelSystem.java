import java.util.ArrayList;	// USE ARRAYLISTS FOR NOW
import java.util.Iterator;
import java.util.Scanner;

/*
 * HotelSystem.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the HotelSystem class which acts as the main class of the program.
 */
public class HotelSystem {
	private static int UNIQUE_ID = 0;
	private int hotelID;
	private String hotelName;
	private ArrayList<Room> listOfRooms;
	private ArrayList<Reservation> listOfReservations;
	private ArrayList<Users> listOfUsers;
	private static Calendar calendar = new Calendar();

	private Scanner keyboard = new Scanner(System.in);

	public HotelSystem()
	{
		// Create an instance of hotel system. Has an ID just in case
		// the user wants to create more than 1 instance of a hotel.
		this.hotelID = UNIQUE_ID++;
	}
	public Reservation makeReservation(Users userID)
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
			System.out.println("Room ID: " + rm.getRoomID());
			System.out.println("Price: " + rm.getRoomCost());
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
			rsvp = Reservation(userID, rm, occupants, date, rm.getRoomCost(), rm.getRoomCost());
			listOfReservations.add(rsvp);
			System.out.println("You have successfully added a reservation under " + userID.getName() + "'s account");
		}
		else
			System.out.println("Unfortunately, this date and room is already taken. Please try a different room or date.");
		return rsvp;
	}

	public Reservation lookReservation(Users user)
	{
		return null;
	}

	public void updateReservation(Reservation rsvp)
	{

	}

	public void deleteReservation(Reservation rsvp)
	{

	}

	public void createUser() {
		// TODO Auto-generated method stub

	}

	public void lookUser() {
		// TODO Auto-generated method stub

	}

	public Users loginWindow()
	{
		Iterator<Users> users = listOfUsers.iterator();
		System.out.println("======\nLogin Window\n======");
		System.out.println("Enter the username:");
		String user = keyboard.nextLine();
		System.out.println("Enter the user's password");
		String pass = keyboard.nextLine();
		// Look for the User and check if password matches.
		// If yes, return the user.
		Users tmp;
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

	// Setters and Getters
	public int getHotelID() {
		return hotelID;
	}
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public ArrayList<Room> getListOfRooms() {
		return listOfRooms;
	}

	public void setListOfRooms(ArrayList<Room> listOfRooms) {
		this.listOfRooms = listOfRooms;
	}

	public ArrayList<Reservation> getListOfReservations() {
		return listOfReservations;
	}

	public void setListOfReservations(ArrayList<Reservation> listOfReservations) {
		this.listOfReservations = listOfReservations;
	}

	public ArrayList<Users> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(ArrayList<Users> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}
}
