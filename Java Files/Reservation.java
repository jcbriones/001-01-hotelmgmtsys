/*
 * Reservation.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the Reservation class where good things happen. Just wait...
 */
public class Reservation
{
	private static int UNIQUE_ID = 0;

	private int rsvpID;
	private int reservedTo;
	private Room room;
	private int numberOfOccupants;
	private int month;
	private int day;
	private int year;
	private int numberOfDays;
	private int balance;
	private int roomCost;

	public Reservation(int customerID, Room room, int occupants, int m, int d, int y, int bal, int cost)
	{
		this.rsvpID = UNIQUE_ID++;
		this.reservedTo = customerID;
		this.room = room;
		this.numberOfOccupants = occupants;
		this.month = m;
		this.day = d;
		this.year = y;
		this.balance = bal;
		this.roomCost = cost;
	}

	//Should call ProcessPayment's validate Payment and send it
	//This reservation's CreditCard
	public boolean validatePayment()
	{
		return true;
	}

	// Setters and Getters
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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getRoomCost() {
		return roomCost;
	}
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}


}
