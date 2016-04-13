/*
 * Room.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the Room class which holds the data of a Room instance.
 */

//Room class that is created when a user makes a reservation. This instance is placed in the database whilst being associated with a user.
//2 types of rooms: single and double. This is denoted by the isDouble boolean.
public class Room {
	// Instance Variables
	private int roomNumber;
	private boolean isOccupied;
	private boolean isDouble;
	private double price;

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


