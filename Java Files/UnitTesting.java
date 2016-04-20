import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.*;

public class UnitTesting {

	/**
	 * We have to test first for making a User, CreditCard, Date, and Room that will be used for making a reservation.
	 */
	@Test
	public void Users_Constructor() {
		String username = "user";
		String password = "pass";
		String fullName = "George Mason";
		String address1 = "4400 University Dr";
		String address2 = "";
		String city = "Fairfax";
		String state = "VA";
		int zip = 22030;
		int accountType = 0;

		// Catch any Exception caused by testing the program
		try {
			// Set-up a constructor
			User usr = new User(username, password, fullName, accountType, address1, address2, city, state, zip);

			// Assert post condition is true
			assertEquals(username, usr.getUsername());
			assertEquals(password, usr.getPassword());
			assertEquals(fullName, usr.getFullName());
			assertEquals(accountType, usr.getAccountType());
			assertEquals(address1, usr.getAddress1());
			assertEquals(address2, usr.getAddress2());
			assertEquals(city, usr.getCity());
			assertEquals(state, usr.getState());
			assertEquals(zip, usr.getZip());
		}
		catch (Exception e)
		{
			fail("Create an instance of User failed." + e.toString());
		}

	}

	@Test
	public void CreditCard_Constructor1() {
		String nameOnCard = "George Mason";
		String type = "Visa";
		String cardNumber = "1234123412341234";
		int CCV = 123;
		int expDateM = 1;
		int expDateY = 2016;
		String billingAddress1 = "4400 University Dr";
		String billingAddress2 = "";
		String billingCity = "Fairfax";
		String billingState = "VA";
		int billingZip = 22030;

		// Catch any Exception caused by testing the program
		try {
			// Set-up a constructor
			CreditCard cc = new CreditCard(nameOnCard, type, cardNumber, CCV, expDateM, expDateY, billingAddress1, billingAddress2, billingCity, billingState, billingZip);

			// Assert post condition is true
			assertEquals(nameOnCard, cc.getNameOnCard());
			assertEquals(type, cc.getType());
			assertEquals(cardNumber, cc.getCardNumber());
			assertEquals(CCV, cc.getCCV());
			assertEquals(expDateM, cc.getExpDateM());
			assertEquals(expDateY, cc.getExpDateY());
			assertEquals(billingAddress1, cc.getBillingAddress1());
			assertEquals(billingAddress2, cc.getBillingAddress2());
			assertEquals(billingCity, cc.getBillingCity());
			assertEquals(billingState, cc.getBillingState());
			assertEquals(billingZip, cc.getBillingZip());
		}
		catch (Exception e)
		{
			fail("Create an instance of User failed. " + e.toString());
		}
	}

	@Test
	public void CreditCard_Constructor2() {
		boolean thrown = false;

		String nameOnCard = "George Mason";
		String type = "Visa";
		String cardNumber = "1234123412341234";
		int CCV = 123;
		int expDateM = 0;
		int expDateY = 2016;
		String billingAddress1 = "4400 University Dr";
		String billingAddress2 = "";
		String billingCity = "Fairfax";
		String billingState = "VA";
		int billingZip = 22030;

		// Catch any Exception caused by testing the program
		try {
			// Set-up a constructor
			CreditCard cc = new CreditCard(nameOnCard, type, cardNumber, CCV, expDateM, expDateY, billingAddress1, billingAddress2, billingCity, billingState, billingZip);

			// Assert post condition is true
			assertEquals(nameOnCard, cc.getNameOnCard());
			assertEquals(type, cc.getType());
			assertEquals(cardNumber, cc.getCardNumber());
			assertEquals(CCV, cc.getCCV());
			assertEquals(expDateM, cc.getExpDateM());
			assertEquals(expDateY, cc.getExpDateY());
			assertEquals(billingAddress1, cc.getBillingAddress1());
			assertEquals(billingAddress2, cc.getBillingAddress2());
			assertEquals(billingCity, cc.getBillingCity());
			assertEquals(billingState, cc.getBillingState());
			assertEquals(billingZip, cc.getBillingZip());
		}
		catch (Exception e)
		{
			thrown = true;
			String msg = "Should throw an exception " + e.toString();
			assertTrue(msg,thrown);
		}
	}

