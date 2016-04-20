import static org.junit.Assert.*;
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
			new Date(month, day, year);
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
			new Date(month, day, year);
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

}
