/**
 * HotelSystem.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the HotelSystem class which acts as the central class of the program that controls all of the
 * Hotel's functionalities/
 */
import java.util.ArrayList;
import java.util.Iterator;

//The central HotelSystem class that controls all of the Hotel's functionalities
public class HotelSystem {
	/**
	 * Class Variables
	 */
	private static int UNIQUE_ID = 0;
	private int hotelID;
	private String hotelName;
	private Calendar cal;
	private Database db;
	private Date currentDate = new Date(1,1,1970);

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

	/**
	 * Description: Creates a room inside the database.
	 * 
	 * @param roomNumber
	 * @param isDouble
	 * @param price
	 * @return Room
	 * @author Matt Edwards
	 */
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

	/**
	 * Description: Returns the room with the room number equals to '@param roomNumber'.
	 * 
	 * @param roomNumber
	 * @return Room
	 * @author Matt Edwards
	 */
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

	/**
	 * Description: It returns a boolean if a room was successfully deleted or not.
	 * 
	 * @param rm
	 * @return boolean
	 * @author Matt Edwards
	 */
	public boolean deleteRoom(Room rm)
	{
		//Directly call the ArrayList's remove function
		return db.getListOfRooms().remove(rm);
	}

	/**
	 * Description: It returns a boolean if a room was successfully deleted or not.
	 * 
	 * @param rm
	 * @return boolean
	 * @author Ken Matsuda
	 */
	public boolean deleteRoom(int roomNumber)
	{
		for (int i = 0; i < db.getListOfRooms().size(); i++)
			if (roomNumber == db.getListOfRooms().get(i).getRoomNumber())
				return db.getListOfRooms().remove(db.getListOfRooms().get(i));

		return false;
	}

	/**
	 * Description: This adds a reservation to the database and returns the Reservation instance.
	 * Before adding a new reservation, it will check if that reservation doesn't have any
	 * conflicts on dates and room that is used. If successful, then it returns the generated
	 * reservation back.
	 * 
	 * @param reservedTo
	 * @param rm
	 * @param numberOfOccupants
	 * @param guaranteed
	 * @param month
	 * @param day
	 * @param year
	 * @param numberOfNights
	 * @return Reservation
	 * @author Jc Briones
	 */
	public Reservation addReservation(User reservedTo, Room rm, int numberOfOccupants, boolean guaranteed, int month, int day, int year, int numberOfNights)
	{
		ArrayList<Date> dates = new ArrayList<Date>();
		// Adding a list of dates that the customer will be using a given room
		for (int i = 0; i <= numberOfNights; i++)
			dates.add(new Date(month, day + i, year));
		// If the room is free on the given date and the current date is before the booking date. Cannot book rooms in the past.
		if (cal.checkDate(rm,dates) && currentDate.isBefore(dates.get(0)))
		{
			//Add the reservation to the list of reservations in the database
			Reservation rsvp = new Reservation(reservedTo, rm, numberOfOccupants, guaranteed, month, day, year, numberOfNights, rm.getPrice()*numberOfNights, rm.getPrice());
			db.getListOfReservations().add(rsvp);

			return rsvp;
		}
		else
			return null;
	}

	/**
	 * Description: Get a reservation from the database based on the reservation ID.
	 * 
	 * @param reservationID
	 * @return Reservation
	 * @author Jc Briones
	 */
	public Reservation getReservationByID(int reservationID)
	{
		for (int i = 0; i < db.getListOfReservations().size(); i++)
			//Only return the reservation if the IDs match
			if (db.getListOfReservations().get(i).getRsvpID() == reservationID)
				return db.getListOfReservations().get(i);

		return null;
	}

	/**
	 * Description: Get the reservation from the database based on customer ID.
	 * 
	 * @param customerID
	 * @return Reservation
	 * @author Jc Briones
	 */
	public Reservation getReservationByCID(int customerID)
	{
		for (int i = 0; i < db.getListOfReservations().size(); i++)
			//Only return the reservation if the customer's ID matches with the one in the database
			if (db.getListOfReservations().get(i).getReservedTo().getUserID() == customerID)
				return db.getListOfReservations().get(i);

		return null;
	}

	/**
	 * Description: Get the reservations from the database under a specific user
	 * @param usr
	 * @return ArrayList<Reservation>
	 * @author Jc Briones
	 */
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

	/**
	 * Description: Deletes a given reservation from the database
	 * 
	 * @param rsvp
	 * @return boolean
	 * @author Jc Briones
	 */
	public boolean deleteReservation(Reservation rsvp)
	{
		return db.getListOfReservations().remove(rsvp);
	}

	/**
	 * Description: Add a user to the database. It does check the database first if the user does not
	 * exist on the system. Otherwise, continue adding and return the User object.
	 * 
	 * @param user
	 * @param pass
	 * @param name
	 * @param type
	 * @param address1
	 * @param address2
	 * @param city
	 * @param state
	 * @param zip
	 * @return User
	 * @author Ken Matsuda
	 */
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

	/**
	 * Description: Get a user from the database.
	 * 
	 * @param username
	 * @return User
	 * @author Ken Matsuda
	 */
	public User getUser(String username) {
		// Check if a User with username does exist
		for (int i = 0; i < db.getListOfUsers().size(); i++)
			//if the queried user is in the database, then a reference to that user will be returned
			if(db.getListOfUsers().get(i).getUsername().equals(username))
				return db.getListOfUsers().get(i);
		return null;
	}