	@Test
	public void CreditCard_Constructor3() {
		boolean thrown = false;

		String nameOnCard = "George Mason";
		String type = "Visa";
		String cardNumber = "1234123412341234";
		int CCV = 123;
		int expDateM = 13;
		int expDateY = 2016;
		String billingAddress1 = "4400 University Dr";
		String billingAddress2 = "";
		String billingCity = "Fairfax";
		String billingState = "VA";
		int billingZip = 22030;

		// Catch any Exception caused by testing the program
		try {
			// Set-up a constructor
			CreditCard cc = new CreditCard(nameOnCard, type, cardNumber, CCV, expDateM, expDateY, billingAddress1, billingAddress2, billingCity, billingState, billingZip);

			// Assert post condition is true
			assertEquals(nameOnCard, cc.getNameOnCard());
			assertEquals(type, cc.getType());
			assertEquals(cardNumber, cc.getCardNumber());
			assertEquals(CCV, cc.getCCV());
			assertEquals(expDateM, cc.getExpDateM());
			assertEquals(expDateY, cc.getExpDateY());
			assertEquals(billingAddress1, cc.getBillingAddress1());
			assertEquals(billingAddress2, cc.getBillingAddress2());
			assertEquals(billingCity, cc.getBillingCity());
			assertEquals(billingState, cc.getBillingState());
			assertEquals(billingZip, cc.getBillingZip());
		}
		catch (Exception e)
		{
			thrown = true;
			String msg = "Should throw an exception " + e.toString();
			assertTrue(msg,thrown);
		}
	}

	@Test
	public void CreditCard_Constructor4() {
		boolean thrown = false;

		String nameOnCard = "George Mason";
		String type = "Visa";
		String cardNumber = "1234123412341234";
		int CCV = 123;
		int expDateM = 1;
		int expDateY = 1969;
		String billingAddress1 = "4400 University Dr";
		String billingAddress2 = "";
		String billingCity = "Fairfax";
		String billingState = "VA";
		int billingZip = 22030;

		// Catch any Exception caused by testing the program
		try {
			// Set-up a constructor
			CreditCard cc = new CreditCard(nameOnCard, type, cardNumber, CCV, expDateM, expDateY, billingAddress1, billingAddress2, billingCity, billingState, billingZip);

			// Assert post condition is true
			assertEquals(nameOnCard, cc.getNameOnCard());
			assertEquals(type, cc.getType());
			assertEquals(cardNumber, cc.getCardNumber());
			assertEquals(CCV, cc.getCCV());
			assertEquals(expDateM, cc.getExpDateM());
			assertEquals(expDateY, cc.getExpDateY());
			assertEquals(billingAddress1, cc.getBillingAddress1());
			assertEquals(billingAddress2, cc.getBillingAddress2());
			assertEquals(billingCity, cc.getBillingCity());
			assertEquals(billingState, cc.getBillingState());
			assertEquals(billingZip, cc.getBillingZip());
		}
		catch (Exception e)
		{
			thrown = true;
			String msg = "Should throw an exception " + e.toString();
			assertTrue(msg,thrown);
		}
	}

	@Test
	public void Room_Constructor1() {
		int roomNumber = 101;
		boolean isDouble = false;
		double price = 100;

		// Catch any Exception caused by testing the program
		try {
			// Set-up a constructor
			Room rm = new Room(roomNumber, isDouble, price);

			// Assert post condition is true
			assertEquals(roomNumber, rm.getRoomNumber());
			assertEquals(isDouble, rm.isDouble());
			assertEquals(price, rm.getPrice(),0);
		}
		catch (Exception e)
		{
			fail("Create an instance of Room failed. " + e.toString());
		}
	}

