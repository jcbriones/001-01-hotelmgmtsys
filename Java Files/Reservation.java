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

	private ArrayList<Date> dates;
	private Room room;
	private User reservedTo;
	private int rsvpID;
	private int numberOfOccupants;
	private int numberOfNights;
	private double balance;
	private double roomCost;
	private boolean guaranteed;
	private boolean bookingCompleted;

	public Reservation(User user, Room room, int occupants, int m, int d, int y, int numberOfNights, double bal, double cost)
	{
		this.rsvpID = UNIQUE_ID++;
		this.reservedTo = user;
		this.room = room;
		this.numberOfOccupants = occupants;
		this.dates = new ArrayList<Date>();
		for(int i = 0; i <= numberOfNights; i++)
			dates.add(new Date(m, d + i, y));
		this.numberOfNights = numberOfNights;
		this.balance = bal;
		this.roomCost = cost;
		this.guaranteed = false;
		this.bookingCompleted = false;
	}

	//Should call ProcessPayment's validate Payment and send it
	//This reservation's CreditCard
	public boolean validatePayment(double amount)
	{
		return ProcessPayment.processPayment(reservedTo.getCreditCard(), amount);
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

	public User getReservedTo() {
		return reservedTo;
	}

	public void setReservedTo(User reservedTo) {
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

	public ArrayList<Date> getDates() {
		return dates;
	}

	public void setDates(ArrayList<Date> dates) {
		this.dates = dates;
	}

	public int getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(double roomCost) {
		this.roomCost = roomCost;
	}

	public boolean isGuaranteed() {
		return guaranteed;
	}

	public void setGuaranteed(boolean guaranteed) {
		this.guaranteed = guaranteed;
	}

	public boolean isBookingCompleted() {
		return bookingCompleted;
	}

	public void setBookingCompleted(boolean bookingCompleted) {
		this.bookingCompleted = bookingCompleted;
	}

}
