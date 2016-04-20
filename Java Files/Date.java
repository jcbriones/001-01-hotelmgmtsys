/**
 * Date.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the Date class which holds the days in our Calendar.
 */

public class Date {
	/**
	 * Class Variables
	 */
	private java.util.Calendar date;	// The date itself using java Calendar

	public Date(int month, int day, int year)
	{
		if (month < 1 || month > 12)
			throw new IllegalArgumentException("Invalid month");
		if (day < 1 || day > maxDayInMonth(month,year))
			throw new IllegalArgumentException("Invalid day for month " + month + " with the given year " + year + ". Trying "+day);
		if (year < 1970)
			throw new IllegalArgumentException("Can't go below year 1970");
		
		this.date = java.util.Calendar.getInstance();
		this.date.set(year, month, day);
	}

	public Date(int month, int year)
	{
		this(month,maxDayInMonth(month,year),year);
	}

	public String toString()
	{
		String month;
		switch(this.getMonth())
		{
		case 1:
			month = "January";
			break;
		case 2:
			month = "February";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "June";
			break;
		case 7:
			month = "July";
			break;
		case 8:
			month = "August";
			break;
		case 9:
			month = "September";
			break;
		case 10:
			month = "October";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "December";
			break;
		default:
			month = "Unknown";
			break;
		}
		return String.format("%s %d, %d",month, this.getDay(), this.getYear());
	}


	/**
	 * Description: This calculate the total number of days between this date to that date.
	 * 
	 * @param that
	 * @return int
	 * @author Pavan Vittala
	 */
	public int getDifferenceFrom(Date that) {
		if (this.getYear() == that.getYear() && this.getMonth() == that.getMonth() && this.getDay() == that.getDay())
			return 0;

		Date day1 = this;
		Date day2 = that;
		boolean reversed = false;
		if ((this.getYear() > that.getYear()) || (this.getYear() == that.getYear() && this.getMonth() > that.getMonth()) || 
				(this.getYear() == that.getYear() && this.getMonth() == that.getMonth() && this.getDay() > that.getDay()))
		{
			day1 = that;
			day2 = this;
			reversed = true;
		}

		int count = 0;
		int month = day1.getMonth();
		int day = day1.getDay();
		int year = day1.getYear();
		while (!(year == day2.getYear() && month == day2.getMonth() && day == day2.getDay())) {
			if (day == maxDayInMonth(month, year)) {
				if (month == 12) {
					month = 1;
					day = 1;
					year++;
				} else {
					month++;
					day = 1;
				}
			}
			else
				day++;
			count++;
		}
		if (reversed)
			return -count;
		return count;
	}

	/**
	 * Description: This gets the max day of a given month and year. Also checks for leap years.
	 * 
	 * @param month
	 * @param year
	 * @return int
	 * @author Pavan Vittala
	 */
	public static int maxDayInMonth(int month, int year) {
		switch(month)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			// Check for Leap Year
			if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
				return 29;
			else
				return 28;
		default:
			return -1;
		}
	}

	/**
	 * Description: Check if this date is before that date.
	 * 
	 * @param that
	 * @return boolean
	 * @author Pavan Vittala
	 */
	public boolean isBefore(Date that) {
		return this.date.before(that.date);
	}
	
	/**
	 * Description: This will increase the instance with the specified numberOfDays.
	 * 
	 * @param numberOfDays
	 * @return Date
	 * @author Jc Briones
	 */
	public Date increase(int numberOfDays) {
		date.add(java.util.Calendar.DATE, numberOfDays);
		return this;
	}

	/* =======================================
	 * Setters and Getters
	 * =======================================
	 */
	public int getDay() {
		return date.get(java.util.Calendar.DAY_OF_MONTH);
	}

	public void setDay(int day) {
		this.date.set(java.util.Calendar.DAY_OF_MONTH, day);
	}

	public int getMonth() {
		return date.get(java.util.Calendar.MONTH);
	}

	public void setMonth(int month) {
		this.date.set(java.util.Calendar.MONTH, month);
	}

	public int getYear() {
		return date.get(java.util.Calendar.YEAR);
	}

	public void setYear(int year) {
		this.date.set(java.util.Calendar.YEAR, year);
	}

	public boolean equals(Date that)
	{
		return this.getMonth() == that.getMonth() && this.getDay() == that.getDay() && this.getYear() == that.getYear();
	}

}