	/**
	 * The actual TestCases for MakeReservation
	 */
	@Test
	public void MakeReservation_Constructor1() {
		// Set-up a User
		User usr = new User("user", "pass", "George Mason", 0, "4400 University Dr", "", "Fairfax", "VA", 22030);

		// Set-up a Room
		Room rm = new Room(101, false, 100);

		// Reserved Dates
		ArrayList<Date> dates = new ArrayList<Date>();
		dates.add(new Date(1,12,2016));
		dates.add(new Date(1,13,2016));
		dates.add(new Date(1,14,2016));

		// Reservation Info
		User reservedTo = usr;
		int m = 1;
		int d = 12;
		int y = 2016;
		int numberOfOccupants = 4;
		int numberOfNights = 2;
		boolean guaranteed = false;
		boolean checkedIn = false;
		boolean noShow = false;
		double balance = 100;
		double roomCost = 300;

		// Catch any Exception caused by testing the program
		try {

			// Set-up a Reservation
			Reservation rsvp = new Reservation(usr, rm, numberOfOccupants, guaranteed, m, d, y, numberOfNights, balance, roomCost);

			// Assert post condition is true
			assertEquals(rm, rsvp.getRoom());
			assertEquals(reservedTo, rsvp.getReservedTo());
			for (int i = 0; i < dates.size(); i++)
				assertEquals(dates.get(i).toString(), rsvp.getDates().get(i).toString());
			assertEquals(numberOfOccupants, rsvp.getNumberOfOccupants());
			assertEquals(numberOfNights, rsvp.getNumberOfNights());
			assertEquals(guaranteed, rsvp.isGuaranteed());
			assertEquals(checkedIn, rsvp.isCheckedIn());
			assertEquals(noShow, rsvp.isNoShow());
			assertEquals(balance, rsvp.getBalance(),0);
			assertEquals(roomCost, rsvp.getRoomCost(),0);
		}
		catch (Exception e)
		{
			fail("Create an instance of Reservation failed. " + e.toString());
		}
	}

	@Test
	public void MakeReservation_Test1()
	{
		// Create an instance of HotelSystem
		HotelSystem hs = new HotelSystem();

		// Set-up Users
		User user1 = hs.addUser("user","John","Smith",0,"address","home","Fairfax","VA",22153);
		User user2 = hs.addUser("user","Mary","Johnson",0,"somewhere","home","Fairfax","VA",22153);
		
		// Set-up Rooms
		Room room1 = hs.addRoom(111,false, 100);
		Room room2 = hs.addRoom(112, true, 150);

		// These should evaluate to true
		assertNotNull(hs.addReservation(user1,room1,1,false,5,12,2016,2));
		assertNotNull(hs.addReservation(user2,room2,3,false,5,15,2016,3));

		// These should evaluate to false since there is a duplicate when making a reservation
		assertNull(hs.addReservation(user2,room1,1,true,5,12,2016,2));
	}

	@Test
	public void CheckIn_NotGuaranteed_Success() {
		// Create an instance of the HotelSystem
		HotelSystem hs = new HotelSystem();

		// Set-up a User
		User usr = hs.addUser("user", "pass", "George Mason", 0, "4400 University Dr", "", "Fairfax", "VA", 22030);

		// Set-up a Room
		Room rm = hs.addRoom(101, false, 100);

		// Reservation Info
		int m = 1;
		int d = 12;
		int y = 2016;
		int numberOfOccupants = 4;
		int numberOfNights = 2;
		boolean guaranteed = false;

		// Set-up a Reservation
		Reservation rsvp = hs.addReservation(usr, rm, numberOfOccupants, guaranteed, m, d, y, numberOfNights);

		// Check-In Info
		Date checkInDate = new Date(m, d, y);

		// Set HotelSystem date to the checkInDate
		hs.setCurrentDate(checkInDate);

		// Catch any Exception caused by testing the program
		try {
			// Add CreditCard
			assertNotNull(hs.addCreditCard(usr, usr.getFullName(), "Visa", "12341234123412", 123, 12, 2018, usr.getAddress1(), usr.getAddress2(), usr.getCity(), usr.getState(), usr.getZip()));

			// Process Payment
			assertTrue(hs.chargeUser(rsvp));

			// Check In the User with the given Reservation
			assertNotNull(hs.checkInReservation(rsvp, checkInDate));
			assertTrue(rsvp.isCheckedIn());
			assertTrue(rsvp.isGuaranteed());
			assertEquals(rsvp.getBalance(), 0, 0);
		}
		catch (Exception e)
		{
			fail("Failed to check-in the User with the given Reservation. " + e.toString());
		}
	}

