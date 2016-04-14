/**
 * Room.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * Room class that is created when a user makes a reservation. This instance is placed in the database whilst being associated with a user.
 * 2 types of rooms: single and double. This is denoted by the isDouble boolean.
 */

public class Room {
	/**
	 * Class Variables
	 */
	private int roomNumber;	//Unique room number. Between 1-10
	private boolean isOccupied;	//Boolean to keep track of whether or not a user is using the room
	private boolean isDouble;	//Boolean to keep track of the room type
	private double price;	//The price of the room

	/**
	 * Constructor
	 * @param roomNumber
	 * @param isDouble
	 * @param price
	 * @author Jc Briones
	 */
	public Room(int roomNumber, boolean isDouble, double price){
		this.roomNumber = roomNumber;
		this.isOccupied = false;
		this.isDouble = isDouble;
		this.price = price;
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("== Room Details ==\n");
		str.append("Room Number:\t" + roomNumber + "\n");
		str.append("Is Occupied?:\t" + isOccupied + "\n");
		str.append("Is Double?:\t" + isDouble + "\n");
		str.append("Price/Night:\t" + price + "\n");
		str.append("==================\n");
		return str.toString();
	}
	
	/* =======================================
	 * Setters and Getters
	 * =======================================
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	public boolean setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
		return true;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public boolean isDouble() {
		return isDouble;
	}

	public void setDouble(boolean isDouble) {
		this.isDouble = isDouble;
	}

	public double getPrice() {
		return price;
	}

}


