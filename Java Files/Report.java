
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
	private int numebrOfReservations;
	private int numberOfSinglesReserved;
	private int numberOfDoublesReserved;
	private int occupancyRate;
	private int totalRevenue;
	
	public Report(int reservations, int singles, int doubles, int occupancy, int revenue) {
		this.numebrOfReservations = reservations;
		this.numberOfSinglesReserved = singles;
		this.numberOfDoublesReserved = doubles;
		this.occupancyRate = occupancy;
		this.totalRevenue = revenue;
	}
	
	public Report createReport(Date first, Date second) {
		Calendar cal = new Calendar();
		double revenue = cal.RevinueByPeriod(first, second);
		int occupancy = cal.TotalOcucpancy();
	}
}
