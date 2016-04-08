
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
import java.util.Iterator;

public class Report {
	private int numberOfReservations;
	private int numberOfSinglesReserved;
	private int numberOfDoublesReserved;
	private int occupancyRate;
	private double totalRevenue;
	
	public Report(int reservations, int singles, int doubles, int occupancy, double revenue) {
		this.numberOfReservations = reservations;
		this.numberOfSinglesReserved = singles;
		this.numberOfDoublesReserved = doubles;
		this.occupancyRate = occupancy;
		this.totalRevenue = revenue;
	}
	
	public void generateReport(Date first, Date second) {
		Calendar cal = new Calendar();
		double revenue = cal.RevenueRange(first, second);
		int occupancy = cal.TotalOcucpancy();
		int numReservations = HotelSystem.getDB().getListOfReservations().size();
		ArrayList<Room> list = HotelSystem.getDB().getListOfRooms();
		Iterator<Room> iter = list.iterator();
		int numDoubles = 0;
		int numSingles = 0;
		Room room;
		while (iter.hasNext()) {
			room = iter.next();
			if (room.isDouble()) {
				numDoubles++;
			} else {
				numSingles++;
			}
		}
		occupancy = (occupancy/10)*100;
	}
}
