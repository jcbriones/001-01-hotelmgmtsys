/*
 * Room.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the Room class which holds the data of a Room instance.
 */

public class Room {
	// Instance Variables
	private int roomNumber;
	private boolean isOccupied;
	private boolean isDouble;
	private double price;

	public Room(int roomNumber, boolean isOccupied, boolean isDouble){
		this.roomNumber=roomNumber;
		this.isOccupied=isOccupied;
		this.isDouble=isDouble;
	}

	// Setters and getters

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		// TODO: Need to update this where the value should be unique
		this.roomNumber = roomNumber;
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

	public void setPrice(double price) throws Exception {
		// Cannot be negative
		if (price < 0)
			throw new Exception("Cannot be negative");
		this.price = price;
	}

}


