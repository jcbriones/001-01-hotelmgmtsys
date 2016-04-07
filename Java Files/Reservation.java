import java.util.ArrayList;

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
	private Date date;
	private int numberOfNights;
	private double balance;
	private double roomCost;

	public Reservation(int customerID, Room room, int occupants, int m, int d, int y, int nod, double bal, double cost)
	{
		this.rsvpID = UNIQUE_ID++;
		this.reservedTo = customerID;
		this.room = room;
		this.numberOfOccupants = occupants;
		this.date = new Date(m,d,y);
		this.numberOfNights = nod;
		this.balance = bal;
		this.roomCost = cost;
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
	
	public int getMonth() {
		return date.getMonth();
	}

	public void setMonth(int month) {
		this.date.setMonth(month);
	}

	public int getDay() {
		return date.getDay();
	}

	public void setDay(int day) {
		this.date.setDay(day);
	}

	public int getYear() {
		return date.getYear();
	}

	public void setYear(int year) {
		this.date.setYear(year);
	}

	public Date getDate() {
		return date;
	}
	
	// TODO:
	public ArrayList<Date> getBookingDate() {
		return null;
	}
	
	public int getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}


}
