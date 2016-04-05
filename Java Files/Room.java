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
    private int roomNumber;
    private boolean isOccupied;
    private boolean isDouble;
    private double price;

    public Room(int roomNumber, boolean isOccupied, boolean isDouble){
        this.roomNumber=roomNumber;
        this.isOccupied=isOccupied;
        this.isDouble=isDouble;
    }
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isDouble() {
        return isDouble;
    }

    public void setDouble(boolean aDouble) {
        isDouble = aDouble;
        if(this.aDouble){
            setPrice(120.00);
        }
        else{
            setPrice(70.00);
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    void setOccupancy(boolean occ){
        if(occ)
            setOccupied(true);
        else
            setOccupied(false);
    }
}


