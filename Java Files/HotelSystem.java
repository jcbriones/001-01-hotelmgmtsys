import java.util.ArrayList;
import java.util.Iterator;

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
	private Database db;
	private Calendar cal;

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
	public Room createRoom(int roomNumber, boolean isDouble, double price)
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
	public Reservation addReservation(int reservedTo, Room rm, int numberOfOccupants, int month, int day, int year, int numberOfDays)
	{
		Reservation rsvp;
		if (cal.checkDate(rm,month,day,year))
		{
			rsvp = new Reservation(reservedTo, rm, numberOfOccupants, month, day, year, numberOfDays, rm.getPrice()*numberOfDays, rm.getPrice()*numberOfDays);
			db.getListOfReservations().add(rsvp);
			return rsvp;
		}
		else
			return null;
	}

	public Reservation getReservation(int userID)
	{
		// Search the list
		Iterator<Reservation> itr = db.getListOfReservations().iterator();
		Reservation rsvp;
		while(itr.hasNext())
		{
			rsvp = itr.next();
			if (rsvp.getReservedTo() == userID)
				return rsvp;
		}
		return null;
	}
	
	public ArrayList<Reservation> getReservations(int userID)
	{
		// Search the list
		Iterator<Reservation> itr = db.getListOfReservations().iterator();
		ArrayList<Reservation> rsvps = new ArrayList<Reservation>();
		Reservation rsvp;
		while(itr.hasNext())
		{
			rsvp = itr.next();
			if (rsvp.getReservedTo() == userID)
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
			if (tmp.getUsername().equals(username))
				return tmp;
		}
		return null;
	}

	public boolean deleteUser(User usr)
	{
		if (db.getListOfUsers().remove(usr))
		{
			// TODO: Delete all reservations under that user.
			return true;
		}
		return false;
	}


	// Used for verifying logins
	public User loginUser(String username, String password)
	{
		User usr = getUser(username);
		return usr.getPassword().equals(password) ? usr : null;
	}

	// Minimum rank to check for priviledge
	public boolean checkPriviledge(User usr, int accountType) {
		return usr.getAccountType() >= accountType;
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

	public Database getDB() {
		return db;
	}
}
