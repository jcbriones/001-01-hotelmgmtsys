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

	// Constructor
	public Database()
	{
		listOfRooms = new ArrayList<Room>();
		listOfReservations = new ArrayList<Reservation>();
		listOfUsers = new ArrayList<User>();
		calendar = new Calendar();
	}

	/* =======================================
	 * Setters and Getters
	 * =======================================
	 */
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

	public ArrayList<User> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(ArrayList<User> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}

}
