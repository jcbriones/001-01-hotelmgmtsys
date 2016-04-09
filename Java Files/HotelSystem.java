/*
 * HotelSystem.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the HotelSystem class which acts as the main class of the program.
 */
import java.util.ArrayList;
import java.util.Iterator;

public class HotelSystem {
	private static int UNIQUE_ID = 0;
	private int hotelID;
	private String hotelName;
	private Calendar cal;
	private static Database db;

	public HotelSystem()
	{
		// Create an instance of hotel system. Has an ID just in case
		// the user wants to create more than 1 instance of a hotel.
		this.hotelID = UNIQUE_ID++;

		hotelName = null;
		db = new Database();
		cal = new Calendar();
	}

	/* =======================================
	 * List of Functions of a HotelSystem
	 * =======================================
	 */

	// Rooms
	public Room addRoom(int roomNumber, boolean isDouble, double price)
	{
		if(getRoom(roomNumber) != null)
			return null;
		else
		{
			Room rm = new Room(roomNumber, isDouble, price);
			db.getListOfRooms().add(rm);
			return rm;
		}
	}

	public Room getRoom(int roomNumber)
	{
		// Search the list
		Iterator<Room> itr = db.getListOfRooms().iterator();
		Room rm;
		while(itr.hasNext())
		{
			rm = itr.next();
			if (rm.getRoomNumber() == roomNumber)
				return rm;
		}
		return null;
	}

	public boolean deleteRoom(Room rm)
	{
		return db.getListOfRooms().remove(rm);
	}

	// Reservations
	public Reservation addReservation(User reservedTo, Room rm, int numberOfOccupants, int month, int day, int year, int numberOfNights)
	{
		ArrayList<Date> dates = new ArrayList<Date>();
		for (int i = 0; i <= numberOfNights; i++)
			dates.add(new Date(month, day + i, year));
		if (cal.checkDate(rm,dates))
		{
			Reservation rsvp = new Reservation(reservedTo, rm, numberOfOccupants, month, day, year, numberOfNights, rm.getPrice()*numberOfNights, rm.getPrice());
			db.getListOfReservations().add(rsvp);

			return rsvp;
		}
		else
			return null;
	}

	public Reservation getReservation(User usr)
	{
		// Search the list
		Iterator<Reservation> itr = db.getListOfReservations().iterator();
		Reservation rsvp;
		while(itr.hasNext())
		{
			rsvp = itr.next();
			if (rsvp.getReservedTo() == usr)
				return rsvp;
		}
		return null;
	}

	public ArrayList<Reservation> getReservations(User usr)
	{
		// Search the list
		Iterator<Reservation> itr = db.getListOfReservations().iterator();
		ArrayList<Reservation> rsvps = new ArrayList<Reservation>();
		Reservation rsvp;
		while(itr.hasNext())
		{
			rsvp = itr.next();
			if (rsvp.getReservedTo() == usr)
				rsvps.add(rsvp);
		}
		return rsvps;
	}

	public boolean deleteReservation(Reservation rsvp)
	{
		return db.getListOfReservations().remove(rsvp);
	}

	// Users
	public User addUser(String username, String password, String name, int accountType) {
		// Check first if a username exist
		Iterator<User> itr = db.getListOfUsers().iterator();
		while (itr.hasNext())
			if (itr.next().getUsername().equals(username))
				return null;

		// Create the user if not found
		User usr = new User(username,password,name,accountType);
		db.getListOfUsers().add(usr);
		return usr;
	}

	public User getUser(String username) {
		// Check if a User with username does exist
		Iterator<User> itr = db.getListOfUsers().iterator();
		User tmp;
		while (itr.hasNext())
		{
			tmp = itr.next();
			// If found return that user
			if (tmp.getUsername().equals(username))
				return tmp;
		}
		return null;
	}

	// Delete the specified User in the database.
	public boolean deleteUser(User usr)
	{
		if (db.getListOfUsers().remove(usr))
		{
			// TODO: Delete all reservations under that user.
			return true;
		}
		return false;
	}


	// Used for verifying logins and returning the User that matches the given user and pass
	public User loginUser(String username, String password)
	{
		User usr = getUser(username);
		return usr.getPassword().equals(password) ? usr : null;
	}

	// Minimum rank to check for priviledge
	public boolean checkPriviledge(User usr, int accountType)
	{
		return usr.getAccountType() >= accountType;
	}
	
	// Generate Report All
	public Report generateReportAll()
	{
		return new Report().generateReportAll();
	}
	
	// Generate Report Range
	public Report generateReportRange(Date from, Date to)
	{
		return new Report().generateReportRange(from,to);
	}

	/* =======================================
	 * Setters and Getters
	 * =======================================
	 */
	public int getHotelID()
	{
		return hotelID;
	}

	public String getHotelName()
	{
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public static Database getDB() {
		return db;
	}
}