	@Test
	public void CheckIn_NotGuaranteed_Fail() {
		// Create an instance of the HotelSystem
		HotelSystem hs = new HotelSystem();

		// Set-up a User
		User usr = hs.addUser("user", "pass", "George Mason", 0, "4400 University Dr", "", "Fairfax", "VA", 22030);

		// Set-up a Room
		Room rm = hs.addRoom(101, false, 100);

		// Reservation Info
		int m = 1;
		int d = 12;
		int y = 2016;
		int numberOfOccupants = 4;
		int numberOfNights = 2;
		boolean guaranteed = false;

		// Set-up a Reservation
		Reservation rsvp = hs.addReservation(usr, rm, numberOfOccupants, guaranteed, m, d, y, numberOfNights);

		// Check-In Info
		Date checkInDate = new Date(m, d, y);

		// Set HotelSystem date to the checkInDate
		hs.setCurrentDate(checkInDate);

		// Catch any Exception caused by testing the program
		try {
			// Add CreditCard - Should be null since the credit card is already expired. It means it can't add a card that is already expired
			assertNull(hs.addCreditCard(usr, usr.getFullName(), "Visa", "12341234123412", 123, 12, 2010, usr.getAddress1(), usr.getAddress2(), usr.getCity(), usr.getState(), usr.getZip()));

			// Process Payment - Should be false since no credit card is being charged
			assertFalse(hs.chargeUser(rsvp));

			// Check In the User with the given Reservation
			assertNull(hs.checkInReservation(rsvp, checkInDate));
			assertFalse(rsvp.isCheckedIn());
		}
		catch (Exception e)
		{
			fail("Failed to check-in the User with the given Reservation. " + e.toString());
		}
	}

	// Test Cases for Date Class
	// General Field Test
	@Test
	public void Date_fieldTest1() {
		int month = 1;
		int day = 1;
		int year = 2000;
		Date date = new Date(month, day, year);

		assertEquals(day, date.getDay());
		assertEquals(month, date.getMonth());
		assertEquals(year, date.getYear());
	}

	// Test for when month is < 1
	@Test
	public void Date_fieldTest2() {
		boolean thrown = false;
		int month = 0;
		int day = 1;
		int year = 2000;

		try {
			Date date = new Date(month, day, year);
			assertEquals(day, date.getDay());
			assertEquals(month, date.getMonth());
			assertEquals(year, date.getYear());
		} catch(Exception e) {
			thrown = true;
		}
		assertTrue("IllegalArgumentException was thrown", thrown);
	}

	// Test for when month is > 12
	@Test
	public void Date_fieldTest3() {
		boolean thrown = false;
		int month = 13;
		int day = 1;
		int year = 2000;

		try {
			Date date = new Date(month, day, year);
			assertEquals(day, date.getDay());
			assertEquals(month, date.getMonth());
			assertEquals(year, date.getYear());

		} catch(Exception e) {
			//assertTrue(e.toString().equals("java.lang.IllegalArgumentException: Invalid month"));
			thrown = true;
		}
		assertTrue(thrown);
	}

