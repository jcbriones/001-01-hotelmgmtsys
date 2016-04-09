
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

		for (int i = 0; i < rsvps.size(); i++)
		{
			// Number of Reservations
			numberOfReservations++;

			// Single Or Double
			if (rsvps.get(i).getRoom().isDouble())
				numberOfDoublesReserved++;
			else
				numberOfSinglesReserved++;
		}

		int counter = 0;
		ArrayList<Room> rms = HotelSystem.getDB().getListOfRooms();
		for (int i = 0; i < rms.size(); i++)
			if (rms.get(i).isOccupied())
				counter++;

		occupancyRate = (counter / rms.size())*100;
		return this;
	}

	public Report generateReportAll()
	{
		ArrayList<Reservation> rsvps = HotelSystem.getDB().getListOfReservations();
		for (int i = 0; i < rsvps.size(); i++)
		{
			// Number of Reservations
			numberOfReservations++;

			// Single Or Double
			if (rsvps.get(i).getRoom().isDouble())
				numberOfDoublesReserved++;
			else
				numberOfSinglesReserved++;
		}

		int counter = 0;
		ArrayList<Room> rms = HotelSystem.getDB().getListOfRooms();
		for (int i = 0; i < rms.size(); i++)
			if (rms.get(i).isOccupied())
				counter++;

		occupancyRate = (counter / rms.size())*100;
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

}
