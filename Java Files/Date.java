/*
 * Date.java
 * 
 * CS321-001 - George Mason University
 * Group 01
 * @author: Jc Briones, Pavan Vittala, Ken Matsuda, Matt Edwards
 * 
 * This is the Date class which holds the days in our Calendar.
 */

public class Date {
	private int month, day, year;

	public Date(int month, int day, int year)
	{
		if (month < 1 || month > 12)
			throw new IndexOutOfBoundsException("Invalid month");
		if (day < 1 || day > maxDayInMonth(month,year))
			throw new IndexOutOfBoundsException("Invalid day for month " + month + " with the given year");
		if (year < 1970)
			throw new IndexOutOfBoundsException("Can't go below year 1970");

		this.month = month;
		this.day = day;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean equals(Date that)
	{
		return this.month == that.month && this.day == that.day && this.year == that.year;
	}

	public String toString()
	{
		return String.format("%d/%d/%d",this.month, this.day, this.year);
	}

	public int getDifferenceFrom(Date that) {
		if (this.year == that.year && this.month == that.month && this.day == that.day)
			return 0;

		Date day1 = this;
		Date day2 = that;
		boolean reversed = false;
		if ((this.year > that.year) || (this.year == that.year && this.month > that.month) || 
				(this.year == that.year && this.month == that.month && this.day > that.day))
		{
			day1 = that;
			day2 = this;
			reversed = true;
		}

		int count = 0;
		int month = day1.month;
		int day = day1.day;
		int year = day1.year;
		while (!(year == day2.year && month == day2.month && day == day2.day)) {
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

	public int maxDayInMonth(int month, int year) {
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

	public boolean isBefore(Date that) {
		return that.getMonth() - this.getMonth() >= 0 && that.getDay() - this.getDay() > 0 && that.getYear() - this.getYear() >= 0;
	}

}
