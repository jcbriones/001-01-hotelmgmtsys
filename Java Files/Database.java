/*
 * Database.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the HotelSystem's database where all the data is stored.
 */

import java.util.ArrayList;

public class Database {
	private ArrayList<Room> listOfRooms;
	private ArrayList<Reservation> listOfReservations;
	private ArrayList<User> listOfUsers;
	private ArrayList<Date> listOfBookedDates;

	// Constructor
	public Database()
	{
		listOfRooms = new ArrayList<Room>();
		listOfReservations = new ArrayList<Reservation>();
		listOfUsers = new ArrayList<User>();
		listOfBookedDates = new ArrayList<Date>();
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
	
	public ArrayList<Date> getListOfBookedDates() {
		return listOfBookedDates;
	}

}
