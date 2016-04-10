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
			if(rsvps.get(i).isBookingCompleted())
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
			if(rsvps.get(i).isBookingCompleted())
				totalRevenue += rsvps.get(i).getRoomCost() * rsvps.get(i).getNumberOfNights();
		}

		// Occupancy Rate
		occupancyRate = (occupancyCount / HotelSystem.getDB().getListOfRooms().size())*100;
		return this;
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("== Management Report ==\n");
		str.append("Number of Reservations:\t" + numberOfReservations + "\n");
		str.append("Single Rooms Reserved:\t" + numberOfSinglesReserved + "\n");
		str.append("Double Rooms Reserved:\t" + numberOfDoublesReserved + "\n");
		str.append("Occupancy Rate:\t\t" + occupancyRate + "%\n");
		str.append("Total Revenue:\t\t" + totalRevenue + "\n");
		str.append("=======================\n");
		return str.toString();
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

}
