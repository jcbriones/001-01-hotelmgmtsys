import java.util.ArrayList;

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
	/*
	 * Don't know the return type of these methods.
	 * That still needs to be determined.
	 */
	
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
	
	getRevenue() {
		
	}
	
	getOccupancy() {
		
	}
}