	/**
	 * Description: Get the user based on the user's ID.
	 * 
	 * @param customerID
	 * @return User
	 * @author Ken Matsuda
	 */
	public User getUserByID(int customerID) {
		// Check if a User with username does exist
		for (int i = 0; i < db.getListOfUsers().size(); i++)
			//If a user with the requested customer ID is in the database, then a reference to that user will be returned,
			if(db.getListOfUsers().get(i).getUserID() == customerID)
				return db.getListOfUsers().get(i);
		return null;
	}

	/**
	 * Description: Get a user from the database based on his/ her name.
	 * 
	 * @param name
	 * @return User
	 * @author Ken Matsuda
	 */
	public User getUserByName(String name) {
		// Check if a User with username does exist
		for (int i = 0; i < db.getListOfUsers().size(); i++)
			//if the requested user's name matches a name of a user in the database, then a reference to that user will be returned
			if(db.getListOfUsers().get(i).getFullName().equals(name))
				return db.getListOfUsers().get(i);
		return null;
	}

	/**
	 * Description: Delete the specified User in the database.
	 * 
	 * @param usr
	 * @return boolean
	 * @author Ken Matsuda
	 */
	public boolean deleteUser(User usr)
	{
		if (db.getListOfUsers().remove(usr))
		{
			ArrayList<Reservation> list = getReservations(usr);
			for (int i = 0; i < list.size(); i++)
				deleteReservation(list.get(i));
			return true;
		}
		return false;
	}

	/**
	 * Description: Add a credit card associated with a user to the database.
	 * 
	 * @param usr
	 * @param nameOnCard
	 * @param type
	 * @param cardNumber
	 * @param CCV
	 * @param expDateM
	 * @param expDateY
	 * @param billingAddress1
	 * @param billingAddress2
	 * @param billingCity
	 * @param billingState
	 * @param billingZip
	 * @return CreditCard
	 * @author Pavan Vittala
	 */
	public CreditCard addCreditCard(User usr, String nameOnCard, String type, String cardNumber, int CCV, int expDateM, int expDateY, String billingAddress1, String billingAddress2, String billingCity, String billingState, int billingZip)
	{
		// Expiration Date
		Date expDate = new Date(expDateM,expDateY);

		// If the added card is expired then it won't continue adding.
		if (expDate.isBefore(currentDate))
			return null;

		// Check first if the credit card exist and return that credit card
		for (int i = 0; i < usr.getCreditCards().size(); i++)
			if (usr.getCreditCards().get(i).getCardNumber() == cardNumber)
				return usr.getCreditCards().get(i);

		// If not, then continue with creating a card
		CreditCard cc = new CreditCard(nameOnCard,type,cardNumber,CCV,expDateM,expDateY,billingAddress1,billingAddress2,billingCity,billingState,billingZip);
		usr.getCreditCards().add(cc);
		usr.setDefaultCard(cc);
		return cc;
	}

	/**
	 * Description: Update credit card info with new information.
	 * 
	 * @param card
	 * @param nameOnCard
	 * @param type
	 * @param cardNumber
	 * @param CCV
	 * @param expDateM
	 * @param expDateY
	 * @param billingAddress1
	 * @param billingAddress2
	 * @param billingCity
	 * @param billingState
	 * @param billingZip
	 * @author Pavan Vittala
	 */
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

	/**
	 * Description: Delete a user's credit card from the database.
	 * 
	 * @param usr
	 * @param card
	 * @return boolean
	 * @author Pavan Vittala
	 */
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

	/**
	 * Description: Generate a report for all reservations with no balance left or fully paid
	 * 
	 * @return Report
	 * @author Pavan Vittala
	 */
	public Report generateReportAll()
	{
		return new Report().generateReportAll(this);
	}

	/**
	 * Description: Generate a report for a given range of dates for all reservations with no
	 * balance left or fully paid.
	 * 
	 * @param from
	 * @param to
	 * @return Report
	 * @author Pavan Vittala
	 */
	public Report generateReportByRange(Date from, Date to)
	{
		return new Report().generateReportRange(this, from,to);
	}

	/**
	 * Description: Checking in a reservation.
	 * 
	 * @param rsvp
	 * @param date
	 * @return CheckIn
	 * @author Matt Edwards
	 */
	public CheckIn checkInReservation(Reservation rsvp, Date date)
	{
		return new CheckIn(rsvp).checkIn(date);
	}

	/**
	 * Description: Checking out a reservation.
	 * 
	 * @param rsvp
	 * @param date
	 * @return CheckOut
	 * @author Matt Edwards
	 */
	public CheckOut checkOutReservation(Reservation rsvp, Date date)
	{
		return new CheckOut(rsvp).checkOut(date);
	}

	/**
	 * Description: Used for verifying logins and returning the User that matches the given user and pass.
	 * 
	 * @param username
	 * @param password
	 * @return User
	 * @author Jc Briones
	 */
	public User loginUser(String username, String password)
	{
		User usr = getUser(username);
		return usr.getPassword().equals(password) ? usr : null;
	}

	/**
	 * Description: Minimum rank to check for privilege
	 * 
	 * @param usr
	 * @param accountType
	 * @return boolean
	 * @author Jc Briones
	 */
	public boolean checkPrivilege(User usr, int accountType)
	{
		return usr.getAccountType() >= accountType;
	}

	/**
	 * Description: Charge the User. It returns whether if the user was successfully charged or not
	 * 
	 * @param rsvp
	 * @return boolean
	 * @author Jc Briones
	 */
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

	/**
	 * Description: This will trigger the 6PM time which will get all the list of users that
	 * are not guaranteed.
	 * 
	 * @return ArrayList<Reservation>
	 * @author Jc Briones
	 */
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

	public Calendar getCalendar() {
		return cal;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

}
