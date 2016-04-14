/**
 * Database.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This class acts as a storage class for all of the information in the HotelSystem.
 * This class holds 3 lists: listOfRooms, listOfReservations, and a listOfUsers.
 * This class updates and maintains new information about the HotelSystem as customers arrive, book-in, check-out, and leave.
 */
import java.util.ArrayList;



public class Database {
	/**
	 * Class Variables
	 */
	private ArrayList<Room> listOfRooms;
	private ArrayList<Reservation> listOfReservations;
	private ArrayList<User> listOfUsers;

	/**
	 * Description: This is where an instance of a single database is created which will hold all the data.
	 * @author Matt Edwards
	 */
	public Database()
	{
		listOfRooms = new ArrayList<Room>();
		listOfReservations = new ArrayList<Reservation>();
		listOfUsers = new ArrayList<User>();
	}

	/* =======================================
	 * Setters and Getters
	 * =======================================
	 */
	public ArrayList<Room> getListOfRooms() {
		return listOfRooms;
	}

	public ArrayList<Reservation> getListOfReservations() {
		return listOfReservations;
	}

	public ArrayList<User> getListOfUsers() {
		return listOfUsers;
	}

}
