//Pavan Vittala - 4/14/16
import static org.junit.Assert.*;
import org.junit.Test;

public class DateTest {

	//assertEquals(expected, actual);

	//General Field Test
	@Test
	public void fieldTest1() {
		int month = 1;
		int day = 1;
		int year = 2000;
		Date date = new Date(month, day, year);

		assertEquals(day, date.getDay());
		assertEquals(month, date.getMonth());
		assertEquals(year, date.getYear());
	}

	//Test for when month is < 1
	@Test
	public void fieldTest2() {
		boolean thrown = false;
		int month = 0;
		int day = 1;
		int year = 2000;

		Date date;
		try {
			date = new Date(month, day, year);
		} catch(Exception e) {
			//assertTrue(e.toString().equals("java.lang.IllegalArgumentException: Invalid month"));
			thrown = true;
		}
		assertTrue("IllegalArgumentException was thrown", thrown);
	}

	//Test for when month is > 12
	@Test
	public void fieldTest3() {
		boolean thrown = false;
		int month = 13;
		int day = 1;
		int year = 2000;

		Date date;
		try {
			date = new Date(month, day, year);
		} catch(Exception e) {
			//assertTrue(e.toString().equals("java.lang.IllegalArgumentException: Invalid month"));
			thrown = true;
		}
		assertTrue(thrown);
	}

	//Test for when day < 1
	@Test
	public void fieldTest4() {
		boolean thrown = false;
		int month = 1;
		int day = 0;
		int year = 2000;

		Date date;
		try {
			date = new Date(month, day, year);
		} catch(Exception e) {
			//assertTrue(e.toString().equals("java.lang.IllegalArgumentException: Invalid day for month " + month + " with the given year"));
			thrown = true;
		}
		assertTrue(thrown);
	}

	//Test for when day > 31
	@Test
	public void fieldTest5() {
		boolean thrown = false;
		int month = 1;
		int day = 32;
		int year = 2000;

		Date date;
		try {
			date = new Date(month, day, year);
		} catch(Exception e) {
			//assertTrue(e.toString().equals("java.lang.IllegalArgumentException: Invalid day for month " + month + " with the given year"));
			thrown = true;
		}
		assertTrue(thrown);
	}

	//Test for when year < 1970
	@Test
	public void fieldTest6() {
		boolean thrown = false;
		int month = 1;
		int day = 1;
		int year = 1969;

		Date date;
		try {
			date = new Date(month, day, year);
		} catch(Exception e) {
			//assertTrue(e.toString().equals("java.lang.IllegalArgumentException: Can't go below year 1970"));
			thrown = true;
		}
		assertTrue(thrown);
	}

	//Max day in month, standard dates
	@Test
	public void maxDayInMonthTest1() {
		int month = 1;
		int day = 1;
		int year = 2000;
		Date date = new Date(month, day, year);
		
		int try1 = date.maxDayInMonth(1, 2013);
		int try2 = date.maxDayInMonth(2, 2013);
		int try3 = date.maxDayInMonth(3, 2013);
		int try4 = date.maxDayInMonth(4, 2013);
		int try5 = date.maxDayInMonth(5, 2013);
		int try6 = date.maxDayInMonth(6, 2013);
		int try7 = date.maxDayInMonth(7, 2013);
		int try8 = date.maxDayInMonth(8, 2013);
		int try9 = date.maxDayInMonth(9, 2013);
		int try10 = date.maxDayInMonth(10, 2013);
		int try11 = date.maxDayInMonth(11, 2013);
		int try12 = date.maxDayInMonth(12, 2013);
		int try13 = date.maxDayInMonth(2, 2012);

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
	public void maxDayInMonthTest2() {
		int month = 1;
		int day = 1;
		int year = 2000;
		Date date = new Date(month, day, year);
		
		int try1 = date.maxDayInMonth(0, 2013);
		
		assertEquals(-1, try1);
	}

	//Testing for month input that isn't 1-12
	//Month input > 12
	@Test
	public void maxDayInMonthTest3() {
		int month = 1;
		int day = 1;
		int year = 2000;
		Date date = new Date(month, day, year);
		
		int try1 = date.maxDayInMonth(13, 2013);
		
		assertEquals(-1, try1);
	}
	
	//getDifferenceFrom Test 1
	//Basic test
	@Test
	public void getDifferenceFromTest1() {
		Date date1 = new Date(10, 11, 1994);
		Date date2 = new Date(10, 11, 2016);
		
		
		
		int try1 = date1.getDifferenceFrom(date2);
		assertEquals(8036, try1);
	}
	//getDifferenceFrom Test 2
	//When that>this
	@Test
	public void getDifferenceFromTest2() {
		Date date1 = new Date(10, 11, 1994);
		Date date2 = new Date(10, 11, 2016);
		
		
		
		int try1 = date2.getDifferenceFrom(date1);
		assertEquals(-8036, try1);
	}
	
	//getDifferenceFrom Test 3
	//No difference
	@Test
	public void getDifferenceFromTest3() {
		Date date1 = new Date(10, 11, 1994);
		Date date2 = new Date(10, 11, 1994);
		
		
		
		int try1 = date1.getDifferenceFrom(date2);
		assertEquals(0, try1);
	}
	
	//getDifferenceFrom Test 4
	//Basic test 2, make sure a difference of 1 is actually 1
	@Test
	public void getDifferenceFromTest4() {
		Date date1 = new Date(10, 11, 1994);
		Date date2 = new Date(10, 12, 1994);
		
		
		
		int try1 = date1.getDifferenceFrom(date2);
		assertEquals(1, try1);
	}
}
