/*
 * Reservation.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the Reservation class where good things happen. Just wait...
 */
import java.util.ArrayList;

public class Reservation
{
	private static int UNIQUE_ID = 0;

	private int rsvpID;
	private int reservedTo;
	private Room room;
	private int numberOfOccupants;
	private ArrayList<Date> dates;
	private int numberOfNights;
	private double balance;
	private double roomCost;
	private boolean guaranteed;
	private boolean bookingCompleted;

	public Reservation(int customerID, Room room, int occupants, int m, int d, int y, int numberOfNights, double bal, double cost, boolean guaranteed)
	{
		this.rsvpID = UNIQUE_ID++;
		this.reservedTo = customerID;
		this.room = room;
		this.numberOfOccupants = occupants;
		this.dates = new ArrayList<Date>();
		for(int i = 0; i <= numberOfNights; i++)
			dates.add(new Date(m, d + i, y));
		this.numberOfNights = numberOfNights;
		this.balance = bal;
		this.roomCost = cost;
		this.guaranteed;
		this.bookingCompleted = false;
	}

	//Should call ProcessPayment's validate Payment and send it
	//This reservation's CreditCard
	public boolean validatePayment()
	{
		return true;
	}

	/* =======================================
	 * Setters and Getters
	 * =======================================
	 */
	public int getRsvpID() {
		return rsvpID;
	}

	public void setRsvpID(int rsvpID) {
		this.rsvpID = rsvpID;
	}

	public int getReservedTo() {
		return reservedTo;
	}

	public void setReservedTo(int reservedTo) {
		this.reservedTo = reservedTo;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getNumberOfOccupants() {
		return numberOfOccupants;
	}

	public void setNumberOfOccupants(int numberOfOccupants) {
		this.numberOfOccupants = numberOfOccupants;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public double getRoomCost() {
		return roomCost;
	}

	public ArrayList<Date> getDates() {
		return dates;
	}

	public int getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	public boolean getGuaranteed() {
		return guaranteed;
	}

	public void setGuaranteed(boolean val) {
		this.guaranteed = val;
	}

	public boolean getBookingCompleted() {
		return bookingCompleted;
	}

	public void setBookingCompleted(boolean val) {
		this.bookingCompleted = val;
	}

}
