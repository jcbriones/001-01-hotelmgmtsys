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
	private boolean stayFinished;
	private boolean checkedIn;

	public Reservation(User user, Room room, int occupants, boolean guaranteed, int m, int d, int y, int numberOfNights, double bal, double cost)
	{
		this.rsvpID = UNIQUE_ID++;
		this.reservedTo = user;
		this.room = room;
		this.numberOfOccupants = occupants;
		this.dates = new ArrayList<Date>();
		this.guaranteed = guaranteed;
		for(int i = 0; i <= numberOfNights; i++)
			dates.add(new Date(m, d + i, y));
		this.numberOfNights = numberOfNights;
		this.balance = bal;
		this.roomCost = cost;
		this.stayFinished = false;
		this.checkedIn = false;
	}

	// Should call ProcessPayment's validate Payment and send it
	// This reservation's CreditCard
	public boolean validatePayment(double amount)
	{
		return ProcessPayment.processPayment(reservedTo.getDefaultCard(), amount);
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("======== Reservation ID: " + rsvpID + " ========\n");
		str.append("Reserved to:\t\t" + reservedTo.getFullName() + "\n");
		str.append("Room:\t\t\t" + room.getRoomNumber() + "\n");
		str.append("Number of Occupants:\t" + numberOfOccupants + "\n");
		str.append("Guaranteed?:\t\t" + guaranteed + "\n");
		str.append("Completed?:\t\t" + stayFinished + "\n");
		str.append("Checked-In?:\t\t" + checkedIn + "\n");
		str.append("Booked on the following dates:\n");
		for (int i = 0; i < dates.size(); i++)
			str.append("\t" + dates.get(i).toString() + "\n");
		str.append("Number of Nights:\t" + numberOfNights + "\n");
		str.append("Balance:\t\t" + balance + "\n");
		str.append("Room Cost/Night:\t" + roomCost + "\n");
		str.append("Total Room Cost:\t" + roomCost * numberOfNights + "\n");
		str.append("====================================\n");
		return str.toString();
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

	public boolean isStayFinished() {
		return stayFinished;
	}

	public void setStayFinished(boolean stayFinished) {
		this.stayFinished = stayFinished;
	}

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

}
