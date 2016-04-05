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
    private int ReservedToCustomerID;
    private int RoomNumber;
    private int NumberOfOccupants;
    private Date ArrivalDate;
    private Date DepartureDate;
    private int Balance;
    private int RoomCost;

    public Reservation(int ReservedToCustomerID, int RoomNumber,
                       int NumberOfOccupants, Date ArrivalDate,
                       Date DepartureDate, int Balance, int RoomCost)
    {
        this.ReservedToCustomer = ReservedToCustomer;
        this.RoomNumber = RoomNumber;
        this.NumberOfOccupants = NumberOfOccupants;
        this.ArrivalDate = ArrivalDate;
        this.DepartureDate = DepartureDate;
        this.Balance = Balance;
        this.RoomCost = RoomCost;
    }

    public int getReservedToCustomerID() {
        return ReservedToCustomerID;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public int getNumberOfOccupants() {
        return NumberOfOccupants;
    }

    public Date getArrivalDate() {
        return ArrivalDate;
    }

    public Date getDepartureDate() {
        return DepartureDate;
    }

    public int getBalance() {
        return Balance;
    }

    public int getRoomCost() {
        return RoomCost;
    }

    public void setReservedToCustomerID(int reservedToCustomerID) {
        ReservedToCustomerID = reservedToCustomerID;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public void setNumberOfOccupants(int numberOfOccupants) {
        NumberOfOccupants = numberOfOccupants;
    }

    public void setArrivalDate(Date arrivalDate) {
        ArrivalDate = arrivalDate;
    }

    public void setDepartureDate(Date departureDate) {
        DepartureDate = departureDate;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public void setRoomCost(int roomCost) {
        RoomCost = roomCost;
    }

    //Should call ProcessPayment's validate Payment and send it
    //This reservation's CreditCard
    public boolean validatePayment()
    {
        return true;
    }
}
