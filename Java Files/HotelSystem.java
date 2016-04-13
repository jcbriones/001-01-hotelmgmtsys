/*
 * HotelSystem.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the HotelSystem class which acts as the main class of the program.
 */
import java.util.ArrayList;
import java.util.Iterator;

//The central HotelSystem class that controls all of the Hotel's functionalities
public class HotelSystem {
	private static int UNIQUE_ID = 0;
	private int hotelID;
	private String hotelName;
	private Calendar cal;
	private Database db;

	public HotelSystem()
	{
		// Create an instance of hotel system. Has an ID just in case
		// the user wants to create more than 1 instance of a hotel.
		this.hotelID = UNIQUE_ID++;

		hotelName = null;
		db = new Database();
		cal = new Calendar(this);
	}

	/* =======================================
	 * List of Functions of a HotelSystem
	 * =======================================
	 */

	// Creates a room in the database
	public Room addRoom(int roomNumber, boolean isDouble, double price)
	{
		if(getRoom(roomNumber) != null)		
			return null;
		else
		{
			//Create a room with the desired specs
			Room rm = new Room(roomNumber, isDouble, price);
			//Add the instantiated room to the database
			db.getListOfRooms().add(rm);
			return rm;
		}
	}

	public Room getRoom(int roomNumber)
	{
		// Search the list using an Iterator
		Iterator<Room> itr = db.getListOfRooms().iterator();
		Room rm;
		while(itr.hasNext())
		{
			rm = itr.next();
			//You've found the room you're looking for
			if (rm.getRoomNumber() == roomNumber)
				return rm;
		}
		return null;
	}

	//Deletes a room from the database
	public boolean deleteRoom(Room rm)
	{
		//Directly call the ArrayList's remove function
		return db.getListOfRooms().remove(rm);
	}

	//Adding a reservation to the list of reservations in the datebase
	public Reservation addReservation(User reservedTo, Room rm, int numberOfOccupants, boolean guaranteed, int month, int day, int year, int numberOfNights)
	{
		ArrayList<Date> dates = new ArrayList<Date>();
		//Adding a list of dates that the customer will be using a given room
		for (int i = 0; i <= numberOfNights; i++)
			dates.add(new Date(month, day + i, year));
		//If the room is free on the given date
		if (cal.checkDate(rm,dates))
		{
			//Add the reservation to the list of reservations in the database
			Reservation rsvp = new Reservation(reservedTo, rm, numberOfOccupants, guaranteed, month, day, year, numberOfNights, rm.getPrice()*numberOfNights, rm.getPrice());
			db.getListOfReservations().add(rsvp);

			return rsvp;
		}
		else
			return null;
	}

	//Get a reservation from the database based on the reservation ID
	public Reservation getReservationByID(int reservationID)
	{
		for (int i = 0; i < db.getListOfReservations().size(); i++)
			//Only return the reservation if the IDs match
			if (db.getListOfReservations().get(i).getRsvpID() == reservationID)
				return db.getListOfReservations().get(i);

		return null;
	}

	//Get the reservation from the database based on customer ID
	public Reservation getReservationByCID(int customerID)
	{
		for (int i = 0; i < db.getListOfReservations().size(); i++)
			//Only return the reservation if the customer's ID matches with the one in the database
			if (db.getListOfReservations().get(i).getReservedTo().getUserID() == customerID)
				return db.getListOfReservations().get(i);

		return null;
	}

	//Get the reservation from the database
	//Getting all the reservations of a given user
	public ArrayList<Reservation> getReservations(User usr)
	{
		// Search the list
		Iterator<Reservation> itr = db.getListOfReservations().iterator();
		ArrayList<Reservation> rsvps = new ArrayList<Reservation>();
		Reservation rsvp;
		while(itr.hasNext())
		{
			rsvp = itr.next();
			//If the given user has reserved that reservation, then add it to the rsvps list
			if (rsvp.getReservedTo() == usr)
				rsvps.add(rsvp);
		}
		return rsvps;
	}

	//Deletes a given reservation from the database
	public boolean deleteReservation(Reservation rsvp)
	{
		return db.getListOfReservations().remove(rsvp);
	}

	//Add a user to the database
	public User addUser(String user, String pass, String name, int type, String address1, String address2, String city, String state, int zip) {
		// Check first if a username exist
		Iterator<User> itr = db.getListOfUsers().iterator();
		while (itr.hasNext())
			//Make sure the user is not already in the databse
			if (itr.next().getUsername().equals(user))
				return null;

		// Create the user if not found in the database
		User usr = new User(user,pass,name,type,address1,address2,city,state,zip);
		db.getListOfUsers().add(usr);
		return usr;
	}

	//Get a user from the database
	public User getUser(String username) {
		// Check if a User with username does exist
		for (int i = 0; i < db.getListOfUsers().size(); i++)
			//if the queried user is in the database, then a reference to that user will be returned
			if(db.getListOfUsers().get(i).getUsername().equals(username))
				return db.getListOfUsers().get(i);
		return null;
	}

