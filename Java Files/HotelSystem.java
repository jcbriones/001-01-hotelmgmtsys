/*
 * HotelSystem.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the HotelSystem class which acts as the main class of the program.
 */

import java.util.ArrayList;	// USE ARRAYLISTS FOR NOW
import java.util.Iterator;
import java.util.Scanner;

public class HotelSystem {
	private static int UNIQUE_ID = 0;
	private int hotelID;
	private String hotelName;
	private ArrayList<Room> listOfRooms;
	private ArrayList<Reservation> listOfReservations;
	private ArrayList<User> listOfUsers;
	private Calendar calendar;

	public HotelSystem()
	{
		// Create an instance of hotel system. Has an ID just in case
		// the user wants to create more than 1 instance of a hotel.
		this.hotelID = UNIQUE_ID++;
		
		hotelName = null;
		listOfRooms = new ArrayList<Room>();
		listOfReservations = new ArrayList<Reservation>();
		listOfUsers = new ArrayList<User>();
		calendar = new Calendar();
	}
	public Reservation makeReservation(int reservedTo, Room rm, int numberOfOccupants, int month, int day, int year, int numberOfDays)
	{
		Reservation rsvp;
		if (calendar.checkDate(rm,month,day,year) == null)
		{
			rsvp = new Reservation(reservedTo, rm, numberOfOccupants, month, day, year, numberOfDays, rm.getPrice()*numberOfDays, rm.getPrice()*numberOfDays);
			listOfReservations.add(rsvp);
		}
		return rsvp;
	}

	public Reservation lookReservation(User user)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void updateReservation(Reservation rsvp)
	{
		// TODO Auto-generated method stub
	}

	public void deleteReservation(Reservation rsvp)
	{
		// TODO Auto-generated method stub
	}

	public User createUser(String username, String password, String name, int accountType) {
		// Check first if a username exist
		Iterator<User> itr = listOfUsers.iterator();
		while (itr.hasNext())
			if (itr.next().getUsername().equals(username))
				return null;

		// Else, create the user and add it to the user list.
		User newUser = new User(username,password,name,accountType);
		listOfUsers.add(newUser);
		return newUser;
	}

	public User lookUser(String username) {
		// Check first if a username exist
		Iterator<User> itr = listOfUsers.iterator();
		User tmp;
		while (itr.hasNext())
		{
			tmp = itr.next();
			if (tmp.getUsername().equals(username))
				return tmp;
		}
		return null;
	}

	public User loginUser(String username, String password)
	{
		// Initialize Iterator for searching
		Iterator<User> users = listOfUsers.iterator();

		// Look for the User and check if password matches.
		// If yes, return the user.
		User tmp;
		while (users.hasNext())
		{
			tmp = users.next();
			if (tmp.getUsername().equals(username) && tmp.getPassword().equals(password))
				return tmp;
		}
		// Else, return null because no match found.
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

	public ArrayList<User> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(ArrayList<User> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}
}
