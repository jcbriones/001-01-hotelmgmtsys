import java.util.ArrayList;
import java.util.Date;

/*
 * Report.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the Report class which generate reports of the hotel system.
 */
public class Report {
	private int revenue;
	private int occupancy;
	
	public Report() {
		
	}
	
	ArrayList<Reservation> listOfReservations(HotelSystem hotel) {
		return hotel.getListOfReservations();
	}
	
	ArrayList<Room>listOfRooms(HotelSystem hotel) {
		return hotel.getListOfRooms();
	}
	
	/*
	ArrayList listOfPayments() {
		
	}
	*/
	
	ArrayList<Customer> listOfCustomers(HotelSystem hotel) {
		return hotel.getListOfCustomers();
	}
	
	int getRevenue(Date date) {
		
	}
	
	getOccupancy() {
		
	}
}
