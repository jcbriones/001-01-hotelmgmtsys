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
	public void Reservation_Constructor1() {
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
			// Add CreditCard - Should fail since the credit card is already expired.
			assertNotNull(hs.addCreditCard(usr, usr.getFullName(), "Visa", "12341234123412", 123, 12, 2010, usr.getAddress1(), usr.getAddress2(), usr.getCity(), usr.getState(), usr.getZip()));

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
}
