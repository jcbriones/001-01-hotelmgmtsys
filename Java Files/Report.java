
/*
 * Report.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the Report class which generate reports of the hotel system.
 */
import java.util.ArrayList;

public class Report {
	private int numberOfReservations;
	private int numberOfSinglesReserved;
	private int numberOfDoublesReserved;
	private double occupancyRate;
	private double totalRevenue;

	public Report generateReportRange(Date first, Date second)
	{
		// Reservation Lists on the given two dates
		ArrayList<Reservation> rsvps = new Calendar().ReservationByDateRange(first, second);
		ArrayList<Room> rms = new ArrayList<Room>();
		double occupancyCount = 0;
		for (int i = 0; i < rsvps.size(); i++)
		{
			// Number of Reservations
			numberOfReservations++;

			// Single Or Double
			if (rsvps.get(i).getRoom().isDouble())
				numberOfDoublesReserved++;
			else
				numberOfSinglesReserved++;

			// Occupancy Counter
			if (!rms.contains(rsvps.get(i).getRoom()))
			{
				rms.add(rsvps.get(i).getRoom());
				occupancyCount++;
			}

			// Revenue
			totalRevenue += rsvps.get(i).getRoomCost() * rsvps.get(i).getNumberOfNights();
		}

		// Occupancy Rate
		occupancyRate = (occupancyCount / HotelSystem.getDB().getListOfRooms().size())*100;
		return this;
	}

	public Report generateReportAll()
	{
		// Get all Reservations from the database
		ArrayList<Reservation> rsvps = HotelSystem.getDB().getListOfReservations();
		ArrayList<Room> rms = new ArrayList<Room>();
		double occupancyCount = 0;
		for (int i = 0; i < rsvps.size(); i++)
		{
			// Number of Reservations
			numberOfReservations++;

			// Single Or Double
			if (rsvps.get(i).getRoom().isDouble())
				numberOfDoublesReserved++;
			else
				numberOfSinglesReserved++;

			// Occupancy Counter
			if (!rms.contains(rsvps.get(i).getRoom()))
			{
				rms.add(rsvps.get(i).getRoom());
				occupancyCount++;
			}

			// Revenue
			totalRevenue += rsvps.get(i).getRoomCost() * rsvps.get(i).getNumberOfNights();
		}

		// Occupancy Rate
		occupancyRate = (occupancyCount / HotelSystem.getDB().getListOfRooms().size())*100;
		return this;
	}

	/* =======================================
	 * Setters and Getters
	 * =======================================
	 */

	public int getNumberOfReservations() {
		return numberOfReservations;
	}

	public int getNumberOfSinglesReserved() {
		return numberOfSinglesReserved;
	}

	public int getNumberOfDoublesReserved() {
		return numberOfDoublesReserved;
	}

	public double getOccupancyRate() {
		return occupancyRate;
	}

	public double getTotalRevenue() {
		return totalRevenue;
	}

	// ONLY FOR TESTING
	public static void main(String[] args) {
		Date date1 = new Date(3, 12, 2016);
		Date date2 = new Date(3, 13, 2016);

		HotelSystem hs = new HotelSystem();
		print(hs.addRoom(101, false, 100.50));
		print(hs.addRoom(102, false, 213.20));
		print(hs.addRoom(103, true, 163.50));
		print(hs.addUser("user1", "pass", "Full Name User 1", 0));
		print(hs.addUser("user2", "pass", "Full Name User 2", 0));
		print(hs.addReservation(HotelSystem.getDB().getListOfUsers().get(0), HotelSystem.getDB().getListOfRooms().get(0), 2, 3, 13, 2016, 3));
		//print(hs.addReservation(HotelSystem.getDB().getListOfUsers().get(0), HotelSystem.getDB().getListOfRooms().get(2), 2, 3, 13, 2016, 3));
		print(hs.addReservation(HotelSystem.getDB().getListOfUsers().get(1), HotelSystem.getDB().getListOfRooms().get(0), 2, 3, 17, 2016, 3));
		//print(hs.addReservation(HotelSystem.getDB().getListOfUsers().get(1), HotelSystem.getDB().getListOfRooms().get(1), 2, 3, 17, 2016, 3));

		Report rp = hs.generateReportAll();

		print("");
		print("Management Report for All:");
		print("Number of Reservations: " + rp.getNumberOfReservations());
		print("Single Rooms Reserved: " + rp.getNumberOfSinglesReserved());
		print("Double Rooms Reserved: " + rp.getNumberOfDoublesReserved());
		print("Occupany Rate: " + rp.getOccupancyRate());
		print("Total Revenue: " + rp.getTotalRevenue());

		Report rp2 = hs.generateReportRange(date1,date2);

		print("");
		print("Management Report for " + date1.toString() + " to " + date2.toString() + " :");
		print("Number of Reservations: " + rp2.getNumberOfReservations());
		print("Single Rooms Reserved: " + rp2.getNumberOfSinglesReserved());
		print("Double Rooms Reserved: " + rp2.getNumberOfDoublesReserved());
		print("Occupany Rate: " + rp2.getOccupancyRate());
		print("Total Revenue: " + rp2.getTotalRevenue());
	}
	public static void print(Object o)
	{
		System.out.println(o);
	}
}
