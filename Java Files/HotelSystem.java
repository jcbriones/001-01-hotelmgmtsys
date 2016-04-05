import java.util.ArrayList;
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

	private int hotelID;
	private String hotelName;
	private ArrayList<Room> listOfRooms;
	private ArrayList<Reservation> listOfReservations;
	private ArrayList<Users> listOfUsers;
	
	private static Scanner keyboard = new Scanner(System.in);
	
	// HAVE MAIN CLASS TO IMMITRATE THE PROGRAM FOR NOW SINCE WE DON'T
	// HAVE THE FRAMEWORK YET
	public static void main(String[] args)
	{
		// ASK USER TO CREATE RESERVATION
		System.out.println("Would you like to create a new reservation");
		switch (keyboard.nextLine().toLowerCase())
		{
		case "yes":
		case "y":
			System.out.println("Alright then. Fill this one up!");
			MakeReservation();
			break;
		case "no":
		case "n":
			System.out.println("Then what do you want to do then?");
			PrintMenu();
			break;
		}
		
	}
	
	private static void PrintMenu() {
		System.out.println("Select one of the following:");
		System.out.println("\tcr: Create Reservation");
		System.out.println("\tur: Update Reservation");
		System.out.println("\tdr: Delete Reservation");
		switch(keyboard.nextLine())
		{
		case "cr":
			MakeReservation();
			break;
		}
	}

	private static Reservation MakeReservation()
	{
		Reservation rsvp = new Reservation();
		
		return rsvp;
	}

	
	
	// Setters and Getters
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
