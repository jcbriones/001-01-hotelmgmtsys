import static org.junit.Assert.*;
import org.junit.*;

public class IntegrationTesting {

	/**
	 * The actual TestCases for MakeReservation
	 */
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

		// These should evaluate to not null
		assertNotNull(hs.addReservation(user1,room1,1,false,5,12,2016,2));
		assertNotNull(hs.addReservation(user2,room2,3,false,5,15,2016,3));

		// These should evaluate to null since there is a duplicate when making a reservation
		assertNull(hs.addReservation(user2,room1,1,true,5,12,2016,2));
	}

	@Test
	public void MakeReservation_Test2()
	{
		// Create an instance of HotelSystem
		HotelSystem hs = new HotelSystem();

		// Set-up Users
		User user1 = hs.addUser("user","John","Smith",0,"address","home","Fairfax","VA",22153);
		User user2 = hs.addUser("user","Mary","Johnson",0,"somewhere","home","Fairfax","VA",22153);

		// Set-up Rooms
		Room room1 = hs.addRoom(111,false, 100);
		Room room2 = hs.addRoom(112, true, 150);

		// These should evaluate to not null
		assertNotNull(hs.addReservation(user1,room1,1,false,5,12,2016,2));
		assertNotNull(hs.addReservation(user2,room2,3,false,5,15,2016,3));

		// These should evaluate to not null since there is a no duplicate when making a reservation. Just added it to a different date
		assertNotNull(hs.addReservation(user2,room1,1,true,5,15,2016,2));
	}

	@Test
	public void MakeReservation_Test3()
	{
		// Create an instance of HotelSystem
		HotelSystem hs = new HotelSystem();

		// Set-up Users
		User user1 = hs.addUser("user","John","Smith",0,"address","home","Fairfax","VA",22153);
		User user2 = hs.addUser("user","Mary","Johnson",0,"somewhere","home","Fairfax","VA",22153);

		// Set-up Rooms
		Room room1 = hs.addRoom(111,false, 100);
		Room room2 = hs.addRoom(112, true, 150);

		// These should evaluate to not null
		assertNotNull(hs.addReservation(user1,room1,1,false,5,12,2016,2));
		assertNotNull(hs.addReservation(user2,room2,3,false,5,15,2016,3));

		// These should evaluate to null since there is a no duplicate when making a reservation.
		assertNull(hs.addReservation(user1,room2,1,true,5,15,2016,2));
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

	/**
	 * Report
	 */
	@Test
	public void Report_Test1() {
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
		hs.addReservation(usr2,rm2, 4, false, 1, 2, 2016, 5);
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

	@Test
	public void Report_Test2() {
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
		hs.addReservation(usr2,rm2, 4, false, 1, 2, 2016, 5);
		hs.addReservation(usr3,rm3, 3, false, 2,14, 2016, 2);

		// Another list of reservations but doesn't fall under the given date
		hs.addReservation(usr1,rm1, 2, false, 4, 1, 2016, 3);
		hs.addReservation(usr2,rm2, 4, false, 4, 2, 2016, 5);
		hs.addReservation(usr3,rm3, 3, false, 5,14, 2016, 2);


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

	@Test
	public void Report_Test3() {
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
		hs.addReservation(usr2,rm2, 4, false, 1, 2, 2016, 5);
		hs.addReservation(usr3,rm3, 3, false, 2,14, 2016, 2);
		hs.addReservation(usr1,rm1, 2, false, 4, 1, 2016, 3);
		hs.addReservation(usr2,rm2, 4, false, 4, 2, 2016, 5);
		hs.addReservation(usr3,rm3, 3, false, 5,14, 2016, 2);


		// Expected Result
		int expectedReservations = 6;		// There are 6 reservations
		int expectedSinglesReserved = 2;	// 2 Singles
		int expectedDoublesReserved = 4;	// 4 Doubles
		double expectedOccupancyRate = 0;	// 0 Occupancy Rate since nobody got checked-in
		double expectedRevenue = 0;			// 0 Revenue because no reservation has been paid.

		// Catch any Exception caused by testing the program
		try {
			// Generate the Report by the Given Range
			Report rpt = hs.generateReportAll();

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

	@Test
	public void Report_Test4() {
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
		Reservation rsvp1 = hs.addReservation(usr1,rm1, 2, false, 1, 1, 2016, 3);
		Reservation rsvp2 = hs.addReservation(usr2,rm2, 4, false, 1, 2, 2016, 5);
		Reservation rsvp3 = hs.addReservation(usr3,rm3, 3, false, 2,14, 2016, 2);

		// Expected Result
		int expectedReservations = 3;		// There are 3 reservations
		int expectedSinglesReserved = 1;	// 1 Singles
		int expectedDoublesReserved = 2;	// 2 Doubles
		double expectedOccupancyRate = 100;	// 100.00% Occupancy Rate since nobody got checked-in
		double expectedRevenue = 1350;		// $1,350.00 Revenue because no reservation has been paid.

		// Catch any Exception caused by testing the program
		try {
			// Add CreditCard
			hs.addCreditCard(usr1, "Card1", "Visa", "12341234123412", 123, 12, 2018, "", "", "", "", 12345);
			hs.addCreditCard(usr2, "Card2", "Visa", "12341234123412", 123, 12, 2018, "", "", "", "", 12345);
			hs.addCreditCard(usr3, "Card3", "Visa", "12341234123412", 123, 12, 2018, "", "", "", "", 12345);
			
			// Pay all Reservations
			hs.chargeUser(rsvp1);
			hs.chargeUser(rsvp2);
			hs.chargeUser(rsvp3);

			// CheckIn Each Reservation
			hs.checkInReservation(rsvp1, new Date(1,1,2016));
			hs.checkInReservation(rsvp2, new Date(1,2,2016));
			hs.checkInReservation(rsvp3, new Date(2,14,2016));

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

	/**
	 * Check-Out
	 */
	@Test
	public void CheckOut_Test1() {
		// Create an instance of the HotelSystem
		HotelSystem hs = new HotelSystem();

		// Set-up a User
		User usr = hs.addUser("pavan", "pass", "George Mason", 0, "4400 University Dr", "", "Fairfax", "VA", 22030);

		// Set-up a Room
		Room rm = hs.addRoom(1, false, 100);

		// Reservation Info
		int month = 10;
		int day = 11;
		int year = 2016;
		int numberOfOccupants = 2;
		int numberOfNights = 2;
		boolean guaranteed = true;

		// Set-up a Reservation
		Reservation rsvp = hs.addReservation(usr, rm, numberOfOccupants, guaranteed, month, day, year, numberOfNights);

		// Check-In Info
		Date checkInDate = new Date(month, day, year);

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

			// Check Out Stuff
			assertNotNull(hs.checkOutReservation(rsvp, rsvp.getDates().get(rsvp.getDates().size()-1)));
			assertTrue(rsvp.isStayFinished());
			assertFalse(rm.isOccupied());
		}
		catch (Exception e)
		{
			fail("Failed to check-in the User with the given Reservation. " + e.toString());
		}


	}

	@Test
	public void CheckOut_Test2() {
		// Create an instance of the HotelSystem
		HotelSystem hs = new HotelSystem();

		// Set-up a User
		User usr = hs.addUser("pavan", "pass", "George Mason", 0, "4400 University Dr", "", "Fairfax", "VA", 22030);

		// Set-up a Room
		Room rm = hs.addRoom(1, false, 100);

		// Reservation Info
		int month = 10;
		int day = 11;
		int year = 2016;
		int numberOfOccupants = 2;
		int numberOfNights = 2;
		boolean guaranteed = true;

		// Set-up a Reservation
		Reservation rsvp = hs.addReservation(usr, rm, numberOfOccupants, guaranteed, month, day, year, numberOfNights);

		// Check-In Info
		Date checkInDate = new Date(month, day + 1, year);

		// Set HotelSystem date to the checkInDate
		hs.setCurrentDate(checkInDate);

		// Catch any Exception caused by testing the program
		try {
			// Add CreditCard
			assertNotNull(hs.addCreditCard(usr, usr.getFullName(), "Visa", "12341234123412", 123, 12, 2018, usr.getAddress1(), usr.getAddress2(), usr.getCity(), usr.getState(), usr.getZip()));

			// Process Payment
			assertTrue(hs.chargeUser(rsvp));

			// Check In the User with the given Reservation but will fail! Hence, you can't check-out
			assertNull(hs.checkInReservation(rsvp, checkInDate));
			assertFalse(rsvp.isCheckedIn());

			// Check-out Info
			assertNull(hs.checkOutReservation(rsvp, rsvp.getDates().get(rsvp.getDates().size()-1)));
			assertFalse(rsvp.isStayFinished());
		}
		catch (Exception e)
		{
			fail("Failed to check-in the User with the given Reservation. " + e.toString());
		}


	}


}