	//Test for when day < 1
	@Test
	public void Date_fieldTest4() {
		boolean thrown = false;
		int month = 1;
		int day = 0;
		int year = 2000;

		try {
			Date date = new Date(month, day, year);
			assertEquals(day, date.getDay());
			assertEquals(month, date.getMonth());
			assertEquals(year, date.getYear());
		} catch(Exception e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	//Test for when day > 31
	@Test
	public void Date_fieldTest5() {
		boolean thrown = false;
		int month = 1;
		int day = 32;
		int year = 2000;

		try {
			Date date = new Date(month, day, year);
		} catch(Exception e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	//Test for when year < 1970
	@Test
	public void Date_fieldTest6() {
		boolean thrown = false;
		int month = 1;
		int day = 1;
		int year = 1969;

		try {
			Date date = new Date(month, day, year);
		} catch(Exception e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	//Max day in month, standard dates
	@Test
	public void Date_maxDayInMonthTest1() {
		int try1 = Date.maxDayInMonth(1, 2013);
		int try2 = Date.maxDayInMonth(2, 2013);
		int try3 = Date.maxDayInMonth(3, 2013);
		int try4 = Date.maxDayInMonth(4, 2013);
		int try5 = Date.maxDayInMonth(5, 2013);
		int try6 = Date.maxDayInMonth(6, 2013);
		int try7 = Date.maxDayInMonth(7, 2013);
		int try8 = Date.maxDayInMonth(8, 2013);
		int try9 = Date.maxDayInMonth(9, 2013);
		int try10 = Date.maxDayInMonth(10, 2013);
		int try11 = Date.maxDayInMonth(11, 2013);
		int try12 = Date.maxDayInMonth(12, 2013);
		int try13 = Date.maxDayInMonth(2, 2012);

		assertEquals(31, try1);
		assertEquals(28, try2);
		assertEquals(31, try3);
		assertEquals(30, try4);
		assertEquals(31, try5);
		assertEquals(30, try6);
		assertEquals(31, try7);
		assertEquals(31, try8);
		assertEquals(30, try9);
		assertEquals(31, try10);
		assertEquals(30, try11);
		assertEquals(31, try12);
		assertEquals(29, try13);
	}

	//Testing for month input that isn't 1-12
	//Month input < 1
	@Test
	public void Date_maxDayInMonthTest2() {
		int try1 = Date.maxDayInMonth(0, 2013);
		// Test
		assertEquals(-1, try1);
	}

	//Testing for month input that isn't 1-12
	//Month input > 12
	@Test
	public void Date_maxDayInMonthTest3() {
		int try1 = Date.maxDayInMonth(13, 2013);
		// Test
		assertEquals(-1, try1);
	}

	//getDifferenceFrom Test 1
	//Basic test
	@Test
	public void Date_getDifferenceFromTest1() {
		Date date1 = new Date(10, 11, 1994);
		Date date2 = new Date(10, 11, 2016);

		int try1 = date1.getDifferenceFrom(date2);
		assertEquals(8036, try1);
	}

	//getDifferenceFrom Test 2
	//When that>this
	@Test
	public void Date_getDifferenceFromTest2() {
		Date date1 = new Date(10, 11, 1994);
		Date date2 = new Date(10, 11, 2016);

		int try1 = date2.getDifferenceFrom(date1);
		assertEquals(-8036, try1);
	}

	//getDifferenceFrom Test 3
	//No difference
	@Test
	public void Date_getDifferenceFromTest3() {
		Date date1 = new Date(10, 11, 1994);
		Date date2 = new Date(10, 11, 1994);

		int try1 = date1.getDifferenceFrom(date2);
		assertEquals(0, try1);
	}

	//getDifferenceFrom Test 4
	//Basic test 2, make sure a difference of 1 is actually 1
	@Test
	public void Date_getDifferenceFromTest4() {
		Date date1 = new Date(10, 11, 1994);
		Date date2 = new Date(10, 12, 1994);

		int try1 = date1.getDifferenceFrom(date2);
		assertEquals(1, try1);
	}

	@Test
	public void Report_Constructor() {
		//Create an instance of the HotelSystem
		HotelSystem hs = new HotelSystem();

		//Create an instance of a User
		User usr1 = hs.addUser("user", "pass", "George Mason", 0, "4400 University Dr", "", "Fairfax", "VA", 22030);
		User usr2 = hs.addUser("user2", "pass2", "Abraham Lincoln", 0," ", "4444 Labomba st","Fairfax", "VA", 22030 );
		User usr3 = hs.addUser("user3", "pass3", "Abraham Lincoln", 0, " ", "32394 MarioParty dr", "Mushroom", "OH", 22032);

		// Create an instance of Room
		Room rm1 = hs.addRoom(101, false, 100);
		Room rm2 = hs.addRoom(201, true, 150);
		Room rm3 = hs.addRoom(202, true, 150);

		//Create multiple Reservations
		hs.addReservation(usr1,rm1, 2, false, 1, 1, 2016, 3);
		hs.addReservation(usr2,rm2, 4, true, 1, 2, 2016, 5);
		hs.addReservation(usr3,rm3, 3, false, 2,14, 2016, 2);

		// Expected Result
		int expectedReservations = 3;		// There are 3 reservations
		int expectedSinglesReserved = 1;	// 1 Singles
		int expectedDoublesReserved = 2;	// 2 Doubles
		double expectedOccupancyRate = 0;	// 0 Occupancy Rate since nobody got checked-in
		double expectedRevenue = 0;			// 0 Revenue because no reservation has been paid.

		// Catch any Exception caused by testing the program
		try {

			// From Date To Date
			Date from = new Date(1,1,2016);
			Date to = new Date(3,1,2016);
			// Generate the Report by the Given Range
			Report rpt = hs.generateReportByRange(from, to);

			// Check to see if rpt isnt empty
			assertNotNull(rpt);

			// Check if number of reservations is equal to the expected results
			assertEquals(expectedReservations, rpt.getNumberOfReservations());
			assertEquals(expectedSinglesReserved,rpt.getNumberOfSinglesReserved());
			assertEquals(expectedDoublesReserved,rpt.getNumberOfDoublesReserved());
			assertEquals(expectedOccupancyRate,rpt.getOccupancyRate(),0);
			assertEquals(expectedRevenue,rpt.getTotalRevenue(),0);
		}
		catch (Exception e)
		{
			fail("Failed to check-in the User with the given Reservation. " + e.toString());
		}
	}

}
