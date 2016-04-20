/**
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
	/**
	 * Class Variables
	 */
	private int numberOfReservations;
	private int numberOfSinglesReserved;
	private int numberOfDoublesReserved;
	private double occupancyRate;
	private double totalRevenue;

	/**
	 * Description: This generates a report for the given dates from '@param from' to '@param to'
	 * Only reservations that have a balance of 0 will be included in the report.
	 * Any reservation dates that fall in the given date will still be included in the Report.
	 * 
	 * @param hs
	 * @param from
	 * @param to
	 * @return Report
	 * @author Jc Briones
	 */
	public Report generateReportRange(HotelSystem hs, Date from, Date to)
	{
		// Reservation Lists between the given two dates but not including the check-out date (Calendar.ReservationByDateRange)
		ArrayList<Reservation> rsvps = new Calendar(hs).ReservationByDateRange(from, to);
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

			// Occupancy
			if (rsvps.get(i).isCheckedIn() || rsvps.get(i).isStayFinished())
					occupancyCount++;

			// Revenue
			if (rsvps.get(i).getBalance() == 0)
				totalRevenue += rsvps.get(i).getRoomCost() * rsvps.get(i).getNumberOfNights();
		}

		// Occupancy Rate
		occupancyRate = (occupancyCount / hs.getDB().getListOfRooms().size())*100;
		return this;
	}

	/**
	 * Description: This generates a report for all reservations done on the system.
	 * Only reservations that have a balance of 0 will be included in the report.
	 * 
	 * @param hs
	 * @return Report
	 * @author Jc Briones
	 */
	public Report generateReportAll(HotelSystem hs)
	{
		// Get all Reservations from the database
		ArrayList<Reservation> rsvps = hs.getDB().getListOfReservations();
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

			// Occupancy
			if (rsvps.get(i).isCheckedIn() || rsvps.get(i).isStayFinished())
					occupancyCount++;

			// Revenue
			if (rsvps.get(i).getBalance() == 0)
				totalRevenue += rsvps.get(i).getRoomCost() * rsvps.get(i).getNumberOfNights();
		}

		// Occupancy Rate
		occupancyRate = (occupancyCount / hs.getDB().getListOfRooms().size())*100;
		return this;
	}

	/**
	 * Description: This creates a String of the given values inside this class in
	 * a readable format.
	 * 
	 * @return String
	 * @author Pavan Vittala
	 */
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("== Management Report for All ==\n");
		str.append("Number of Reservations:\t" + numberOfReservations + "\n");
		str.append("Single Rooms Reserved:\t" + numberOfSinglesReserved + "\n");
		str.append("Double Rooms Reserved:\t" + numberOfDoublesReserved + "\n");
		str.append("Occupancy Rate:\t\t" + occupancyRate + "%\n");
		str.append("Total Revenue:\t\t" + totalRevenue + "\n");
		str.append("=============================\n");
		return str.toString();
	}

	/**
	 * Description: This creates a String of the given values inside this class in
	 * a readable format. Used for generatingReportByRange()
	 * 
	 * @param from
	 * @param to
	 * @return String
	 * @author Pavan Vittala
	 */
	public String toString(Date from, Date to)
	{
		StringBuilder str = new StringBuilder();
		str.append("Management Report (" + from.toString() + " to " + to.toString() +") ==\n");
		str.append("Number of Reservations:\t" + numberOfReservations + "\n");
		str.append("Single Rooms Reserved:\t" + numberOfSinglesReserved + "\n");
		str.append("Double Rooms Reserved:\t" + numberOfDoublesReserved + "\n");
		str.append("Occupancy Rate:\t\t" + occupancyRate + "%\n");
		str.append("Total Revenue:\t\t" + totalRevenue + "\n");
		str.append("=============================\n");
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