	//Get the user based on the user's ID
	public User getUserByID(int customerID) {
		// Check if a User with username does exist
		for (int i = 0; i < db.getListOfUsers().size(); i++)
			//If a user with the requested customer ID is in the database, then a reference to that user will be returned,
			if(db.getListOfUsers().get(i).getUserID() == customerID)
				return db.getListOfUsers().get(i);
		return null;
	}

	//Get a user from the database based on his/ her name
	public User getUserByName(String name) {
		// Check if a User with username does exist
		for (int i = 0; i < db.getListOfUsers().size(); i++)
			//if the requested user's name matches a name of a user in the database, then a reference to that user will be returned
			if(db.getListOfUsers().get(i).getFullName().equals(name))
				return db.getListOfUsers().get(i);
		return null;
	}

	// Delete the specified User in the database.
	public boolean deleteUser(User usr)
	{
		if (db.getListOfUsers().remove(usr))
		{
			// TODO: Delete all reservations under that user.
			return true;
		}
		return false;
	}

	// Used for verifying logins and returning the User that matches the given user and pass
	public User loginUser(String username, String password)
	{
		User usr = getUser(username);
		return usr.getPassword().equals(password) ? usr : null;
	}

	//Add a credit card associated with a user to the database
	public CreditCard addCreditCard(User usr, String nameOnCard, String type, String cardNumber, int CCV, int expDateM, int expDateY, String billingAddress1, String billingAddress2, String billingCity, String billingState, int billingZip)
	{
		CreditCard cc = new CreditCard(nameOnCard,type,cardNumber,CCV,expDateM,expDateY,billingAddress1,billingAddress2,billingCity,billingState,billingZip);
		usr.getCreditCards().add(cc);
		usr.setDefaultCard(cc);
		return cc;
	}

	//Update credit card info with new information.
	public void updateCreditCard(CreditCard card, String nameOnCard, String type, String cardNumber, int CCV, int expDateM, int expDateY, String billingAddress1, String billingAddress2, String billingCity, String billingState, int billingZip)
	{
		card.setNameOnCard(nameOnCard);
		card.setType(type);
		card.setCardNumber(cardNumber);
		card.setCCV(CCV);
		card.setExpDateM(expDateM);
		card.setExpDateY(expDateY);
		card.setBillingAddress1(billingAddress1);
		card.setBillingAddress2(billingAddress2);
		card.setBillingCity(billingCity);
		card.setBillingState(billingState);
		card.setBillingZip(billingZip);
	}

	//Delete a user's credit card from the database
	public boolean deleteCreditCard(User usr, CreditCard card)
	{
		if (usr.getCreditCards().indexOf(card) >= 0)
		{
			usr.getCreditCards().remove(usr.getCreditCards().indexOf(card));
			if(usr.getDefaultCard() == card && usr.getCreditCards().size() != 0)
				usr.setDefaultCard(usr.getCreditCards().get(0));
			else
				usr.setDefaultCard(null);
			return true;
		}
		return false;
	}

	// Minimum rank to check for privilege
	public boolean checkPrivilege(User usr, int accountType)
	{
		return usr.getAccountType() >= accountType;
	}

	// Generate Report All
	public Report generateReportAll()
	{
		return new Report().generateReportAll(this);
	}

	// Generate Report Range
	public Report generateReportByRange(Date from, Date to)
	{
		return new Report().generateReportRange(this, from,to);
	}

	// Check-In Reservation
	public CheckIn checkInReservation(Reservation rsvp, Date date)
	{
		return new CheckIn(rsvp).checkIn(date);
	}

	// Check-Out Reservation
	public CheckOut checkOutReservation(Reservation rsvp, Date date)
	{
		return new CheckOut(rsvp).checkOut(date);
	}

	// Charge the User
	public boolean chargeUser(Reservation rsvp)
	{
		// Charge the remaining balance of the reservation, if payment doesn't go through then checking-in of user
		// is not successful. Credit Card is invalid. Otherwise, complete checking-in of user
		if (rsvp.validatePayment(rsvp.getBalance()))
		{
			rsvp.setBalance(0);
			rsvp.setGuaranteed(true);
			return true;
		}
		else
			return false;
	}

	//6 PM trigger code
	public ArrayList<Reservation> trigger6PM() {
		ArrayList<Reservation> tmp = new ArrayList<Reservation>();
		for (int i = 0; i < db.getListOfReservations().size(); i++)
			if (!db.getListOfReservations().get(i).isGuaranteed())
			{
				tmp.add(db.getListOfReservations().get(i));
				deleteReservation(db.getListOfReservations().get(i));
			}
		return tmp;
	}

	/* =======================================
	 * Setters and Getters
	 * =======================================
	 */
	public int getHotelID()
	{
		return hotelID;
	}

	public String getHotelName()
	{
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Database getDB() {
		return db;
	}

}
